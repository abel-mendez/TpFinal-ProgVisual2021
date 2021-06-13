package ar.edu.unju.fi.tpfinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Usuario;
import ar.edu.unju.fi.tpfinal.reposiroty.IUsuarioRepository;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

/**
 * @author Diego
 *
 */
@Service
public class UsuarioServiceImp implements IUsuarioService {
	@Autowired
	private IUsuarioRepository usuarioRepo;

	@Override
	public void guardarUsuario(Usuario usuario) {
		
		usuarioRepo.save(usuario);

	}

	@Override
	public Usuario buscarPorUsuario(String usuario) {
		Usuario us = usuarioRepo.findByUsuario(usuario);
		return us;
	}

}
