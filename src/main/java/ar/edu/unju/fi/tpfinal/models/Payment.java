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
	
public Payment() {
	// TODO Auto-generated constructor stub
}

/**
 * @return the checkNumber
 */
public String getCheckNumber() {
	return checkNumber;
}

/**
 * @param checkNumber the checkNumber to set
 */
public void setCheckNumber(String checkNumber) {
	this.checkNumber = checkNumber;
}

/**
 * @return the paymentDate
 */
public Date getPaymentDate() {
	return paymentDate;
}

/**
 * @param paymentDate the paymentDate to set
 */
public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}

/**
 * @return the amount
 */
public Double getAmount() {
	return amount;
}

/**
 * @param amount the amount to set
 */
public void setAmount(Double amount) {
	this.amount = amount;
}

/**
 * @return the customers
 */
public Customers getCustomers() {
	return customers;
}

/**
 * @param customers the customers to set
 */
public void setCustomers(Customers customers) {
	this.customers = customers;
}

/**
 * @param checkNumber
 * @param paymentDate
 * @param amount
 * @param customers
 */
public Payment(String checkNumber, Date paymentDate, Double amount, Customers customers) {
	super();
	this.checkNumber = checkNumber;
	this.paymentDate = paymentDate;
	this.amount = amount;
	this.customers = customers;
}

	
}
