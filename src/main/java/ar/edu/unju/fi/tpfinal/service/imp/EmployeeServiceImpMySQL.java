package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Employee;
import ar.edu.unju.fi.tpfinal.reposiroty.IEmployeRepository;
import ar.edu.unju.fi.tpfinal.service.IEmployeeService;

@Service
public class EmployeeServiceImpMySQL implements IEmployeeService {

	private List<Employee> employees=new ArrayList<Employee>();
	@Autowired
	private IEmployeRepository employeeRepo;
	@Autowired
	Employee employee;
	
	@Override
	public void guardarEmployee(Employee employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		this.employees=(List<Employee>) employeeRepo.findAll();
		return employees;
	}

	@Override
	public Employee getEmployee() {
		return this.employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee emp=employeeRepo.findById(id).get();
		return emp;
	}

	@Override
	public void deletEmployeeById(int id) {
		employeeRepo.deleteById(id);
	}
}
