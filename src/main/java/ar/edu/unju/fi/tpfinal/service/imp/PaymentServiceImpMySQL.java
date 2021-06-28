package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Payment;
import ar.edu.unju.fi.tpfinal.repository.IPaymentRepository;
import ar.edu.unju.fi.tpfinal.service.IPaymentService;
/**Clase PaymentServiceImpMySQL que implementa IPaymentService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IPaymentService.
 * @author ProgVisual2021
 *
 */
@Service
public class PaymentServiceImpMySQL implements IPaymentService {
	private List<Payment> payments=new ArrayList<Payment>();
	@Autowired
	private IPaymentRepository paymentRepo;
	@Autowired
	Payment payment;
	
	/**
	 *Metodo que permite guardar un Payment
	 */
	@Override
	public void guardarPayment(Payment payment) {
		paymentRepo.save(payment);
	}

	/**
	 *metodo que muestra una colecion de payments
	 */
	@Override
	public List<Payment> getAllPayments() {
		this.payments=(List<Payment>) paymentRepo.findAll();
		return payments;
	}

	/**
	 *metodo que obtiene un Payment nuevo
	 */
	@Override
	public Payment getPayment() {
		return this.payment;
	}

	/**
	 *Metodo que busca un Payment segun su id
	 */
	@Override
	public Payment getPaymentById(String id) {
		Payment pay=paymentRepo.findById(id).get();
		return pay;
	}

	/**
	 *Metodo que elimina un Payment segun su id
	 */
	@Override
	public void deletPaymentById(String id) {
		paymentRepo.deleteById(id);
	}
}
