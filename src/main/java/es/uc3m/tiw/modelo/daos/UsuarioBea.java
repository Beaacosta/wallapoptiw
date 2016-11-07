package es.uc3m.tiw.modelo.daos;
import java.sql.*;
import java.util.ArrayList;

import es.uc3m.tiw.modelo.Usuario;

public class UsuarioBea {
	private Connection conn;
	private Statement state;
	
	public void conexion(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url);
			state=conn.createStatement();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean anyadir_usuario(Usuario usuario){
		boolean encontrado=false;
		try{
			conexion();
			/*Falta id*/
			int i=state.executeUpdate("INSERT INTO USUARIO VALUES ('"+usuario.getNombre()+"','"+usuario.getApellidos()+"','"+usuario.getPassword()+"','"+usuario.getMail()+"','"+usuario.getCiudad()+"')");
			if (i>0){
				encontrado=true;
			}
		}	
		catch (Exception e){
			e.getStackTrace();
		}
		return encontrado;
	}
	
	public boolean eliminar_usuario(String id){
		boolean encontrado=false;
		try{
			conexion();
			/*Falta id*/
			int i=state.executeUpdate("DELETE FROM USUARIO WHERE id='"+id+"'");
			if (i>0){
				encontrado=true;
			}
		}	
		catch (Exception e){
			e.getStackTrace();
		}
		return encontrado;
	}


	public boolean actualizar_usuario(Usuario usuario){
		boolean encontrado=false;
		try{
			conexion();
			/*Falta id*/
			int i=state.executeUpdate("UPDATE USUARIO SET nombre='"+usuario.getNombre()+"'WHERE id="+usuario.getId()+"");
			if (i>0){
				encontrado=true;
			}
		}	
		catch (Exception e){
			e.getStackTrace();
		}
		return encontrado;
		
	}
	
	public ArrayList<Usuario> buscar(int id) throws Exception{
		conexion();
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		ResultSet rs=state.executeQuery("SELECT * FROM USUARIO WHERE id="+id+"");
		while(rs.next()){
			Usuario usuario=new Usuario();
			usuario.setNombre((String)rs.getObject(2));
			/*Rellenar todos*/
			usuarios.add(usuario);
		}
		return usuarios;
	}

}