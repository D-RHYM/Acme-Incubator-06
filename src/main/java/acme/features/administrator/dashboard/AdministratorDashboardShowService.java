
package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "totalNumberOfNotices", "totalNumberOfTechRecords", "totalNumberOfToolRecords", "totalNumberOfTechRecordsByActivitySectors", "totalNumberOfToolRecordsByActivitySectors", "ratioOfOpenSourceTechRecords",
			"ratioOfCloseSourceTechRecords", "ratioOfOpenSourceToolRecords", "ratioOfCloseSourceToolRecords");
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		result.setTotalNumberOfNotices(this.repository.findTotalNumberOfNotices());
		result.setTotalNumberOfTechRecords(this.repository.findTotalNumberOfTechRecords());
		result.setTotalNumberOfToolRecords(this.repository.findTotalNumberOfToolRecords());

		result.setRatioOfOpenSourceTechRecords(this.repository.ratioOfOpenSourceTechRecords());
		result.setRatioOfCloseSourceTechRecords(this.repository.ratioOfCloseSourceTechRecords());
		result.setRatioOfOpenSourceToolRecords(this.repository.ratioOfOpenSourceToolRecords());
		result.setRatioOfCloseSourceToolRecords(this.repository.ratioOfCloseSourceToolRecords());

		result.setTotalNumberOfTechRecordsByActivitySectors(this.repository.findTotalNumberOfTechRecordsByActivitySectors());
		result.setTotalNumberOfToolRecordsByActivitySectors(this.repository.findTotalNumberOfToolRecordsByActivitySectors());

		return result;
	}

}
