
package acme.features.bookkeeper.investmentRounds;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class BookkeeperInvestmentRoundListNotMineService implements AbstractListService<Bookkeeper, InvestmentRound> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private BookkeeperInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "ticker", "amount");

	}

	@Override
	public Collection<InvestmentRound> findMany(final Request<InvestmentRound> request) {
		assert request != null;

		Collection<InvestmentRound> res;
		int id = request.getPrincipal().getActiveRoleId();
		List<InvestmentRound> lista = this.repository.findInvestmentRoundsByNotBookkeeperId(id).stream().distinct().collect(Collectors.toList());
		res = lista;

		return res;
	}

}
