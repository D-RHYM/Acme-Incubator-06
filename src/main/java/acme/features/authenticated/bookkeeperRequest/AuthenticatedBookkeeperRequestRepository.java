
package acme.features.authenticated.bookkeeperRequest;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bookkeeperRequest.BookkeeperRequest;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedBookkeeperRequestRepository extends AbstractRepository {

	@Query("select br from BookkeeperRequest br where br.id = ?1")
	BookkeeperRequest findOneById(int id);

	@Query("select count(br)>0 from BookkeeperRequest br where br.userAccount.id = ?1 and br.status = acme.entities.bookkeeperRequest.BookkeeperRequestStatus.PENDING")
	Boolean findHasPendingByUserAccountId(int id);

	@Query("select count(b)>0 from Bookkeeper b where b.userAccount.id = ?1")
	Boolean findIsBookkeeperByUserAccountId(int id);

	@Query("select ua from UserAccount ua where ua.id = ?1")
	UserAccount findOneUserAccountById(int id);
}
