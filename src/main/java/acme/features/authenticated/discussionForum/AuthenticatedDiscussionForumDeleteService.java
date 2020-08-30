
package acme.features.authenticated.discussionForum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForum.DiscussionForum;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractDeleteService;

@Service
public class AuthenticatedDiscussionForumDeleteService implements AbstractDeleteService<Authenticated, DiscussionForum> {

	@Autowired
	AuthenticatedDiscussionForumRepository repository;


	@Override
	public boolean authorise(final Request<DiscussionForum> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		DiscussionForum df = this.repository.findOneById(id);

		Authenticated au = df.getCreator();
		Principal principal = request.getPrincipal();
		boolean result = au.getId() == principal.getActiveRoleId();

		return result;
	}

	@Override
	public void bind(final Request<DiscussionForum> request, final DiscussionForum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<DiscussionForum> request, final DiscussionForum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model);
	}

	@Override
	public DiscussionForum findOne(final Request<DiscussionForum> request) {
		DiscussionForum result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void validate(final Request<DiscussionForum> request, final DiscussionForum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<DiscussionForum> request, final DiscussionForum entity) {
		assert request != null;
		assert entity != null;

		this.repository.deleteAll(this.repository.findManyMessagesByDiscussionForumId(entity.getId()));
		this.repository.deleteAll(this.repository.findManyParticipantByDiscussionForumId(entity.getId()));
		this.repository.delete(entity);
	}
}
