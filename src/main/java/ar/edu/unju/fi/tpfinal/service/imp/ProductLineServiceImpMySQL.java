package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.ProductLine;
import ar.edu.unju.fi.tpfinal.repository.IProductLineRepository;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

/**
 * @author Diego
 *
 */
@Service
public class ProductLineServiceImpMySQL implements IProductLineService {

	@Autowired
	private IProductLineRepository productLineRepo;
	@Autowired
	private ProductLine productLine;
	private List<ProductLine> listPL=new ArrayList<ProductLine>();
	
	@Override
	public void guardarProductLine(ProductLine productLine) {
		productLineRepo.save(productLine);
	}

	@Override
	public void eliminarProductLine(String id) {
		productLineRepo.deleteById(id);
	}

	@Override
	public List<ProductLine> getAllProductsLine() {
		this.listPL=(List<ProductLine>) productLineRepo.findAll();
		return listPL;
	}

	@Override
	public ProductLine getProductLineById(String id) {
		ProductLine pl=productLineRepo.findById(id).get();
		return pl;
	}

	@Override
	public ProductLine getNewProductLine() {
		
		return this.productLine;
	}

}
