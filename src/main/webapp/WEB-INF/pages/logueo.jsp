<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>demo</title>
</head>
<body ng-app="myApp">
    <div ng-controller="registroController as vm">
        <form>
            <p>
                <label>NickName</label>
                <input type="nombre" ng-model="vm.nombre" />
            </p>
            <p>
                <label>Nuevo Password</label>
                <input type="password" ng-model="vm.password" />
            </p>
            <p>
                <label>Repite Password</label>
                <input type="password" ng-model="vm.repeatPassword" />
            </p>
            <input type="button" value="registrarse"
                    ng-click="vm.registrar()"/>
        </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.9/angular.min.js"></script>
    <script src="resources/js/base.js"></script>
</body>
</html>