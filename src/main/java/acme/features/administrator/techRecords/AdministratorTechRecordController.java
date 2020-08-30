
package acme.features.administrator.techRecords;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.techRecords.TechRecord;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/tech-record/")
public class AdministratorTechRecordController extends AbstractController<Administrator, TechRecord> {

	@Autowired
	private AdministratorTechRecordListService		listService;

	@Autowired
	private AdministratorTechRecordShowService		showService;

	@Autowired
	private AdministratorTechRecordCreateService	createService;

	@Autowired
	private AdministratorTechRecordUpdateService	updateService;

	@Autowired
	private AdministratorTechRecordDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.UPDATE, this.updateService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
