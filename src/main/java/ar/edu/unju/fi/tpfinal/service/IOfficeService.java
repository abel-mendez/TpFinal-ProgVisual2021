package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Office;


public interface IOfficeService {
	public void guardarOffice(Office office);
	public List<Office> getAllOffices();
	public Office getOffice();
	public Office getOfficeById(String id);
	public void deletOfficeById(String id);
}	
