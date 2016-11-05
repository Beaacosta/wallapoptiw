import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;


public interface ProductoDAO {
	
	public abstract Producto actualizarProducto(Producto producto) throws SQLException;

	public abstract void borrarProducto(Producto producto) throws SQLException;

	public abstract Producto crearProducto(Producto nuevoProducto) throws SQLException;

	public abstract Producto productoPorNombre(String nombre) throws SQLException;

	public abstract Producto productoPorClave(int pk) throws SQLException;

	public abstract Collection<Producto> listaProducto() throws SQLException;

	public abstract void setConexion(Connection con);

	public abstract void setQuerys(ResourceBundle rb);
}