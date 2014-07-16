var licencaApp = angular.module('licencaApp', []);


licencaApp.controller('loginCtrl', function ($scope,  $http) {
    $scope.formLogin = {};
    $scope.formLogin.submit = function(item, event) {

        console.log("--> Submitting form");

        var responsePromise = $http.post("/login",
            {
                'login': $scope.formLogin.login,
                'senha': $scope.formLogin.senha
            });

        responsePromise.success(function(dataFromServer, status, headers, config) {
           window.location.href = '/';

        });

        responsePromise.error(function(data, status, headers, config) {
            alert("Login/Senha inválidos");
        });
    }

});

licencaApp.controller('geradorCtrl', function ($scope,  $http) {
    $scope.formGerar = {};
    $scope.mostraResultado = false;
    $scope.formGerar.submit = function(item, event) {

        console.log("--> Submitting form");

        var responsePromise = $http.post("/genserial", $scope.formGerar.hash, {headers: {'Content-Type': 'text/plain;charset=UTF-8'}});

        responsePromise.success(function(dataFromServer, status, headers, config) {
            $scope.licenca = dataFromServer;
            $scope.mostraResultado = true;
        });

        responsePromise.error(function(data, status, headers, config) {
            alert("Erro ao enviar, status " + status);
        });
    }

});

var mithApp = angular.module('MithITapp',[]);


mithApp.controller('visitanteGridCtrl', function ($scope, $http) {
    $http.get('/listaVisitante').success(function (data) {

        //$scope.animais = $.parseJSON(angular.fromJson(data));
        $scope.visitantes = angular.fromJson(data);
    });

    $scope.gridOptions = {data: 'visitantes',
        /*columnDefs: [
         {field: 'nome', displayName: 'Nome'},
         {field: 'especie', displayName: 'Especie'},
         {field: 'qtdPatas', displayName: 'Quantidade Patas',summary:true}],*/
        showGroupPanel: true

    };
});
