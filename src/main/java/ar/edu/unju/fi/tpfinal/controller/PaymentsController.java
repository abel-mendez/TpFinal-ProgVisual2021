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
import ar.edu.unju.fi.tpfinal.models.Payment;
import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentsController {
	
	private static final Log LOGGER = LogFactory.getLog(PaymentsController.class);
	
	@Autowired
	private IPaymentService paymentService;
	@Autowired
	private ICustomersService customerService;
	
	@GetMapping("/payments/new")
	public String newPaymentsPage(Model model) {
		LOGGER.info("CONTROLLER : PaymentController with / get method");
		LOGGER.info("METHOD : newPaymentsPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA new-payment.html");
		model.addAttribute("payment", paymentService.getPayment());
		model.addAttribute("customer", customerService.getAllCustomers());
		return "new-payment";
	}
	
	@PostMapping("/payments/save")
	public ModelAndView guardarPaymentsPage(@Valid @ModelAttribute("payment") Payment payment ,BindingResult result) {
		LOGGER.info("CONTROLLER : PaymentsController with / post method");
		LOGGER.info("METHOD : guardarProductPage()");
		if (result.hasErrors()) {
			LOGGER.info("RESULT : VISUALIZA LA PAGINA new-payment.html");
			ModelAndView model= new ModelAndView("new-payment");
			model.addObject(payment);
			model.addObject("customer", customerService.getAllCustomers());
			return model;
		}else {
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-payments.html");		
		ModelAndView modelView = new ModelAndView("all-payments");
		Customers cust= customerService.getCustomerById(payment.getCustomers().getCustomerNumber());
		payment.setCustomers(cust);
		paymentService.guardarPayment(payment);
		modelView.addObject("payments",paymentService.getAllPayments());
		return modelView;
		}
	}
	
	@GetMapping("/payments/all")
	public ModelAndView getPaymentsPage() {
		LOGGER.info("CONTROLLER : PaymentsController with / payments/all get method");
		LOGGER.info("METHOD : getPaymentsPage()");		
		ModelAndView modelView = new ModelAndView("all-payments");
		modelView.addObject("payments",paymentService.getAllPayments());
		LOGGER.info("RESULT : VISUALIZA LA PAGINA all-payments.html");
		return modelView;
	}
	
	@GetMapping("/payments/edit/{id}")
	public ModelAndView editPaymentsPage(@PathVariable(value="id") String id) {
		ModelAndView modelView = new ModelAndView("new-payment");
		Payment payment= paymentService.getPaymentById(id);
		modelView.addObject("payment", payment);
		modelView.addObject("customer", customerService.getAllCustomers());
		return modelView;
	}
	
	@GetMapping("/payments/delete/{id}")
	public ModelAndView deletePaymentsPage(@PathVariable(value="id") String id) { 
		ModelAndView modelView = new ModelAndView("redirect:/payments/all");
		paymentService.deletPaymentById(id);
		return modelView;
	}
}
