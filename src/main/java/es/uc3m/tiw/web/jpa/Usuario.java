import static javax.persistence.GenerationType.AUTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="USUARIO")
public class usuario {
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column(nullable = false, length = 15)
	private String nombre;
	@Column(length = 30)
	private String apellidos;
	@Column(nullable = false, length = 30, unique = true)
	private String ciudad;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String mail;
	@Column(nullable = false)
	private String passVerif;
	
	/*@OneToOne(cascade = ALL)
	private Direccion direccion;*/
	
	public usuario() {
		// TODO Auto-generated constructor stub
	}
	public usuario(String nombre, String apellidos, String ciudad,
			String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.usuario = ciudad;
		this.password = password;
	}
	public usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
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
		return usuario;
	}
	public void setCiudad(String ciudad) {
		this.usuario = usuario;
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
	return password;
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