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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;
import ar.edu.unju.fi.tpfinal.models.Orders;
import ar.edu.unju.fi.tpfinal.models.Usuario;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
import ar.edu.unju.fi.tpfinal.service.IProductService;
/**
 * Clase OrderDetailController
 * Clase que responde a los eventos e invoca peticiones de Office
 * y ademas es el intermediario entre la vista y el modelo .
 * @author ProgVisual2021
 *
 */
@Controller
public class OrderDetailController {
	
	@Autowired
	IOrderDetailService orderDetailService;
	@Autowired
	IOrdersService orderService;
	@Autowired
	IProductService productService;
	private static final Log LOGGER= LogFactory.getLog(OrderDetailController.class);
	
	
	/**
	 * Metodo que nos permite mostrar el formulario para ingresar una nueva OrderDetail
	 * donde por medio del controller mostramos el template new-orderdetails.html
	 * @param model Parametro que se usa para agregar informacion al template,
	 * @return retorna el template new-orderdetails.html
	 */
	@GetMapping("/order/orderDetail/new")
	public String getOrderDetailPage(Model model) {
		LOGGER.info("-CONTROLLER : OrderDetailController with / get method");
		LOGGER.info("-METHOD : getOrderDetailPage()");
		LOGGER.info("-RESULT : VISUALIZA LA PAGINA new-orderdetails.html");
		model.addAttribute("orderDetail", orderDetailService.getNewOrderDetail());
		model.addAttribute("order", orderService.getAllOrders());
		model.addAttribute("product", productService.getAllProducts());
		return "new-orderdetails";
	}
	
	
	/**
	 * Metodo que sirve para capturar los valores o informacion ingresada en el template
	 * new-orderdetails.html por medio del metodo GET, para mandarla y almacenarla a la base
	 * de datos y ademas ingresa valores a los atributos a la clase OrderDetailId para que se
	 * genere la tabla que relaciona Products con OrderDetail en la base de datos.
	 * @param orderDet
	 * @param result
	 * @param model
	 * Atributos de la clase OrderDetailId que sirven para asignar los valores manualmente.
	 * @param orderNumber
	 * @param productCode
	 * Atributos de la clase OrderDetail que sirven para asignar los valores manualmente.
	 * @param quantityOrdered
	 * @param princeEach
	 * @param orderLineNumber
	 * @return retorna la vista (all-orderdetail) donde se muestran todas las OrderDetails que estan en la
	 * base de datos o si presenta alguna error de validacion nos muetra nuevamente la vista 
	 * new-orderdetails.html
	 */
	@GetMapping("/order/orderDetail/save")
	public String saveOrderDetailPage(@Valid @ModelAttribute("orderDetail") OrderDetail orderDet,BindingResult result, Model model, @RequestParam (name="id.orderNumber") int orderNumber,
			 @RequestParam (name="id.productCode") String productCode, @RequestParam (name="quantityOrdered") int quantityOrdered,
			 @RequestParam (name="princeEach") double princeEach, @RequestParam (name="orderLineNumber") int orderLineNumber) {
		LOGGER.info("CONTROLLER : OrderDetailController with / get method");
		LOGGER.info("METHOD : saveOrderDetailPage()");
		OrderDetail orderDetail = new OrderDetail();
		OrderDetailId orderDetailID= new OrderDetailId(productService.getProductById(productCode), orderService.getOrderById(orderNumber));
		orderDetail.setId(orderDetailID);
		orderDetail.setOrderLineNumber(orderLineNumber);
		orderDetail.setPrinceEach(princeEach);
		orderDetail.setQuantityOrdered(quantityOrdered);
		
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VALIDACION");
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-orderdetails.html");
			model.addAttribute("orderDetail", orderDetail);
			model.addAttribute("order", orderService.getAllOrders());
			model.addAttribute("product", productService.getAllProducts());	
			return "new-orderdetails";
		}else {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA all-orderdetail.html");
			orderDetailService.guardarOrderDetail(orderDetail);
			model.addAttribute("ordersDetail", orderDetailService.getAllOrderDetail());
			return "all-orderdetail";
		}

	}
	
	/**
	 * Modelo que muestra la vista donde esta la tabla de todas las OrderDetail, la vista se
	 * llama all-orderDetail.html
	 * @return retorna el modelo donde esta la vista all-orderDetail.html que muestra la lista 
	 * de todas las OrderDetail.
	 */
	@GetMapping("/order/orderDetail/all")
	public ModelAndView getOrderDetailPage() {
		LOGGER.info("CONTROLLER : OrderDetailController with / orderDetail/all get method");
		LOGGER.info("METHOD : getOrderDetailPage()");		
		ModelAndView modelView = new ModelAndView("all-orderDetail");
		modelView.addObject("ordersDetail",orderDetailService.getAllOrderDetail());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-orderDetail.html");
		return modelView;
	}

	
	/**
	 * Modelo principalmente que sirve para editar informacion del objeto (OrderDetail)
	 * mostrando la vista del formulario (new-orderdetails.html) con valores que ya tiene 
	 * en la base de datos para ser modificado a eleccion. 
	 * @param productCode parametro que sirve para identificar el product en la order.
	 * @param orderNumber parametro que relaciona la order con el product.
	 * @return retorna la vista new-orderdetail.html
	 */
	@GetMapping("/order/orderDetail/edit/{id.productCode}/{id.orderNumber}")
	public ModelAndView editOrderPage(@PathVariable(value="id.productCode") String productCode,
			@PathVariable(value = "id.orderNumber")int orderNumber) {
		ModelAndView modelView = new ModelAndView("new-orderdetails");
		OrderDetailId id = new OrderDetailId(productService.getProductById(productCode), orderService.getOrderById(orderNumber));
		modelView.addObject("orderDetail", orderDetailService.getOrderDetailById(id));
		modelView.addObject("order", orderService.getAllOrders());
		modelView.addObject("product", productService.getAllProducts());
		return modelView;
	}

	/**
	 * Modelo principalmente que sirve para eliminar un objeto (OrderDetail) de
	 * la vista all-orderDetail.html
	 * @param productCode parametro que sirve para identificar el product en la order.
	 * @param orderNumber parametro que relaciona la order con el product.
	 * @return retorna la vista all-orderDetail.html
	 */
	@GetMapping("/order/orderDetail/delete/{id.productCode}/{id.orderNumber}")
	public ModelAndView deleteOrderPage(@PathVariable(value="id.productCode") String productCode,
			@PathVariable(value = "id.orderNumber")int orderNumber) { 
		ModelAndView modelView = new ModelAndView("redirect:/orderDetail/all");
		OrderDetailId id = new OrderDetailId(productService.getProductById(productCode), orderService.getOrderById(orderNumber));
		orderDetailService.eliminarOrderDetail(id);
		return modelView;
	}
	

}
