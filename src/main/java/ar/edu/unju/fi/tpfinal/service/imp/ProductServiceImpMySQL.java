package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.models.Product;
import ar.edu.unju.fi.tpfinal.reposiroty.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

/**
 * @author Diego
 *
 */
public class ProductServiceImpMySQL implements IProductService {

	@Autowired
	private IProductRepository productRepo;
	@Autowired
	private Product product;
	private List<Product> listProduct=new ArrayList<Product>();
	
	@Override
	public void guardarProduct(Product product) {
		productRepo.save(product);

	}

	@Override
	public void eliminarProduct(String id) {
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> getAllProducts() {
		this.listProduct=(List<Product>) productRepo.findAll();
		return listProduct;
	}

	@Override
	public Product getProductById(String id) {
		Product prod=productRepo.findById(id).get();
		return prod;
	}

	@Override
	public Product getNewProduct() {
		// TODO Auto-generated method stub
		return this.product;
	}

}
