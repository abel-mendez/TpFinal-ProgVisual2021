package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Product;

/**
 * Interface de Servicio IProductService
 * que nos permite definir los metodos que podemos utilizar.
 * 
 * @author ProgVisual2021
 *
 */
public interface IProductService {
	
	/**
	 *  Metodo que nos permite guardar un Product a la base de datos
	 * @param product parametro objeto para guardar
	 */
	public void guardarProduct(Product product);
	
	/**Metodo que elimina un Product idetificado por el id
	 * @param id  parametro que sirve para identidicar al Product a eliminar
	 */
	public void eliminarProduct(String id);
	
	/**
	 * Metodo que muestra la lista de Product que tenemos en la base de datos
	 * 
	 * @return retorna una lista de Product
	 */
	public List<Product> getAllProducts();
	
	/**
	 * Metodo que Busca un Product por id
	 * @param id parametro que se usa para obtener un Product por su id
	 * @return  retorna un Product que correspone al parametro id
	 */
	public Product getProductById(String id);
	
	/**
	 * Metodo que obtiene un nuevo Producto vacio
	 * @return retorna un objeto producto vacio
	 */
	public Product getNewProduct();

}
