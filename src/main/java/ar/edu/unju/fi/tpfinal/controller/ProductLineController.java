package ar.edu.unju.fi.tpfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {
	@Autowired
	private IProductLineService productLineService;
	private static final Log LOGGER=LogFactory.getLog(ProductLineController.class);
	
	@GetMapping("/productLine/new")
	public String nuevoProductLinePage(Model model) {
		LOGGER.info("-CONTROLLER : ProductLineController with / get method");
		LOGGER.info("-METHOD : nuevoProductLinePage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-productLine.html");
		model.addAttribute("productLine", productLineService.getNewProductLine());
		return "new-productLine";
	}

}
