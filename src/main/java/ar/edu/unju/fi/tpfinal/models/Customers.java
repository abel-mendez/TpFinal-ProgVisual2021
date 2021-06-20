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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name="CUSTOMERS")
@Component("oneCustomer")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull(message = "Debes introducir customerNumber")
	private int customerNumber;
	@Column
	@NotEmpty(message="Debes ingresar customerName")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String customerName;
	@Column
	@NotEmpty(message="Debes ingresar contactLastName")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String contactLastName;
	@Column
	@NotEmpty(message="Debes ingresar contactFirstName")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String contactFirstName;
	@Column
	@NotEmpty(message="Debes ingresar phone")
	@Size(min = 8,max = 30, message="Minimo 8 y Maximo 30 caracteres")
	private String phone;
	@Column
	@NotEmpty(message="Debes ingresar addresLine1")
	@Size(min = 5,max = 50, message="Minimo 5 y Maximo 50 caracteres")
	private String addresLine1;
	@Column
	@NotEmpty(message="Debes ingresar addresLine2")
	@Size(min = 5,max = 50, message="Minimo 5 y Maximo 50 caracteres")
	private String addresLine2;
	@Column
	@NotEmpty(message="Debes ingresar city")
	@Size(min = 5,max = 60, message="Minimo 5 y Maximo 60 caracteres")
	private String city;
	@Column
	@NotEmpty(message="Debes ingresar un status")
	@Size(min = 5,max = 50, message="Minimo 5 y Maximo 50 caracteres")
	private String state;
	@Column
	@NotNull(message = "Debes introducir postalCode")
	@Min(value=4,message="minimo 4 digitos")
	private int postalCode;
	@Column
	@NotEmpty(message="Debes ingresar country")
	@Size(min = 5,max = 50, message="Minimo 5 y Maximo 50 caracteres")
	private String country;
	@Column
	@NotNull(message = "Debes introducir creditLimit")
	@Min(value=100,message="Minimo valor 100")
	private Double creditLimit;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="salesRepEmployeeNumber")
	@Valid
	private Employee employee;
	
	@Autowired
	@OneToOne(mappedBy = "customers",fetch = FetchType.LAZY)
	@Valid
	private Payment payment; 
	
	public Customers() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the customerNumber
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber the customerNumber to set
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the addresLine1
	 */
	public String getAddresLine1() {
		return addresLine1;
	}

	/**
	 * @param addresLine1 the addresLine1 to set
	 */
	public void setAddresLine1(String addresLine1) {
		this.addresLine1 = addresLine1;
	}

	/**
	 * @return the addresLine2
	 */
	public String getAddresLine2() {
		return addresLine2;
	}

	/**
	 * @param addresLine2 the addresLine2 to set
	 */
	public void setAddresLine2(String addresLine2) {
		this.addresLine2 = addresLine2;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the postalCode
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the creditLimit
	 */
	public Double getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
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
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	/**
	 * @param customerNumber
	 * @param customerName
	 * @param contactLastName
	 * @param contactFirstName
	 * @param phone
	 * @param addresLine1
	 * @param addresLine2
	 * @param city
	 * @param state
	 * @param postalCode
	 * @param country
	 * @param creditLimit
	 * @param employee
	 * @param payment
	 */
	public Customers(int customerNumber, String customerName, String contactLastName, String contactFirstName,
			String phone, String addresLine1, String addresLine2, String city, String state, int postalCode,
			String country, Double creditLimit, Employee employee, Payment payment) {
		super();
		this.customerNumber = customerNumber;
		this.customerName = customerName;
		this.contactLastName = contactLastName;
		this.contactFirstName = contactFirstName;
		this.phone = phone;
		this.addresLine1 = addresLine1;
		this.addresLine2 = addresLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.creditLimit = creditLimit;
		this.employee = employee;
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Customers [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addresLine1="
				+ addresLine1 + ", addresLine2=" + addresLine2 + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + ", creditLimit=" + creditLimit + ", employee=" + employee
				+ ", payment=" + payment + "]";
	}
	
	
}
