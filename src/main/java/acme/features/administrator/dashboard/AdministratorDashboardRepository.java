
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("SELECT count(n.id) FROM Notice n")
	Integer findTotalNumberOfNotices();

	@Query("SELECT count(t.id) FROM TechRecord t")
	Integer findTotalNumberOfTechRecords();

	@Query("SELECT count(t.id) FROM ToolRecord t")
	Integer findTotalNumberOfToolRecords();

	@Query("SELECT max(a.maxMoney.amount) FROM Inquirie a where a.deadline > current_date()")
	Object[] findMaxMoneyOfActiveInquires();

	@Query("SELECT min(a.minMoney.amount) FROM Inquirie a where a.deadline > current_date()")
	Object[] findMinMoneyOfActiveInquires();

	@Query("SELECT avg((a.maxMoney.amount+a.minMoney.amount)/2) FROM Inquirie a where a.deadline > current_date()")
	Object[] findAvgMoneyOfActiveInquires();

	@Query("SELECT stddev((a.maxMoney.amount+a.minMoney.amount)/2) FROM Inquirie a where a.deadline > current_date()")
	Object[] findStandardDeviationMoneyOfActiveInquires();

	@Query("SELECT max(a.maxMoney.amount) FROM Overture a where a.deadline > current_date()")
	Object[] findMaxMoneyOfActiveOvertures();

	@Query("SELECT min(a.minMoney.amount) FROM Overture a where a.deadline > current_date()")
	Object[] findMinMoneyOfActiveOvertures();

	@Query("SELECT avg((a.maxMoney.amount+a.minMoney.amount)/2) FROM Overture a where a.deadline > current_date()")
	Object[] findAvgMoneyOfActiveOvertures();

	@Query("SELECT stddev((a.maxMoney.amount+a.minMoney.amount)/2) FROM Overture a where a.deadline > current_date()")
	Object[] findStandardDeviationMoneyOfActiveOvertures();

	@Query("SELECT t.activitySector, count(t) FROM TechRecord t GROUP BY t.activitySector ORDER BY t.activitySector")
	Object[] findTotalNumberOfTechRecordsByActivitySectors();

	@Query("SELECT t.sector, count(t) FROM ToolRecord t GROUP BY t.sector ORDER BY t.sector")
	Object[] findTotalNumberOfToolRecordsByActivitySectors();

	@Query("SELECT 1.0 * count(t) / (SELECT count(c) FROM TechRecord c) FROM TechRecord t WHERE t.open = true")
	Double ratioOfOpenSourceTechRecords();

	@Query("SELECT 1.0 * count(t) / (SELECT count(c) FROM TechRecord c) FROM TechRecord t WHERE t.open = false")
	Double ratioOfCloseSourceTechRecords();

	@Query("SELECT 1.0 * count(t) / (SELECT count(c) FROM ToolRecord c) FROM ToolRecord t WHERE t.open = true")
	Double ratioOfOpenSourceToolRecords();

	@Query("SELECT 1.0 * count(t) / (SELECT count(c) FROM ToolRecord c) FROM ToolRecord t WHERE t.open = false")
	Double ratioOfCloseSourceToolRecords();

}
