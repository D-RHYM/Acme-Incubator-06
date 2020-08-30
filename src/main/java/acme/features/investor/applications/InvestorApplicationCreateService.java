
package acme.features.investor.applications;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.applications.Status;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.entities.roles.Investor;
import acme.features.entrepreneur.investmentRounds.EntrepreneurInvestmentRoundRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractCreateService;

@Service
public class InvestorApplicationCreateService implements AbstractCreateService<Investor, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private InvestorApplicationRepository			repository;

	@Autowired
	private EntrepreneurInvestmentRoundRepository	InvestmentRoundRepository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		Boolean res = true;
		int irId = request.getModel().getInteger("investId");
		int invId = request.getPrincipal().getActiveRoleId();
		Integer numApps = this.repository.findApplicationsByInvestmentRoundId(irId, invId);

		if (numApps != 0) {
			res = false;
		}

		return res;
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

		model.setAttribute("investId", entity.getInvestmentRound().getId());
		request.unbind(entity, model, "ticker", "moment", "statement", "status", "moneyOffer");

	}

	@Override
	public Application instantiate(final Request<Application> request) {
		assert request != null;

		Application result;
		result = new Application();
		result.setStatus(Status.PENDING);
		int id;
		int idInvitacion;
		Date moment;
		Entrepreneur entrepreneur;
		Investor investor;
		Principal principal;

		principal = request.getPrincipal();
		id = principal.getActiveRoleId();
		idInvitacion = request.getModel().getInteger("investId");

		System.out.println("idInv " + idInvitacion);
		InvestmentRound ir = this.InvestmentRoundRepository.findOneById(idInvitacion);
		System.out.println("investment " + ir);
		entrepreneur = ir.getEntrepreneur();
		System.out.println("entrepreneur " + entrepreneur);
		investor = this.repository.findOneInvestorById(id);
		System.out.println("investor " + investor);
		moment = new Date(System.currentTimeMillis() - 1);
		result.setMoment(moment);
		result.setEntrepreneur(entrepreneur);
		result.setInvestor(investor);
		result.setInvestmentRound(ir);
		result.setMoment(moment);

		return result;
	}

	@Override
	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		Principal principal = request.getPrincipal();
		int id = principal.getActiveRoleId();

		Collection<String> tickers = this.repository.findAllApplicationTickers();
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		String yearInString = String.valueOf(year);
		String activitySectorOfThisInvestor = this.repository.findSectorOfInvestor(id);

		//Ticker errors
		if (!errors.hasErrors("ticker")) {

			Boolean letters = request.getModel().getAttribute("ticker").toString().toUpperCase().substring(0, 3).equals(activitySectorOfThisInvestor.toUpperCase().subSequence(0, 3));

			Boolean yearDigits = request.getModel().getAttribute("ticker").toString().substring(4, 6).equals(yearInString.substring(2, 4));

			Boolean tickerAvailable = !tickers.contains(request.getModel().getAttribute("ticker"));

			errors.state(request, letters, "ticker", "investor.application.form.error.tickerLetters", entity.getTicker());
			errors.state(request, yearDigits, "ticker", "investor.application.form.error.tickerYearDigits", entity.getTicker());
			errors.state(request, tickerAvailable, "ticker", "investor.application.form.error.existingTicker", entity.getTicker());
		}

		//Dinero incorrecto
		if (!errors.hasErrors("moneyOffer")) {
			errors.state(request, entity.getMoneyOffer().getCurrency().equals("EUR") || entity.getMoneyOffer().getCurrency().equals("€"), "moneyOffer", "investor.application.form.error.moneyError");
		}

	}

	@Override
	public void create(final Request<Application> request, final Application entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);

		this.repository.save(entity);

	}

}
