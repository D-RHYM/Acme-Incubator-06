
package acme.features.authenticated.techRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.techRecords.TechRecord;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedTechRecordListService implements AbstractListService<Authenticated, TechRecord> {

	@Autowired
	AuthenticatedTechRecordRepository repository;


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

		request.unbind(entity, model, "title", "activitySector", "stars");

	}

	@Override
	public Collection<TechRecord> findMany(final Request<TechRecord> request) {
		assert request != null;
		Collection<TechRecord> result;
		result = this.repository.findManyAll();
		return result;
	}

}
