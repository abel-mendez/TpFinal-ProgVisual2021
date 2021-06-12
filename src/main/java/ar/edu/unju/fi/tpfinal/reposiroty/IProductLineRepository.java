package ar.edu.unju.fi.tpfinal.reposiroty;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.ProductLine;

public interface IProductLineRepository extends CrudRepository<ProductLine, String> {

}
