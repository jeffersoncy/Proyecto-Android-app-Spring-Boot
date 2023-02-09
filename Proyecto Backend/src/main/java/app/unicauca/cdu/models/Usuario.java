package app.unicauca.cdu.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	private Long user_id;
	
	@Column(name = "user_documento")
    private Long user_documento;
	
	@Column(name = "user_nombre")
    private String user_nombre;
	
	@Column(name = "user_genero")
    private char user_genero;
	
	@Column(name = "user_fecha")
    private Date user_fecha;
	
	@Column(name = "user_email")
    private String user_email;
	
	@Column(name = "user_password")
    private String user_password;

	

	
	public Usuario() {
		super();
	}

	

	public Usuario(Long user_id, Long user_documento, String user_nombre, char user_genero, Date user_fecha,
			String user_email, String user_password) {
		super();
		this.user_id = user_id;
		this.user_documento = user_documento;
		this.user_nombre = user_nombre;
		this.user_genero = user_genero;
		this.user_fecha = user_fecha;
		this.user_email = user_email;
		this.user_password = user_password;
	}



	public Long getUser_id() {
		return user_id;
	}



	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}



	public Long getUser_documento() {
		return user_documento;
	}



	public void setUser_documento(Long user_documento) {
		this.user_documento = user_documento;
	}



	public String getUser_nombre() {
		return user_nombre;
	}

	public void setUser_nombre(String user_nombre) {
		this.user_nombre = user_nombre;
	}

	public char getUser_genero() {
		return user_genero;
	}

	public void setUser_genero(char user_genero) {
		this.user_genero = user_genero;
	}

	public Date getUser_fecha() {
		return user_fecha;
	}

	public void setUser_fecha(Date user_fecha) {
		this.user_fecha = user_fecha;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	
	
}
