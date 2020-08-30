
package acme.features.bookkeeper.accountingRecord;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecord.AccountingRecord;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service

public class BookkeeperAccountingRecordListService implements AbstractListService<Bookkeeper, AccountingRecord> {

	@Autowired
	BookkeeperAccountingRecordRepository repository;


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		return true;
	}

	@Override
	public Collection<AccountingRecord> findMany(final Request<AccountingRecord> request) {
		assert request != null;

		Collection<AccountingRecord> result = this.repository.findMany(request.getPrincipal().getActiveRoleId());

		return result;
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "investmentRound.ticker", "creationMoment", "status");
	}

}
