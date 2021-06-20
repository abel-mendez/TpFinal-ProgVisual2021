package ar.edu.unju.fi.tpfinal.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name= "ORDERS")
@Component("oneOrder")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int orderNumber;
	@Column
	@NotNull(message="Debe ingresar una fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	@Column
	@NotNull(message="Debe ingresar una fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date requiredDate;
	@Column
	@NotNull(message="Debe ingresar una fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shippedDate;
	@Column
	@NotEmpty(message="Debes ingresar un status")
	@Size(min = 5,max = 50, message="Minimo 5 y Maximo 50 caracteres")
	private String status;
	@Column
	@NotEmpty(message="Debes ingresar un comments")
	@Size(min = 10,max = 100, message="Minimo 10 y Maximo 100 caracteres")
	private String comments;
	@Autowired
	@ManyToOne
	@JoinColumn(name="customerNumber")
	@Valid
	private Customers customers;
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the orderNumber
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the requiredDate
	 */
	public Date getRequiredDate() {
		return requiredDate;
	}

	/**
	 * @param requiredDate the requiredDate to set
	 */
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	/**
	 * @return the shippedDate
	 */
	public Date getShippedDate() {
		return shippedDate;
	}

	/**
	 * @param shippedDate the shippedDate to set
	 */
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
	 * @param orderNumber
	 * @param orderDate
	 * @param requiredDate
	 * @param shippedDate
	 * @param status
	 * @param comments
	 * @param customers
	 */
	public Orders(int orderNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments,
			Customers customers) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customers="
				+ customers + "]";
	}
	
}
