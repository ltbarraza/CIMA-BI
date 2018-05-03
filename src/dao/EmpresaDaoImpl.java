package dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pojo.Empresa;

@Repository
@Transactional
public class EmpresaDaoImpl implements EmpresaDao  {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> allEmpresas() {

		return getSession().createQuery("FROM Empresa").list();
	}

	public Empresa findById(int id) {
		
		return  (Empresa) getSession().createQuery("FROM Empresa where idEmpresa = :idEmpresa")
				.setParameter("idEmpresa", id).uniqueResult();
	}

	public void saveEmpresa(Empresa empresa) {
		
		getSession().save(empresa);
	}

	public void updateEmpresa(Empresa empresa) {
		
		getSession().update(empresa);
		
	}

}
