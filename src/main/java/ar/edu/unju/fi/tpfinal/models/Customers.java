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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**Clase Customers
 *Clase entidad - Esta Tabla recibe el nombre CUSTOMERS
 *contiene metodos accesores getters y setters de las variables miembros o atributos
 * @author ProgVisual2021
 *
 */
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
	
	
	/**
	 * Constructor por defecto o sin parametro
	 */
	public Customers() {
		// TODO Auto-generated constructor stub
	}

	/**metodo accesor getter muestra lo q contiene la variable miembro
	 * @return retorna customerNumber (int)
	 */
	public int getCustomerNumber() {
		return customerNumber;
	}

	/**metodo accesor setter introduce datos a la variable miembro 
	 * @param customerNumber de tipo (int)
	 */
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	/**
	 * @return customerName (String)
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName de tipo (String)
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return contactLastName (String)
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName de tipo (String)
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * @return contactFirstName (String)
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName de tipo (String)
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return phone (String)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone de tipo (String)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return addresLine1 (String)
	 */
	public String getAddresLine1() {
		return addresLine1;
	}

	/**
	 * @param addresLine1 de tipo (String)
	 */
	public void setAddresLine1(String addresLine1) {
		this.addresLine1 = addresLine1;
	}

	/**
	 * @return addresLine2 (String)
	 */
	public String getAddresLine2() {
		return addresLine2;
	}

	/**
	 * @param addresLine2 de tipo (String)
	 */
	public void setAddresLine2(String addresLine2) {
		this.addresLine2 = addresLine2;
	}

	/**
	 * @return city (String)
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city de tipo (String)
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return state (String)
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state de tipo (String)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return postalCode (int)
	 */
	public int getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode de tipo (int)
	 */
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return country (String)
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country de tipo (String)
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return creditLimit (Double)
	 */
	public Double getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit de tipo (Double)
	 */
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return  employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee de tipo (Employee)
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	/**Constructor parametrizado o sobrecargado
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
			String country, Double creditLimit, Employee employee) {
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
	}

	/**
	 *Muestra la informacion completa del Customers
	 */
	@Override
	public String toString() {
		return "Customers [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirstName=" + contactFirstName + ", phone=" + phone + ", addresLine1="
				+ addresLine1 + ", addresLine2=" + addresLine2 + ", city=" + city + ", state=" + state + ", postalCode="
				+ postalCode + ", country=" + country + ", creditLimit=" + creditLimit + ", employee=" + employee
				+ "]";
	}
	
	
}
