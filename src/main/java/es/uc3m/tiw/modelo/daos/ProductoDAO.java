package es.uc3m.tiw.modelo.daos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

<<<<<<< HEAD
=======
import javax.persistence.NoResultException;
>>>>>>> 4f6c91a14d67991f6a56ee6c7a33c097f23ead40
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.modelo.Producto;
import es.uc3m.tiw.modelo.Usuario;


public interface ProductoDAO {
	
	public Collection<Producto> buscarProductosDeUsuario(Usuario usuario);
	
	//public abstract Producto actualizarProducto(Producto producto) throws SQLException;

	//public abstract void borrarProducto(Producto producto) throws SQLException;

	public  Producto crearProducto(Producto nuevoproducto) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

<<<<<<< HEAD
	public abstract Producto crearProducto(Producto nuevoProducto) throws SQLException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException;
=======
	Producto buscarporUsuarioId(String id) throws NoResultException;
>>>>>>> 4f6c91a14d67991f6a56ee6c7a33c097f23ead40

	//public abstract Producto productoPorNombre(String nombre) throws SQLException;

	//public abstract Producto productoPorClave(int pk) throws SQLException;

	//public abstract Collection<Producto> listaProducto() throws SQLException;

	//public abstract void setConexion(Connection con);

	//public abstract void setQuerys(ResourceBundle rb);
}