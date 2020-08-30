
package acme.features.authenticated.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.message.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedMessageShowService implements AbstractShowService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository repository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;

		int messageId = request.getModel().getInteger("id");
		Principal principal = request.getPrincipal();
		Message message = this.repository.findOneById(messageId);
		boolean result = this.repository.findExistsDiscussionForumParticipant(message.getDiscussionForum().getId(), principal.getActiveRoleId());

		return result;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment", "body", "tags", "creator.userAccount.username");
	}

	@Override
	public Message findOne(final Request<Message> request) {
		assert request != null;

		Message result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
