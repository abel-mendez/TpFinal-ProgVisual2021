package ar.edu.unju.fi.tpfinal.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**Clase OrderDetailId
 * Clase que es una relacion entre dos tablas (Products - OrderDetail)
 * donde almacena las claves para generar una tabla de relacion en la base de datos.
 * @author ProgVisual2021
 *
 */
@Embeddable
public class OrderDetailId implements Serializable{


	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product productCode;
	@ManyToOne
	@JoinColumn(name = "orderNumber")
	private Orders orderNumber;
//CONSTRUCTORES
	/**
	 *  Constructor por defecto o sin parametro
	 */
	public OrderDetailId() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**Constructor parametrizado o sobrecargado
	 * @param productCode
	 * @param orderNumber
	 */
	public OrderDetailId(Product productCode, Orders orderNumber) {
		super();
		this.productCode = productCode;
		this.orderNumber = orderNumber;
	}
//SETERs y GETERS
	/**metodo accesor getter muestra lo q contiene la variable miembro
	 * @return retorna productCode (Product)
	 */
	public Product getProductCode() {
		return productCode;
	}
	/**metodo accesor setter introduce datos a la variable miembro
	 * @param productCode de Tipo (Product)
	 */
	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return retorna orderNumber (Orders)
	 */
	public Orders getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber de Tipo (Orders)
	 */
	public void setOrderNumber(Orders orderNumber) {
		this.orderNumber = orderNumber;
	}
	

/**
 * @return retorna serialVersionUID (Long)
 */
public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//TO STRINGs
	/**
	 *Muestra la informacion completa de OrderDetailId
	 */
	@Override
	public String toString() {
		return "OrderDetailId [productCode=" + productCode + ", orderNumber=" + orderNumber + "]";
	}
	

	
	
	

}
