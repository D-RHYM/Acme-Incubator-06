
package acme.features.administrator.bookkeeperRequest;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.bookkeeperRequest.BookkeeperRequest;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorBookkeeperRequestRepository extends AbstractRepository {

	@Query("select br from BookkeeperRequest br where br.status = acme.entities.bookkeeperRequest.BookkeeperRequestStatus.PENDING")
	Collection<BookkeeperRequest> findManyAll();

	@Query("select br from BookkeeperRequest br where br.id = ?1")
	BookkeeperRequest findOneById(int id);
}
