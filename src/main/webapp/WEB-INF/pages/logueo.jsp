<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>demo</title>
</head>
<body>
    <div id="logueo">
        <h1>Logueo</h1>
        <fieldset>
            <form>
                <label>Usuario</label>
                <input type="text" value="" />
                <label>Password</label>
                <input type="password" />
                <input type="button" value="Iniciar sesion" />
            </form>
            <a href="/registro">Cambiar pass</a>
        </fieldset>
    </div>
</body>
</html>