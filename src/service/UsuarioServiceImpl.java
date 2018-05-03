package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuarioDao;
import pojo.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService  {

	@Autowired
	UsuarioDao usuarioDao;

	public List<Usuario> AllConsultores() {

		return usuarioDao.AllConsultores();
	}

	public List<Usuario> AllUsuarios() {

		return usuarioDao.AllUsuarios();
	}

	public Usuario findById(int id) {

		return usuarioDao.findById(id);
	}

	public void SaveUsuario(Usuario usuario) {
		
		if(usuario.getIdUsuario() == 0){
			
			usuarioDao.SaveUsuario(usuario);
			
		}else{
			
			usuarioDao.UpdateUsuario(usuario);
			
		}

		

	}

	public void DeleteUsuario(Usuario usuario) {
		
		usuarioDao.DeleteUsuario(usuario);
		
	}

	

}
