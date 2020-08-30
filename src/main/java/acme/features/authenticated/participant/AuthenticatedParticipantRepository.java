
package acme.features.authenticated.participant;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.discussionForum.DiscussionForum;
import acme.entities.participant.Participant;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedParticipantRepository extends AbstractRepository {

	@Query("select p from Participant p where p.id = ?1")
	Participant findOneById(int id);

	@Query("select df from DiscussionForum df where df.id = ?1")
	DiscussionForum findOneDiscussionForumById(int discussionForumId);

	@Query("select count(df)>0 from DiscussionForum df where df.id = ?1 and df.creator.id = ?2")
	Boolean findIsForumCreator(int discussionForumId, int creatorId);

	@Query("select count(p)>0 from Participant p where p.discussionForum.id = ?1 and p.authenticated.id = ?2")
	Boolean findIsForumParticipant(int discussionForumId, int authenticatedId);

	@Query("select count(p)>0 from Participant p where p.discussionForum.id = ?1 and p.authenticated.id = ?2")
	Boolean findAuthenticatedExists(int authenticatedId);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneAuthenticatedById(int id);

	@Query("select p from Participant p where p.discussionForum.id = ?1")
	Collection<Participant> findManyParticipantsByForumId(int discussionForumId);

	@Query("select a from Authenticated a where a.userAccount.username = ?1")
	Authenticated findOneAuthenticatedByUsername(String username);
}
