
package acme.features.entrepreneur.investmentRounds;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.entities.investmentRounds.Activity;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findOneById(int id);

	@Query("select i from InvestmentRound i")
	Collection<InvestmentRound> findManyAll();

	@Query("select ir from InvestmentRound ir where ir.entrepreneur.id =?1")
	Collection<InvestmentRound> findInvestmentRoundsByEntrepreneurId(int id);

	@Query("select p from CustomisationParameters p")
	CustomisationParameters findCustomisationParameters();

	@Query("select i.ticker from InvestmentRound i")
	Collection<String> findAllTickers();

	@Query("select e from Entrepreneur e where e.id = ?1")
	Entrepreneur findOneEntrepreneurById(int id);

	@Query("select e.sector from Entrepreneur e where e.id = ?1")
	String findSectorOfEntrepreneur(int id);

	@Query("select sum(a.budget.amount) from Activity a where a.investmentRound.id = ?1")
	Double sumBudgetActivity(int id);

	@Query("select count(a) from Activity a where a.investmentRound.id = ?1")
	int countActivitiesByInvestmentRoundId(int investmentRoundId);

	@Query("select a from Activity a where a.investmentRound.id = ?1")
	Collection<Activity> findManyActivitiesByInvestmentRoundId(int investmentRoundId);

	@Query("select count(ap) from Application ap where ap.investmentRound.id = ?1")
	int findApplicationsByInvestmentRoundId(int investmentRoundId);

}
