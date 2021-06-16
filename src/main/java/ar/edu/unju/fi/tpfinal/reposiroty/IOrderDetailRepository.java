package ar.edu.unju.fi.tpfinal.reposiroty;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;

public interface IOrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId>{

}
