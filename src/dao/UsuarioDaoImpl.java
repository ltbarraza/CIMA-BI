package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao  {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> AllConsultores() {

		return getSession().createQuery("FROM Usuario where idTipo_Usuario = :idTipo_Usuario")
				.setParameter("idTipo_Usuario", "2").list();
		
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> AllUsuarios() {
		// TODO Auto-generated method stub
		
		return getSession().createQuery("FROM Usuario where idTipo_Usuario = :idTipo_Usuario")
				.setParameter("idTipo_Usuario", "3").list();
	}

	public Usuario findById(int id) {
		
		Usuario usuario = (Usuario) getSession().createQuery("FROM Usuario where idUsuario = :idUsuario")
				.setParameter("idUsuario", id).uniqueResult();
			
		return usuario;
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void SaveUsuario(Usuario usuario) {
		
		getSession().save(usuario);
		
	}

	public void UpdateUsuario(Usuario usuario) {
		
		getSession().update(usuario);
		
	}

	public void DeleteUsuario(Usuario usuario) {
		
		getSession().delete(usuario);
		
	}

}
