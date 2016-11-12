package es.uc3m.tiw.modelo;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="USUARIO")
public class Usuario implements Serializable {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(length = 30)
	private String apellidos;
	@Column(nullable = false)
	private String ciudad;
	@Column(nullable = false, length = 30, unique = true)
	private String mail;
	@Column(nullable = false, length = 15)
	private String nombre;	
	@Column(nullable = true)
	private String passVerif;
	@Column(nullable = false)
	private String password;
	
	/*@OneToOne(cascade = ALL)
	private Direccion direccion;*/
		
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	public Usuario(String nombre, String apellidos, String ciudad,
			String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.ciudad = ciudad;
		this.password = password;
	}
	public Usuario(String mail, String password) {
		super();
		this.mail = mail;
		this.password = password;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassVerif() {
	return passVerif;
	}
	public void setPassVerif(String passVerif) {
		this.passVerif = passVerif;
	}
	
	public String getMail() {
	return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
}