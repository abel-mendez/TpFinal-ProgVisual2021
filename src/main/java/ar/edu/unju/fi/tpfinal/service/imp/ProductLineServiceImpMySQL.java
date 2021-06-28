package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

/**
 * Clase ProductLineServiceImpMySQL que implementa IProductLineService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IProductLineService.
 * 
 * @author ProgVisual2021
 *
 */
@Service
public class ProductLineServiceImpMySQL implements IProductLineService {

	@Autowired
	private IProductLineRepository productLineRepo;
	@Autowired
	private ProductLine productLine;
	private List<ProductLine> listPL=new ArrayList<ProductLine>();
	
	/**
	 *Metodo que nos permite guardar un ProductLine a la base de datos
	 */
	@Override
	public void guardarProductLine(ProductLine productLine) {
		productLineRepo.save(productLine);
	}

	/**
	 *Metodo que elimina un ProductLine idetificado por el id
	 */
	@Override
	public void eliminarProductLine(String id) {
		productLineRepo.deleteById(id);
	}

	/**
	 *Metodo que muestra la lista de ProductLine que tenemos en la base de datos
	 */
	@Override
	public List<ProductLine> getAllProductsLine() {
		this.listPL=(List<ProductLine>) productLineRepo.findAll();
		return listPL;
	}

	/**
	 *Metodo que Busca unProductLiner por id
	 */
	@Override
	public ProductLine getProductLineById(String id) {
		ProductLine pl=productLineRepo.findById(id).get();
		return pl;
	}

	/**
	 * Metodo que se obtiene un nuevo Productline vacio
	 */
	@Override
	public ProductLine getNewProductLine() {
		
		return this.productLine;
	}

}
