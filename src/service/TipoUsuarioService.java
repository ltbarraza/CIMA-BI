package service;

import java.util.List;

import pojo.TipoUsuario;

public interface TipoUsuarioService {
	
	public TipoUsuario findById(int id);
	public List<TipoUsuario> AllTipoUsuario();

}
