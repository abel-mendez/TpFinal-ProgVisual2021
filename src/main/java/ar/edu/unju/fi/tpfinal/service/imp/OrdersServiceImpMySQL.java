package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Orders;
import ar.edu.unju.fi.tpfinal.repository.IOrdersRepository;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;
/**Clase OrdersServiceImpMySQL que implementa IOrdersService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IOrdersService.
 * @author ProgVisual2021
 *
 */
@Service
public class OrdersServiceImpMySQL implements IOrdersService{
	
	private List<Orders> orderss= new ArrayList<Orders>();
	@Autowired
	private IOrdersRepository orderRepo;
	@Autowired
	Orders orders;

	/**
	 *metodo que guarda un Order
	 */
	@Override
	public void guardarOrder(Orders order) {
		orderRepo.save(order);
	}

	/**
	 *metodo que muestra una coleccion de Orders
	 */
	@Override
	public List<Orders> getAllOrders() {
		this.orderss=(List<Orders>) orderRepo.findAll();
		return orderss;
	}

	/**
	 *metodo que genera un nuevo objeto Order
	 */
	@Override
	public Orders getOrder() {
		return this.orders;
	}

	/**
	 *Metodo de busqueda segun id 
	 */
	@Override
	public Orders getOrderById(int id) {
		Orders ord= orderRepo.findById(id).get();
		return ord;
	}

	/**metodo eliminar un Order de la tabla segun id
	 *
	 */
	@Override
	public void deleteOrderById(int id) {
		orderRepo.deleteById(id);
	}

}
