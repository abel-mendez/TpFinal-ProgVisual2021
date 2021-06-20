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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.models.Customers;
import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Controller
public class CustomerController {
	
	@Autowired
	private ICustomersService customerService;
	private static final Log LOGGER=LogFactory.getLog(CustomerController.class);
	@Autowired
	private IEmployeeService employeeService;
	
	@GetMapping("/customer/new")
	public String nuevoProductPage(Model model) {
		LOGGER.info("-CONTROLLER : ProductController with / get method");
		LOGGER.info("-METHOD : nuevoProductLinePage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-product.html");
		model.addAttribute("customer", customerService.getCustomer());
		model.addAttribute("employees",customerService.getAllCustomers());
		return "new-customer";
	}
	
	@PostMapping("/customer/save")
	public ModelAndView guardarCustomer(@ModelAttribute("customer")Customers unCustomer) {
		
		ModelAndView modelView=new ModelAndView("all-customer");
		
		
		if (unCustomer.getEmployee().getEmployeeNumber()==0) {
			unCustomer.setEmployee(null);
			
		} else {
			Employee employee=employeeService.getEmployeeById(unCustomer.getEmployee().getEmployeeNumber());
			unCustomer.setEmployee(employee);
			System.out.println("--->"+employee);
		}
		
		customerService.guardarCustomer(unCustomer);
		modelView.addObject("customers",customerService.getAllCustomers());
		return modelView;
	}
	
	@GetMapping("/customer/all")
	public ModelAndView getCustomersPage() {
		LOGGER.info("CONTROLLER : CustomerController with / product/all get method");
		LOGGER.info("METHOD : getCustomersPage()");		
		ModelAndView modelView = new ModelAndView("all-customer");
		modelView.addObject("customers",customerService.getAllCustomers());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-customer.html");
		return modelView;
	}
	
	@GetMapping("/customer/edit/{id}")
	public ModelAndView editCustomerPage(@PathVariable(value="id") int id) {
		ModelAndView modelView = new ModelAndView("new-customer");
		Customers customer= customerService.getCustomerById(id);
		modelView.addObject("customer", customer);
		modelView.addObject("employee",employeeService.getAllEmployees());
		return modelView;
	}
	
	@GetMapping("/customer/delete/{id}")
	public ModelAndView deleteCustomerPage(@PathVariable(value="id") int id) { 
		ModelAndView modelView = new ModelAndView("redirect:/customer/all");
		customerService.deleteCustomerById(id);
		return modelView;
	}

}