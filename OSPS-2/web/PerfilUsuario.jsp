<%-- 
    Document   : PerfilUsuario
    Created on : 12-may-2018, 17:15:01
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
        <title>OSPStudio</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <link rel="icon" href="https://use.fontawesome.com/releases/v5.0.13/svgs/brands/osi.svg" type="image/x-icon"/>
        <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
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
        </div>
    </body>
</html>
