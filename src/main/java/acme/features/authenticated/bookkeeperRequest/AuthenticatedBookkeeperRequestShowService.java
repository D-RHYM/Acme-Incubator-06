/*
 * AuthenticatedConsumerCreateService.java
 *
 * Copyright (c) 2019 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.authenticated.bookkeeperRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.bookkeeperRequest.BookkeeperRequest;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedBookkeeperRequestShowService implements AbstractShowService<Authenticated, BookkeeperRequest> {

	@Autowired
	private AuthenticatedBookkeeperRequestRepository repository;


	@Override
	public boolean authorise(final Request<BookkeeperRequest> request) {
		assert request != null;

		int bookkeeperRequestId = request.getModel().getInteger("id");
		BookkeeperRequest bookkeeperRequest = this.repository.findOneById(bookkeeperRequestId);
		Principal principal = request.getPrincipal();
		boolean result = !this.repository.findIsBookkeeperByUserAccountId(principal.getAccountId()) && principal.getAccountId() == bookkeeperRequest.getUserAccount().getId();

		return result;
	}

	@Override
	public void unbind(final Request<BookkeeperRequest> request, final BookkeeperRequest entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "firm", "responsabilityStatement", "status");
	}

	@Override
	public BookkeeperRequest findOne(final Request<BookkeeperRequest> request) {
		assert request != null;

		int id = request.getModel().getInteger("id");
		BookkeeperRequest result = this.repository.findOneById(id);

		return result;
	}

}
