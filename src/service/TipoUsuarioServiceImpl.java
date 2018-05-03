package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.TipoUsuarioDao;
import pojo.TipoUsuario;
@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService  {
	
	@Autowired
	TipoUsuarioDao tipoUsuarioDao;

	public TipoUsuario findById(int id) {
	
		return tipoUsuarioDao.findById(id);
	}

}
