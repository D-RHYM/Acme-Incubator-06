
package acme.features.entrepreneur.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurApplicationShowService implements AbstractShowService<Entrepreneur, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean res;
		int id;
		Application i;
		Entrepreneur entrepreneur;
		Principal principal;
		id = request.getModel().getInteger("id");
		i = this.repository.findOneById(id);
		entrepreneur = i.getInvestmentRound().getEntrepreneur();
		principal = request.getPrincipal();
		res = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return res;

	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "moment", "status", "statement", "moneyOffer", "justification");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
