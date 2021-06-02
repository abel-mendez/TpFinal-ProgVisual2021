package ar.edu.unju.fi.tpfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="EMPLOYEES")
@Component
public class Employee {
	@Id
	@Column
	private int employeeNumbre;
	@Column
	private String lastName;
	@Column
	private String firstName;
	@Column
	private String extension;
	@Column
	private String email;
	@Column
	private Office office;
	@Column
	private Employee employee;
	@Column
	private String jobTitle;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the employeeNumbre
	 */
	public int getEmployeeNumbre() {
		return employeeNumbre;
	}

	/**
	 * @param employeeNumbre the employeeNumbre to set
	 */
	public void setEmployeeNumbre(int employeeNumbre) {
		this.employeeNumbre = employeeNumbre;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the office
	 */
	public Office getOffice() {
		return office;
	}

	/**
	 * @param office the office to set
	 */
	public void setOffice(Office office) {
		this.office = office;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * @param employeeNumbre
	 * @param lastName
	 * @param firstName
	 * @param extension
	 * @param email
	 * @param office
	 * @param employee
	 * @param jobTitle
	 */
	public Employee(int employeeNumbre, String lastName, String firstName, String extension, String email,
			Office office, Employee employee, String jobTitle) {
		super();
		this.employeeNumbre = employeeNumbre;
		this.lastName = lastName;
		this.firstName = firstName;
		this.extension = extension;
		this.email = email;
		this.office = office;
		this.employee = employee;
		this.jobTitle = jobTitle;
	}
	
	
}
