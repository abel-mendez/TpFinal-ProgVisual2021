package ar.edu.unju.fi.tpfinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ar.edu.unju.fi.tpfinal.models.Usuario;
import ar.edu.unju.fi.tpfinal.service.IUsuarioService;

@SpringBootApplication
public class TrabajoFinalProgVisualApplication implements CommandLineRunner {
	@Autowired
	IUsuarioService usuarioService;
	public static void main(String[] args) {
		SpringApplication.run(TrabajoFinalProgVisualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*Usuario us= new Usuario();
		us.setPassword("admin");
		us.setTipo("ADMINISTRADOR");
		us.setUsuario("admin");
		us.setId(Long.valueOf(4125));
		usuarioService.guardarUsuario(us);*/
		
	}
}
