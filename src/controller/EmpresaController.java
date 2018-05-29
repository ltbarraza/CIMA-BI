package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pojo.Empresa;
import service.EmpresaService;

@Controller
public class EmpresaController {
	
	@Autowired
	EmpresaService empresaservice;
	
	@RequestMapping(value = "/empresas", method = RequestMethod.GET)
	public ResponseEntity<List<Empresa>> getAllEmpresa() {

		List<Empresa> empresas = empresaservice.allEmpresas();

		if (empresas.isEmpty()) {

			return new ResponseEntity<List<Empresa>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/empresas/{id}", method = RequestMethod.GET)
	public ResponseEntity<Empresa> getUsuario(@PathVariable("id") int id){
		
		Empresa empresa = empresaservice.findById(id);
		
		if(empresa == null){
			
			return new ResponseEntity<Empresa>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/addempresa", method = RequestMethod.POST)
	public ResponseEntity<Empresa> add(@RequestBody Empresa empresa) {
		
		empresaservice.saveEmpresa(empresa);
		
		return new ResponseEntity<Empresa>(empresa, HttpStatus.CREATED);
	}
	
	
}
