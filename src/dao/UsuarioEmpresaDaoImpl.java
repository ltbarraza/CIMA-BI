package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.UsuarioEmpresa;

@Repository
@Transactional
public class UsuarioEmpresaDaoImpl implements UsuarioEmpresaDao  {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	@org.springframework.transaction.annotation.Transactional
	public void SaveUsuarioEmpresa(List<UsuarioEmpresa> usuarioEmpresa) {
		
		getSession().save(usuarioEmpresa);
		
	}
	
	

}
