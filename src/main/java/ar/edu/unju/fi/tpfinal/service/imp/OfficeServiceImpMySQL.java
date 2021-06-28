package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Office;
import ar.edu.unju.fi.tpfinal.repository.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;
/**
 * Clase OfficeServiceImpMySQL que implementa IOfficeService
 * clase que no permite utilizar e implementar los metodos definidos
 * en la capa de servicio IOfficeService.
 * @author ProgVisual2021
 *
 */
@Service
public class OfficeServiceImpMySQL implements IOfficeService {
	private List<Office> offices=new ArrayList<Office>();
	@Autowired
	private IOfficeRepository officeRepo;
	@Autowired
	Office office;
	
	/**
	 *Metodo que guarda un Office en la Base de datos.
	 */
	@Override
	public void guardarOffice(Office office) {
		officeRepo.save(office);
	}

	/**
	 *Metodo que devuelve la lista de Offices almacenados en la base de datos.
	 */
	@Override
	public List<Office> getAllOffices() {
		this.offices=(List<Office>) officeRepo.findAll();
		return offices;
	}

	/**
	 *Metodo que obtiene un Office vacio.
	 */
	@Override
	public Office getOffice() {
		return this.office;
	}

	/**
	 *Metodo que busca un Office por su id en la base de datos para devolverlo
	 */
	@Override
	public Office getOfficeById(String id) {
		Office ofi=officeRepo.findById(id).get();
		return ofi;
	}

	/**
	 *Metodo que elimina un office en la base de datos.
	 */
	@Override
	public void deletOfficeById(String id) {
		officeRepo.deleteById(id);
	}

}
