/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Consultas extends Conexion{
    
    /**
     * Realiza una consulta a la BBDD
     * Comprueba la existencia del usuario y contraseña introducidos en la BBDD
     * @param usuario
     * @param contraseña
     * @return boolean Conexion
     */
    public boolean auttenticacion (String usuario, String contraseña){
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try{
            String consulta = "SELECT * FROM login WHERE userName = ? AND userPassword = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
            
        } catch(Exception e){
            System.err.println("Error" + e);
        } finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
                if(rs != null) rs.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
        return false;
    }
    
    /**
     * Realiza una consulta a la BBDD
     * Devuelve un arrayList del objeto Proyecto
     * @return Arraylist of all projects
     */
    public ArrayList<Proyecto> getAllProjects() {
        ArrayList<Proyecto> proyectos = new ArrayList<Proyecto>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT * FROM project";
            pst = getConexion().prepareCall(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                proyectos.add(new Proyecto(rs.getInt("projectId"),
                rs.getString("nombreProyecto"),
                rs.getString("lenguajeProyecto"),
                rs.getString("github"),
                rs.getString("adminProyecto"),
                rs.getDate("fechaInicio"),
                rs.getString("descripcionProyecto")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }

        return proyectos;
    }
    
    /**
     * Realiza una consulta a la BBDD
     * Devuelve un arrayList del objeto Usuario
     * @return ArrayList of all users
     */
    public ArrayList<Usuario> getAllUsers() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String consulta = "SELECT userName,email FROM login";
            pst = getConexion().prepareCall(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuarios.add(new Usuario(rs.getString("UserName"),
                rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }

        return usuarios;
    }
    
    /**
     * Realiza una consulta a la BBDD
     * Devuelve un hashMap con los nombres de usuarios dentro del proyecto especificado
     * con un índice de autoincremental
     * @param projectID
     * @return HashMap of all Users in the project
     */
    public HashMap<Proyecto, ArrayList<Usuario>> getProjectUsers(Integer projectID) {
        HashMap<Proyecto, ArrayList<Usuario>> usuariosProyecto = new HashMap<Proyecto, ArrayList<Usuario>>();
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        Proyecto proyectos = new Proyecto();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta ="SELECT P.projectID, P.nombreProyecto,P.lenguajeProyecto, P.github, P.adminProyecto, P.fechaInicio, P.descripcionProyecto, L.userName, L.email "
                    + "FROM project P left join activeproject AP on P.projectID=AP.projectID inner join login L on AP.userName=L.userName  group by projectID, userName HAVING projectID = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, projectID);
            rs = pst.executeQuery();
            while(rs.next()) {
                proyectos.setProjectId(rs.getInt("projectID"));
                proyectos.setNombreProyecto(rs.getString("nombreProyecto"));
                proyectos.setLenguajeProyecto(rs.getString("lenguajeProyecto"));
                proyectos.setGithub(rs.getString("github"));
                proyectos.setAdminProyecto(rs.getString("adminProyecto"));
                proyectos.setFechaInicio(rs.getDate("fechaInicio"));
                proyectos.setDescripcionProyecto(rs.getString("descripcionProyecto"));
                usuarios.add(new Usuario(rs.getString("UserName"),
                rs.getString("email")));
            }
            usuariosProyecto.put(proyectos, usuarios);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
        
        return usuariosProyecto;
    }
    public ArrayList<Usuario> getProjectUser(Integer projectID) {
        ArrayList<Usuario> usuariosProyecto = new ArrayList<Usuario>();
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            String consulta ="SELECT userName FROM activeproject  WHERE projectID = ?";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, projectID);
            while(rs.next()) {
                usuariosProyecto.add(new Usuario(rs.getString("UserName")));
            }  
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
        
        return usuariosProyecto;
    }
    
    /**
     * Realiza una consulta a la BBDD
     * Añade un usuario a la tabla 'activeproject'
     * @param projectID
     * @param userName
     * @return boolean User suscribed to a project
     */
    public boolean suscribeUser(Integer projectID, String userName){
      
        PreparedStatement pst = null;
      
        try{
             String consulta ="INSERT INTO activeproject (projectID, userName) VALUES (?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, projectID);
            pst.setString(2, userName);
          
            if(pst.executeUpdate() == 1){ 
              return true;
            }
        } catch(Exception e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    return false;
    }
    
    
    /**
     * Registra un nuevo usuario a la BBDD
     * @param nombre
     * @param contraseña
     * @param email
     * @return boolean Registro Usuario
     */
    public boolean registerUser(String nombre, String contraseña, String email){
      
        PreparedStatement pst = null;
      
        try{
             String consulta ="INSERT INTO login (userName, userPassword, email) VALUES (?,?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, contraseña);
            pst.setString(3, email);
          
            if(pst.executeUpdate() == 1){ 
              return true;
            }
        } catch(Exception e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    return false;
    }
    
    /**
     * Registra un nuevo Proyecto a la BBDD
     * @param nombre
     * @param lenguaje
     * @param github
     * @param descripcion
     * @return boolean Registro Proyecto
     */
    public boolean registerProject(String nombre, String lenguaje, String github,String admin, String descripcion){
      
        PreparedStatement pst = null;
      
        try{
             String consulta ="INSERT INTO project (nombreProyecto,lenguajeProyecto,github,adminProyecto,descripcionProyecto ) VALUES (?,?,?,?,?) ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
            pst.setString(2, lenguaje);
            pst.setString(3, github);
            pst.setString(4, admin);
            pst.setString(5, descripcion);
          
            if(pst.executeUpdate() == 1){
              return true;
            }
        } catch(Exception e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    return false;
    }
    
    
    
    /**
     * Realiza una consulta a la BBDD
     * Modifica los valores del proyecto
     * @param codigo
     * @param nombre
     * @param lenguaje
     * @param github
     * @param descripcion
     * @return boolean updated Project
     */
    public boolean updateProject(Integer codigo,String nombre, String lenguaje, String github, String descripcion){
        PreparedStatement pst = null; 
        try {
            String consulta = "UPDATE project SET nombreProyecto=?,lenguajeProyecto=?,github=?,descripcionProyecto=?  WHERE projectId=?";
            pst = getConexion().prepareStatement(consulta);
                pst.setString(1, nombre);
                pst.setString(2, lenguaje);
                pst.setString(3,github);
                pst.setString(4,descripcion);
                pst.setInt(5, codigo);
                pst.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    return false;
    }
    
    /**
     * 
     * @param codigo
     * @param nombre
     * @param lenguaje
     * @param github
     * @param descripcion
     * @return boolean User Updated
     */
    public boolean updateUser(String userName, String password, String email){
        PreparedStatement pst = null; 
        try {
            String consulta = "UPDATE login SET userPassword=?,email=?  WHERE userName=?";
            pst = getConexion().prepareStatement(consulta);
                pst.setString(1, password);
                pst.setString(2, email);
                pst.setString(3, userName);
                pst.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    return false;
    }
    
    /**
     * Borra un proyecto de la BBDD
     * @param codigo
     * @return boolean Project Deleted
     */
    public boolean deleteProject(int codigo) {
         
        PreparedStatement pst = null;
      
        try{
             String consulta ="DELETE FROM project WHERE projectId=? ";
            pst = getConexion().prepareStatement(consulta);
            pst.setInt(1, codigo);
          
            if(pst.executeUpdate() == 1){
              return true;
            }
        } catch(Exception e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
    return false;
    }
    
    /**
     * Borra un Usuario de la BBDD
     * @param nombre
     * @return boolean User Deleted
     */
    public boolean deleteUser(String nombre) {
         
        PreparedStatement pst = null;
      
        try{
             String consulta ="DELETE FROM login WHERE userName=? ";
            pst = getConexion().prepareStatement(consulta);
            pst.setString(1, nombre);
          
            if(pst.executeUpdate() == 1){
              return true;
            }
        } catch(Exception e){
            System.err.println("Error" + e);
        }finally{
            try{
                if(getConexion() != null) getConexion().close();
                if(pst != null) pst.close();
            } catch(Exception e){
                System.err.println("Error" + e);
            }
        }
        return false;
    }
}
