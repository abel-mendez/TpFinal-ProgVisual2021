package ar.edu.unju.fi.tpfinal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="PAYMENTS")
@Component
public class Payment {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String checkNumber;
	@Column
	private Date paymentDate;
	@Column
	private Double amount;
	
	
	@OneToOne(mappedBy = "payment",fetch = FetchType.LAZY)
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
