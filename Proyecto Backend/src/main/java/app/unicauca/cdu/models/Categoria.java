package app.unicauca.cdu.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	public Categoria() {
		super();
	}

	@Id
	@Column(name = "cat_nombre")
	private String cat_nombre;

	@Column(name = "cat_descripcion")
	private String cat_descripcion;

//	@Column(name = "cat_foto", length = 100000000)
//	private String cat_foto;
	
	@Column(name = "cat_foto", length = 100000000)
	private String cat_foto;
	
	@OneToMany(mappedBy = "categoria")
	private Set<Escenario> escenarios = new HashSet<>();

	public String getCat_nombre() {
		return cat_nombre;
	}

	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}

	public String getCat_descripcion() {
		return cat_descripcion;
	}

	public void setCat_descripcion(String cat_descripcion) {
		this.cat_descripcion = cat_descripcion;
	}

	public String getCat_foto() {
		return cat_foto;
	}

	public void setCat_foto(String cat_foto) {
		this.cat_foto = cat_foto;
	}

	public Categoria(String cat_nombre, String cat_descripcion, String cat_foto) {
		super();
		this.cat_nombre = cat_nombre;
		this.cat_descripcion = cat_descripcion;
		this.cat_foto = cat_foto;
	}

	

	

	
}
