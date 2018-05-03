package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pojo.Empresa;
import pojo.Usuario;
import pojo.UsuarioEmpresa;
import service.UsuarioEmpresaService;
import service.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	UsuarioEmpresaService usuarioEmpresaService;
	

	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllUsuarios() {

		List<Usuario> usuarios = usuarioService.AllUsuarios();

		if (usuarios.isEmpty()) {

			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/consultores", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> getAllConsultores() {

		List<Usuario> usuarios = usuarioService.AllConsultores();

		if (usuarios.isEmpty()) {

			return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") int id) {
		
		Usuario usuario = usuarioService.findById(id);

		if (usuario == null) {

			return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	/* la anotación @RequestBody asigna el cuerpo HttpRequest a un objeto de transferencia u objeto de dominio, lo que permite la deserialización 
	 * automática del cuerpo HttpRequest entrante en un objeto Java.*/

	@RequestMapping(value = "/addusuario", method = RequestMethod.POST)
	public ResponseEntity<?> add(@RequestBody  Usuario usuario) {
		
		usuarioService.SaveUsuario(usuario);
		
		UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
		
		for (  Empresa idEmpresas: usuario.getEmpresas()) {
			
			 usuarioEmpresa.setIdEmpresa(idEmpresas.getIdEmpresa());
			 usuarioEmpresa.setIdUsuario(usuario.getIdUsuario());
		}
		
		@SuppressWarnings("unchecked")
		List<UsuarioEmpresa> usuarioEmpresas = (List<UsuarioEmpresa>) usuarioEmpresa;
		
		usuarioEmpresaService.SaveUsuarioEmpresa(usuarioEmpresas);
			
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		
		usuarioService.DeleteUsuario(usuarioService.findById(id));

		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.NO_CONTENT);
	}

}
