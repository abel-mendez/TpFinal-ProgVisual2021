package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.repository.IEmployeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;
/**
 * Clase EmployeeServiceImpMySQL que implementa IEmployeeService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IEmployeeService.
 * @author ProgVisual2021
 *
 */
@Service
public class EmployeeServiceImpMySQL implements IEmployeeService {

	private List<Employee> employees=new ArrayList<Employee>();
	@Autowired
	private IEmployeRepository employeeRepo;
	@Autowired
	Employee employee;
	
	/**
	 *Metodo que guarda un Employee en la Base de datos.
	 */
	@Override
	public void guardarEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	/**
	 *Metodo que devuelve la lista de Employees almacenados en la base de datos.
	 */
	@Override
	public List<Employee> getAllEmployees() {
		this.employees=(List<Employee>) employeeRepo.findAll();
		return employees;
	}

	/**
	 *Metodo que obtiene un Employee vacio.
	 */
	@Override
	public Employee getEmployee() {
		return this.employee;
	}

	/**
	 *Metodo que busca un Employee por su id en la base de datos para devolverlo.
	 */
	@Override
	public Employee getEmployeeById(int id) {
		Employee emp=employeeRepo.findById(id).get();
		return emp;
	}

	/**
	 *Metodo que elimina un Employee en la base de datos.
	 */
	@Override
	public void deletEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}
}
