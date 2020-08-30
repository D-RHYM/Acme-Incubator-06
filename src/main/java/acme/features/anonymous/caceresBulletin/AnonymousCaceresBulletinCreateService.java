
package acme.features.anonymous.caceresBulletin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bulletins.CaceresBulletin;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousCaceresBulletinCreateService implements AbstractCreateService<Anonymous, CaceresBulletin> {

	// Internal state -------------------------------------------------------------

	@Autowired
	AnonymousCaceresBulletinRepository repository;


	@Override
	public boolean authorise(final Request<CaceresBulletin> request) {
		assert request != null;

		return true;
	}

	@Override
	public CaceresBulletin instantiate(final Request<CaceresBulletin> request) {
		assert request != null;

		CaceresBulletin result;
		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);

		result = new CaceresBulletin();

		result.setMoment(moment);

		return result;
	}

	@Override
	public void unbind(final Request<CaceresBulletin> request, final CaceresBulletin entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "author", "age", "url");
	}

	@Override
	public void bind(final Request<CaceresBulletin> request, final CaceresBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void validate(final Request<CaceresBulletin> request, final CaceresBulletin entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<CaceresBulletin> request, final CaceresBulletin entity) {
		assert request != null;
		assert entity != null;

		Date moment;

		moment = new Date(System.currentTimeMillis() - 1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}
}
