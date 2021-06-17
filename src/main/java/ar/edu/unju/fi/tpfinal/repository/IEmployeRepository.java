package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Employee;

public interface IEmployeRepository extends CrudRepository<Employee, Integer> {

}
