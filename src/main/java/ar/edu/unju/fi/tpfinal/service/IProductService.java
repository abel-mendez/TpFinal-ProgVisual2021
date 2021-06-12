package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Product;

public interface IProductService {
	public void guardarProduct(Product product);
	public void eliminarProduct(String id);
	public List<Product> getAllProducts();
	public Product getProductById(String id);
	public Product getNewProduct();

}
