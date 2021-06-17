package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Product;

public interface IProductRepository extends CrudRepository<Product, String> {

}
