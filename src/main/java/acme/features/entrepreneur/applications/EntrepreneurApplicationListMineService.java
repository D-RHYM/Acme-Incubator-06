
package acme.features.entrepreneur.applications;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurApplicationListMineService implements AbstractListService<Entrepreneur, Application> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return request.getPrincipal().hasRole(Entrepreneur.class);
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "moment", "status");

	}

	@Override
	public Collection<Application> findMany(final Request<Application> request) {
		assert request != null;

		Collection<Application> result;
		result = this.repository.findManyByEntrepreneurId(request.getPrincipal().getActiveRoleId());

		return result;
	}

}
