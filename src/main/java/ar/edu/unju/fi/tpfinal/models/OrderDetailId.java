package ar.edu.unju.fi.tpfinal.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class OrderDetailId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product productCode;
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Orders orderNumber;
//CONSTRUCTORES
	public OrderDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailId(Product productCode, Orders orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}
//SETERs y GETERS
	public Product getProductCode() {
		return productCode;
	}
	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}
	public Orders getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Orders orderNumber) {
		this.orderNumber = orderNumber;
	}
	

public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//TO STRINGs
	@Override
	public String toString() {
		return "OrderDetailId [productCode=" + productCode + ", orderNumber=" + orderNumber + "]";
	}
	

	
	
	

}
