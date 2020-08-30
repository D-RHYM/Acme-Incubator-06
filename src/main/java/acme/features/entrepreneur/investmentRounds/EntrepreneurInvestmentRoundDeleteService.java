
package acme.features.entrepreneur.investmentRounds;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class EntrepreneurInvestmentRoundDeleteService implements AbstractDeleteService<Entrepreneur, InvestmentRound> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		boolean res;
		int id;
		InvestmentRound investmentRound;
		Entrepreneur entrepreneur;
		Principal principal;
		id = request.getModel().getInteger("id");
		investmentRound = this.repository.findOneById(id);
		entrepreneur = investmentRound.getEntrepreneur();
		principal = request.getPrincipal();
		res = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return res;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "finalMode");

	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "moment", "round", "title", "description", "amount", "link", "finalMode");

	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;
		InvestmentRound result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		int id;
		int numApplications;

		// Borrado incorrecto
		if (!errors.hasErrors("ticker")) {

			id = request.getModel().getInteger("id");
			numApplications = this.repository.findApplicationsByInvestmentRoundId(id);
			errors.state(request, numApplications == 0, "ticker", "entrepreneur.investmentRound.form.error.applications");
		}

	}

	@Override
	public void delete(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		int id;

		id = request.getModel().getInteger("id");
		Collection<Activity> activities = this.repository.findManyActivitiesByInvestmentRoundId(id);

		this.repository.deleteAll(activities);

		this.repository.delete(entity);

	}

}
