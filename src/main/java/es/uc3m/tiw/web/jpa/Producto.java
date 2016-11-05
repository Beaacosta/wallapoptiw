import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="PRODUCTO")
public class producto {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(nullable = false, length = 15)
	private String titulo;
	@Column(length = 30)
	private String categoria;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private double precio;
    @Column(nullable = false)
    private enum estado {
        disponible, reservado, vendido
    };
    @Column
    private String picture;
    
    
	@ManyToOne(cascade = ALL)
	private Usuario usuario;
	
	public producto() {
		// TODO Auto-generated constructor stub
	}
	public producto(int id,String titulo, String categoria, String descripcion,
			double precio, enum estado, String picture) {
		super();
        this.id=id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
        this.estado = estado;
        this.picture = picture;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion (String descripcion){
		this.descripcion = descripcion;
	}
	public double getPrecio{
		return precio;
	}
	public void setPrecio (double precio){
		this.precio = precio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    public void setEstado (enum estado){
        this.estado = estado;
    }
    public enum getEstado{
        return estado;
    }
    public void setPicture (String picture){
        this.picture = picture;
    }
    public String getPicture{
        return picture;
	
}
