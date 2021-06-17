package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;
import ar.edu.unju.fi.tpfinal.models.Orders;
import ar.edu.unju.fi.tpfinal.models.Product;
import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.repository.IOrdersRepository;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;

class OrderDetailTest {
	@Autowired
	IProductRepository productRepo;
	
	@Autowired
	IOrdersRepository orderRepo;
	
	@Autowired
	IOrderDetailRepository orderDetailRepo;
	
/*@Test
	void testGuardarOrderDetails() {
		OrderDetail orderDetail=new OrderDetail();
		ProductLine pl=new ProductLine("pl1", "description", "wwww","22");
		Product product1=new Product("a1","nameP", pl, "pS", "pVendedor", "pDescription", 2, 22,21);		
		Date fecha= new Date(2021, 2, 2);
		Orders order1=new Orders(1, fecha, fecha, fecha, "s", "s", 1);		
		OrderDetailId orderDetail1ID= new OrderDetailId(product1, order1);
		//primer registro
		orderDetail.setId(orderDetail1ID);
		orderDetail.setQuantityOrdered(10);
		orderDetail.setOrderLineNumber(1);
		orderDetail.setPrinceEach(21);
		System.out.println("--->"+ orderDetail);
		orderDetailRepo.save(orderDetail);
		
		assertEquals(10, orderDetail.getQuantityOrdered());
	}*/

}
