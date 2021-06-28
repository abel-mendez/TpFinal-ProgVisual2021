package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Customers;
import ar.edu.unju.fi.tpfinal.repository.ICustomersRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
/**
 * Clase CustomersServiceImpMySQL que implementa ICustomersService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio ICustomersService.
 * @author ProgVisual2021
 *
 */
@Service
public class CustomersServiceImpMySQL implements ICustomersService {
	
	private List<Customers> customerss= new ArrayList<Customers>();
	@Autowired
	private ICustomersRepository customerRepo;
	@Autowired
	Customers customers;

	/**
	 *Metodo que guarda un Customer en la Base de datos.
	 */
	@Override
	public void guardarCustomer(Customers customers) {
		customerRepo.save(customers);
	}

	/**
	 *Metodo que devuelve la lista de Customers almacenados en la base de datos.
	 */
	@Override
	public List<Customers> getAllCustomers() {
		this.customerss=(List<Customers>) customerRepo.findAll();
		return customerss;
	}

	/**
	 *Metodo que obtiene un Customer vacio.
	 */
	@Override
	public Customers getCustomer() {
		return this.customers;
	}

	/**
	 *Metodo que busca un Customer por su id en la base de datos para devolverlo
	 */
	@Override
	public Customers getCustomerById(int id) {
		Customers cust= customerRepo.findById(id).get();
		return cust;
	}

	/**
	 *Metodo que elimina un customer en la base de datos.
	 */
	@Override
	public void deleteCustomerById(int id) {
		customerRepo.deleteById(id);
	}

}
