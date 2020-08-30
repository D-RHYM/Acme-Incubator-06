
package acme.features.administrator.customisationParameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisationParameters.CustomisationParameters;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCustomisationParametersShowService implements AbstractShowService<Administrator, CustomisationParameters> {

	@Autowired
	AdministratorCustomisationParametersRepository repository;


	@Override
	public boolean authorise(final Request<CustomisationParameters> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<CustomisationParameters> request, final CustomisationParameters entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWords", "spamThreshold", "activitySectors");
	}

	@Override
	public CustomisationParameters findOne(final Request<CustomisationParameters> request) {

		assert request != null;
		CustomisationParameters result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}
}
