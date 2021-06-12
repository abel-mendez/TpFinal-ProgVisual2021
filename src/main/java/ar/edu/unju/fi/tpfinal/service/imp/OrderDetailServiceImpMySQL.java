package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.reposiroty.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

/**
 * @author Diego
 *
 */
public class OrderDetailServiceImpMySQL implements IOrderDetailService {
	
	@Autowired
	private OrderDetail orderDetail;
	@Autowired
	private IOrderDetailRepository orderDetailRepo;
	private List<OrderDetail> listOD=new ArrayList<OrderDetail>();
	
	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		orderDetailRepo.save(orderDetail);

	}

	@Override
	public void eliminarOrderDetail(int id) {
		orderDetailRepo.deleteById(id);

	}

	@Override
	public List<OrderDetail> getAllOrderDetail() {
		this.listOD=(List<OrderDetail>) orderDetailRepo.findAll();
		return listOD;
	}

	@Override
	public OrderDetail getOrderDetailById(int id) {
		OrderDetail oD=orderDetailRepo.findById(id).get();
		return oD;
	}

	@Override
	public OrderDetail getNewOrderDetail() {
		// TODO Auto-generated method stub
		return this.orderDetail;
	}

}
