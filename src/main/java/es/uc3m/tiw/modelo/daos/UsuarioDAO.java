package es.uc3m.tiw.modelo.daos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import es.uc3m.tiw.modelo.Usuario;


public interface UsuarioDAO {
	
	public abstract Usuario actualizarUsuario(Usuario usuario) throws SQLException;

	public abstract void borrarUsuario(Usuario usuario) throws SQLException;

	public abstract Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException;

	public abstract Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException;

	public abstract Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException;

	public abstract Collection<Usuario> listarUsuarios() throws SQLException;

	public abstract void setConexion(Connection con);

	public abstract void setQuerys(ResourceBundle rb);
}