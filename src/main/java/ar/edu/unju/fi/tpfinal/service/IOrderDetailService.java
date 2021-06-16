package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;

public interface IOrderDetailService {
	public void guardarOrderDetail(OrderDetail orderDetail);
	public void eliminarOrderDetail(OrderDetailId id);
	public List<OrderDetail> getAllOrderDetail();
	public OrderDetail getOrderDetailById(OrderDetailId id);
	public OrderDetail getNewOrderDetail();

}
