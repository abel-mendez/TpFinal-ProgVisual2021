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

import ar.edu.unju.fi.tpfinal.models.Office;
import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@Controller
public class ProductLineController {
	@Autowired
	private IProductLineService productLineService;
	private static final Log LOGGER=LogFactory.getLog(ProductLineController.class);
	
	@GetMapping("/product/productLine/new")
	public String nuevoProductLinePage(Model model) {
		LOGGER.info("-CONTROLLER : ProductLineController with / get method");
		LOGGER.info("-METHOD : nuevoProductLinePage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-productLine.html");
		model.addAttribute("productLine", productLineService.getNewProductLine());
		return "new-productLine";
	}
	

	@PostMapping("/product/productLine/save")
	public ModelAndView guardarProductLine(@Valid @ModelAttribute("productLine") ProductLine productLine,BindingResult result) {
		LOGGER.info("CONTROLLER : ProductLineController with / post method");
		LOGGER.info("METHOD : guardarProductLine()");
		
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VALIDACION");
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-productLine.html");
			ModelAndView modelVi = new ModelAndView("new-productLine");
			modelVi.addObject("productLine", productLine);
			return modelVi;
		}else {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA all-productsLine.html");
			ModelAndView modelView = new ModelAndView("all-productsLine");
			productLineService.guardarProductLine(productLine);
			modelView.addObject("productsLine",productLineService.getAllProductsLine());
			return modelView;
		}
	}
	
	@GetMapping("/product/productLine/all")
	public ModelAndView getProductsLinePage() {
		LOGGER.info("CONTROLLER : OfficeController with / office/listado get method");
		LOGGER.info("METHOD : getOfficesPage()");		
		ModelAndView modelView = new ModelAndView("all-productsLine");
		modelView.addObject("productsLine",productLineService.getAllProductsLine());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA offices.html");
		return modelView;
	}
	
	@GetMapping("/product/productLine/edit/{id}")
	public ModelAndView editOfficePage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("new-productLine");
		ProductLine productLine= productLineService.getProductLineById(id);
		modelView.addObject("productLine", productLine);
		return modelView;
	}
	
	@GetMapping("/product/productLine/delete/{id}")
	public ModelAndView deleteOfficePage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/product/productLine/all");
		productLineService.eliminarProductLine(id);
		return modelView;
	}

}
