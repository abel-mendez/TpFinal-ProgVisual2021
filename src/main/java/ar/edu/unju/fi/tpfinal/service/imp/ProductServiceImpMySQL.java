package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Product;
import ar.edu.unju.fi.tpfinal.repository.IProductRepository;
import ar.edu.unju.fi.tpfinal.service.IProductService;

/**
 * Clase ProductServiceImpMySQL que implementa IProductService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IProductService.
 * 
 * @author ProgVisual2021
 *
 */
@Service
public class ProductServiceImpMySQL implements IProductService {

	@Autowired
	private IProductRepository productRepo;
	@Autowired
	private Product product;
	private List<Product> listProduct=new ArrayList<Product>();
	
	/**
	 *Metodo que nos permite guardar un Product a la base de datos
	 */
	@Override
	public void guardarProduct(Product product) {
		productRepo.save(product);

	}

	/**
	 *Metodo que elimina un Product idetificado por el id
	 */
	@Override
	public void eliminarProduct(String id) {
		productRepo.deleteById(id);
	}

	/**
	 *Metodo que muestra la lista de Product que tenemos en la base de datos
	 * 
	 */
	@Override
	public List<Product> getAllProducts() {
		this.listProduct=(List<Product>) productRepo.findAll();
		return listProduct;
	}

	/**
	 *Metodo que Busca un Product por id
	 */
	@Override
	public Product getProductById(String id) {
		Product prod=productRepo.findById(id).get();
		return prod;
	}

	/**
	 * Metodo que obtiene un nuevo Producto vacio
	 */
	@Override
	public Product getNewProduct() {
		// TODO Auto-generated method stub
		return this.product;
	}

}
