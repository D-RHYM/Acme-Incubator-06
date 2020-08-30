
package acme.features.administrator.notices;

import java.awt.Checkbox;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.notices.Notice;
import acme.framework.components.Errors;
import acme.framework.components.HttpMethod;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorNoticeCreateService implements AbstractCreateService<Administrator, Notice> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	AdministratorNoticeRepository repository;


	@Override
	public boolean authorise(final Request<Notice> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");

	}

	@Override
	public void unbind(final Request<Notice> request, final Notice entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "headerPicture", "title", "creationMoment", "deadline", "body", "links");

		if (request.isMethod(HttpMethod.GET)) {
			model.setAttribute("accept", "false");
		} else {
			request.transfer(model, "accept");
		}
	}

	@Override
	public Notice instantiate(final Request<Notice> request) {
		Notice res;

		res = new Notice();

		return res;
	}

	@Override
	public void validate(final Request<Notice> request, final Notice entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		if (!errors.hasErrors("deadline")) {
			Boolean future = entity.getDeadline().after(new Date());
			errors.state(request, future, "deadline", "administrator.notice.error.deadline", entity.getDeadline());
		}

		Boolean check = request.getModel().getBoolean("accept");
		errors.state(request, check, "accept", "administrator.notice.error.accept");

	}

	@Override
	public void create(final Request<Notice> request, final Notice entity) {
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(moment);

		this.repository.save(entity);

	}

}
