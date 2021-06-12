package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.ProductLine;

public interface IProductLineService {
	public void guardarProductLine(ProductLine productLine);
	public void eliminarProductLine(String id);
	public List<ProductLine> getAllProductsLine();
	public ProductLine getProductLineById(String id);
	public ProductLine getNewProductLine();

}
