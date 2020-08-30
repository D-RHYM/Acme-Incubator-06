
package acme.features.administrator.customisationParameters;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorCustomisationParametersListService implements AbstractListService<Administrator, CustomisationParameters> {

	@Autowired
	AdministratorCustomisationParametersRepository repository;


	@Override
	public boolean authorise(final Request<CustomisationParameters> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<CustomisationParameters> findMany(final Request<CustomisationParameters> request) {
		assert request != null;

		Collection<CustomisationParameters> result;

		result = this.repository.findManyAll();

		return result;
	}

	@Override
	public void unbind(final Request<CustomisationParameters> request, final CustomisationParameters entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWords", "spamThreshold", "activitySectors");
	}
}
