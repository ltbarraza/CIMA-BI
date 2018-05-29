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

	var empresaUri = 'http://localhost:8081/CIMA-BI/empresas/'
	var addempresa = 'http://localhost:8081/CIMA-BI/addempresa/'

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
	
	
	self.findEmpresaId = function (item) {
        ajaxHelper(empresaUri + item.idEmpresa, 'GET').done(function (data) {

			self.newEmpresa.idEmpresa(data.idEmpresa);
			self.newEmpresa.nombre(data.nombre);
			self.newEmpresa.activa(data.activa);
			self.newEmpresa.asignada(data.asignada);

        });
    }


	self.addEmpresa = function(formElement) {

		var empresa = {

			idEmpresa : self.newEmpresa.idEmpresa(),
			nombre : self.newEmpresa.nombre(),
			activa : self.newEmpresa.activa(),
			asignada : self.newEmpresa.asignada()

		};

		ajaxHelper(addempresa, 'POST', empresa).done(function(item) {
			getAllEmpresa();
			self.newEmpresa.idEmpresa("");
		    self.newEmpresa.nombre("");
			self.newEmpresa.activa(false);
			self.newEmpresa.asignada(false)

		});

	}

	getAllEmpresa();

};

ko.applyBindings(new EmpresaModel()); // Activa Knockout
