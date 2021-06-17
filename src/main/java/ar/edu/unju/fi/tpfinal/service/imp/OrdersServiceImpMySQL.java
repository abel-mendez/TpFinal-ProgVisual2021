package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.models.Orders;
import ar.edu.unju.fi.tpfinal.repository.IOrdersRepository;
import ar.edu.unju.fi.tpfinal.service.IOrdersService;

public class OrdersServiceImpMySQL implements IOrdersService{
	
	private List<Orders> orderss= new ArrayList<Orders>();
	@Autowired
	private IOrdersRepository orderRepo;
	@Autowired
	Orders orders;

	@Override
	public void guardarOrder(Orders order) {
		orderRepo.save(order);
	}

	@Override
	public List<Orders> getAllOrders() {
		this.orderss=(List<Orders>) orderRepo.findAll();
		return orderss;
	}

	@Override
	public Orders getOrder() {
		return this.orders;
	}

	@Override
	public Orders getOrderById(int id) {
		Orders ord= orderRepo.findById(id).get();
		return ord;
	}

	@Override
	public void deleteOrderById(int id) {
		orderRepo.deleteById(id);
	}

}
