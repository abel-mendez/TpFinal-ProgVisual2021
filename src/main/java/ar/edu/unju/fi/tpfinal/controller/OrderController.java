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
import ar.edu.unju.fi.tpfinal.models.Orders;
import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;

/**Clase OrderController
 * Clase que responde a los eventos e invoca peticiones de Order
 *  ademas es el intermediario entre la vista y el modelo .
 * @author ProgVisual2021
 *
 */
@Controller
public class OrderController {
	
	@Autowired
	private IOrdersService orderService;
	private static final Log LOGGER= LogFactory.getLog(OrderController.class);
	@Autowired
	private ICustomersService customerService;
	
	/**Metodo para levantar pagina
	 * @param model
	 * @return Retorna la pagina new-order
	 */
	@GetMapping("/order/new")
	public String newOrderPage(Model model) {
		LOGGER.info("CONTROLLER : OrderController with / get method");
		LOGGER.info("METHOD : newOrderPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA new-order.html");
		model.addAttribute("order", orderService.getOrder());
		model.addAttribute("customers", customerService.getAllCustomers());		
		return"new-order";
	}
	
	/**Guardar oneOrder
	 * @param oneOrder de la vista 
	 * @return pagina all-order
	 */
	@PostMapping("/order/save")
	public ModelAndView saveOrderPage(@Valid @ModelAttribute("order") Orders oneOrder,BindingResult result) {
		LOGGER.info("CONTROLLER : OrderController with / post method");
		LOGGER.info("METHOD : saveOrderPage()");
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VALIDACION");
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-order.html");
			ModelAndView modelVi= new ModelAndView("new-order");
			modelVi.addObject("order", oneOrder);
			modelVi.addObject("customers", customerService.getAllCustomers());	
			return modelVi;
		}else {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA all-order.html");
			ModelAndView modelView=new ModelAndView("all-order");
			Customers cust= customerService.getCustomerById(oneOrder.getCustomers().getCustomerNumber());
			oneOrder.setCustomers(cust);
			orderService.guardarOrder(oneOrder);
			modelView.addObject("orders", orderService.getAllOrders());

			return modelView;
		}
		
	}
	
	/**Modelo que muestra la vista donde esta la tabla de todos los orders, la vista se
	 * llama all-order.html
	 * @return retorna el modelo donde esta la vista all-order.html que muestra la lista 
	 * de todos los orders.
	 */
	@GetMapping("/order/all")
	public ModelAndView getOrdersPage() {
		LOGGER.info("CONTROLLER : OrderController with / order/all get method");
		LOGGER.info("METHOD : getOrderPage()");		
		ModelAndView modelView = new ModelAndView("all-order");
		modelView.addObject("orders",orderService.getAllOrders());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-order.html");
		return modelView;
	}

	/**Modelo principalmente que sirve para editar informacion del objeto (Order)
	 * mostrando la vista del formulario (new-order.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion.
	 * @param id parametro que nos permite identificar el objeto a editar por medio del id
	 * @return retorna la vista new-order.html
	 */
	@GetMapping("/order/edit/{id}")
	public ModelAndView editOrderPage(@PathVariable(value="id") int id) {
		ModelAndView modelView = new ModelAndView("new-order");
		Orders order= orderService.getOrderById(id);
		modelView.addObject("order", order);
		modelView.addObject("customers", customerService.getAllCustomers());	
		return modelView;
	}

	/**
	 * @param id parametro que permite identificar el objeto a eliminar
	 * @return retorna la vista all-order.html
	 */
	@GetMapping("/order/delete/{id}")
	public ModelAndView deleteOrderPage(@PathVariable(value="id") int id) { 
		ModelAndView modelView = new ModelAndView("redirect:/order/all");
		orderService.deleteOrderById(id);
		return modelView;
	}

}
