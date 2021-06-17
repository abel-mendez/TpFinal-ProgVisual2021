package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.models.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;

public class PaymentServiceImpMySQL implements IPaymentService {
	private List<Payment> payments=new ArrayList<Payment>();
	@Autowired
	private IPaymentRepository paymentRepo;
	@Autowired
	Payment payment;
	
	@Override
	public void guardarPayment(Payment payment) {
		paymentRepo.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		this.payments=(List<Payment>) paymentRepo.findAll();
		return payments;
	}

	@Override
	public Payment getPayment() {
		return this.payment;
	}

	@Override
	public Payment getPaymentById(String id) {
		Payment pay=paymentRepo.findById(id).get();
		return pay;
	}

	@Override
	public void deletPaymentById(String id) {
		paymentRepo.deleteById(id);
	}
}
