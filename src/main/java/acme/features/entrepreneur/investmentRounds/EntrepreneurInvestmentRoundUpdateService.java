
package acme.features.entrepreneur.investmentRounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurInvestmentRoundUpdateService implements AbstractUpdateService<Entrepreneur, InvestmentRound> {

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
		res = entrepreneur.getUserAccount().getId() == principal.getAccountId() && !investmentRound.getFinalMode();

		return res;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "amount", "round", "moment", "link", "ticker", "finalMode");

	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;

		InvestmentRound res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);

		return res;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		CustomisationParameters customisation = this.repository.findCustomisationParameters();

		//Spam title
		boolean titleHasErrors = errors.hasErrors("title");
		if (!titleHasErrors) {
			errors.state(request, !customisation.isSpam(entity.getTitle()), "title", "entrepreneur.investmentRound.form.error.spamTitle");
		}

		//Spam description
		boolean descriptionHasErrors = errors.hasErrors("description");
		if (!descriptionHasErrors) {
			errors.state(request, !customisation.isSpam(entity.getDescription()), "description", "entrepreneur.investmentRound.form.error.spamDescription");
		}

		//Dinero incorrecto
		if (!errors.hasErrors("amount")) {
			errors.state(request, entity.getAmount().getCurrency().equals("EUR") || entity.getAmount().getCurrency().equals("€"), "amount", "entrepreneur.investmentRound.form.error.amountError");
		}

		Boolean superaDinero;
		Double sumaBudget;

		//Suma dinero incorrecta
		int cont = 0;
		cont = this.repository.countActivitiesByInvestmentRoundId(entity.getId());
		if (cont != 0) {

			if (!errors.hasErrors("amount")) {
				superaDinero = true;
				sumaBudget = this.repository.sumBudgetActivity(entity.getId());
				double actualAmount = entity.getAmount().getAmount();
				if (actualAmount < sumaBudget) {
					superaDinero = false;
				}
				errors.state(request, superaDinero, "amount", "entrepreneur.investmentRound.form.error.amountError");
			}
		}

	}

	@Override
	public void update(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		int cont = 0;
		cont = this.repository.countActivitiesByInvestmentRoundId(entity.getId());
		if (cont != 0) {
			double sumaBudget = this.repository.sumBudgetActivity(entity.getId());
			double actualAmount = entity.getAmount().getAmount();
			if (actualAmount == sumaBudget) {
				entity.setFinalMode(true);
			}
		}

		this.repository.save(entity);

	}

}
