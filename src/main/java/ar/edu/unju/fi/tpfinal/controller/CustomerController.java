package ar.edu.unju.fi.tpfinal.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.models.Customers;
import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

/**
 * Clase CustomerController
 * Clase que responde a los eventos e invoca peticiones de Customers
 * y ademas es el intermediario entre la vista y el modelo .
 * @author ProgVisual2021
 *
 */
@Controller
public class CustomerController {
	
	
	@Autowired
	private ICustomersService customerService;
	private static final Log LOGGER=LogFactory.getLog(CustomerController.class);
	@Autowired
	private IEmployeeService employeeService;
	


	@GetMapping("/error")
	public String errorMapping() {
		return "index";
	}

	/**
	 * Metodo que nos permite mostrar el formulario para ingresar un nuevo Customers
	 * donde por medio del controller mostramos el template new-customer.html
	 * @param model Parametro que se usa para agregar informacion al template,
	 * @return retorna el template new-customer.html
	 */
	@GetMapping("/customer/new")
	public String nuevoCustomerPage(Model model) {
		LOGGER.info("-CONTROLLER : CustomerController with / get method");
		LOGGER.info("-METHOD : nuevoCustomerPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA new-customer.html");
		model.addAttribute("customer", customerService.getCustomer());
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "new-customer";
	}
	
	/**
	 * Metodo que sirve para capturar los valores o informacion ingresada en el template
	 * new-customer.html por medio del metodo POST, para mandarla y almacenarla a la base
	 * de datos.
	 * @param unCustomer parametro Modelo que captura lo ingresado en la vista.
	 * @param result parametro que caputra si existe algun error en la vista.
	 * @return retorna la vista donde se almacenan todos los customers (all-customer.html) o si 
	 * se presenta algun error de validacion en la vista nos muestra nuevamente la 
	 * vista new-customer.html
	 */
	@PostMapping("/customer/save")
	public ModelAndView guardarCustomer(@Valid @ModelAttribute("customer")Customers unCustomer,BindingResult result) {
		LOGGER.info("CONTROLLER : customerController with / post method");
		LOGGER.info("METHOD : guardarCustomer()");
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VALIDACION");
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-customer.html");
			ModelAndView modelVi= new ModelAndView("new-customer");
			modelVi.addObject("customer", unCustomer);
			modelVi.addObject("employees",employeeService.getAllEmployees());
			return modelVi;
		}else {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA all-customer.html");
			ModelAndView modelView=new ModelAndView("all-customer");
			if (unCustomer.getEmployee().getEmployeeNumber()==0) {
				unCustomer.setEmployee(null);
			} else {
				Employee emp=employeeService.getEmployeeById(unCustomer.getEmployee().getEmployeeNumber());
				unCustomer.setEmployee(emp);
			}
			customerService.guardarCustomer(unCustomer);
			modelView.addObject("customers",customerService.getAllCustomers());
			return modelView;
		}
	}
	
	/**
	 * Modelo que muestra la vista donde esta la tabla de todos los customers, la vista se
	 * llama all-customers.html
	 * @return retorna el modelo donde esta la vista all-customer.html que muestra la lista 
	 * de todos los customers.
	 */
	@GetMapping("/customer/all")
	public ModelAndView getCustomersPage() {
		LOGGER.info("CONTROLLER : CustomerController with / product/all get method");
		LOGGER.info("METHOD : getCustomersPage()");		
		ModelAndView modelView = new ModelAndView("all-customer");
		modelView.addObject("customers",customerService.getAllCustomers());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-customer.html");
		return modelView;
	}
	
	/**
	 * Modelo principalmente que sirve para editar informacion del objeto (Customer)
	 * mostrando la vista del formulario (new-customer.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion. 
	 * @param id parametro que nos permite identificar el objeto a editar por medio del id
	 * @return retorna la vista new-customer.html
	 */
	@GetMapping("/customer/edit/{id}")
	public ModelAndView editCustomerPage(@PathVariable(value="id") int id) {
		ModelAndView modelView = new ModelAndView("new-customer");
		Customers customer= customerService.getCustomerById(id);
		modelView.addObject("customer", customer);
		modelView.addObject("employees",employeeService.getAllEmployees());
		return modelView;
	}
	
	/**
	 * Metodo que permite eliminar un objeto de la vista (all-customer.html)
	 * atraves del id del objeto.
	 * @param id parametro que permite identificar el objeto a eliminar
	 * @return retorna la vista all-customer.html
	 */
	@GetMapping("/customer/delete/{id}")
	public ModelAndView deleteCustomerPage(@PathVariable(value="id") int id) { 
		ModelAndView modelView = new ModelAndView("redirect:/customer/all");
		customerService.deleteCustomerById(id);
		return modelView;
	}

}
