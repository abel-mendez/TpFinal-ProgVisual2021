package ar.edu.unju.fi.tpfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**Clase Office
 *Clase entidad - Esta Tabla recibe el nombre OFFICES
 *contiene metodos accesores getters y setters de las variables miembros o atributos
 * @author ProgVisual2021
 *
 */
@Entity
@Table(name="OFFICES")
@Component
public class Office {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	@Column
	private String officeCode;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String city;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String phone;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String addressLine1;
	@Column
	private String addressLine2;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String state;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String country;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String postalCode;
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String territory;
	
	/**
	 * Constructor por defecto o sin parametro
	 */
	public Office() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return retorna officeCode (String)
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * @param officeCode de Tipo (String)
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	/**
	 * @return retorna city (String)
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city de Tipo (String)
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return retorna phone (String)
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone de Tipo (String)
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return retorna addressLine1 (String)
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 de Tipo (String)
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return retorna addressLine2 (String)
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 de Tipo (String)
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * @return retorna state (String)
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state de Tipo (String)
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return retorna country (String)
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country de Tipo (String)
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return retorna postalCode (String)
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode de Tipo (String) 
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return retorna territory (String)
	 */
	public String getTerritory() {
		return territory;
	}

	/**
	 * @param territory de Tipo (String)
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}

	/**Constructor parametrizado o sobrecargado
	 * @param officeCode
	 * @param city
	 * @param phone
	 * @param addressLine1
	 * @param addressLine2
	 * @param state
	 * @param country
	 * @param postalCode
	 * @param territory
	 */
	public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}

	/**
	 *Muestra la informacion completa de Office
	 */
	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}
	
	
}
