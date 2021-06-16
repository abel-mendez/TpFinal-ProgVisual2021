package ar.edu.unju.fi.tpfinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author Diego
 *
 */
@Entity
@Table(name="PRODUCTLINES")
@Component
public class ProductLine {
	@Id
	@Column(name = "productline")
	private String productline;
	@Column
	private String textDescription;
	@Column(columnDefinition = "MEDIUMTEXT")
	private String htmlDescription;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
//CONSTRUCTORES
	/**
	 * 
	 */
	public ProductLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param productline
	 * @param textDescription
	 * @param htmlDescription
	 * @param image
	 */
	public ProductLine(String productline, String textDescription, String htmlDescription, String image) {
		super();
		this.productline = productline;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}
//SETERs y GETERs
	public String getProductline() {
		return productline;
	}
	public void setProductline(String productline) {
		this.productline = productline;
	}
	public String getTextDescription() {
		return textDescription;
	}
	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}
	public String getHtmlDescription() {
		return htmlDescription;
	}
	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
//TO STRING
	@Override
	public String toString() {
		return "ProductLine [productline=" + productline + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + "]";
	}

}
