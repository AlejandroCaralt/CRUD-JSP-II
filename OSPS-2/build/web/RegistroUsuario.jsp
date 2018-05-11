<%-- 
    Document   : RegistroUsuario
    Created on : 10-may-2018, 23:35:05
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrarme</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </head>
    <body class="text-center"><br>
        <h1 class="display-4 font-italic">Registro de Nuevo Usuario</h1><br>
        
        <form class="form-signin" action="RegistroNuevo" method="POST">
            <input placeholder="NombreUsuario" type="text" name="userName"><br>
            <input placeholder="Password" type="password" name="userPassword"><br>
            <input placeholder="Correo(Opcional)" type="text" name="email"><br>
            <br>
            <input class="btn btn-lg btn-primary btn-block" type="submit" value="Registrar">
        </form>
        <br>
        <p><button class="btn btn-lg btn-secondary"  onclick="history.go(-1)">Volver</button></p>
                <p class="mt-5 mb-3 text-muted">Alejandro Caralt Caralt © 2018-2019</p>
    </body>
</html>