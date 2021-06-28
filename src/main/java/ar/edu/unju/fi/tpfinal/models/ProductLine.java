package ar.edu.unju.fi.tpfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

/**Clase ProductLine
 *Clase entidad - Esta Tabla recibe el nombre PRODUCTLINES
 *contiene metodos accesores getters y setters de las variables miembros o atributos
 * 
 * @author ProgVisual2021
 *
 */
@Entity
@Table(name="PRODUCTLINES")
@Component
public class ProductLine {
	@Id
	@Column(name = "productline")
	@NotEmpty(message="Debes ingresar productline")
	private String productline;
	@Column
	@NotEmpty(message="Debes ingresar textDescription")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String textDescription;
	@Column(columnDefinition = "MEDIUMTEXT")
	@NotEmpty(message="Debes ingresar htmlDescription")
	@Size(min = 5,max = 30, message="Minimo 5 y Maximo 30 caracteres")
	private String htmlDescription;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	@NotEmpty(message="Debes ingresar image")
	private String image;
//CONSTRUCTORES
	/**
	 * Contstructor por defecto o sin parametros
	 */
	public ProductLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor Parametrizado o sobrecargado
	 * 
	 * @param productline de tipo String
	 * @param textDescription de tipo String
	 * @param htmlDescription de Tipo String
	 * @param image de tipo String
	 */
	public ProductLine(String productline, String textDescription, String htmlDescription, String image) {
		super();
		this.productline = productline;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}
//SETERs y GETERs
	/**
	 * @return muestra contenido de la variable productLine(id) 
	 * de tipo string 
	 */
	public String getProductline() {
		return productline;
	}
	/**
	 * @param productline de tipo String introducir datos a la variable productLine
	 */
	public void setProductline(String productline) {
		this.productline = productline;
	}
	/**
	 * @return muestra el contenido de textDescription de tipo String
	 */
	public String getTextDescription() {
		return textDescription;
	}
	/**
	 * @param textDescription de tipo String 
	 * introduce datos a la variable miembre
	 */
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	/**
	 * @return devuelve un String q contiene en la varible miembre htmlDescription
	 */
	public String getHtmlDescription() {
		return htmlDescription;
	}
	/**
	 * @param htmlDescription recibe un String para almacenar en la variable miembro
	 */
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	/**
	 * @return retorna un cadena q representa la imgene
	 */
	public String getImage() {
		return image;
	}
	/**
	 * @param image recibe una imagen en tipo cadena 
	 */
	public void setImage(String image) {
		this.image = image;
	}
//TO STRING
	/**
	 *Metodo To String muestra 
	 *la informacion completa de ProductLine
	 */
	@Override
	public String toString() {
		return "ProductLine [productline=" + productline + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + "]";
	}

}
