package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UsuariosEmpresas")
public class UsuarioEmpresa {
	
	
	@Id
	private int idEmpresa;
	

	private int idUsuario;
	
	
	public UsuarioEmpresa(){
		
	}

	public UsuarioEmpresa(int idEmpresa, int idUsuario) {
		
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
