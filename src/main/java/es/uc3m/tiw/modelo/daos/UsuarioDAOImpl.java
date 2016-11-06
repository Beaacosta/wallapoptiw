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
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.Usuario;


public class UsuarioDAOImpl implements UsuarioDAO {

	private Connection con;
	private ResourceBundle rb;
	private EntityManager em;
	private UserTransaction ut;

	public UsuarioDAOImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	@Override
	public Collection<Usuario> listarUsuarios() throws SQLException{

		Statement st = con.createStatement();
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
		return listaUsuarios;
	}
	@Override
	public Usuario recuperarUnUsuarioPorClave(int pk) throws SQLException{

		PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarUsuarioPK"));
		ps.setInt(1, pk);
		Usuario usuario = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));

		}
		return usuario;
	}
	@Override
	/**
	 * Se asume que el campo nombre es unique y por tanto solo recuperará un usuario en caso de existir
	 */
	public Usuario recuperarUnUsuarioPorNombre(String nombre) throws SQLException{

		PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarUsuarioNombre"));
		ps.setString(1, nombre);
		Usuario usuario = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			usuario = new Usuario();
			usuario.setId(resultados.getInt("id"));
			usuario.setNombre(resultados.getString("nombre"));
			usuario.setPassword(resultados.getString("password"));

		}
		return usuario;
	}
	
	
	public Collection<Usuario> recuperarUnUsuarioPorMail(String email)throws NoResultException{
		return em.createQuery("select u from Usuario u where u.email='"+email+"'", Usuario.class).getResultList();
	}
	
	
	@Override
	public Usuario crearUsuario(Usuario nuevoUsuario) throws SQLException{

		PreparedStatement ps = con.prepareStatement(rb.getString("crearUsuario"));
		ps.setString(1, nuevoUsuario.getNombre());
		ps.setString(2, nuevoUsuario.getPassword());
		ps.execute();

		return recuperarUnUsuarioPorNombre(nuevoUsuario.getNombre());
	}
	@Override
	public void borrarUsuario(Usuario usuario) throws SQLException{

		PreparedStatement ps = con.prepareStatement(rb.getString("borrarUsuario"));
		ps.setInt(1, usuario.getId());
		ps.execute();

	}
	@Override
	public Usuario actualizarUsuario(Usuario usuario) throws SQLException{

		PreparedStatement ps = con.prepareStatement(rb.getString("actualizarUsuario"));
		ps.setString(1, usuario.getNombre());
		ps.setString(2, usuario.getPassword());
		ps.setInt(3, usuario.getId());
		ps.execute();
		return recuperarUnUsuarioPorClave(usuario.getId());

	}
	@Override
	public void setConexion(Connection con) {

		this.con = con;

	}
	@Override
	public void setQuerys(ResourceBundle rb) {

		this.rb = rb;

	}

	@Override
	public Usuario recuperarUnUsuarioPorEmailAndPass (String email, String password) throws SQLException {
		return em.createQuery("select u from Usuario u where u.email='"+email+"' and u.clave='"+password+"'",Usuario.class).getSingleResult();
	}

}