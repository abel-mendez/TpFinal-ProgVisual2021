package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Employee;
/**
 * Interface IEmployeRepository
 * Interface que sirve para enlazar a la base datos y utilizar operaciones
 * basicas del Crud.
 * @author ProgVisual2021
 *
 */
public interface IEmployeRepository extends CrudRepository<Employee, Integer> {

}
