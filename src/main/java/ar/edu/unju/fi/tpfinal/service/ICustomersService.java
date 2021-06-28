package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Customers;

/**
 * Interface de Servicio ICustomersService
 * que nos permite definir los metodos que podemos utilizar.
 * @author ProgVisual2021
 *
 */
public interface ICustomersService {
	/**
	 * Metodo que nos permite guardar un Customers a la base de datos
	 * @param customers parametro que tiene el objeto a guardar.
	 */
	public void guardarCustomer(Customers customers);
	/**
	 * Metodo que muestra la lista de Customers que tenemos en la base de datos
	 * @return retorna una lista de Customers
	 */
	public List<Customers> getAllCustomers();
	/**
	 * Metodo que Obtiene un Customer
	 * @return retorna un Customer vacio
	 */
	public Customers getCustomer();
	/**
	 * Metodo que Busca un Customer por id
	 * @param id parametro que se usa para obtener un Customer por su id
	 * @return retorna un Customers que correspone al parametro id
	 */
	public Customers getCustomerById(int id);
	/**
	 * Metodo que elimina un Customer idetificado por el id
	 * @param id parametro que sirve para identidicar al Customer a eliminar
	 */
	public void deleteCustomerById(int id);
}
