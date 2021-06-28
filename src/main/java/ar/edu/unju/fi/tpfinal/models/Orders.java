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

/** Clase Orders
 * clase entidad  esta tabla recibe el nombre de ORDERS
 * contiene metodos accesores getters y setters de las variables miembros o atributos 
 * @author ProgVisual2021
 *
 */
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
	@Size(min = 3,max = 100, message="Minimo 3 y Maximo 100 caracteres")
	private String comments;
	@Autowired
	@ManyToOne
	@JoinColumn(name="customerNumber")
	//@Valid
	private Customers customers;
	
// <<<<<<---------CONSTRUCTORES-------->>>>>>
	/**
	 * Constructor por defecto o sin parametro
	 */
	public Orders() {
		// TODO Auto-generated constructor stub
	}
	
	/** Constructor parametrizado o sobrecargado
	 * 
	 * @param orderNumber Identificaor (ID) de tipo entero (int) 
	 * @param orderDate fecha de orden, tipo fecha(Date)
	 * @param requiredDate  fecha requerida, tipo fecha (Date)
	 * @param shippedDate   fecha de envio, tipo fecha(Date)
	 * @param status estado de orden, tipo texto(String)
	 * @param comments comentarios, tipo texto(String)
	 * @param customers cliente, tipo cliente (Customer)
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
	
//<<<<--------Metodos Accesores SETERs Y GETERs-------->>>>
	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return retorna orderNumber (int)
	 */
	public int getOrderNumber() {
		return orderNumber;
	}

	/**metodo accesor setter introduce datos a la variable miembro 
	 * @param orderNumber de tipo entero (int)
	 */
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate de tipo Date
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return the requiredDate
	 */
	public Date getRequiredDate() {
		return requiredDate;
	}

	/**
	 * @param requiredDate de tipo Date
	 */
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return the shippedDate
	 */
	public Date getShippedDate() {
		return shippedDate;
	}

	/**
	 * @param shippedDate de tipo Date
	 */
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status de tipo String
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments de tipo String
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/** metodo accesor getter muestra lo q contiene la variable miembro
	 * @return the customers
	 */
	public Customers getCustomers() {
		return customers;
	}

	/**
	 * @param customers de tipo Customers
	 */
	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

//<<<<-------TO STRING-------->>>>
	/**
	 *Muestra la informacion completa de Order
	 */
	@Override
	public String toString() {
		return "Orders [orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", requiredDate=" + requiredDate
				+ ", shippedDate=" + shippedDate + ", status=" + status + ", comments=" + comments + ", customers="
				+ customers + "]";
	}
	
}
