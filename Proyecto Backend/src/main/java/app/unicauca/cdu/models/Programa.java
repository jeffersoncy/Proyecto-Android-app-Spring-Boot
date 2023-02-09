package app.unicauca.cdu.models;

//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "programa")
public class Programa {
	public Programa() {
		super();
	}
	public Programa(int pro_id, String pro_nombre) {
		super();
		this.pro_id = pro_id;
		this.pro_nombre = pro_nombre;
	}

	@Id
	@Column(name = "pro_id",length = 15)
	private int pro_id;

	@Column(name = "pro_nombre",length = 200)
	private String pro_nombre;

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_nombre() {
		return pro_nombre;
	}

	public void setPro_nombre(String pro_nombre) {
		this.pro_nombre = pro_nombre;
	}

	//@OneToMany(mappedBy = "categoria")
	//private Set<Escenario> escenarios = new HashSet<>();

	

	
}
