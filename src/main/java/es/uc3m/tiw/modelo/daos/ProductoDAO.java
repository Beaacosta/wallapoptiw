package es.uc3m.tiw.modelo.daos;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import es.uc3m.tiw.modelo.Producto;


public interface ProductoDAO {
	
	//public abstract Producto actualizarProducto(Producto producto) throws SQLException;

	public void borrarProducto(Producto producto) throws SQLException, NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	public Producto crearProducto(Producto nuevoproducto) throws SQLException, SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException;

	//public abstract Producto productoPorNombre(String nombre) throws SQLException;

	//public abstract Producto productoPorClave(int pk) throws SQLException;

	//public abstract Collection<Producto> listaProducto() throws SQLException;

	//public abstract void setConexion(Connection con);

	//public abstract void setQuerys(ResourceBundle rb);
}