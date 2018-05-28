package dao;

import java.util.List;

import pojo.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> AllConsultores();
	public List<Usuario> AllUsuarios();
	public Usuario findById(int id);
	public List<Usuario> findEmpresaUsuariobyId(int id);
	public void SaveUsuario(Usuario usuario);
	public void UpdateUsuario(Usuario usuario);
	public void DeleteUsuario(Usuario usuario);
	
}
