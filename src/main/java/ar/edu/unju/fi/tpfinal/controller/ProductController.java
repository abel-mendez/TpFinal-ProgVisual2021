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

import ar.edu.unju.fi.tpfinal.models.Product;
import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;
/**
 * Clase ProductController
 * Clase que responde a los eventos e invoca peticiones de Products
 * y ademas es el intermediario entre la vista y el modelo .
 * @author ProgVisual2021
 *
 */
@Controller
public class ProductController {
	@Autowired
	private IProductLineService productLineService;
	@Autowired
	private IProductService productService;
	private static final Log LOGGER=LogFactory.getLog(ProductLineController.class);
	
	/**
	 * etodo que nos permite mostrar el formulario para ingresar un nuevo Product
	 * donde por medio del controller mostramos el template new-product.html
	 * @param model Parametro que se usa para agregar informacion al template,
	 * @return retorna el template new-product.html
	 */
	@GetMapping("/product/new")
	public String nuevoProductPage(Model model) {
		LOGGER.info("-CONTROLLER : ProductController with / get method");
		LOGGER.info("-METHOD : nuevoProductPage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-product.html");
		model.addAttribute("product", productService.getNewProduct());
		model.addAttribute("productsLine",productLineService.getAllProductsLine());
		return "new-product";
	}
	

	/**
	 * Metodo que sirve para capturar los valores o informacion ingresada en el template
	 * new-product.html por medio del metodo POST, para mandarla y almacenarla a la base
	 * de datos.
	 * @param product paramero que trae datos de la vista un product
	 * @param result parametro que caputra si existe algun error en la vista.
	 * @return retorna la vista donde se almacenan todos los customers (all-product.html) o si 
	 * se presenta algun error de validacion en la vista nos muestra nuevamente la 
	 * vista new-product.html
	 */
	@PostMapping("/product/save")
	public ModelAndView guardarProduc(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		LOGGER.info("CONTROLLER : ProductController with / post method");
		LOGGER.info("METHOD : guardarProductPage()");
		
		
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VALIDACION");
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-product.html");
			ModelAndView modelVi = new ModelAndView("new-product");
			modelVi.addObject("product", product);
			modelVi.addObject("productsLine", productLineService.getAllProductsLine());
			return modelVi;
		}else {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA all-products.html");
			ModelAndView modelView = new ModelAndView("all-products");
			ProductLine proLine= productLineService.getProductLineById(product.getProductLine().getProductline());
			System.out.println("-------"+proLine);
			product.setProductLine(proLine);
			productService.guardarProduct(product);
			modelView.addObject("products",productService.getAllProducts());
			return modelView;
		}
	}
	
	/**
	 * Modelo que muestra la vista donde esta la tabla de todos los products, la vista se
	 * llama all-products.html
	 * @return retorna el modelo donde esta la vista all-products.html que muestra la lista 
	 * de todos los products.
	 */
	@GetMapping("/product/all")
	public ModelAndView getProductsPage() {
		LOGGER.info("CONTROLLER : ProductController with / product/all get method");
		LOGGER.info("METHOD : getProductsPage()");		
		ModelAndView modelView = new ModelAndView("all-products");
		modelView.addObject("products",productService.getAllProducts());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-products.html");
		return modelView;
	}
	
	/**
	 * Modelo principalmente que sirve para editar informacion del objeto (Product)
	 * mostrando la vista del formulario (new-product.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion. 
	 * @param id parametro que nos permite identificar el objeto a editar por medio del id
	 * @returnretorna la vista new-product.html
	 */
	@GetMapping("/product/edit/{id}")
	public ModelAndView editProductPage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("new-product");
		Product product= productService.getProductById(id);
		modelView.addObject("product", product);
		modelView.addObject("productsLine",productLineService.getAllProductsLine());
		return modelView;
	}
	
	/**
	 * Metodo que permite eliminar un objeto de la vista (all-products.html)
	 * atraves del id del objeto.
	 * @param id parametro que permite identificar el objeto a eliminar
	 * @return retorna la vista all-products.html
	 */
	@GetMapping("/product/delete/{id}")
	public ModelAndView deleteProductPage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/product/all");
		productService.eliminarProduct(id);
		return modelView;
	}
}
