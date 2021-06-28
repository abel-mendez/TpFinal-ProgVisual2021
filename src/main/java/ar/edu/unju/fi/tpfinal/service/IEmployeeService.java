package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Employee;
/**
 * Interface de Servicio IEmployeeService
 * que nos permite definir los metodos que podemos utilizar.
 * @author ProgVisual2021
 *
 */
public interface IEmployeeService {
	/**
	 * Metodo que nos permite guardar un Employee a la base de datos
	 * @param employee parametro que tiene el objeto a guardar.
	 */
	public void guardarEmployee(Employee employee);
	/**
	 * Metodo que muestra la lista de Customers que tenemos en la base de datos
	 * @return retorna una lista de Customers
	 */
	public List<Employee> getAllEmployees();
	/**
	 * Metodo que Obtiene un Employee
	 * @return retorna un Employee vacio
	 */
	public Employee getEmployee();
	/**
	 * Metodo que Busca un Employee por id
	 * @param id parametro que se usa para obtener un Employee por su id
	 * @return retorna un Employee que correspone al parametro id
	 */
	public Employee getEmployeeById(int id);
	/**
	 * Metodo que elimina un Employee idetificado por el id
	 * @param id parametro que sirve para identidicar al Employee a eliminar
	 */
	public void deletEmployeeById(int id);
}
