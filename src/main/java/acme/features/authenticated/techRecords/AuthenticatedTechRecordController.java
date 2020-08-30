
package acme.features.authenticated.techRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.techRecords.TechRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/tech-record/")
public class AuthenticatedTechRecordController extends AbstractController<Authenticated, TechRecord> {

	@Autowired
	private AuthenticatedTechRecordListService	listService;

	@Autowired
	private AuthenticatedTechRecordShowService	showService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
