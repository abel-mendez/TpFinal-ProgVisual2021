package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Customers;

public interface ICustomersRepository extends CrudRepository<Customers, Integer>{

}
