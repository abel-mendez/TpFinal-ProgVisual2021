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
 * Clase Product
 *Clase entidad - Esta Tabla recibe el nombre PRODUCTS
 *contiene metodos accesores getters y setters de las variables miembros o atributos
 *
 * @author ProgVisual2021
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
	private ProductLine productLine;
	@Column
	@NotEmpty(message="Debes ingresar productScale")
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
	@Min(value=1,message="minimo 1 digito")
	private double buyPrice;
	@Column
	@NotNull(message = "El campo msrp no puede estar vacio")
	@Min(value=1,message="minimo 1 digito")
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
	 * Constructor parametrizado o sobre cargado
	 * 
	 * @param productCode tipo de dato String 
	 * @param productName tipo de dato String
	 * @param productLine tipo de dato ProductLine
	 * @param productScale tipo de dato String
	 * @param productVendor tipo de dato String
	 * @param productDescription tipo de dato String 
	 * @param quantityInStock tipo de dato entero(int)
	 * @param buyPrice tipo de dato double 
	 * @param msrp tipo de dato double
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
	
	/**
	 * @return muestra contenido de la variable ProductCode
	 */
	public String getProductCode() {
		return productCode;
	}
	/**
	 * @param productCode envia dato a la variable  y de tipo String
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	/**
	 * @return devuelve el contenido en la variable productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName  recibe tipo de dato String
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return muestra la variable miembre Producto line  de tipo  ProductLine
	 */
	public ProductLine getProductLine() {
		return productLine;
	}
	/**
	 * @param recibe un obj 
	 * productLine de tipo ProductLine 
	 */ 
	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}
	/**
	 * @return retrona variable miembro de tipo String
	 */
	public String getProductScale() {
		return productScale;
	}
	/**
	 * @param productScale (String)
	 */
	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}
	/**
	 * @return la variable productVendedor 
	 */
	public String getProductVendor() {
		return productVendor;
	}
	/**
	 * @param productVendor de tipo String
	 */
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	/**
	 * @return retorna de tipo string
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription de tipo String
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return retorna un entero int 
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}
	/**
	 * @param quantityInStock de tipo entero (int)
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	/**
	 * @return retorn variable miembre BuyPrice
	 */
	public double getBuyPrice() {
		return buyPrice;
	}
	/**
	 * @param buyPrice de tipo double
	 */
	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}
	/**
	 * @return retorna variable miembre mrsp
	 */
	public double getMsrp() {
		return msrp;
	}
	/**
	 * @param msrp de tipo de dato double
	 */
	public void setMsrp(double msrp) {
		this.msrp = msrp;
	}
	//TO STRING
	/**
	 * muestra la informacion completa de Product
	 */
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
