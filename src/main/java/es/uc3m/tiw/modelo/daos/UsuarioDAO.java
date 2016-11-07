package es.uc3m.tiw.modelo.daos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.Usuario;


public interface UsuarioDAO {
	
	
	public Usuario actualizarUsuario(Usuario usuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	public void borrarUsuario(Usuario usuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	public Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;
	
	public abstract Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException;
	
	public Usuario recuperarUsuarioPorMail(String mail);
		
	public abstract Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException;
	
	public abstract Usuario recuperarUnUsuarioPorEmailAndPass (String email, String password) throws SQLException;

	public abstract Collection<Usuario> listarUsuarios() throws SQLException;

	void setTransaction(UserTransaction ut);

	void setConexion(EntityManager em);

	Collection<Usuario> buscarPorMail(String email) throws NoResultException;

	public Collection<Usuario> buscarTodosLosUsuarios();
}