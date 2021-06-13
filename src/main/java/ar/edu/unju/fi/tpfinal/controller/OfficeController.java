package ar.edu.unju.fi.tpfinal.controller;

import java.util.Optional;

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

import ar.edu.unju.fi.tpfinal.models.Office;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

@Controller
public class OfficeController {
	
	@Autowired
	private IOfficeService officeService;
	
	private static final Log LOGGER = LogFactory.getLog(OfficeController.class);
	
	@GetMapping("/")
	public String getHome() {
		return "index";
	}
	
	@GetMapping("/office/new")
	public String nuevoOfficePage(Model model) {
		LOGGER.info("CONTROLLER : OfficeController with / get method");
		LOGGER.info("METHOD : nuevoOfficePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA nuevo-office.html");
		model.addAttribute("office",officeService.getOffice());
		return "nuevo-office";
	}
	
	@PostMapping("/office/save")
	public ModelAndView guardarOfficePage(@ModelAttribute("office") Office oneOffice) {
		LOGGER.info("CONTROLLER : OfficeController with / post method");
		LOGGER.info("METHOD : guardarOfficePage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA offices.html");		
		ModelAndView modelView = new ModelAndView("offices");
		officeService.guardarOffice(oneOffice);
		modelView.addObject("offices",officeService.getAllOffices());
		return modelView;
	}
	
	@GetMapping("/office/listado")
	public ModelAndView getOfficesPage(@ModelAttribute("office")Office oneOffice) {
		LOGGER.info("CONTROLLER : OfficeController with / office/listado get method");
		LOGGER.info("METHOD : getOfficesPage()");		
		ModelAndView modelView = new ModelAndView("offices");
		modelView.addObject("offices",officeService.getAllOffices());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA offices.html");
		return modelView;
	}
	
	@GetMapping("/office/editar/{id}")
	public ModelAndView editOfficePage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("nuevo-office");
		Optional<Office> office= Optional.ofNullable(officeService.getOfficeById(id));
		modelView.addObject("offices", office);
		return modelView;
	}
	
	@GetMapping("/office/eliminar/{id}")
	public ModelAndView deleteOfficePage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/office/listado");
		officeService.deletOfficeById(id);
		return modelView;
	}
}
