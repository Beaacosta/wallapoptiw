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
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import es.uc3m.tiw.modelo.Producto;
import es.uc3m.tiw.modelo.Usuario;


public class ProductoDAOImpl implements ProductoDAO {

	private EntityManager em;
	private UserTransaction ut;
	
	public ProductoDAOImpl(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	public Collection<Producto> buscarProductosDeUsuario(Usuario usuario){
		
		return em.createQuery("select p from Producto p ",Producto.class).getResultList();
	}
	
	/*
	@Override
	public Collection<Producto> listaProducto() throws SQLException{
	
		Statement st = con.createStatement();
		ResultSet resultados = st.executeQuery(rb.getString("seleccionarTodosproductos"));
		
		List<Producto> listaproductos = new ArrayList<Producto>();
		Producto producto;
		while (resultados.next()) {
			producto = new Producto();
			producto.setId(resultados.getInt("id"));
			producto.setTitulo(resultados.getString("titulo"));
			producto.setCategoria(resultados.getString("categoria"));
			producto.setDescripcion(resultados.getString("descripcion"));
			//producto.setPrecio(resultados.getPrecio("precio"));
            //producto.setEstado((resultados.getEstado("estado"));
            //producto.setPicture (resutados.getPicture("picture"));


			listaproductos.add(producto);
		}
		return listaproductos;
	}
	*/
	/*
	@Override
	public  Producto productoPorClave(int pk) throws SQLException{
	
		PreparedStatement ps = con.prepareStatement(rb.getString("seleccionarproductoPK"));
		ps.setInt(1, pk);
		Producto producto = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			producto = new Producto();
			producto.setId(resultados.getInt("id"));
			producto.setTitulo(resultados.getString("titulo"));
			producto.setCategoria(resultados.getString("categoria"));
			producto.setDescripcion(resultados.getString("descripcion"));
			//producto.setPrecio((String)resultados.getPrecio("precio"));
            //producto.setEstado((enum)resultados.getEstado("estado"));
            //producto.setPicture (resutados.getPicture("picture"));
			
		}
		return producto;
	}
	*/
	/*
	@Override
	
	public Producto productoPorNombre(String titulo) throws SQLException{
	
		PreparedStatement ps = con.prepareStatement(rb.getString("productoPorTitulo"));
		ps.setString(1, titulo);
		Producto producto = null;
		ResultSet resultados = ps.executeQuery();
		while (resultados.next()) {
			producto = new Producto();
			producto.setId(resultados.getInt("id"));
			producto.setTitulo(resultados.getString("titulo"));
			producto.setCategoria(resultados.getString("categoria"));
			producto.setDescripcion(resultados.getString("descripcion"));
			//producto.setPrecio((String)resultados.getPrecio("precio"));
            //producto.setEstado((enum)resultados.getEstado("estado"));
            //producto.setPicture (resutados.getPicture("picture"));
			
		}
		return producto;
	}
	*/
	
	@Override
	public  Producto crearProducto(Producto nuevoproducto) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException{
		ut.begin();
		em.persist(nuevoproducto);
		ut.commit();
		return nuevoproducto;
		/*
		PreparedStatement ps = con.prepareStatement(rb.getString("crearProducto"));
		ps.setString(1, nuevoproducto.getTitulo());
		ps.setString(2, nuevoproducto.getCategoria());
		ps.setString(3, nuevoproducto.getDescripcion());
		//ps.setString(4, (String)nuevoproducto.getPrecio());
        //ps.setString(5, (enum)nuevoproducto.getEstado());
        //ps.setString(6, nuevoproducto.getPicture());


		ps.execute();
		
		return productoPorNombre(nuevoproducto.getTitulo());
		*/
	}
	/*
	@Override
	public void borrarProducto(Producto producto) throws SQLException{
	
		PreparedStatement ps = con.prepareStatement(rb.getString("borrarProducto"));
		ps.setInt(1, producto.getId());
		ps.execute();
		
	}
	*/
	/*
	@Override
	public Producto actualizarProducto(Producto producto) throws SQLException{
	
		PreparedStatement ps = con.prepareStatement(rb.getString("actualizarProducto"));
		ps.setString(1, producto.getTitulo());
		ps.setString(2, producto.getCategoria());
		ps.setString(3, producto.getDescripcion());
		//ps.setString(4, (String)producto.getPrecio());
        //ps.setString(5, (enum)producto.getEstado());
        //ps.setString(6, producto.getPicture());
		ps.execute();
		return productoPorClave(producto.getId());
		
	}
	*/
	/*
	@Override
	public void setConexion(Connection con) {
	
		this.con = con;
		
	}
	@Override
	public void setQuerys(ResourceBundle rb) {
	
		this.rb = rb;
		
	}
	*/

	@Override
	public Producto buscarporUsuarioId(String id) throws NoResultException {
		// TODO Auto-generated method stub
		return em.createQuery("select p from Producto p where p.usuario='"+id+"'", Producto.class).getSingleResult();
	
	}
}
