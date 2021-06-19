package ar.edu.unju.fi.tpfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

@Controller
public class EmployeeControlles {
	@Autowired
	private IEmployeeService employeeService;
	private static final Log LOGGER=LogFactory.getLog(EmployeeControlles.class);
	@Autowired
	private IOfficeService officeService;
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/employee/new")
	public String newEmployeePage(Model model) {
		LOGGER.info("CONTROLLER : EmployeeController with / get method");
		LOGGER.info("METHOD : newEmployeePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevo-office.html");
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("offices", officeService.getAllOffices());
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "new-employee";
	}
	
	@GetMapping("/employee/save")
	public String saveEmployeePage(Model model, @RequestParam (name="employeeNumber") String employeeNumber,
			 @RequestParam (name="lastName") String lastName, @RequestParam (name="firstName") String firstName,
			 @RequestParam (name="extension") String extension, @RequestParam (name="email") String email,
			 @RequestParam (name="office") String officeCode, @RequestParam (name="employee") String reportsTo,
			 @RequestParam (name="jobTitle") String jobTitle,@RequestParam (name="usuario") String id) {
		Employee emplo = new Employee() ;
		emplo.setEmployeeNumber(Integer.valueOf(employeeNumber));
		emplo.setLastName(lastName);
		emplo.setFirstName(firstName);
		emplo.setExtension(extension);
		emplo.setEmail(email);
		
		emplo.setOffice(this.officeService.getOfficeById(officeCode));
		
		if (employeeService.getAllEmployees()== null) {
			emplo.setEmployee(null);
		}else {
			emplo.setEmployee(this.employeeService.getEmployeeById(Integer.valueOf(reportsTo)));
		}
		emplo.setJobTitle(jobTitle);
		emplo.setUser(this.usuarioService.buscarPorUsuario(id));
		employeeService.guardarEmployee(emplo);
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "all-employee";
	}
	
	@GetMapping("/employee/all")
	public ModelAndView getEmployeesPage() {
		LOGGER.info("CONTROLLER : EmployeeController with / employee/all get method");
		LOGGER.info("METHOD : getEmployeesPage()");		
		ModelAndView modelView = new ModelAndView("all-employee");
		modelView.addObject("employees",employeeService.getAllEmployees());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-employee.html");
		return modelView;
	}

	@GetMapping("/employee/edit/{id}")
	public ModelAndView editEmployeePage(@PathVariable(value="id") int id) {
		ModelAndView modelView = new ModelAndView("new-employee");
		Employee employee= employeeService.getEmployeeById(id);
		modelView.addObject("employees", employee);
		return modelView;
	}

	@GetMapping("/employee/delete/{id}")
	public ModelAndView deleteEmployeePage(@PathVariable(value="id") int id) { 
		ModelAndView modelView = new ModelAndView("redirect:/employee/all");
		employeeService.deletEmployeeById(id);
		return modelView;
	}	

}
