
package acme.features.authenticated.discussionForum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.discussionForum.DiscussionForum;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.message.Message;
import acme.entities.participant.Participant;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedDiscussionForumRepository extends AbstractRepository {

	@Query("select i from DiscussionForum i where i.id = ?1")
	DiscussionForum findOneById(int id);

	@Query("select i from DiscussionForum i")
	Collection<DiscussionForum> findManyAll();

	@Query("select distinct p.discussionForum from Participant p where p.authenticated.id = ?1")
	Collection<DiscussionForum> findManyByAuthenticatedId(int authenticatedId);

	@Query("select distinct d from DiscussionForum d where d.creator.id = ?1")
	Collection<DiscussionForum> findManyByCreatorId(int creatorId);

	@Query("select count(p)>0 from Participant p where p.discussionForum.id =?1 and p.authenticated.id = ?2")
	Boolean findExistsDiscussionForumParticipant(int discussionForumId, int authenticatedId);

	@Query("select distinct d from DiscussionForum d where d.investmentRound.id = ?1")
	Collection<DiscussionForum> findManyByInvestmentRoundId(int investmentRoundId);

	@Query("select a from Authenticated a where a.id = ?1")
	Authenticated findOneAuthenticatedById(int id);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneInvestmentRoundById(int id);

	@Query("select count(d)>0 from DiscussionForum d where d.id = ?1 and d.creator.id = ?2")
	Boolean findIsDiscussionForumCreator(int forumId, int creatorId);

	@Query("select m from Message m where m.discussionForum.id = ?1")
	Collection<Message> findManyMessagesByDiscussionForumId(int discussionForumId);

	@Query("select p from Participant p where p.discussionForum.id = ?1")
	Collection<Participant> findManyParticipantByDiscussionForumId(int discussionForumId);

	@Query("select p from Participant p where p.id = ?1")
	Participant findOneParticipantById(int id);
}
