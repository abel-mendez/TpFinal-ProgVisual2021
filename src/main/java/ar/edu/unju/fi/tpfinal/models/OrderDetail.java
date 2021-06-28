package ar.edu.unju.fi.tpfinal.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


/**Clase OrderDetail
 *Clase entidad - Esta Tabla recibe el nombre OFFICES
 *contiene metodos accesores getters y setters de las variables miembros o atributos
 * @author ProgVisual2021
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
	@NotNull(message = "Debes introducir quantityOrdered")
	@Min(value=1,message="minimo 1 digito")
	private int quantityOrdered;
	@Column
	@NotNull(message = "El campo princeEach no puede estar vacio")
	private double princeEach;
	@Column
	@NotNull(message = "Debes introducir orderLineNumber")
	@Min(value=2,message="minimo 2 digito")
	private int orderLineNumber;
	
//CONSTRUCTORES
	/**
	 * Constructor por defecto o sin parametro
	 */
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
/**Constructor parametrizado o sobrecargado
 * @param id
 * @param quantityOrdered
 * @param princeEach
 * @param orderLineNumber
 */
public OrderDetail(OrderDetailId id, int quantityOrdered, double princeEach, int orderLineNumber) {
	super();
	this.id = id;
	this.quantityOrdered = quantityOrdered;
	this.princeEach = princeEach;
	this.orderLineNumber = orderLineNumber;
}


//SETERs y GETERs

	/**metodo accesor getter muestra lo q contiene la variable miembro
	 * @return retorna id (OrderDetailId)
	 */
	public OrderDetailId getId() {
		return id;
	}
	/**metodo accesor setter introduce datos a la variable miembro
	 * @param id de Tipo (OrderDetailId)
	 */
	public void setId(OrderDetailId id) {
		this.id = id;
	}
	/**
	 * @return retorna quantityOrdered (int)
	 */
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	/**
	 * @param quantityOrdered de Tipo (int)
	 */
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	/**
	 * @return retorna princeEach (double)
	 */
	public double getPrinceEach() {
		return princeEach;
	}
	/**
	 * @param princeEach de Tipo (double)
	 */
	public void setPrinceEach(double princeEach) {
		this.princeEach = princeEach;
	}
	/**
	 * @return retorna orderLineNumber (int)
	 */
	public int getOrderLineNumber() {
		return orderLineNumber;
	}
	/**
	 * @param orderLineNumber de Tipo (int)
	 */
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	/**
	 * @return retorna serialVersionUID (Long)
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//TO STRING

	/**
	 *Muestra la informacion completa de OrderDetail
	 */
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantityOrdered=" + quantityOrdered + ", princeEach=" + princeEach
				+ ", orderLineNumber=" + orderLineNumber + "]";
	}
	
	
	
	
	
	
}
