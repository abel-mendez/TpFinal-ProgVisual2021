package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Customers;

public interface ICustomersService {
	public void guardarCustomer(Customers customers);
	public List<Customers> getAllCustomers();
	public Customers getCustomer();
	public Customers getCustomerById(int id);
	public void deleteCustomerById(int id);
}
