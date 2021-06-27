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
@Controller
public class ProductController {
	@Autowired
	private IProductLineService productLineService;
	@Autowired
	private IProductService productService;
	private static final Log LOGGER=LogFactory.getLog(ProductLineController.class);
	
	@GetMapping("/product/new")
	public String nuevoProductPage(Model model) {
		LOGGER.info("-CONTROLLER : ProductController with / get method");
		LOGGER.info("-METHOD : nuevoProductPage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-product.html");
		model.addAttribute("product", productService.getNewProduct());
		model.addAttribute("productsLine",productLineService.getAllProductsLine());
		return "new-product";
	}
	

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
	
	@GetMapping("/product/all")
	public ModelAndView getProductsPage() {
		LOGGER.info("CONTROLLER : ProductController with / product/all get method");
		LOGGER.info("METHOD : getProductsPage()");		
		ModelAndView modelView = new ModelAndView("all-products");
		modelView.addObject("products",productService.getAllProducts());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-products.html");
		return modelView;
	}
	
	@GetMapping("/product/edit/{id}")
	public ModelAndView editProductPage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("new-product");
		Product product= productService.getProductById(id);
		modelView.addObject("product", product);
		modelView.addObject("productsLine",productLineService.getAllProductsLine());
		return modelView;
	}
	
	@GetMapping("/product/delete/{id}")
	public ModelAndView deleteProductPage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/product/all");
		productService.eliminarProduct(id);
		return modelView;
	}
}
