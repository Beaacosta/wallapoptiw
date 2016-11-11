package es.uc3m.tiw.modelo;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="PRODUCTO")
public class Producto implements Serializable {
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
    private String estado; 
    @Column
    private String picture;
    
    
	@ManyToOne(cascade = ALL)
	private Usuario usuario;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	public Producto(int id,String titulo, String categoria, String descripcion,
			double precio, String estado, String picture) {
		super();
        this.id=id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.precio = precio;
        this.estado = estado;
        this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	
	
}