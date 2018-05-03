package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpresaDao;
import pojo.Empresa;

@Service
public class EmpresaServiceImpl implements EmpresaService  {

	@Autowired
	EmpresaDao empresaDao;

	public List<Empresa> allEmpresas() {

		return empresaDao.allEmpresas();
	}

	public Empresa findById(int id) {

		return empresaDao.findById(id);
	}

	public void saveEmpresa(Empresa empresa) {

		if (empresa.getIdEmpresa() > 0) {

			empresaDao.updateEmpresa(empresa);

		}else{
			
			empresaDao.saveEmpresa(empresa);
		}


	}

}
