package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

/**
 * Clase OrderDetailServiceImpMySQL que implementa IOrderDetailService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IOrderDetailService.
 * @author ProgVisual2021
 *
 */
@Service
public class OrderDetailServiceImpMySQL implements IOrderDetailService {
	
	@Autowired
	private OrderDetail orderDetail;
	@Autowired
	private IOrderDetailRepository orderDetailRepo;
	private List<OrderDetail> listOD=new ArrayList<OrderDetail>();
	
	/**
	 *Metodo que elimina un orderDetail en la base de datos.
	 */
	@Override
	public void eliminarOrderDetail(OrderDetailId id) {
		orderDetailRepo.deleteById(id);

	}

	/**
	 *Metodo que devuelve la lista de orderDetail almacenados en la base de datos.
	 */
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		this.listOD=(List<OrderDetail>) orderDetailRepo.findAll();
		return listOD;
	}

	/**
	 *Metodo que busca un orderDetail por su id en la base de datos para devolverlo
	 */
	@Override
	public OrderDetail getOrderDetailById(OrderDetailId id) {
		OrderDetail oD=orderDetailRepo.findById(id).get();
		return oD;
	}

	/**
	 *Metodo que obtiene un orderDetail vacio.
	 */
	@Override
	public OrderDetail getNewOrderDetail() {
		// TODO Auto-generated method stub
		return this.orderDetail;
	}

	/**
	 *Metodo que guarda un orderDetail en la Base de datos.
	 */
	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		orderDetailRepo.save(orderDetail);
		
	}

}
