package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UsuarioEmpresaDao;
import pojo.UsuarioEmpresa;

@Service
public class UsuarioEmpresaServiceImpl implements UsuarioEmpresaService  {
	
	@Autowired
	UsuarioEmpresaDao usuarioEmpresaDao;


	public void SaveUsuarioEmpresa(List<UsuarioEmpresa> usuarioEmpresa) {
		
		usuarioEmpresaDao.SaveUsuarioEmpresa(usuarioEmpresa);
	}

}
