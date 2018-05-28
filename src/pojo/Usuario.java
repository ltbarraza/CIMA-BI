package pojo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;

	@Column(name = "apellido", nullable = false, length = 30)
	private String apellido;

	@Column(name = "usuario", nullable = false, length = 30)
	private String usuario;

	@Column(name = "clave", nullable = false, length = 30)
	private String clave;

	@Column(name = "correo", nullable = false, length = 100)
	public String correo;

	@Column(name = "cedula", nullable = false)
	private Double cedula;

	@Column(name = "telefono", nullable = false)
	private Double telefono;

	@Column(name = "activo", nullable = false)
	private boolean activo;

	@ManyToOne()
	@JoinColumn(name = "idTipo_Usuario", nullable = false)
	private TipoUsuario tipoUsuario;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "UsuarioEmpresa", joinColumns = { @JoinColumn(name = "idUsuario") }, inverseJoinColumns = {
			@JoinColumn(name = "idEmpresa") })

	private Set<Empresa> empresas = new HashSet<Empresa>();

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Boletin> boletins;

	public Usuario() {

	}

	public Usuario(int idUsuario, String nombre, String apellido, String usuario, String clave, String correo,
			Double cedula, Double telefono, boolean activo, TipoUsuario tipoUsuario, Set<Empresa> usuarioEmpresas,
			List<Boletin> boletins) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.correo = correo;
		this.cedula = cedula;
		this.telefono = telefono;
		this.activo = activo;
		this.tipoUsuario = tipoUsuario;
		this.empresas = usuarioEmpresas;
		this.boletins = boletins;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Double getCedula() {
		return cedula;
	}

	public void setCedula(Double cedula) {
		this.cedula = cedula;
	}

	public Double getTelefono() {
		return telefono;
	}

	public void setTelefono(Double telefono) {
		this.telefono = telefono;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Set<Empresa> getUsuarioEmpresas() {
		return empresas;
	}

	public void setUsuarioEmpresas(Set<Empresa> usuarioEmpresas) {
		this.empresas = usuarioEmpresas;
	}

	public List<Boletin> getBoletins() {
		return boletins;
	}

	public void setBoletins(List<Boletin> boletins) {
		this.boletins = boletins;
	}

}
