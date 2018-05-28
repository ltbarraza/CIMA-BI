var EmpresaModel = function() {

	var self = this;

	self.empresas = ko.observableArray();
	self.error = ko.observable();
	self.newEmpresa = {
		idEmpresa : ko.observable(),
		nombre : ko.observable(),
		activa : ko.observable(),
		asignada : ko.observable(),

	}

	var empresaUri = 'http://localhost:8081/CIMA-BI/empresas'

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

	function getAllEmpresa() {
		ajaxHelper(empresaUri, 'GET').done(function(data) {
			self.empresas(data);
		});
	}

	self.addEmpresa = function(formElement) {

		var usuario = {

			idEmpresa : self.newEmpresa.idEmpresa(),
			nombre : self.newEmpresa.nombre(),
			activa : self.newEmpresa.activa(),
			asignada : self.newEmpresa.asignada()

		};

		ajaxHelper(addusuario, 'POST', usuario).done(function(item) {
			
			self.newEmpresa.idEmpresa("");
		    self.newEmpresa.nombre("");
			self.newEmpresa.activa(false);
			self.newEmpresa.asignada(false)

		});

	}

	getAllEmpresa();

};

ko.applyBindings(new EmpresaModel()); // Activa Knockout
