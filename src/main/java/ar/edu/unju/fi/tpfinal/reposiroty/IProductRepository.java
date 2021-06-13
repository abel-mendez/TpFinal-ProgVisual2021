package ar.edu.unju.fi.tpfinal.reposiroty;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Product;

public interface IProductRepository extends CrudRepository<Product, String> {

}
