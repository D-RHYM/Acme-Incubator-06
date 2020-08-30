
package acme.features.entrepreneur.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurActivityShowService implements AbstractShowService<Entrepreneur, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		boolean res;
		int id;
		InvestmentRound i;
		Entrepreneur entrepreneur;
		Principal principal;
		id = request.getModel().getInteger("id");
		i = this.repository.findOneById(id).getInvestmentRound();
		entrepreneur = i.getEntrepreneur();
		principal = request.getPrincipal();
		res = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return res;
	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("investmentRoundId", entity.getInvestmentRound().getId());
		model.setAttribute("finalMode", entity.getInvestmentRound().getFinalMode());

		request.unbind(entity, model, "title", "moment", "deadline", "budget");

	}

	@Override
	public Activity findOne(final Request<Activity> request) {
		assert request != null;

		Activity result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
