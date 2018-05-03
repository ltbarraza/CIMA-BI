package dao;

import java.util.List;

import pojo.Empresa;

public interface EmpresaDao {
	
	public List<Empresa> allEmpresas(); 
	public Empresa findById(int id);
	public void saveEmpresa(Empresa empresa);
	public void updateEmpresa(Empresa empresa);
}
