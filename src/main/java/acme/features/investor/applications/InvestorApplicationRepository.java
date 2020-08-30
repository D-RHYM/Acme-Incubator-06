
package acme.features.investor.applications;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.roles.Investor;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneById(int id);

	@Query("select a from Application a where a.investor.id = ?1")
	Collection<Application> findManyByInvestorId(int investorId);

	@Query("select count(a) from Application a where a.investmentRound.id = ?1 and a.investor.id = ?2")
	int findApplicationsByInvestmentRoundId(int irId, int invId);

	@Query("select i from Investor i where i.id = ?1")
	Investor findOneInvestorById(int id);

	@Query("select a.ticker from Application a")
	Collection<String> findAllApplicationTickers();

	@Query("select i.sector from Investor i where i.id = ?1")
	String findSectorOfInvestor(int id);

	@Query("select a from Application a where a.investor.id = ?1 and a.investmentRound.id = ?2")
	Application findOneByInvestorIdAndInvestmentRoundId(int invId, int irId);

}
