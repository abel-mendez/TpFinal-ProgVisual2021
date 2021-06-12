package ar.edu.unju.fi.tpfinal.service;

import ar.edu.unju.fi.tpfinal.models.Usuario;

public interface IUsuarioService {
	public void guardarUsuario(Usuario usuario);
	public Usuario buscarPorUsuario(String usuario);

}
