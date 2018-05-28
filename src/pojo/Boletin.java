package pojo;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Boletins")
public class Boletin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBoletin;

	@Column(name = "titulo")
	private String titulo;

	@Column(name = "fecha_creacion")
	private Timestamp fecha_creacion;

	@Column(name = "enviado")
	private boolean enviado;

	@Column(name = "fecha_envio")
	private Timestamp fecha_envio;

	@ManyToOne()
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;

	@ManyToOne()
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "boletin")
	public Set<Hecho> hechos;

	public Boletin() {

	}

	public Boletin(int idBoletin, String titulo, Timestamp fecha_creacion, boolean enviado, Timestamp fecha_envio,
			Empresa empresa, Usuario usuario) {

		this.idBoletin = idBoletin;
		this.titulo = titulo;
		this.fecha_creacion = fecha_creacion;
		this.enviado = enviado;
		this.fecha_envio = fecha_envio;
		this.empresa = empresa;
		this.usuario = usuario;
	}

	public int getIdBoletin() {
		return idBoletin;
	}

	public void setIdBoletin(int idBoletin) {
		this.idBoletin = idBoletin;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Timestamp getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Timestamp fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public boolean isEnviado() {
		return enviado;
	}

	public void setEnviado(boolean enviado) {
		this.enviado = enviado;
	}

	public Timestamp getFecha_envio() {
		return fecha_envio;
	}

	public void setFecha_envio(Timestamp fecha_envio) {
		this.fecha_envio = fecha_envio;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
