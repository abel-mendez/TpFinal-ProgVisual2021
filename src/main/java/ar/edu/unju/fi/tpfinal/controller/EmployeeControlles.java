package ar.edu.unju.fi.tpfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class EmployeeControlles {
	@Autowired
	private IEmployeeService employeeService;
	private static final Log LOGGER=LogFactory.getLog(EmployeeControlles.class);
	
	@Autowired
	private IOfficeService officeService;
	
	@GetMapping("/employee/new")
	public String nuevoOfficePage(Model model) {
		LOGGER.info("CONTROLLER : OfficeController with / get method");
		LOGGER.info("METHOD : nuevoOfficePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevo-office.html");
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("office", officeService.getAllOffices());
		model.addAttribute("employe", employeeService.getAllEmployees());
		return "new-employee";
		
	}

}