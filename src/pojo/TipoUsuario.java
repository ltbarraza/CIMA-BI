package pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "TipoUsuarios")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idTipo_Usuario;

	@Column(name = "nombre")
	public String nombre;

	

	@JsonBackReference
	@OneToMany(mappedBy = "usuario")
	public Set<Usuario> usuarios;

	public TipoUsuario() {

	}
	


	public TipoUsuario(int idTipo_Usuario, String nombre, Set<Usuario> usuarios) {

		this.idTipo_Usuario = idTipo_Usuario;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public int getIdTipo_Usuario() {
		return idTipo_Usuario;
	}

	public void setIdTipo_Usuario(int idTipo_Usuario) {
		this.idTipo_Usuario = idTipo_Usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
