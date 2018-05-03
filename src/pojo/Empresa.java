package pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEmpresa;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="activa")
	private boolean activa;
	
	@Column(name="asignada")
	private boolean asignada;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="UsuarioEmpresa",
	joinColumns={@JoinColumn(name="idEmpresa")},
	inverseJoinColumns={@JoinColumn(name="idUsuario")})
	private Set<Usuario> usuarios;
	
	@JsonIgnore
	@OneToMany(mappedBy="empresa")
	private Set<Boletin> boletins;
	
	public Empresa(){
		
	}

	public Empresa(int idEmpresa, String nombre, boolean activa, boolean asignada, Set<Usuario> usuarios,
			Set<Boletin> boletins) {
		super();
		this.idEmpresa = idEmpresa;
		this.nombre = nombre;
		this.activa = activa;
		this.asignada = asignada;
		this.usuarios = usuarios;
		this.boletins = boletins;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public boolean isAsignada() {
		return asignada;
	}

	public void setAsignada(boolean asignada) {
		this.asignada = asignada;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Set<Boletin> getBoletins() {
		return boletins;
	}

	public void setBoletins(Set<Boletin> boletins) {
		this.boletins = boletins;
	}
	
	

}
