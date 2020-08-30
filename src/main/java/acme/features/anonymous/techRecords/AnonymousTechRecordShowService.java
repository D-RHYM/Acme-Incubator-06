
package acme.features.anonymous.techRecords;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.techRecords.TechRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractShowService;

@Service
public class AnonymousTechRecordShowService implements AbstractShowService<Anonymous, TechRecord> {

	@Autowired
	private AnonymousTechRecordRepository repository;


	@Override
	public boolean authorise(final Request<TechRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<TechRecord> request, final TechRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorName", "description", "webSite", "email", "open", "stars");

	}

	@Override
	public TechRecord findOne(final Request<TechRecord> request) {
		assert request != null;
		TechRecord result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

}
