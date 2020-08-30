
package acme.features.bookkeeper.accountingRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperAccountingRecordRepository extends AbstractRepository {

	@Query("select a from AccountingRecord a where a.id = ?1")
	AccountingRecord findOneById(int id);

	@Query("select count(a)>0 from AccountingRecord a where a.bookkeeper.id = ?1 and a.investmentRound.id = ?2")
	Boolean findExistsAccountingRecordByBookkeeperIdInvestmentRoundId(int bookkeeperId, int investmentRoundId);

	@Query("select a from AccountingRecord a where a.bookkeeper.id = ?1")
	Collection<AccountingRecord> findMany(int auditorId);

	@Query("select i from InvestmentRound i where i.id = ?1")
	InvestmentRound findInvestmentRoundById(int investmentRoundId);

	@Query("select bk from Bookkeeper bk where bk.id = ?1")
	Bookkeeper findBookkeeperById(int bookkeeperId);

	void save(AccountingRecord entity);

}
