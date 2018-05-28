package dao;

import java.util.List;

import pojo.TipoUsuario;

public interface TipoUsuarioDao {

	public TipoUsuario findById(int id);
	public List<TipoUsuario> AllTipoUsuario();
}
