package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.models.Office;

/**
 * Interface de Servicio IOfficeService
 * que nos permite definir los metodos que podemos utilizar.
 * @author ProgVisual2021
 *
 */
public interface IOfficeService {
	/**
	 * Metodo que nos permite guardar un Office a la base de datos
	 * @param office parametro que tiene el objeto a guardar.
	 */
	public void guardarOffice(Office office);
	/**
	 * Metodo que muestra la lista de Offices que tenemos en la base de datos
	 * @return retorna una lista de Offices.
	 */
	public List<Office> getAllOffices();
	/**
	 * Metodo que Obtiene un Office
	 * @return retorna la lista de Office
	 */
	public Office getOffice();
	/**
	 * Metodo que Busca un Office por id
	 * @param id parametro que se usa para obtener un Office por su id
	 * @return retorna un Office que correspone al parametro id
	 */
	public Office getOfficeById(String id);
	/**
	 * Metodo que elimina un Office idetificado por el id
	 * @param id parametro que sirve para identidicar al Office a eliminar
	 */
	public void deletOfficeById(String id);
}	
