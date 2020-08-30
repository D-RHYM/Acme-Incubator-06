
package acme.features.authenticated.discussionForum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForum.DiscussionForum;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedDiscussionForumListMineService implements AbstractListService<Authenticated, DiscussionForum> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private AuthenticatedDiscussionForumRepository repository;


	@Override
	public boolean authorise(final Request<DiscussionForum> request) {
		assert request != null;

		return request.getPrincipal().hasRole(Authenticated.class);
	}

	@Override
	public void unbind(final Request<DiscussionForum> request, final DiscussionForum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "investmentRound.title", "investmentRound.description", "creator.userAccount.username", "investmentRound.ticker");

	}

	@Override
	public Collection<DiscussionForum> findMany(final Request<DiscussionForum> request) {
		assert request != null;

		Collection<DiscussionForum> result;
		Principal principal;

		principal = request.getPrincipal();
		result = this.repository.findManyByAuthenticatedId(principal.getActiveRoleId());
		return result;
	}

}
