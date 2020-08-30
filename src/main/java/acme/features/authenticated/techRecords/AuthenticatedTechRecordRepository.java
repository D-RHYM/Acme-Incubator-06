
package acme.features.authenticated.techRecords;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.techRecords.TechRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedTechRecordRepository extends AbstractRepository {

	@Query("select t from TechRecord t where t.id = ?1")
	TechRecord findOneById(int id);

	@Query("select t from TechRecord t")
	Collection<TechRecord> findManyAll();

}
