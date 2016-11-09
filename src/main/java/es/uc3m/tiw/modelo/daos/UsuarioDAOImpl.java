package es.uc3m.tiw.modelo.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.Usuario;


public class UsuarioDAOImpl implements UsuarioDAO {

	private EntityManager em;
	private UserTransaction ut;

	public UsuarioDAOImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Collection<Usuario> listarUsuarios() throws SQLException{
		
		return em.createQuery("select u from Usuario u", Usuario.class).getResultList();

		/*Statement st = con.createStatement();
		ResultSet resultados = st.executeQuery(rb.getString("seleccionarTodosUsuarios"));

		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario;
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));
			listaUsuarios.add(usuario);
		}
		return listaUsuarios;*/
	}
	@Override
	public Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException{

		return em.find(Usuario.class, pk);
		
		/*PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarUsuarioPK"));
		ps.setInt(1, pk);
		Usuario usuario = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));

		}
		return usuario;*/
	}
	@Override
	/**
	 * Se asume que el campo nombre es unique y por tanto solo recuperará un usuario en caso de existir
	 */
	public Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException{

		 return em.createQuery("select u from Usuario u where u.nombre="+nombre, Usuario.class).getSingleResult();

		
		/*PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarUsuarioNombre"));
		ps.setString(1, nombre);
		Usuario usuario = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));

		}
		return usuario;*/
	}
	
	
	public Collection<Usuario> buscarPorEmail(String mail)throws NoResultException{
		return em.createQuery("select u from Usuario u where u.mail='"+mail+"'", Usuario.class).getResultList();
	}
	
	
	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{

		ut.begin();
		em.persist(nuevoUsuario);
		ut.commit();
		return nuevoUsuario;
		
		/*PreparedStatement ps = con.prepareStatement(rb.getString("crearUsuario"));
		ps.setString(1, nuevoUsuario.getMail());
		ps.setString(2, nuevoUsuario.getPassword());
		ps.setString(3, nuevoUsuario.getNombre());
		ps.setString(4, nuevoUsuario.getApellidos());
		ps.setString(5, nuevoUsuario.getCiudad());
		ps.execute();

		return recuperarUnUsuarioPorNombre(nuevoUsuario.getNombre());*/
		
		
	}
	@Override
	public void borrarUsuario(Usuario usuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{

		ut.begin();
		em.remove(em.merge(usuario));
		ut.commit();
		
		/*PreparedStatement ps = con.prepareStatement(rb.getString("borrarUsuario"));
		ps.setInt(1, usuario.getId());
		ps.execute();*/

	}
	@Override
	public Usuario actualizarUsuario(Usuario usuario) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{

		ut.begin();
		em.merge(usuario);
		ut.commit();
		return usuario;
		
		/*PreparedStatement ps = con.prepareStatement(rb.getString("actualizarUsuario"));
		ps.setString(1, usuario.getNombre());
		ps.setString(2, usuario.getPassword());
		ps.setInt(3, usuario.getId());
		ps.execute();
		return recuperarUnUsuarioPorClave(usuario.getId());*/

	}
	@Override
	public void setConexion(EntityManager em) {

		this.em = em;

	}
	@Override
	public void setTransaction(UserTransaction ut) {

		this.ut = ut;

	}

	@Override
	public Usuario recuperarUnUsuarioPorEmailAndPass (String mail, String password) throws SQLException {
		return em.createQuery("select u from Usuario u where u.mail='"+mail+"' and u.password='"+password+"'",Usuario.class).getSingleResult();
	}

	@Override
	public Collection<Usuario> buscarPorMail(String mail) throws NoResultException {
		// TODO Auto-generated method stub
		return em.createQuery("select u from Usuario u where u.mail='"+mail+"'", Usuario.class).getResultList();
	}
	
	public Usuario recuperarUsuarioPorMail(String mail) {
		 return em.createQuery("select u from Usuario u where u.mail="+mail, Usuario.class).getSingleResult();
	}

	public Collection<Usuario> buscarTodosLosUsuarios(){
		return em.createQuery("select u from Usuario u",Usuario.class).getResultList();
	}
	
	
	public List<Usuario> recuperarUsuarioPorMailLista(String mail) {
		return em.createQuery("select u from Usuario u where u.mail='"+mail+"'", Usuario.class).getResultList();
	}
	

}