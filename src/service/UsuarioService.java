package service;

import java.util.List;

import pojo.Usuario;


public interface UsuarioService {

	public List<Usuario> AllConsultores();
	public List<Usuario> AllUsuarios();
	public Usuario findById(int id);
	public void SaveUsuario(Usuario usuario);
	public void DeleteUsuario(Usuario usuario);
	public List<Usuario> findEmpresaUsuariobyId(int id);
}
