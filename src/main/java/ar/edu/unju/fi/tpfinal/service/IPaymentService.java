package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Payment;



/** Interface de Servicio IPaymentsService
 * que nos permite definir los metodos que podemos utilizar.
 * @author ProgVisual2021
 *
 */
public interface IPaymentService {
	/**Metodo que permite guardar un Payment
	 * @param payment parametro  que tiene el objeto payment
	 */
	public void guardarPayment(Payment payment);
	/**metodo que muestra una colecion de payments
	 * @return devuelve una lista  de payments
	 */
	public List<Payment> getAllPayments();
	/**metodo que obtiene un Payment
	 * @return devuelve un payment vacio
	 */
	public Payment getPayment();
	/**Metodo que busca un Payment segun su id 
	 * @param id parametro de tipo string 
	 * @return devuelve un objeto tipo Payment
	 */
	public Payment getPaymentById(String id);
	/**Metodo que elimina un Payment segun su id
	 * @param id de tipo string
	 */
	public void deletPaymentById(String id);
}
