
package acme.features.authenticated.entrepreneur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.components.Response;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.helpers.PrincipalHelper;
import acme.framework.services.AbstractUpdateService;

@Service
public class AuthenticatedEntrepreneurUpdateService implements AbstractUpdateService<Authenticated, Entrepreneur> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedEntrepreneurRepository repository;


	@Override
	public boolean authorise(final Request<Entrepreneur> request) {
		assert request != null;

		boolean result = false;
		if (request.getPrincipal().hasRole(Entrepreneur.class)) {
			result = true;
		}

		return result;
	}

	@Override
	public void bind(final Request<Entrepreneur> request, final Entrepreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Entrepreneur> request, final Entrepreneur entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "sector", "qualificationRecord", "skillsRecord");

	}

	@Override
	public Entrepreneur findOne(final Request<Entrepreneur> request) {
		assert request != null;

		Entrepreneur res;
		Principal principal;
		int id;
		principal = request.getPrincipal();
		id = principal.getAccountId();
		res = this.repository.findOneEntrepreneurByUserAccountId(id);

		return res;
	}

	@Override
	public void validate(final Request<Entrepreneur> request, final Entrepreneur entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("sector")) {
			Boolean sectorErr = entity.getSector().equalsIgnoreCase("Software") || entity.getSector().equalsIgnoreCase("Computers") || entity.getSector().equalsIgnoreCase("Tech") || entity.getSector().equalsIgnoreCase("Health");
			errors.state(request, sectorErr, "sector", "authenticated.entrepreneur.error.sector", entity.getSector());
		}

	}

	@Override
	public void update(final Request<Entrepreneur> request, final Entrepreneur entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

	@Override
	public void onSuccess(final Request<Entrepreneur> request, final Response<Entrepreneur> response) {
		assert request != null;
		assert response != null;

		if (request.isMethod(HttpMethod.POST)) {
			PrincipalHelper.handleUpdate();
		}
	}

}
