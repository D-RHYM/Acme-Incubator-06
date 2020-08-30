
package acme.features.authenticated.inquiries;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.inquiries.Inquirie;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedInquirieRepository extends AbstractRepository {

	@Query("select i from Inquirie i where i.deadline > current_date()")
	Collection<Inquirie> findManyInquiries();

	@Query("select i from Inquirie i where i.id =?1")
	Inquirie findOneInquireById(int id);

}
