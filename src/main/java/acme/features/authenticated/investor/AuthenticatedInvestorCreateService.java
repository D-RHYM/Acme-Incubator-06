
package acme.features.authenticated.investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Investor;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.entities.UserAccount;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedInvestorCreateService implements AbstractCreateService<Authenticated, Investor> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedInvestorRepository repository;


	@Override
	public boolean authorise(final Request<Investor> request) {
		assert request != null;

		boolean result = true;
		if (request.getPrincipal().hasRole(Investor.class)) {
			result = false;
		}

		return result;
	}

	@Override
	public void bind(final Request<Investor> request, final Investor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Investor> request, final Investor entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "profile");

	}

	@Override
	public Investor instantiate(final Request<Investor> request) {
		assert request != null;

		Investor res;
		Principal principal;
		int id;
		UserAccount userAccount;
		principal = request.getPrincipal();
		id = principal.getAccountId();
		userAccount = this.repository.findOneUserAccountById(id);
		res = new Investor();
		res.setUserAccount(userAccount);

		return res;
	}

	@Override
	public void validate(final Request<Investor> request, final Investor entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("sector")) {
			Boolean sectorErr = entity.getSector().equalsIgnoreCase("Software") || entity.getSector().equalsIgnoreCase("Computers") || entity.getSector().equalsIgnoreCase("Tech") || entity.getSector().equalsIgnoreCase("Health");
			errors.state(request, sectorErr, "sector", "authenticated.investor.error.sector", entity.getSector());
		}

	}

	@Override
	public void create(final Request<Investor> request, final Investor entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Investor> request, final Response<Investor> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
