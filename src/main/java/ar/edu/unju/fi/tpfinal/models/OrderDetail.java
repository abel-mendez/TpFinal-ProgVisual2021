package ar.edu.unju.fi.tpfinal.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Diego
 *
 */
@Entity
@Table(name="ORDERDETAILS")
//@IdClass(value = Product.class)
@Component
public class OrderDetail implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@EmbeddedId
	private OrderDetailId id;
	@Column
	private int quantityOrdered;
	@Column
	private double princeEach;
	@Column
	private int orderLineNumber;
//CONSTRUCTORES
	/**
	 * 
	 */
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
public OrderDetail(OrderDetailId id, int quantityOrdered, double princeEach, int orderLineNumber) {
	super();
	this.id = id;
	this.quantityOrdered = quantityOrdered;
	this.princeEach = princeEach;
	this.orderLineNumber = orderLineNumber;
}


//SETERs y GETERs
	public OrderDetailId getId() {
		return id;
	}
	public void setId(OrderDetailId id) {
		this.id = id;
	}
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	public double getPrinceEach() {
		return princeEach;
	}
	public void setPrinceEach(double princeEach) {
		this.princeEach = princeEach;
	}
	public int getOrderLineNumber() {
		return orderLineNumber;
	}
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//TO STRING

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantityOrdered=" + quantityOrdered + ", princeEach=" + princeEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}
	
	
	
	
	
	
}
