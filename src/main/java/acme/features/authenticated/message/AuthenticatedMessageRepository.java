
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.discussionForum.DiscussionForum;
import acme.entities.message.Message;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedMessageRepository extends AbstractRepository {

	@Query("select m from Message m where m.id = ?1")
	Message findOneById(int id);

	@Query("select mt from DiscussionForum mt where mt.id = ?1")
	DiscussionForum findOneDiscussionForumById(int discussionForumId);

	@Query("select m from Message m where m.discussionForum.id = ?1")
	Collection<Message> findManyByDiscussionForumId(Integer discussionForumId);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneAuthenticatedById(int id);

	@Query("select c from CustomisationParameters c")
	CustomisationParameters findOneCustomisationParameters();

	@Query("select count(d)>0 from DiscussionForum d where d.id = ?1 and d.creator.id = ?2")
	Boolean findIsDiscussionForumCreator(int forumId, int creatorId);

	@Query("select count(p)>0 from Participant p where p.discussionForum.id = ?1 and p.authenticated.id = ?2")
	Boolean findExistsDiscussionForumParticipant(int discussionForumId, int authenticatedId);
}
