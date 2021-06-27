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
	
	public Office() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the officeCode
	 */
	public String getOfficeCode() {
		return officeCode;
	}

	/**
	 * @param officeCode the officeCode to set
	 */
	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
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
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}

	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}

	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the territory
	 */
	public String getTerritory() {
		return territory;
	}

	/**
	 * @param territory the territory to set
	 */
	public void setTerritory(String territory) {
		this.territory = territory;
	}

	/**
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

	@Override
	public String toString() {
		return "Office [officeCode=" + officeCode + ", city=" + city + ", phone=" + phone + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", state=" + state + ", country=" + country
				+ ", postalCode=" + postalCode + ", territory=" + territory + "]";
	}
	
	
}
