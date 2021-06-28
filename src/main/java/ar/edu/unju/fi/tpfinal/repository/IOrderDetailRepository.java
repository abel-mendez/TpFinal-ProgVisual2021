package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.OrderDetail;
import ar.edu.unju.fi.tpfinal.models.OrderDetailId;
/**
 * Interface IOrderDetailRepository
 * Interface que sirve para enlazar a la base datos y utilizar operaciones
 * basicas del Crud.
 * @author ProgVisual2021
 *
 */
public interface IOrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailId>{

}
