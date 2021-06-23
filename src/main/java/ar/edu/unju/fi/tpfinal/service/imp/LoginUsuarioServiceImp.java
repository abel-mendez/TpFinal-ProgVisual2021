package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.models.Usuario;
import ar.edu.unju.fi.tpfinal.repository.IUsuarioRepository;

@Service
public class LoginUsuarioServiceImp implements UserDetailsService {
	@Autowired
	IUsuarioRepository usuarioRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuarioEncontrado = usuarioRepo.findByUsuario(username).orElseThrow(()-> new UsernameNotFoundException("Usuario inválido"));
		
		List<GrantedAuthority> perfiles = new ArrayList<>(); 
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		perfiles.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(username, usuarioEncontrado.getPassword(), perfiles);
		return user;
	}

}


