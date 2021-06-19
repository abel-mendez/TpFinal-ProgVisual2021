package ar.edu.unju.fi.tpfinal.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.fi.tpfinal.service.IPaymentService;

@Controller
public class PaymentsController {
	
	private static final Log LOGGER = LogFactory.getLog(PaymentsController.class);
	
	@Autowired
	private IPaymentService paymentService;
	
	@GetMapping("/payments/new")
	public String newPaymentsPage(Model model) {
		LOGGER.info("CONTROLLER : PaymentController with / get method");
		LOGGER.info("METHOD : newPaymentsPage()");
		LOGGER.info("RESULT : VISUALIZA LA PAGINA new-payment.html");
		model.addAttribute("payment", paymentService.getPayment());
		return "new-payment";
	}
}
