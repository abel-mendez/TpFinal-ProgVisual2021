package ar.edu.unju.fi.tpfinal.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.subst.Token.Type;

/**Clase Employee
 * Clase entidad - Esta Tabla recibe el nombre EMPLOYEES
 * contiene metodos accesores getters y setters de las variables miembros o atributos
 * @author ProgVisual2021
 *
 */
@Entity
@Table(name="EMPLOYEES")
@Component
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	
	private int employeeNumber;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String lastName;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String firstName;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String extension;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String email;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Autowired
	@JoinColumn(name="officeCode")
	@NotNull(message ="El campo no puede estar vacio")
	private Office office;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Autowired
	@JoinColumn(name="reportsTo")
	private Employee employee;
	@Column
	@NotBlank(message = "El campo jobTitle no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String jobTitle;
	
	//USUARIO para login
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="us_Id")
	@Valid
	private Usuario user;
	
	/**
	 * Constructor por defecto o sin parametro
	 */
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**metodo accesor getter muestra lo q contiene la variable miembro
	 * @return retorna employeeNumber (int)
	 */
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	/**metodo accesor setter introduce datos a la variable miembro 
	 * @param employeeNumbre de Tipo (int)
	 */
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return retorna lastName (String)
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName de Tipo (String)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return retorna firstName (String)
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName de Tipo (String)
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return retorna extension (String)
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension de Tipo (String)
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return retorna email (String)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email de Tipo (String)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return retorna office (Office)
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office de Tipo (Office)
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return retorna employee (Employee)
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee de Tipo (Employee)
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return retorna jobTitle (String)
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle de Tipo (String)
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**Constructor parametrizado o sobrecargado
	 * @param employeeNumbre
	 * @param lastName
	 * @param firstName
	 * @param extension
	 * @param email
	 * @param office
	 * @param employee
	 * @param jobTitle
	 */
	public Employee(int employeeNumber, String lastName, String firstName, String extension, String email,
			Office office, Employee employee, String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.office = office;
		this.employee = employee;
		this.jobTitle = jobTitle;
	}

	/**
	 * @return retorna (Usuario)
	 */
	public Usuario getUser() {
		return user;
	}

	/**
	 * @param user de Tipo (Usuario)
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}

	/*@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", extension=" + extension + ", email=" + email + ", office=" + office + ", employee=" + employee
				+ ", jobTitle=" + jobTitle + ", user=" + user + "]";
	}
	*/
	
}
