package app.unicauca.cdu.models;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {
	public Horario() {
		super();
	}

	@EmbeddedId
	private PK_Horario pk_horario;

	@Column(name = "hor_estado")
	private char hor_estado;
	
	@Column(name = "pro_id")
	private int pro_id;
	
	@Column(name = "user_id")
	private String user_id;

	public PK_Horario getPk_horario() {
		return pk_horario;
	}

	public void setPk_horario(PK_Horario pk_horario) {
		this.pk_horario = pk_horario;
	}

	public char getHor_estado() {
		return hor_estado;
	}

	public void setHor_estado(char hor_estado) {
		this.hor_estado = hor_estado;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Horario [pk_horario=" + pk_horario + ", hor_estado=" + hor_estado + ", pro_id=" + pro_id + ", user_id="
				+ user_id + "]";
	}
	
	
}
