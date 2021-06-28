package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;
/**
 * Interface de Servicio IOrderDetailService
 * que nos permite definir los metodos que podemos utilizar.
 * @author ProgVisual2021
 *
 */
public interface IOrderDetailService {
	/**
	 * Metodo que nos permite guardar un orderDetail a la base de datos
	 * @param orderDetail parametro que tiene el objeto a guardar.
	 */
	public void guardarOrderDetail(OrderDetail orderDetail);
	/**
	 * Metodo que elimina un orderDetail idetificado por el id
	 * @param id parametro que sirve para identidicar al orderDetail a eliminar
	 */
	public void eliminarOrderDetail(OrderDetailId id);
	/**
	 * Metodo que muestra la lista de ordersDetail que tenemos en la base de datos
	 * @return retorna una lista de ordersDetail
	 */
	public List<OrderDetail> getAllOrderDetail();
	/**
	 * Metodo que Busca un orderDetail por id
	 * @param id parametro que se usa para obtener un orderDetail por su id
	 * @return retorna un orderDetail que correspone al parametro id
	 */
	public OrderDetail getOrderDetailById(OrderDetailId id);
	/**
	 * Metodo que Obtiene un orderDetail
	 * @return retorna un orderDetail vacio
	 */
	public OrderDetail getNewOrderDetail();

}
