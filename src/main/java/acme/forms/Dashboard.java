
package acme.forms;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						totalNumberOfNotices;
	Integer						totalNumberOfTechRecords;
	Integer						totalNumberOfToolRecords;

	Double						maxMoneyOfActiveInquires;
	Double						minMoneyOfActiveInquires;
	Double						avgMoneyOfActiveInquires;
	Double						standardDeviationMoneyOfActiveInquires;

	Double						maxMoneyOfActiveOvertures;
	Double						minMoneyOfActiveOvertures;
	Double						avgMoneyOfActiveOvertures;
	Double						standardDeviationMoneyOfActiveOvertures;

	Object[]					totalNumberOfTechRecordsByActivitySectors;
	Object[]					totalNumberOfToolRecordsByActivitySectors;

	Double						ratioOfOpenSourceTechRecords;
	Double						ratioOfCloseSourceTechRecords;
	Double						ratioOfOpenSourceToolRecords;
	Double						ratioOfCloseSourceToolRecords;
}
