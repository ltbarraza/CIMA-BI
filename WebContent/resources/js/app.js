var UsuarioModel = function() {

	var self = this;

	self.usuarios = ko.observableArray();
	self.empresas = ko.observableArray();
	self.tipoUsuarios = ko.observableArray();

	self.newUsuario = {
		idUsuario : ko.observable(),
		nombre : ko.observable(),
		apellido : ko.observable(),
		usuario : ko.observable(),
		clave : ko.observable(),
		correo : ko.observable(),
		cedula : ko.observable(),
		telefono : ko.observable(),
		activo : ko.observable(true),
		tipoUsuario : ko.observable(),
		usuarioEmpresa : ko.observableArray()
	}

	self.error = ko.observable();

	var usuariosUri = 'http://localhost:8081/CIMA-BI/usuarios/';
	var empresaUri = 'http://localhost:8081/CIMA-BI/empresas/';
	var tipoUsuario = 'http://localhost:8081/CIMA-BI/tipoUsuario/';
	var addusuario = 'http://localhost:8081/CIMA-BI/addusuario/';

	function ajaxHelper(uri, method, data) {
		self.error(''); // Clear error message
		return $.ajax({
			type : method,
			url : uri,
			dataType : 'json',
			contentType : 'application/json',
			data : data ? JSON.stringify(data) : null
		}).fail(function(jqXHR, textStatus, errorThrown) {
			self.error(errorThrown);
		});
	}

	function getTipoUsuario() {
		ajaxHelper(tipoUsuario + 3, 'GET').done(function(data) {
			self.tipoUsuarios(data);
		});
	}

	function getAllUsuarios() {
		ajaxHelper(usuariosUri, 'GET').done(function(data) {
			self.usuarios(data);
		});
	}

	function getAllEmpresa() {
		ajaxHelper(empresaUri, 'GET').done(function(data) {
			self.empresas(data);
		});
	}

	self.findUsuariobyId = function(item) {
		ajaxHelper(usuariosUri + item.idUsuario, 'GET').done(function(data) {

			self.newUsuario.idUsuario(data.idUsuario);
			self.newUsuario.nombre(data.nombre);
			self.newUsuario.apellido(data.apellido);
			self.newUsuario.usuario(data.usuario);
			self.newUsuario.clave(data.clave);
			self.newUsuario.correo(data.correo);
			self.newUsuario.cedula(data.cedula);
			self.newUsuario.telefono(data.telefono);
			self.newUsuario.activo(data.activo);
			self.empresas(data.usuarioEmpresas);
			self.newUsuario.usuarioEmpresa(data.usuarioEmpresas)
			

		});
	}

	self.addUsuario = function(formElement) {

		var usuario = {

			idUsuario : self.newUsuario.idUsuario(),
			nombre : self.newUsuario.nombre(),
			apellido : self.newUsuario.apellido(),
			usuario : self.newUsuario.usuario(),
			clave : self.newUsuario.clave(),
			correo : self.newUsuario.correo(),
			cedula : self.newUsuario.cedula(),
			telefono : self.newUsuario.telefono(),
			activo : self.newUsuario.activo(),
			tipoUsuario : self.newUsuario.tipoUsuario(),
			usuarioEmpresas : self.newUsuario.usuarioEmpresa()

		};

		ajaxHelper(addusuario, 'POST', usuario).done(function(item) {
			getAllUsuarios();
			self.newUsuario.idUsuario("");
			self.newUsuario.nombre("");
			self.newUsuario.apellido("");
			self.newUsuario.usuario("");
			self.newUsuario.clave("");
			self.newUsuario.correo("");
			self.newUsuario.cedula("");
			self.newUsuario.telefono("");
			usuarioEmpresa: self.newUsuario.usuarioEmpresa(false);
			self.newUsuario.activo(true);

		});

	}

	getAllUsuarios();
	getAllEmpresa();
	getTipoUsuario();

};

ko.applyBindings(new UsuarioModel()); // Activa Knockout
