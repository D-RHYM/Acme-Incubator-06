
package acme.features.entrepreneur.investmentRounds;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurInvestmentRoundCreateService implements AbstractCreateService<Entrepreneur, InvestmentRound> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
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

		request.unbind(entity, model, "ticker", "moment", "round", "title", "description", "amount", "link", "finalMode");

	}

	@Override
	public InvestmentRound instantiate(final Request<InvestmentRound> request) {

		InvestmentRound result;
		result = new InvestmentRound();
		int id;
		Date moment;
		Entrepreneur entrepreneur;
		Principal principal;
		principal = request.getPrincipal();
		id = principal.getActiveRoleId();
		entrepreneur = this.repository.findOneEntrepreneurById(id);
		result.setEntrepreneur(entrepreneur);
		moment = new Date(System.currentTimeMillis() - 1);

		result.setMoment(moment);
		result.setFinalMode(false);

		return result;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Principal principal = request.getPrincipal();
		int id = principal.getActiveRoleId();

		Collection<String> tickers = this.repository.findAllTickers();
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String yearInString = String.valueOf(year);
		String activitySectorOfThisEntrepreneur = this.repository.findSectorOfEntrepreneur(id);

		//Ticker errors
		if (!errors.hasErrors("ticker")) {

			Boolean letters = request.getModel().getAttribute("ticker").toString().toUpperCase().substring(0, 3).equals(activitySectorOfThisEntrepreneur.toUpperCase().subSequence(0, 3));

			Boolean yearDigits = request.getModel().getAttribute("ticker").toString().substring(4, 6).equals(yearInString.substring(2, 4));

			Boolean tickerAvailable = !tickers.contains(request.getModel().getAttribute("ticker"));

			errors.state(request, letters, "ticker", "entrepreneur.investmentRound.form.error.tickerLetters", entity.getTicker());
			errors.state(request, yearDigits, "ticker", "entrepreneur.investmentRound.form.error.tickerYearDigits", entity.getTicker());
			errors.state(request, tickerAvailable, "ticker", "entrepreneur.investmentRound.form.error.existingTicker", entity.getTicker());
		}

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
	}

	@Override
	public void create(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		entity.setFinalMode(false);

		this.repository.save(entity);

	}

}
