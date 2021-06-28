package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.ProductLine;

/**
 * Interface de Servicio IProductLineService
 * que nos permite definir los metodos que podemos utilizar.
 * 
 * @author ProgVisual2021
 *
 */
public interface IProductLineService {
	
	/**
	 *  Metodo que nos permite guardar un ProductLine a la base de datos
	 * @param productLine parametro que tiene el objeto a guardar.
	 */
	public void guardarProductLine(ProductLine productLine);
	
	/** Metodo que elimina un ProductLine idetificado por el id
	 * @param id parametro que sirve para identidicar al ProductLine a eliminar
	 */
	public void eliminarProductLine(String id);
	
	/**
	 * Metodo que muestra la lista de ProductLine que tenemos en la base de datos
	 * @return retorna una lista de ProductLine
	 */
	public List<ProductLine> getAllProductsLine();
	
	/**
	 * Metodo que Busca unProductLiner por id
	 * @param id parametro que se usa para obtener un ProductLine por su id
	 * @return retorna un ProductLine que correspone al parametro id
	 */
	public ProductLine getProductLineById(String id);
	
	/**
	 * Metodo que se obtiene un nuevo Productline vacio
	 * @return retorna ProductLine vacio
	 */
	public ProductLine getNewProductLine();

}
