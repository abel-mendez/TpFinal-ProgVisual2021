package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Customers;
import ar.edu.unju.fi.tpfinal.repository.ICustomersRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomersService;
@Service
public class CustomersServiceImpMySQL implements ICustomersService {
	
	private List<Customers> customerss= new ArrayList<Customers>();
	@Autowired
	private ICustomersRepository customerRepo;
	@Autowired
	Customers customers;

	@Override
	public void guardarCustomer(Customers customers) {
		customerRepo.save(customers);
	}

	@Override
	public List<Customers> getAllCustomers() {
		this.customerss=(List<Customers>) customerRepo.findAll();
		return customerss;
	}

	@Override
	public Customers getCustomer() {
		return this.customers;
	}

	@Override
	public Customers getCustomerById(int id) {
		Customers cust= customerRepo.findById(id).get();
		return cust;
	}

	@Override
	public void deleteCustomerById(int id) {
		customerRepo.deleteById(id);
	}

}
