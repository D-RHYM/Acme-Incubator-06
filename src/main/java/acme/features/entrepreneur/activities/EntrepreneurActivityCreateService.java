
package acme.features.entrepreneur.activities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.investmentRounds.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.features.entrepreneur.investmentRounds.EntrepreneurInvestmentRoundRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class EntrepreneurActivityCreateService implements AbstractCreateService<Entrepreneur, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurActivityRepository			repository;

	@Autowired
	private EntrepreneurInvestmentRoundRepository	investmentRoundRepository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		boolean res;
		int id;
		InvestmentRound investmentRound;
		Entrepreneur entrepreneur;
		Principal principal;
		principal = request.getPrincipal();
		id = request.getModel().getInteger("investmentId");
		investmentRound = this.investmentRoundRepository.findOneById(id);
		entrepreneur = investmentRound.getEntrepreneur();
		res = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return res;
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
		assert entity != null;
		assert model != null;

		model.setAttribute("investmentId", entity.getInvestmentRound().getId());
		request.unbind(entity, model, "title", "moment", "deadline", "budget");

	}

	@Override
	public Activity instantiate(final Request<Activity> request) {

		Activity res;
		res = new Activity();
		int id = request.getModel().getInteger("investmentId");
		Date moment;
		InvestmentRound investmentRound;
		investmentRound = this.investmentRoundRepository.findOneById(id);
		res.setInvestmentRound(investmentRound);
		moment = new Date(System.currentTimeMillis() - 1);
		res.setMoment(moment);

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
			errors.state(request, entity.getBudget().getCurrency().equals("EUR") || entity.getBudget().getCurrency().equals("€"), "budget", "entrepreneur.activity.form.error.budgetError");
		}

		Double suma;
		Boolean supera;

		// Dinero incorrecto
		int cont = this.investmentRoundRepository.countActivitiesByInvestmentRoundId(entity.getInvestmentRound().getId());

		if (cont != 0) {
			if (!errors.hasErrors("budget")) {
				supera = true;
				suma = this.investmentRoundRepository.sumBudgetActivity(entity.getInvestmentRound().getId());
				double actual = entity.getBudget().getAmount();
				double res = suma + actual;
				if (res > this.investmentRoundRepository.findOneById(entity.getInvestmentRound().getId()).getAmount().getAmount()) {
					supera = false;
				}
				errors.state(request, supera, "budget", "entrepreneur.activity.form.error.errorBudget");
			}

		} else if (cont == 0) {
			if (!errors.hasErrors("budget")) {
				supera = true;
				double actual = entity.getBudget().getAmount();
				if (actual > this.investmentRoundRepository.findOneById(entity.getInvestmentRound().getId()).getAmount().getAmount()) {
					supera = false;
				}
				errors.state(request, supera, "budget", "entrepreneur.activity.form.error.errorBudget");
			}
		}

	}

	@Override
	public void create(final Request<Activity> request, final Activity entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		int cont = this.investmentRoundRepository.countActivitiesByInvestmentRoundId(entity.getInvestmentRound().getId());
		if (cont != 0) {
			double sumBudget = this.investmentRoundRepository.sumBudgetActivity(entity.getInvestmentRound().getId());
			double actualBudget = entity.getBudget().getAmount();
			double res = sumBudget + actualBudget;
			if (res == this.investmentRoundRepository.findOneById(entity.getInvestmentRound().getId()).getAmount().getAmount()) {
				entity.getInvestmentRound().setFinalMode(true);
				this.repository.save(entity.getInvestmentRound());
			}

		} else if (cont == 0) {
			double actualBudget = entity.getBudget().getAmount();
			if (actualBudget == this.investmentRoundRepository.findOneById(entity.getInvestmentRound().getId()).getAmount().getAmount()) {
				entity.getInvestmentRound().setFinalMode(true);
				this.repository.save(entity.getInvestmentRound());
			}
		}

		this.repository.save(entity);

	}

}
