<%-- 
    Document   : index
    Created on : 10-may-2018, 23:14:13
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.InnerHTML"%>
<%
    HttpSession objsession = request.getSession();
    String type = (String)objsession.getAttribute("alert");
    InnerHTML cp = new InnerHTML();
    if(type == null){
        type = "";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OSPStudio</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <link rel="icon" href="https://use.fontawesome.com/releases/v5.0.13/svgs/brands/osi.svg" type="image/x-icon"/>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
    </head>
    <body class="text-center">
        <br><br><br><br>
        <h1 class="display-4 font-italic">Open Source Programming Studio</h1><br><br>
        <div>
            <%= cp.alert(type) %>
            <% objsession.setAttribute("alert", ""); %>
        </div><br><br><br>
        <form class="form-signin" action="InicioSesion" method="POST">
            <label for="user" class="sr-only">Nombre</label>
            <input id="user" class="form-label-group" placeholder="admin" type="text" name="userName" required><br>
            <label for="passw" class="sr-only">Contraseña</label>
            <input id="passw" class="form-label-group" placeholder="1234" type="password" name="userPassword" required><br><br><br>
            <div class="boton">
                <button class="btn btn-lg btn-primary btn-block" type="submit">Iniciar Sesión</button>
            </div>
            <div class="checkbox mb-3"><br>
        <label>
            <input type="checkbox" value="remember-me" checked="checked"> Recuérdame.
        </label>
      </div>
        </form>
        <br>
        <div>¿Nó tienes cuenta aún?<a href="RegistroUsuario.jsp">Registrate aquí</a></div>
        <div ><p class="mt-5 mb-3 text-muted">Alejandro Caralt Caralt © 2018-2019</p></div>
    </body>
    <script type="text/javascript">
        window.setTimeout(function () {
            $(".alert").fadeTo(500,0).slideUp(500, function () {
                $(this).remove();
            });
        }, 4000);
    </script>
</html>

