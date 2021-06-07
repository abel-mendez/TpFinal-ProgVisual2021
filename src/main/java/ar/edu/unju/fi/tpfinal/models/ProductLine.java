package ar.edu.unju.fi.tpfinal.models;

/**
 * @author Diego
 *
 */
public class ProductLine {
	private String productline;
	private String textDescription;
	private String htmlDescription;
	private byte image;
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
	public ProductLine(String productline, String textDescription, String htmlDescription, byte image) {
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
	public byte getImage() {
		return image;
	}
	public void setImage(byte image) {
		this.image = image;
	}
//TO STRING
	@Override
	public String toString() {
		return "ProductLine [productline=" + productline + ", textDescription=" + textDescription + ", htmlDescription="
				+ htmlDescription + ", image=" + image + "]";
	}

}
