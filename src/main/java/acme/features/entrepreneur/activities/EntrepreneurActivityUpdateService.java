
package acme.features.entrepreneur.activities;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.investmentRounds.Activity;
import acme.entities.roles.Entrepreneur;
import acme.features.entrepreneur.investmentRounds.EntrepreneurInvestmentRoundRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurActivityUpdateService implements AbstractUpdateService<Entrepreneur, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurActivityRepository			repository;

	@Autowired
	private EntrepreneurInvestmentRoundRepository	investmentRoundRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		boolean result;
		int id;
		Activity act;
		Entrepreneur entrepreneur;
		Principal principal;
		principal = request.getPrincipal();
		id = request.getModel().getInteger("id");
		act = this.repository.findOneById(id);
		entrepreneur = act.getInvestmentRound().getEntrepreneur();
		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void bind(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Activity> request, final Activity entity, final Model model) {
		assert request != null;
		assert request != null;
		assert request != null;

		request.unbind(entity, model, "title", "moment", "deadline", "budget");

	}

	@Override
	public Activity findOne(final Request<Activity> request) {
		assert request != null;

		Activity res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);

		return res;
	}

	@Override
	public void validate(final Request<Activity> request, final Activity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		CustomisationParameters customisation = this.investmentRoundRepository.findCustomisationParameters();

		//Spam title
		boolean titleHasErrors = errors.hasErrors("title");
		if (!titleHasErrors) {
			errors.state(request, !customisation.isSpam(entity.getTitle()), "title", "entrepreneur.activity.form.error.spamTitle");
		}

		//Deadline errors
		boolean deadlineHasErrors = errors.hasErrors("deadline");
		if (!deadlineHasErrors) {
			Calendar calendar = new GregorianCalendar();
			boolean isFuture = entity.getDeadline().after(calendar.getTime());
			errors.state(request, isFuture, "deadline", "entrepreneur.activity.error.must-future");
		}

		//Dinero incorrecto
		if (!errors.hasErrors("budget")) {
			errors.state(request, entity.getBudget().getCurrency().equals("EUR") || entity.getBudget().getCurrency().equals("€"), "budget", "entrepreneur.activity.form.error.errorBudget");
		}

		Boolean supera;
		Double suma;

		// Dinero incorrecto
		if (!errors.hasErrors("budget")) {
			supera = true;
			suma = this.investmentRoundRepository.sumBudgetActivity(entity.getInvestmentRound().getId());
			double viejo = this.repository.findOneBudgetByActivityId(entity.getId());
			double actual = entity.getBudget().getAmount();
			double res = suma + actual - viejo;
			if (res > this.investmentRoundRepository.findOneById(entity.getInvestmentRound().getId()).getAmount().getAmount()) {
				supera = false;
			}
			errors.state(request, supera, "budget", "entrepreneur.activity.form.error.errorBudget");
		}

	}

	@Override
	public void update(final Request<Activity> request, final Activity entity) {
		assert request != null;
		assert entity != null;

		double suma = this.investmentRoundRepository.sumBudgetActivity(entity.getInvestmentRound().getId());
		double viejo = this.repository.findOneBudgetByActivityId(entity.getId());
		double actual = entity.getBudget().getAmount();
		double res = suma + actual - viejo;
		if (res == this.investmentRoundRepository.findOneById(entity.getInvestmentRound().getId()).getAmount().getAmount()) {
			entity.getInvestmentRound().setFinalMode(true);
			this.repository.save(entity.getInvestmentRound());
		}

		this.repository.save(entity);

	}

}
