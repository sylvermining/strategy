/*angular.module('myApp',[])
.controller('registroController', function($scope){
        $scope.name = 'dolorierp';

});*/
angular.module('myApp',[])
    .controller('registroController', function(){
        var scope = this;
        scope.registrar = function() {
            console.info("nombre :: " + scope.nombre);
            console.info("password :: " + scope.password);
            console.info("repeatPassword :: " + scope.repeatPassword);
        }
});
