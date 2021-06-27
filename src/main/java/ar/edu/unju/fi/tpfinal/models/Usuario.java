package ar.edu.unju.fi.tpfinal.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "USUARIOS")
@Component
public class Usuario {
	@Id
	@Column(name="us_Id")
	@NotNull(message = "Debes introducir id")
	private Long id;
	@Column
	@NotBlank(message = "El campo usuario no puede estar vacio")
	private String usuario;
	@Column
	@NotBlank(message = "El campo password no puede estar vacio")
	private String password;
	@Column
	@NotBlank(message = "El campo tipo no puede estar vacio")
	private String tipo;
	
	@Autowired
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@Valid
	private Employee empleado;
//CONSTRUCTORES
	/**
	 * 
	 */
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param usuario
	 * @param password
	 * @param tipo
	 * @param empleado
	 */
	public Usuario(Long id, String usuario, String password, String tipo, Employee empleado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
		this.tipo = tipo;
		this.empleado = empleado;
	}
//SETERS y GETERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Employee getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}
 //TO STRING
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + ", tipo=" + tipo
				+ ", empleado=" + empleado + "]";
	}
	
}
