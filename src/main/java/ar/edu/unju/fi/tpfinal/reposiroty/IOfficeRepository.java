package ar.edu.unju.fi.tpfinal.reposiroty;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Office;

public interface IOfficeRepository extends CrudRepository<Office, String> {

}
