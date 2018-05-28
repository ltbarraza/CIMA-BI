var ConsultorModel = function() {

	var self = this;

	self.consultores = ko.observableArray();
	self.empresas = ko.observableArray();
	self.tipoUsuarios = ko.observableArray();
	self.newConsultor = {
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
		usuarioEmpresas : ko.observableArray()
	}
	self.error = ko.observable();

	var consultorUri = 'http://localhost:8081/CIMA-BI/consultores/';
	var empresaUri = 'http://localhost:8081/CIMA-BI/empresas/';
	var tipoUsuario = 'http://localhost:8081/CIMA-BI/tipoUsuario/';

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

	function getAllConsultores() {
		ajaxHelper(consultorUri, 'GET').done(function(data) {
			self.consultores(data);
		});
	}
	
	function getAllEmpresa() {
        ajaxHelper(empresaUri, 'GET').done(function (data) {
            self.empresas(data);
        });
    }
	
	function getTipoUsuario() {
		ajaxHelper(tipoUsuario + 2, 'GET').done(function(data) {
			self.tipoUsuarios(data);
		});
	}
	
	self.findConsultorbyId = function (item) {
        ajaxHelper(consultorUri + item.idUsuario, 'GET').done(function (data) {

			self.newConsultor.idUsuario(data.idUsuario);
			self.newConsultor.nombre(data.nombre);
			self.newConsultor.apellido(data.apellido);
			self.newConsultor.usuario(data.usuario);
			self.newConsultor.clave(data.clave);
			self.newConsultor.correo(data.correo);
			self.newConsultor.cedula(data.cedula);
			self.newConsultor.telefono(data.telefono);
			self.newConsultor.activo(data.activo);

        });
    }

	self.addConsultor = function(formElement) {

		var usuario = {

			idUsuario : self.newConsultor.idUsuario(),
			nombre : self.newConsultor.nombre(),
			apellido : self.newConsultor.apellido(),
			usuario : self.newConsultor.usuario(),
			clave : self.newConsultor.clave(),
			correo : self.newConsultor.correo(),
			cedula : self.newConsultor.cedula(),
			telefono : self.newConsultor.telefono(),
			activo : self.newConsultor.activo(),
			tipoUsuario : self.newConsultor.tipoUsuario(),
			usuarioEmpresas : self.newConsultor.usuarioEmpresas()

		};

		ajaxHelper(addusuario, 'POST', usuario).done(function(item) {
			self.newConsultor.push(item);
			self.newConsultor.idUsuario("");
			self.newConsultor.nombre("");
			self.newConsultor.apellido("");
			self.newConsultor.usuario("");
			self.newConsultor.clave("");
			self.newConsultor.correo("");
			self.newConsultor.cedula("");
			self.newConsultor.telefono("");
			usuarioEmpresas : self.newConsultor.usuarioEmpresas(false)
			self.newConsultor.activo(true);

		});

	}


	getAllConsultores();
	getAllEmpresa();
	getTipoUsuario();
};

ko.applyBindings(new ConsultorModel()); // Activa Knockout
