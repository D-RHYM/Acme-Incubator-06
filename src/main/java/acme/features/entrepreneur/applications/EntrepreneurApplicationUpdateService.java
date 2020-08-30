
package acme.features.entrepreneur.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.applications.Status;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurApplicationUpdateService implements AbstractUpdateService<Entrepreneur, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean result;
		int applicationId;
		Application application;
		Entrepreneur entrepreneur;
		Principal principal;
		applicationId = request.getModel().getInteger("id");
		application = this.repository.findOneById(applicationId);
		entrepreneur = application.getInvestmentRound().getEntrepreneur();
		principal = request.getPrincipal();
		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		String investmentRef = entity.getInvestmentRound().getTicker();
		model.setAttribute("investmentRef", investmentRef);
		String investmentEntrepreneur = entity.getInvestmentRound().getEntrepreneur().getUserAccount().getUsername();
		model.setAttribute("investmentEntrepreneur", investmentEntrepreneur);

		request.unbind(entity, model, "ticker", "moment", "status", "statement", "moneyOffer", "justification");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);

		return res;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean statusHasErrors = errors.hasErrors("status");
		if (!statusHasErrors) {
			boolean justificationHasErrors = errors.hasErrors("justification");
			if (!justificationHasErrors) {
				boolean hasJustification = entity.getStatus() != Status.REJECTED || entity.getStatus() == Status.REJECTED && entity.getJustification().length() > 0;
				errors.state(request, hasJustification, "justification", "entrepreneur.application.form.error.justification");
			}
		}

	}

	@Override
	public void update(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Application res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);
		res.setStatus(entity.getStatus());
		if (res.getStatus() == Status.REJECTED) {
			res.setJustification(entity.getJustification());
		}

		this.repository.save(res);

	}

}
