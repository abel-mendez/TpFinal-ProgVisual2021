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

@Controller
public class OrderDetailController {
	
	@Autowired
	IOrderDetailService orderDetailService;
	@Autowired
	IOrdersService orderService;
	@Autowired
	IProductService productService;
	private static final Log LOGGER= LogFactory.getLog(OrderDetailController.class);
	
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
	
	@GetMapping("/order/orderDetail/all")
	public ModelAndView getOrderDetailPage() {
		LOGGER.info("CONTROLLER : OrderDetailController with / orderDetail/all get method");
		LOGGER.info("METHOD : getOrderDetailPage()");		
		ModelAndView modelView = new ModelAndView("all-orderDetail");
		modelView.addObject("ordersDetail",orderDetailService.getAllOrderDetail());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-orderDetail.html");
		return modelView;
	}

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

	@GetMapping("/order/orderDetail/delete/{id.productCode}/{id.orderNumber}")
	public ModelAndView deleteOrderPage(@PathVariable(value="id.productCode") String productCode,
			@PathVariable(value = "id.orderNumber")int orderNumber) { 
		
		ModelAndView modelView = new ModelAndView("redirect:/orderDetail/all");
		OrderDetailId id = new OrderDetailId(productService.getProductById(productCode), orderService.getOrderById(orderNumber));
		orderDetailService.eliminarOrderDetail(id);
		return modelView;
	}
	

}
