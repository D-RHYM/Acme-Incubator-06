
package acme.features.authenticated.accountingRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.accountingRecord.AccountingRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedAccountingRecordRepository extends AbstractRepository {

	@Query("select a from AccountingRecord a where a.id = ?1")
	AccountingRecord findOneById(int id);

	@Query("select a from AccountingRecord a where a.investmentRound.id = ?1 and a.status = acme.entities.accountingRecord.AccountingRecordStatus.PUBLISHED")
	Collection<AccountingRecord> findManyPublishedByInvestmentRoundId(int investmentRoundId);
}
