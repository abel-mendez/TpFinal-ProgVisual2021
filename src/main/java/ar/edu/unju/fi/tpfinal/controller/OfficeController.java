package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

import javax.naming.Binding;
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

import ar.edu.unju.fi.tpfinal.models.Office;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;
/**
 * Clase OfficeController
 * Clase que responde a los eventos e invoca peticiones de Office
 * y ademas es el intermediario entre la vista y el modelo .
 * @author ProgVisual2021
 *
 */
@Controller
public class OfficeController {
	
	@Autowired
	private IOfficeService officeService;
	
	private static final Log LOGGER = LogFactory.getLog(OfficeController.class);
	
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	/**
	 * Metodo que nos permite mostrar el formulario para ingresar una nueva Office
	 * donde por medio del controller mostramos el template nuevo-office.html
	 * @param model Parametro que se usa para agregar informacion al template,
	 * @return retorna el template nuevo-office.html
	 */
	@GetMapping("/office/new")
	public String nuevoOfficePage(Model model) {
		LOGGER.info("CONTROLLER : OfficeController with / get method");
		LOGGER.info("METHOD : nuevoOfficePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevo-office.html");
		model.addAttribute("office",officeService.getOffice());
		return "nuevo-office";
	}
	
	/**
	 * Metodo que sirve para capturar los valores o informacion ingresada en el template
	 * nuevo-office.html por medio del metodo POST, para mandarla y almacenarla a la base
	 * de datos.
	 * @param oneOffice parametro Modelo que captura lo ingresado en la vista.
	 * @param result parametro que caputra si existe algun error en la vista.
	 * @return retorna la vista donde se almacenan todos los customers (all-offices.html)
	 * o si se presenta algun error de validacion muestra nuevamente la vista nuevo-office.html
	 */
	@PostMapping("/office/save")
	public ModelAndView guardarOfficePage(@Valid @ModelAttribute("office") Office oneOffice, BindingResult result) {
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-payment.html");
			ModelAndView model= new ModelAndView("nuevo-office");
			model.addObject(oneOffice);
			return model;
		}else {
		LOGGER.info("CONTROLLER : OfficeController with / post method");
		LOGGER.info("METHOD : guardarOfficePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA offices.html");		
		ModelAndView modelView = new ModelAndView("all-offices");
		officeService.guardarOffice(oneOffice);
		modelView.addObject("offices",officeService.getAllOffices());
		return modelView;
		}
	}
	
	/**
	 * Modelo que muestra la vista donde esta la tabla de todas las Offices, la vista se
	 * llama all-offices.html
	 * @return retorna el modelo donde esta la vista all-employee.html que muestra la lista 
	 * de todos los employees.
	 */
	@GetMapping("/office/all")
	public ModelAndView getOfficesPage() {
		LOGGER.info("CONTROLLER : OfficeController with / office/listado get method");
		LOGGER.info("METHOD : getOfficesPage()");		
		ModelAndView modelView = new ModelAndView("all-offices");
		modelView.addObject("offices",officeService.getAllOffices());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-offices.html");
		return modelView;
	}
	
	/**
	 * Modelo principalmente que sirve para editar informacion del objeto (Office)
	 * mostrando la vista del formulario (nuevo-office.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion. 
	 * @param id parametro que nos permite identificar el objeto a editar por medio del id
	 * @return retorna la vista nuevo-office.html
	 */
	@GetMapping("/office/edit/{id}")
	public ModelAndView editOfficePage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("nuevo-office");
		Office office= officeService.getOfficeById(id);
		modelView.addObject("office", office);
		return modelView;
	}
	
	/**
	 * Metodo que permite eliminar un objeto de la vista (all-offices.html)
	 * atraves del id del objeto.
	 * @param id parametro que permite identificar el objeto a eliminar
	 * @return retorna la vista all-offices.html
	 */
	@GetMapping("/office/delete/{id}")
	public ModelAndView deleteOfficePage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/office/all");
		officeService.deletOfficeById(id);
		return modelView;
	}
}
