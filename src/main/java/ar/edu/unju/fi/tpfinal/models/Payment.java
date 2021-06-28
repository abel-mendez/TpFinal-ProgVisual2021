package ar.edu.unju.fi.tpfinal.models;

import java.util.Date;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
/**Clase Payment
 *Clase entidad - Esta Tabla recibe el nombre PAYMENTS
 *contiene metodos accesores getters y setters de las variables miembros o atributos
 * @author ProgVisual2021
 *
 */
@Entity
@Table(name="PAYMENTS")
@Component
public class Payment {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotBlank(message = "El campo no puede estar vacio")
	private String checkNumber;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "El campo no puede estar vacio")
	private Date paymentDate;
	@Column
	@NotNull(message = "El campo no puede estar vacio")
	private Double amount;
	
	@Autowired
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="customerNumber")
	@NotNull(message = "El campo no puede estar vacio")
	private Customers customers;
//<<<<---------CONSTRUCTORES-------->>>>	
/**
 * Constructor por defecto o sin parametros
 */
public Payment() {
	// TODO Auto-generated constructor stub
}

/** Constructor Parametrizado o sobrecargado
 * @param checkNumber tipo de dato String
 * @param paymentDate tipo de dato Date
 * @param amount tipo de dato Doube
 * @param customers tipo de dato Customer
 */
public Payment(String checkNumber, Date paymentDate, Double amount, Customers customers) { 
	super();
	this.checkNumber = checkNumber;
	this.paymentDate = paymentDate;
	this.amount = amount;
	this.customers = customers;
}
//<<<<------------Metodos accesores GETTERsy SETTERs
/**metodo accesor getter muestra lo q contiene la variable miembro
 * @return retorna checkNumber
 */
public String getCheckNumber() {
	return checkNumber;
}

/**metodo accesor setter introduce datos a la variable miembro 
 * @param checkNumber tipo String
 */
public void setCheckNumber(String checkNumber) {
	this.checkNumber = checkNumber;
}

/**
 * @return retornala variable miembro paymentDate
 */
public Date getPaymentDate() {
	return paymentDate;
}

/**
 * @param paymentDate tipo de dato Date
 */
public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}

/**
 * @return retornala variable miembro amount
 */
public Double getAmount() {
	return amount;
}

/**
 * @param amount tipo Double
 */
public void setAmount(Double amount) {
	this.amount = amount;
}

/**
 * @return retornala variable miembro customers
 */
public Customers getCustomers() {
	return customers;
}

/**
 * @param customers tipo Customer
 */
public void setCustomers(Customers customers) {
	this.customers = customers;
}



	
}
