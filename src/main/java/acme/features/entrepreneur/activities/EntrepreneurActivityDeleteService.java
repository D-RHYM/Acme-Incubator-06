
package acme.features.entrepreneur.activities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.Activity;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EntrepreneurActivityDeleteService implements AbstractDeleteService<Entrepreneur, Activity> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurActivityRepository repository;


	@Override
	public boolean authorise(final Request<Activity> request) {
		assert request != null;

		return true;
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

	}

	@Override
	public void delete(final Request<Activity> request, final Activity entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);

	}

}
