
package acme.features.authenticated.discussionForum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForum.DiscussionForum;
import acme.entities.participant.Participant;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedDiscussionForumCreateService implements AbstractCreateService<Authenticated, DiscussionForum> {

	@Autowired
	AuthenticatedDiscussionForumRepository repository;


	@Override
	public boolean authorise(final Request<DiscussionForum> request) {
		assert request != null;

		boolean result = request.getPrincipal().hasRole(Authenticated.class);

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

		model.setAttribute("investId", request.getModel().getInteger("investId"));
		request.unbind(entity, model, "investmentRound.title", "creator.userAccount.username");
	}

	@Override
	public DiscussionForum instantiate(final Request<DiscussionForum> request) {
		assert request != null;

		DiscussionForum result = new DiscussionForum();

		Authenticated auth = this.repository.findOneAuthenticatedById(request.getPrincipal().getActiveRoleId());
		result.setCreator(auth);

		int investmentRoundId = request.getModel().getInteger("investId");
		result.setInvestmentRound(this.repository.findOneInvestmentRoundById(investmentRoundId));

		return result;
	}

	@Override
	public void validate(final Request<DiscussionForum> request, final DiscussionForum entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		int id = request.getModel().getInteger("investId");
		boolean result = this.repository.findManyByInvestmentRoundId(id).isEmpty();

		boolean titleHasErrors = errors.hasErrors("investmentRound.title");
		if (!titleHasErrors) {
			errors.state(request, result, "investmentRound.title", "authenticated.discussion-forum.form.error.existing");
		}

	}

	@Override
	public void create(final Request<DiscussionForum> request, final DiscussionForum entity) {
		assert request != null;
		assert entity != null;
		Authenticated auth = this.repository.findOneAuthenticatedById(request.getPrincipal().getActiveRoleId());
		Participant creator = new Participant();
		creator.setDiscussionForum(entity);
		creator.setAuthenticated(auth);
		this.repository.save(entity);
		this.repository.save(creator);

	}

}
