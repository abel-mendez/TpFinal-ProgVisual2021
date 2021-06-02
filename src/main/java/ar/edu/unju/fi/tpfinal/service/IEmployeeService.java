package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Employee;



public interface IEmployeeService {
	public void guardarEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Employee getEmployee();
	public Employee getEmployeeById(int id);
	public void deletEmployeeById(int id);
}
