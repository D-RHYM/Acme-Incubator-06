
package acme.features.administrator.challenge;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.challenges.Challenge;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorChallengeCreateService implements AbstractCreateService<Administrator, Challenge> {

	@Autowired
	AdministratorChallengeRepository repository;


	@Override
	public boolean authorise(final Request<Challenge> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Challenge> request, final Challenge entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "deadline", "description", "rookieGoal", "rookieReward", "averageGoal", "averageReward", "expertGoal", "expertReward");

	}

	@Override
	public Challenge instantiate(final Request<Challenge> request) {
		Challenge result;

		result = new Challenge();

		return result;
	}

	@Override
	public void validate(final Request<Challenge> request, final Challenge entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		boolean deadlineHasErrors = errors.hasErrors("deadline");
		if (!deadlineHasErrors) {
			Calendar calendar = new GregorianCalendar();
			boolean isFuture = entity.getDeadline().after(calendar.getTime());
			errors.state(request, isFuture, "deadline", "administrator.challenge.error.must-future");
		}
		boolean rookieRewardHasErrors = errors.hasErrors("rookieReward");
		if (!rookieRewardHasErrors) {
			boolean isEur = entity.getRookieReward().getCurrency().equals("EUR") || entity.getRookieReward().getCurrency().equals("€");
			rookieRewardHasErrors = rookieRewardHasErrors || !isEur;
			errors.state(request, isEur, "rookieReward", "administrator.challenge.error.rejected-currency");
		}

		boolean averageRewardHasErrors = errors.hasErrors("averageReward");
		if (!averageRewardHasErrors) {
			boolean isEur = entity.getAverageReward().getCurrency().equals("EUR") || entity.getAverageReward().getCurrency().equals("€");
			averageRewardHasErrors = averageRewardHasErrors || !isEur;
			errors.state(request, isEur, "averageReward", "administrator.challenge.error.rejected-currency");
		}
		boolean expertRewardHasErrors = errors.hasErrors("expertReward");
		if (!expertRewardHasErrors) {
			boolean isEur = entity.getExpertReward().getCurrency().equals("EUR") || entity.getExpertReward().getCurrency().equals("€");
			expertRewardHasErrors = expertRewardHasErrors || !isEur;
			errors.state(request, isEur, "expertReward", "administrator.challenge.error.rejected-currency");
		}
	}
	@Override
	public void create(final Request<Challenge> request, final Challenge entity) {
		this.repository.save(entity);

	}

}
