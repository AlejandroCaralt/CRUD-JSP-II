<%-- 
    Document   : Proyecto
    Created on : 10-may-2018, 23:57:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Controlador.InnerHTML"%>
<%
    HttpSession objsession = request.getSession();
    String usuario = (String)objsession.getAttribute("usuario");
    Integer id = (Integer)objsession.getAttribute("id");
    String type = (String)objsession.getAttribute("alert");
    InnerHTML cp = new InnerHTML();

    if(usuario.equals("sesionCaducada")){
        response.sendRedirect("./CerrarSesion");
    }
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
        <div>
            <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="PaginaPrincipal.jsp">
                <img  width="20" src="https://use.fontawesome.com/releases/v5.0.13/svgs/solid/arrow-alt-circle-left.svg"> 
                    <span>
                        <% out.print(usuario); %>
                    </span>
            </a>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="./CerrarSesion" >Cerrar Sesión</a>
                </li>
            </ul>
        </div>
        <div>
            <%= cp.alert(type) %>
            <% objsession.setAttribute("alert", ""); %>
        </div>
        <div class="container center-text"
            <div>
                
                <div>
                   <%= cp.viewSub(id)%> 
                </div>
            </div>
            <br>
            <div>
                <div class="mt-5 mb-3 text-muted">
                    Alejandro Caralt Caralt © 2018-2019
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        window.setTimeout(function () {
            $(".alert").fadeTo(500,0).slideUp(500, function () {
                $(this).remove();
            });
        }, 4000);
    </script>
</html>
