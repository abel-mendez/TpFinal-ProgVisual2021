package ar.edu.unju.fi.tpfinal.models;

/**
 * @author Diego
 *
 */
public class OrderDetail {
	private Integer orderNumber;
	private String productCode;
	private int quantityOrdered;
	private double princeEach;
	private byte orderLineNumber;
//CONSTRUCTORES
	/**
	 * 
	 */
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param orderNumber
	 * @param productCode
	 * @param quantityOrdered
	 * @param princeEach
	 * @param orderLineNumber
	 */
	public OrderDetail(Integer orderNumber, String productCode, int quantityOrdered, double princeEach,
			byte orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrdered = quantityOrdered;
		this.princeEach = princeEach;
		this.orderLineNumber = orderLineNumber;
	}
	//SETERs y GETERs
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	public byte getOrderLineNumber() {
		return orderLineNumber;
	}
	public void setOrderLineNumber(byte orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	//TO STRING
	@Override
	public String toString() {
		return "OrderDetail [orderNumber=" + orderNumber + ", productCode=" + productCode + ", quantityOrdered="
				+ quantityOrdered + ", princeEach=" + princeEach + ", orderLineNumber=" + orderLineNumber + "]";
	}
	
}
