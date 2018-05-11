/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
                    + "<td><input type='text' value='"+p.getProjectId()+"' name='projectID' readonly></td>"
                    + "<td><input type='text' value='" + p.getNombreProyecto() + "' name='nombreProyecto'> </td>"
                    + "<td><input type='text' value='" + p.getLenguajeProyecto() + "' name='lenguajeProyecto'> </td>"
                    + "<td><input type='text' value='" + p.getGithub() + "' name='github'> </td>"
                    + "<td>" + p.getAdminProyecto() + "</td>"
                    + "<td>" + p.getFechaInicio() + "</td>"
                    + "<td><input type='text' value='" + p.getDescripcionProyecto() + "' name='descripcionProyecto'> </td>"
                    + "<td><button type='submit' value='Modificar'>Modificar</button></td>"
                    + "<td><button type='submit' formaction='BorrarProyecto' value='Eliminar'>Eliminar</button></td>"
                    + "</form></tr>";
        }
        htmlcode += "<tr><form action='RegistrarProyecto' method='POST'>"
                + "<td><span>ID</span></td>"
                + "<td><input type='text' name='nombreProyecto'autocomplete='off'></td>"
                + "<td><input type='text' name='lenguajeProyecto'autocomplete='off'></td>"
                + "<td><input type='text' name='github'autocomplete='off'></td>"
                + "<td><input type='text' name='adminProyecto' value='" + usuario + "' readonly></td>"
                + "<td><span type='text' name='fechaInicio'>Fecha</span></td>"
                + "<td><input type='text' name='descripcionProyecto'autocomplete='off'></td>" 
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
                    + "<td><input type='text' value='" + u.getUserName() + "' name='userName' readonly> </td>"
                    + "<td><input type='password' value='" + u.getUserPassword() + "' name='userPassword' readonly> </td>"
                    + "<td><input type='text' value='"+ u.getEmail() + "' name='email' readonly></td>"
                    + "<td><button type='submit' value='Eliminar'>Eliminar</button></td>"
                    + "</form></tr>";
        }
        htmlcode += "<tr>"
                + "<form action='RegistrarUsuario' method='POST'>"
                + "<td><input type='text' placeholder='Nombre' name='userName' autocomplete='off'></td>"
                + "<td><input type='password' placeholder='Contraseña' name='userPassword' autocomplete='off'></td>"
                + "<td><input type='text' placeholder='email' name='email' autocomplete='off'></td>"
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
                    + "<td><input style='border:none; background-color:initial;' type='text' value='"+p.getProjectId()+"' name='projectID' readonly></td>"
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
        String htmlcode = "";
        Consultas consulta = new Consultas();
        for(Usuario p : consulta.getAllUsers()){
            String correo = "";
            if(p.getEmail() == null || p.getEmail()== ""){
                correo+= "-------";
            } else {
                correo = p.getEmail();
            }
            htmlcode += "<tr>\n" +
"                    <td>"+p.getUserName()+"</td>\n" +
"                    <td>"+correo+"</td>\n" +
"                </tr>";
        }
        return htmlcode;
    }
    
    
    
    
    public String viewSubs(Integer projectID){
        String htmlcode = "<table class='table table-striped table-sm '><thead>"
                + "<tr><th>Miembros</th></tr></thead><tbody>";
        Consultas consulta = new Consultas();
        Iterator iterator = consulta.getProjectUsers(projectID).entrySet().iterator();
        while (iterator.hasNext()) {
          Map.Entry me = (Map.Entry) iterator.next();
          htmlcode += "<tr><td>" + me.getValue() + "</td></tr>";
        } 
        htmlcode += "</body></table>";
        return htmlcode;
    }
    public String viewSub(Integer projectID) {
        String htmlcode = "<table class='table table-striped table-sm '><thead>"
                + "<tr><td>Miembros</td></tr></thead><tbody>";
        Consultas consulta = new Consultas();
        for(Usuario p : consulta.getProjectUser(projectID)){
            htmlcode += "<tr><td>" + p.getUserName() + "</td></tr>";
        }
        htmlcode += "</tbody></table>";
        return htmlcode;
    }
    
    
    
}
