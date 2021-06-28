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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.models.Usuario;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;
/**
 * Clase EmployeeController
 * Clase que responde a los eventos e invoca peticiones de Employee
 * y ademas es el intermediario entre la vista y el modelo .
 * @author ProgVisual2021
 *
 */
@Controller
public class EmployeeControlles {
	@Autowired
	private IEmployeeService employeeService;
	private static final Log LOGGER=LogFactory.getLog(EmployeeControlles.class);
	@Autowired
	private IOfficeService officeService;
	@Autowired
	private IUsuarioService usuarioService;
	
	/**
	 * Metodo que nos permite mostrar el formulario para ingresar un nuevo Employee
	 * donde por medio del controller mostramos el template new-employee.html
	 * @param model Parametro que se usa para agregar informacion al template,
	 * @return retorna el template new-employee.html
	 */
	@GetMapping("/employee/new")
	public String newEmployeePage(Model model) {
		LOGGER.info("CONTROLLER : EmployeeController with / get method");
		LOGGER.info("METHOD : newEmployeePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA new-employee.html");
		model.addAttribute("employee", employeeService.getEmployee());
		model.addAttribute("offices", officeService.getAllOffices());
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "new-employee";
	}
	
	/**
	 * Metodo que sirve para capturar los valores o informacion ingresada en el template
	 * new-employee.html por medio del metodo GET, para mandarla y almacenarla a la base
	 * de datos.
	 * @param oneEmployee parametro Modelo que captura lo ingresado en la vista.
	 * @param result parametro que caputra si existe algun error en la vista.
	 * @param model parametro que caputra los valores ingresados en la vista para devolver 
	 * los valores cargados en caso de que ocurra un validacion.
	 * Atributos de la clase employee que sirven para asignar los valores manualmente. 
	 * @param employeeNumber
	 * @param lastName
	 * @param firstName
	 * @param extension
	 * @param email
	 * @param officeCode
	 * @param reportsTo
	 * @param jobTitle
	 * Atributos de la clase Usuario que sirven para asignar los valores manualmente. 
	 * @param id
	 * @param usuario
	 * @param password
	 * @param tipo
	 * @return retorna la vista donde se almacenan todos los Employee (all-employee.html)
	 */
	@GetMapping("/employee/save")
	public String saveEmployeePage(@Valid @ModelAttribute("employee") Employee oneEmployee,BindingResult result,Model model, @RequestParam (name="employeeNumber") String employeeNumber,
			 @RequestParam (name="lastName") String lastName, @RequestParam (name="firstName") String firstName,
			 @RequestParam (name="extension") String extension, @RequestParam (name="email") String email,
			 @RequestParam (name="office.officeCode") String officeCode, @RequestParam (name="employee.employeeNumber") String reportsTo,
			 @RequestParam (name="jobTitle") String jobTitle,
			 @RequestParam (name="user.id") Long id,@RequestParam (name="user.usuario") String usuario,
			 @RequestParam (name="user.password") String password,@RequestParam (name="user.tipo") String tipo) {
		LOGGER.info("CONTROLLER : EmployeeControlles with / get method");
		LOGGER.info("METHOD : saveEmployeePage()");
		Employee emplo = new Employee() ;
		emplo.setEmployeeNumber(Integer.valueOf(employeeNumber));
		emplo.setLastName(lastName);
		emplo.setFirstName(firstName);
		emplo.setExtension(extension);
		emplo.setEmail(email);
		emplo.setOffice(this.officeService.getOfficeById(officeCode));
		
		if (Integer.valueOf(reportsTo)== 0) {
			emplo.setEmployee(null);
		}else {
			emplo.setEmployee(this.employeeService.getEmployeeById(Integer.valueOf(reportsTo)));
		}
		emplo.setJobTitle(jobTitle);
		
		Usuario user= new Usuario();
		user.setId(id);
		user.setUsuario(usuario);
		user.setPassword(password);
		user.setTipo(tipo);

	
		if (result.hasErrors()){
			LOGGER.info("RESULT : VALIDACION");
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-employee.html");
			model.addAttribute("employee", oneEmployee);
			model.addAttribute("offices", officeService.getAllOffices());
			model.addAttribute("employees", employeeService.getAllEmployees());
			return "new-employee";
		}else{
			LOGGER.info("RESULT : VISUALIZA LA PAGINA all-employee.html");
			usuarioService.guardarUsuario(user);
			emplo.setUser(user);
			employeeService.guardarEmployee(emplo);
			model.addAttribute("employees", employeeService.getAllEmployees());
			return "all-employee";
		}
	}

	
	/**
	 * Modelo que muestra la vista donde esta la tabla de todos los employees, la vista se
	 * llama all-employee.html
	 * @return retorna el modelo donde esta la vista all-employee.html que muestra la lista 
	 * de todos los employees.
	 */
	@GetMapping("/employee/all")
	public ModelAndView getEmployeesPage() {
		LOGGER.info("CONTROLLER : EmployeeController with / employee/all get method");
		LOGGER.info("METHOD : getEmployeesPage()");		
		ModelAndView modelView = new ModelAndView("all-employee");
		modelView.addObject("employees",employeeService.getAllEmployees());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-employee.html");
		return modelView;
	}
	
	/**
	 * Modelo que muestra la vista donde esta la tabla los employees con sus Usuarios, la vista se
	 * llama all-employee-account.html
	 * @return retorna el modelo donde esta la vista all-employee-account.html que muestra la lista 
	 * de los empleados con sus Usuarios.
	 */
	@GetMapping("/employee/all/account")
	public ModelAndView getEmployeesAccountPage() {
		LOGGER.info("CONTROLLER : EmployeeController with / employee/all/account get method");
		LOGGER.info("METHOD : getEmployeesAccountPage()");		
		ModelAndView modelView = new ModelAndView("all-employee-account");
		modelView.addObject("employees",employeeService.getAllEmployees());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-employee-account.html");
		return modelView;
	}


	/**
	 * Modelo principalmente que sirve para editar informacion del objeto (Employee)
	 * mostrando la vista del formulario (new-employee.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion. 
	 * @param id parametro que nos permite identificar el objeto a editar por medio del id
	 * @return retorna la vista new-employee.html
	 */
	@GetMapping("/employee/edit/{id}")
	public ModelAndView editEmployeePage(@PathVariable(value="id") int id) {
		ModelAndView modelView = new ModelAndView("new-employee");
		Employee employee= employeeService.getEmployeeById(id);
		modelView.addObject("employee", employee);
		modelView.addObject("employees",employeeService.getAllEmployees());
		modelView.addObject("offices",officeService.getAllOffices());
		return modelView;
	}

	/**
	 * Metodo que permite eliminar un objeto de la vista (all-employee.html)
	 * atraves del id del objeto.
	 * @param id parametro que permite identificar el objeto a eliminar
	 * @return retorna la vista all-employee.html
	 */
	@GetMapping("/employee/delete/{id}")
	public ModelAndView deleteEmployeePage(@PathVariable(value="id") int id) { 
		ModelAndView modelView = new ModelAndView("redirect:/employee/all");
		employeeService.deletEmployeeById(id);
		return modelView;
	}	

}
