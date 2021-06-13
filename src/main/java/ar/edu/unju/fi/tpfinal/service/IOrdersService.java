package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Orders;

public interface IOrdersService {
	public void guardarOrder(Orders order);
	public List<Orders> getAllOrders();
	public Orders getOrder();
	public Orders getOrderById(int id);
	public void deleteOrderById(int id);
}
