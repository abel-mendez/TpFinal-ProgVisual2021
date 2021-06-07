package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import ar.edu.unju.fi.tpfinal.models.Office;
import ar.edu.unju.fi.tpfinal.reposiroty.IOfficeRepository;
import ar.edu.unju.fi.tpfinal.service.IOfficeService;

public class OfficeServiceImpMySQL implements IOfficeService {
	private List<Office> offices=new ArrayList<Office>();
	@Autowired
	private IOfficeRepository officeRepo;
	@Autowired
	Office office;
	
	@Override
	public void guardarOffice(Office office) {
		officeRepo.save(office);
	}

	@Override
	public List<Office> getAllOffices() {
		this.offices=(List<Office>) officeRepo.findAll();
		return offices;
	}

	@Override
	public Office getOffice() {
		return this.office;
	}

	@Override
	public Office getOfficeById(String id) {
		Office ofi=officeRepo.findById(id).get();
		return ofi;
	}

	@Override
	public void deletOfficeById(String id) {
		officeRepo.deleteById(id);
	}

}
