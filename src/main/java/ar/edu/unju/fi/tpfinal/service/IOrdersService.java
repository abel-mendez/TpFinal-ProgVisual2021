package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Orders;

/**Interface de Servicio IOrderssService
 * que nos permite definir los metodos que podemos utilizar.
 * @author ProgVisual2021
 *
 */
public interface IOrdersService {
	/**metodo que guarda un Order
	 * @param order objeto que se guarda en la bd
	 */
	public void guardarOrder(Orders order);
	/**metodo que muestra una coleccion de Orders
	 * @return devuelve una lista de Orders
	 */
	public List<Orders> getAllOrders();
	/**metodo que genera un nuevo objeto Order
	 * @return devuelve un order Vacio
	 */
	public Orders getOrder();
	/**Metodo de busqueda segun id 
	 * @param id de tipo entero(int)
	 * @return un Order segun el id enviado en parametro
	 */
	public Orders getOrderById(int id);
	/**metodo eliminar un Order de la tabla segun id
	 * @param id de tipo entero(int)
	 */
	public void deleteOrderById(int id);
}
