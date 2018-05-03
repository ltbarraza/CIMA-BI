package pojo;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

	@Column(name = "groupid", nullable = false, length = 100)
	private String groupid;

	@Column(name = "cedula", nullable = false)
	private Double cedula;

	@Column(name = "telefono", nullable = false)
	private Double telefono;

	@Column(name = "activo", nullable = false)
	private boolean activo;

	// @JsonManagedReference //indicar que la propiedad asociada es parte de la
	// vinculación bidireccional entre campos; y que su función es el enlace "hijo"
	// (o "posterior"). El tipo de valor de la propiedad debe ser un bean: no puede
	// ser una Collection, Map, Array o enumeración. El enlace se maneja de tal
	// manera que la propiedad anotada con esta anotación no se serializa; y durante
	// la deserialización, su valor se establece en la instancia que tiene el enlace
	// "administrado" (hacia adelante).
	@ManyToOne()
	@JoinColumn(name = "idTipo_Usuario", nullable = false)
	private TipoUsuario tipoUsuario;

	@JsonBackReference
	@ManyToMany(mappedBy = "usuarios")
	private Set<Empresa> empresas;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Boletin> boletins;

	public Usuario() {

	}

	public Usuario(int idUsuario, String nombre, String apellido, String usuario, String clave, String correo,
			String groupid, Double cedula, Double telefono, boolean activo, TipoUsuario tipoUsuario,
			Set<Empresa> empresas, List<Boletin> boletins) {

		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.correo = correo;
		this.groupid = groupid;
		this.cedula = cedula;
		this.telefono = telefono;
		this.activo = activo;
		this.tipoUsuario = tipoUsuario;
		this.empresas = empresas;
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

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
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

	public Set<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Boletin> getBoletins() {
		return boletins;
	}

	public void setBoletins(List<Boletin> boletins) {
		this.boletins = boletins;
	}

}
