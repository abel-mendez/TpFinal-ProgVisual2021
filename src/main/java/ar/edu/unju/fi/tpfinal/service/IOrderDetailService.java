package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;

public interface IOrderDetailService {
	public void guardarOrderDetail(OrderDetail orderDetail);
	public void eliminarOrderDetail(int id);
	public List<OrderDetail> getAllOrderDetail();
	public OrderDetail getOrderDetailById(int id);
	public OrderDetail getNewOrderDetail();

}
