package ar.edu.unju.fi.tpfinal.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
	public Optional< Usuario> findByUsuario(String usuario);
}
