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
	public String showIndex(Model model) {
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(3);
		
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("tipoUsuario", tipoUsuario);
		model.addAttribute("empresas", new Empresa());
		
		return "index";
	}
	
	@RequestMapping("/consultor")
	public String consultores(Model model) {
		
		TipoUsuario tipoUsuario = tipoUsuarioService.findById(2);
		
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("tipoUsuario", tipoUsuario);
		model.addAttribute("empresas", new Empresa());
		
		return "consultores";
	}
	
	@RequestMapping("/empresas")
	public String empresa(Model model){
		
		model.addAttribute("empresa", new Empresa());
		
		return "compañias";
	}
	
	

}
