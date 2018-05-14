/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class InnerHTML {
    public String viewProjectsExt(String usuario) {
        String htmlcode = " <table class='table table-striped table-sm 'border=1><thead>"
                + "<tr><th>ID</th><th>Nombre del Proyecto</th><th>Lenguajes de Programación</th>"
                + "<th>GitHub</th><th>Administrador</th><th>Fecha de Inicio</th>"
                + "<th>Descripción</th><th colspan='2'>Acción</th></tr> "
                + "</thead><tbody>";
        Consultas consulta = new Consultas();
        for(Proyecto p : consulta.getAllProjects()) {
            htmlcode += "<tr><form action='ModificarProyecto' method='POST'>"
                    + "<td><input class='form-control-plaintext' type='text' value='"+p.getProjectId()+"' name='projectID' readonly></td>"
                    + "<td><input class='form-control' type='text' value='" + p.getNombreProyecto() + "' name='nombreProyecto'> </td>"
                    + "<td><input class='form-control' type='text' value='" + p.getLenguajeProyecto() + "' name='lenguajeProyecto'> </td>"
                    + "<td><input class='form-control' type='text' value='" + p.getGithub() + "' name='github'> </td>"
                    + "<td>" + p.getAdminProyecto() + "</td>"
                    + "<td>" + p.getFechaInicio() + "</td>"
                    + "<td><textarea  class='form-control' type='text' placeholder='" + p.getDescripcionProyecto() + "' value='" + p.getDescripcionProyecto() + "' name='descripcionProyecto'>" + p.getDescripcionProyecto() + "</textarea> </td>"
                    + "<td><button type='submit' value='Modificar'>Modificar</button></td>"
                    + "<td><button type='submit' formaction='BorrarProyecto' value='Eliminar'>Eliminar</button></td>"
                    + "</form></tr>";
        }
        htmlcode += "<tr'><form action='RegistrarProyecto' method='POST'>"
                + "<td><span>ID</span></td>"
                + "<td><input class='form-control' type='text' name='nombreProyecto'autocomplete='off' required></td>"
                + "<td><input class='form-control' type='text' name='lenguajeProyecto'autocomplete='off'></td>"
                + "<td><input class='form-control' type='text' name='github'autocomplete='off' required></td>"
                + "<td><input class='form-control-plaintext' type='text' style='text-align:center;' name='adminProyecto' value='" + usuario + "' readonly></td>"
                + "<td><span type='text' name='fechaInicio'>Fecha</span></td>"
                + "<td><textarea  class='form-control' type='text' name='descripcionProyecto'autocomplete='off'> </textarea></td>" 
                + "<td colspan='2'><button type='submit' value='Añadir'>Añadir</button></td>"
                + "</form></tr>"
                + "</tbody></table>";
        return htmlcode;
    }
    
    public String viewUsers() {
        String htmlcode = "<table class='table table-striped table-sm 'border=1><thead>"
                + "<tr><th>Nombre</th><th>Contraseña</th><th>Correo</th><th>Acción</th></tr>"
                + "</thead><tbody>";
        Consultas consulta = new Consultas();
        for(Usuario u : consulta.getAllUsers()) {
            htmlcode += "<tr><form action='BorrarUsuario' method='POST'>"
                    + "<td><input class='form-control-plaintext' type='text' value='" + u.getUserName() + "' name='userName' readonly> </td>"
                    + "<td><input class='form-control-plaintext' type='password' value='***************' name='userPassword' readonly> </td>"
                    + "<td><input class='form-control-plaintext' type='text' value='"+ u.getEmail() + "' name='email' readonly></td>"
                    + "<td><button type='submit' value='Eliminar'>Eliminar</button></td>"
                    + "</form></tr>";
        }
        htmlcode += "<tr>"
                + "<form action='RegistrarUsuario' method='POST'>"
                + "<td><input class='form-control' type='text' placeholder='Nombre' name='userName' autocomplete='off' required></td>"
                + "<td><input class='form-control' type='password' placeholder='Contraseña' name='userPassword' autocomplete='off' required></td>"
                + "<td><input class='form-control' type='text' placeholder='email' name='email' autocomplete='off' required></td>"
                + "<td><button type='submit' value='Añadir'>Añadir</button></td>"
                + "</form></tr>"
                + "</tbody></table>";
        return htmlcode;
    }
    
    public String viewProjects(String usuario) {
        String htmlcode = " <table class='table table-striped table-sm 'border=1><thead>"
                + "<tr><th>ID</th><th>Nombre del Proyecto</th><th>Lenguajes de Programación</th>"
                + "<th>GitHub</th><th>Administrador</th><th>Fecha de Inicio</th>"
                + "<th>Descripción</th><td colspan='2'>Acción</th></tr> "
                + "</thead><tbody>";
        Consultas consulta = new Consultas();
        for(Proyecto p : consulta.getAllProjects()){
            String admin = "";
            if(p.getAdminProyecto() == null || p.getAdminProyecto() == "" ){admin +="*Sin asignar*";} else{ admin = p.getAdminProyecto();};
            htmlcode += "<tr><form action='SuscribirseProyecto' method='POST'>"
                    + "<td><input class='form-control-plaintext' style='text-align:center;' type='text' value='"+p.getProjectId()+"' name='projectID' readonly></td>"
                    + "<td><span>"+p.getNombreProyecto()+"</span></td>"
                    + "<td><span>"+p.getLenguajeProyecto()+"</span></td>"
                    + "<td><span><a href=' " + p.getGithub() + "'>"+ p.getGithub() +"</a></span></td>"
                    + "<td><span>" + admin +"</span></td>"
                    + "<td><span>"+p.getFechaInicio()+"</span></td>"
                    + "<td><span>"+p.getDescripcionProyecto()+"</span></td>"
                    + "<td><button class='btn btn-sm btn-secondary' type='submit' value='" + usuario + "' name='userName'>Suscribirse</button></td>"
                    + "</form></tr>";
        }
        htmlcode += "</tbody></table>";
        return htmlcode;
    }
    public String getViewUsuarios(){
        String htmlcode = "<table class='table table-striped table-sm ' border=1><thead>"
                + "<tr><th>Miembros</th><th>Email</th></tr></thead><tbody>";
        Consultas consulta = new Consultas();
        for(Usuario p : consulta.getAllUsers()){
            String correo = "";
            if(p.getEmail() == null || p.getEmail()== ""){
                correo+= "-------";
            } else {
                correo = p.getEmail();
            }
            htmlcode += "<tr>\n" +
                    "<td>"+p.getUserName()+"</td>\n" +
                    "<td>"+correo+"</td>\n" +
                    "</tr>";
        }
        htmlcode += "</tbody></table>";
        return htmlcode;
    }
    
    
    
    
    public String viewSub(Integer projectID) {
        Proyecto proyectos;
        ArrayList<Usuario> usuarios;
        String nombreProyecto = "";
        String lenguaje = "";
        String github = "";
        String administrador = "";
        String descripcion = "";
        Date fecha = new Date(2018,05,11);
        
        Consultas consulta = new Consultas();
        String Tabla = "<div><h1 class='display-4 font-italic'>Miembros del Proyecto</h1><br><table class='table table-striped table-sm 'border=1><thead>"
                + "<tr><th>Miembros</th><th>Email</th></tr></thead><tbody>";
        for(Map.Entry<Proyecto, ArrayList<Usuario>> me : consulta.getProjectUsers(projectID).entrySet()){
            proyectos = me.getKey();
            usuarios = me.getValue();
            
            nombreProyecto = proyectos.getNombreProyecto();
            lenguaje = proyectos.getLenguajeProyecto();
            github = proyectos.getGithub();
            administrador = proyectos.getAdminProyecto();
            descripcion = proyectos.getDescripcionProyecto();
            fecha = proyectos.getFechaInicio();
            
            for(Usuario p : usuarios){
            String correo = "";
            if(p.getEmail() == null || p.getEmail()== ""){
                correo+= "-------";
            } else {
                correo = p.getEmail();
            }
            Tabla += "<tr>\n" +
                    "<td>"+p.getUserName()+"</td>\n" +
                    "<td>"+correo+"</td>\n" +
                    "</tr>";
            }
        }
        if(administrador == null) {
            administrador = "admin";
        }
        String htmlcode = "";
        String Cabecera = "<div>"
                + "<h1 class='display-4 font-italic'>" + nombreProyecto + "</h1><br>"
                + "<div>"
                + "<p class='display-6 font-italic'>Bienvenido al proyecto " + nombreProyecto + ",<br> el objetivo de este proyecto es realizar' " + descripcion + "' con " + lenguaje + ", "
                + "tenemos todo el código subido a este Github: <a href='" + github + "'>" + github + "</a>, si tienes cualquier duda el administrador es '" + administrador + "', "
                + "llevamos trabajando en el proyecto desde el "+ fecha + " pero aún queda mucho por desarrollar. "
                + "Nos encanta tener a un miembro más en el equipo y recuerda, el desarrollo de este software no esta remunerado de ninguna forma, es código abierto en su totalidad. "
                + "Aquí podras aportar tu granito de arena al proyecto con la ayuda de mucha más gente como tú y "
                + "podras usar el código de este o de cualquier otro proyecto para tu uso personal. "
                + "</div><br>¡Por un Mundo de Código Abierto!"
                + "</div><br>";
        Tabla += "</tbody></table></div>";
        
        htmlcode += Cabecera;
        htmlcode += Tabla;
        return htmlcode;
    }
    
    
    
    public String alert(String type) {
        String htmlcode = "";
        
        switch (type.toLowerCase()) {
            case "logincorrecto": 
                htmlcode+= "<div class='alert alert-success alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Login Correcto!</strong><br> Bienvenido al Estudio de Programación más grande del Mundo!"
                        + "</div>";
                break;
            case "loginerroneo": 
                htmlcode+= "<div class='alert alert-danger alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Login Incorrecto!</strong><br> Usuario o Contraseña incorrecta, intentalo de nuevo o registrate <a href='RegistroUsuario'>aquí.</a>"
                        + "</div>";
                break;
            case "modificandoproyecto": 
                htmlcode+= "<div class='alert alert-success alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Proyecto Modificado Correctamente</strong>"
                        + "</div>";
                break;
            case "añadiendoproyecto": 
                htmlcode+= "<div class='alert alert-success alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Nuevo Proyecto Añadido Correctamente</strong>"
                        + "</div>";
                break;
            case "añadiendousuario": 
                htmlcode+= "<div class='alert alert-success alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Nuevo Usuario Añadido Correctamente</strong><br> Bienvenido al Club"
                        + "</div>";
                break;
            case "errorañadiendousuario": 
                htmlcode+= "<div class='alert alert-warning alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Ups!</strong><br> Parece que alguien ya se ha registrado con ese 'Nombre'"
                        + "</div>";
                break;
            case "errorañadiendoproyecto": 
                htmlcode+= "<div class='alert alert-warning alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Ups!</strong><br> Parece que ya hay un Proyecto con ese 'Nombre' intentalo con otro"
                        + "</div>";
                break;
            case "administracion": 
                htmlcode+= "<div class='alert alert-info alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Panel de Administración</strong> <br>Gestiona Usuarios y Proyectos"
                        + "</div>";
                break;
            case "sesioncerrada": 
                htmlcode+= "<div class='alert alert-info alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Sesión Cerrada</strong> <br>Gracias por tu visita, esperamos volver a verte pronto."
                        + "</div>";
                break;
            case "borrandousuario": 
                htmlcode+= "<div class='alert alert-danger alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Usuario Eliminado</strong>"
                        + "</div>";
                break;
            case "borrandoproyecto": 
                htmlcode+= "<div class='alert alert-danger alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Proyecto Eliminado</strong>"
                        + "</div>";
                break;
            case "suscribirseproyecto": 
                htmlcode+= "<div class='alert alert-info alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Te has suscrito al Proyecto!</strong><br> Infórmate desde el link de Github y comparte tu codigo."
                        + "</div>";
                break;
            case "suscritoproyecto": 
                htmlcode+= "<div class='alert alert-info alert-dismissible fade show'>"
                        + "<a href='#' class='close' data-dismiss='alert' aria-label='close'>&times;</a>"
                        + "<strong>Ya estas suscrito a este Proyecto</strong><br>"
                        + "</div>";
                break;
            default:
                htmlcode+="";
                break;
        }
        return htmlcode;
    }
    
}
