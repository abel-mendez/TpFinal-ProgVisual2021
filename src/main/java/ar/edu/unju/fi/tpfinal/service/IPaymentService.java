package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Payment;



public interface IPaymentService {
	public void guardarPayment(Payment payment);
	public List<Payment> getAllPayments();
	public Payment getPayment();
	public Payment getPaymentById(String id);
	public void deletPaymentById(String id);
}
