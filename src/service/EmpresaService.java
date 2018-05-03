package service;

import java.util.List;

import pojo.Empresa;

public interface EmpresaService {
	
	
	public List<Empresa> allEmpresas(); 
	public Empresa findById(int id);
	public void saveEmpresa(Empresa empresa);
	
}
