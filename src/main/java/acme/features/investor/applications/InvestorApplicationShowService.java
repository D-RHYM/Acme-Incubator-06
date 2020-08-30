
package acme.features.investor.applications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class InvestorApplicationShowService implements AbstractShowService<Investor, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private InvestorApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		boolean res;
		int id;
		Application i;
		Investor investor;
		Principal principal;
		id = request.getModel().getInteger("id");
		i = this.repository.findOneById(id);
		investor = i.getInvestor();
		principal = request.getPrincipal();
		res = investor.getUserAccount().getId() == principal.getAccountId();

		return res;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "moment", "statement", "status", "moneyOffer", "justification");

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
