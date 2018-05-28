package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Empresa;
import pojo.TipoUsuario;
import pojo.Usuario;
import service.EmpresaService;
import service.TipoUsuarioService;

@Controller
public class IndexController {
	
	@Autowired
	TipoUsuarioService tipoUsuarioService;
	
	@Autowired
	EmpresaService empresaservice;
	
	@RequestMapping("/")
	public String showIndex() {
		
		return "index";
	}
	
	@RequestMapping("/consultor")
	public String consultores() {
		

		return "consultores";
	}
	
	@RequestMapping("/compañias")
	public String empresa(){
		
		return "compañias";
	}
	
	@RequestMapping("/prueba")
	public String usuarios(){
		
		return "prueba";
	}

}
