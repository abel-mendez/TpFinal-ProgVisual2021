package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.ProductLine;

/**
 * Interface IProductLineRepository
 * Interface que sirve para enlazar a la base datos y utilizar operaciones
 * basicas del Crud.
 * 
 * @author ProgVisual2021
 *
 */
public interface IProductLineRepository extends CrudRepository<ProductLine, String> {

}
