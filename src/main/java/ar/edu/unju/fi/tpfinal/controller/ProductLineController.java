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

/**
 * Clase ProductLineController
 * Clase que responde a los eventos e invoca peticiones de ProductLine
 * y ademas es el intermediario entre la vista y el modelo .
 * 
 * @author ProgVisual2021
 *
 */
@Controller
public class ProductLineController {
	@Autowired
	private IProductLineService productLineService;
	private static final Log LOGGER=LogFactory.getLog(ProductLineController.class);
	
	/**
	 * Metodo que nos permite mostrar el formulario para ingresar un nuevo ProductLine
	 * donde por medio del controller mostramos el template new-productLine.html
	 * 
	 * @param model Parametro que se usa para agregar informacion al template,
	 * @return retorna el template new-productLine.html
	 */
	@GetMapping("/product/productLine/new")
	public String nuevoProductLinePage(Model model) {
		LOGGER.info("-CONTROLLER : ProductLineController with / get method");
		LOGGER.info("-METHOD : nuevoProductLinePage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-productLine.html");
		model.addAttribute("productLine", productLineService.getNewProductLine());
		return "new-productLine";
	}
	

	/**
	 * Metodo que sirve para capturar los valores o informacion ingresada en el template
	 * new-productLine.html por medio del metodo POST, para mandarla y almacenarla a la base
	 * de datos.
	 * 
	 * @param productLine  parametro Modelo que captura lo ingresado en la vista.
	 * @param result parametro que caputra si existe algun error en la vista.
	 * @return retorna la vista donde se almacenan todos los customers (all-productLine.html) o si 
	 * se presenta algun error de validacion en la vista nos muestra nuevamente la 
	 * vista new-customer.html
	 */
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
	
	/**
	 * Modelo que muestra la vista donde esta la tabla de todos los customers, la vista se
	 * llama all-productLine.html
	 * 
	 * @return  retorna el modelo donde esta la vista all-productLine.html que muestra la lista 
	 * de todos los customers.
	 */
	@GetMapping("/product/productLine/all")
	public ModelAndView getProductsLinePage() {
		LOGGER.info("CONTROLLER : OfficeController with / office/listado get method");
		LOGGER.info("METHOD : getOfficesPage()");		
		ModelAndView modelView = new ModelAndView("all-productsLine");
		modelView.addObject("productsLine",productLineService.getAllProductsLine());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA offices.html");
		return modelView;
	}
	
	/** 
	 *  Modelo principalmente que sirve para editar informacion del objeto (ProductLine)
	 * mostrando la vista del formulario (new-productLine.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion. 
	 * 
	 * @param id parametro que nos permite identificar el objeto a editar por medio del id
	 * @return retorna la vista new-productLine.html
	 */
	@GetMapping("/product/productLine/edit/{id}")
	public ModelAndView editOfficePage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("new-productLine");
		ProductLine productLine= productLineService.getProductLineById(id);
		modelView.addObject("productLine", productLine);
		return modelView;
	}
	
	/**
	 * Metodo que permite eliminar un objeto de la vista (all-productLine.html)
	 * atraves del id del objeto.
	 * 
	 * @param id parametro que permite identificar el objeto a eliminar
	 * @return retorna la vista all-productLine.html
	 */
	@GetMapping("/product/productLine/delete/{id}")
	public ModelAndView deleteOfficePage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/product/productLine/all");
		productLineService.eliminarProductLine(id);
		return modelView;
	}

}
