
package acme.features.administrator.techRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.techRecords.TechRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractCreateService;

@Service
public class AdministratorTechRecordCreateService implements AbstractCreateService<Administrator, TechRecord> {

	@Autowired
	AdministratorTechRecordRepository repository;


	@Override
	public boolean authorise(final Request<TechRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<TechRecord> request, final TechRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<TechRecord> request, final TechRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorName", "description", "webSite", "email", "open", "stars");

	}

	@Override
	public TechRecord instantiate(final Request<TechRecord> request) {

		TechRecord res = new TechRecord();

		return res;
	}

	@Override
	public void validate(final Request<TechRecord> request, final TechRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<TechRecord> request, final TechRecord entity) {

		this.repository.save(entity);
	}

}
