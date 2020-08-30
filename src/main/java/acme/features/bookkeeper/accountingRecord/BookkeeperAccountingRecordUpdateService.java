
package acme.features.bookkeeper.accountingRecord;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.accountingRecord.AccountingRecordStatus;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class BookkeeperAccountingRecordUpdateService implements AbstractUpdateService<Bookkeeper, AccountingRecord> {

	@Autowired
	BookkeeperAccountingRecordRepository repository;


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		Principal principal = request.getPrincipal();
		int id = request.getModel().getInteger("id");
		AccountingRecord accountingRecord = this.repository.findOneById(id);
		boolean result = accountingRecord.getBookkeeper().getId() == principal.getActiveRoleId() && accountingRecord.getStatus() == AccountingRecordStatus.DRAFT;

		return result;
	}

	@Override
	public void bind(final Request<AccountingRecord> request, final AccountingRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "status", "body", "investmentRound.id");
	}

	@Override
	public void validate(final Request<AccountingRecord> request, final AccountingRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public AccountingRecord findOne(final Request<AccountingRecord> request) {
		assert request != null;

		AccountingRecord accountingRecord;
		int accountingRecordId;

		accountingRecordId = request.getModel().getInteger("id");
		accountingRecord = this.repository.findOneById(accountingRecordId);

		return accountingRecord;
	}

	@Override
	public void update(final Request<AccountingRecord> request, final AccountingRecord entity) {
		assert request != null;
		assert entity != null;
		Date creationMoment;

		creationMoment = new Date(System.currentTimeMillis() - 1);
		entity.setCreationMoment(creationMoment);

		this.repository.save(entity);
	}

}
