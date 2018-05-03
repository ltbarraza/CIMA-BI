package dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.TipoUsuario;

@Repository
@Transactional
public class TipoUsuarioDaoImpl implements TipoUsuarioDao  {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public TipoUsuario findById(int id) {
		
		TipoUsuario tipoUsuario = (TipoUsuario) getSession().createQuery("from TipoUsuario where idTipo_Usuario = :idTipo_Usuario")
				.setParameter("idTipo_Usuario", id).uniqueResult();
		
		return tipoUsuario;
	}

}
