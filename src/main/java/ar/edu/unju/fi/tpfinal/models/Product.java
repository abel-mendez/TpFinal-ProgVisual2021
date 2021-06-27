package ar.edu.unju.fi.tpfinal.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Diego
 *
 */
@Entity
@Table(name="PRODUCTS")
@Component
public class Product {
	@Id
	@Column
	@NotEmpty(message="Debes ingresar productCode")
	private String productCode;
	@Column
	@NotEmpty(message="Debes ingresar productName")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String productName;
	@Autowired
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="productline")
	@Valid
	private ProductLine productLine;
	@Column
	@NotEmpty(message="Debes ingresar productScale")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String productScale;
	@Column
	@NotEmpty(message="Debes ingresar productVendor")
	@Size(min = 3,max = 30, message="Minimo 3 y Maximo 30 caracteres")
	private String productVendor;
	@Column
	@NotEmpty(message="Debes ingresar productDescription")
	@Size(min = 5,max = 30, message="Minimo 5 y Maximo 30 caracteres")
	private String productDescription;
	@Column
	@NotNull(message = "Debes introducir quantityInStock")
	@Min(value=1,message="minimo 1 digito")
	private int quantityInStock;
	@Column
	@NotNull(message = "El campo buyPrice no puede estar vacio")
	private double buyPrice;
	@Column
	@NotNull(message = "El campo msrp no puede estar vacio")
	private double msrp;
	//CONSTRUCTORES
	/**
	 * Constructor por defecto
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor parametrizado
	 * 
	 * @param productCode
	 * @param productName
	 * @param productLine
	 * @param productScale
	 * @param productVendor
	 * @param productDescription
	 * @param quantityInStock
	 * @param buyPrice
	 * @param msrp
	 */
	public Product(String productCode, String productName, ProductLine productLine, String productScale,
			String productVendor, String productDescription, int quantityInStock, double buyPrice, double msrp) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		this.msrp = msrp;
	}
	//SETERs y GETERs
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductLine getProductLine() {
		return productLine;
	}
	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}
	public String getProductScale() {
		return productScale;
	}
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public double getMsrp() {
		return msrp;
	}
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	//TO STRING
	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productLine=" + productLine
				+ ", productScale=" + productScale + ", productVendor=" + productVendor + ", productDescription="
				+ productDescription + ", quantityInStock=" + quantityInStock + ", buyPrice=" + buyPrice + ", msrp="
				+ msrp + "]";
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        if (!Objects.equals(this.productCode, other.productCode)) {
            return false;
        }
        return true;
    }

}
