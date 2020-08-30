
package acme.features.entrepreneur.activities;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.Activity;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurActivityRepository extends AbstractRepository {

	@Query("select a from Activity a where a.investmentRound.id =?1")
	Collection<Activity> findAllActivitiesById(int id);

	@Query("select a from Activity a where a.id =?1")
	Activity findOneById(int id);

	@Query("select a.budget.amount from Activity a where a.id =?1")
	int findOneBudgetByActivityId(int id);

}
