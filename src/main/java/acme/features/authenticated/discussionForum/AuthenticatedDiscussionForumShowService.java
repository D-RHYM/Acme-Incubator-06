
package acme.features.authenticated.discussionForum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForum.DiscussionForum;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedDiscussionForumShowService implements AbstractShowService<Authenticated, DiscussionForum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedDiscussionForumRepository repository;


	@Override
	public boolean authorise(final Request<DiscussionForum> request) {
		assert request != null;
		int discussionForumId = request.getModel().getInteger("id");
		Principal principal = request.getPrincipal();
		boolean result = this.repository.findExistsDiscussionForumParticipant(discussionForumId, principal.getActiveRoleId()) || this.repository.findIsDiscussionForumCreator(discussionForumId, principal.getActiveRoleId());
		return result;
	}

	@Override
	public void unbind(final Request<DiscussionForum> request, final DiscussionForum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "investmentRound.title", "creator.userAccount.username");

	}

	@Override
	public DiscussionForum findOne(final Request<DiscussionForum> request) {
		assert request != null;

		DiscussionForum res;
		int id;
		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);

		return res;
	}

}
