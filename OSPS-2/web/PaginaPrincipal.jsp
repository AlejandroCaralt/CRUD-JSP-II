<%-- 
    Document   : PaginaPrincipal
    Created on : 10-may-2018, 23:56:56
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.InnerHTML"%>
<%
    HttpSession objsession = request.getSession(false);
    String usuario = (String)objsession.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Principal</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
    </head>
    <body class="text-center">
        <div>
            <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="menu.jsp"><% out.print(usuario); %></a>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="./index.jsp" >Cerrar Sesión</a>
                </li>
            </ul>
        </div>
        <div>
            <div style="top: 100px; position: relative;">
                <h1 class="display-4 font-italic">Tabla de Proyectos</h1><br>
                <%InnerHTML cp = new InnerHTML();%>
                <%= cp.viewProjects(usuario)%>
            </div>
        </div>
            <div style="top: 200px; position: relative; ">
                <h1 class="display-4 font-italic">Tabla de Usuarios Registrados</h1><br>
                <table class="table table-striped table-sm" border=1>
                    <thead>
                        <tr>
                            <th>NickName</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%= cp.getViewUsuarios()%>
                    </tbody>
                </table>
            </div>
    </body>
</html>
