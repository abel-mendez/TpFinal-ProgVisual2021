package ar.edu.unju.fi.tpfinal.reposiroty;



import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.models.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
	public Usuario findByUsuario(String usuario);
}
