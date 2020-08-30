
package acme.features.authenticated.accountingRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.accountingRecord.AccountingRecordStatus;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAccountingRecordShowService implements AbstractShowService<Authenticated, AccountingRecord> {

	@Autowired
	private AuthenticatedAccountingRecordRepository repository;


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		int accountingRecordId = request.getModel().getInteger("id");
		AccountingRecord accountingRecord = this.repository.findOneById(accountingRecordId);

		boolean result = accountingRecord.getStatus() == AccountingRecordStatus.PUBLISHED;

		return result;
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "body");
	}

	@Override
	public AccountingRecord findOne(final Request<AccountingRecord> request) {
		assert request != null;

		AccountingRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
