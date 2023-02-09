package app.unicauca.cdu.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "escenario")
public class Escenario {
	public Escenario() {
		super();
	}

	@Id
	@Column(name = "esc_nombre")
	private String esc_nombre;

	
	@Column(name = "esc_descripcion", length = 100000)
	private String esc_descripcion;

	@Column(name = "esc_foto", length = 100000000)
	private String esc_foto;

	@Column(name = "esc_estado")
	private char esc_estado;
	
	@ManyToOne
	@JoinColumn(name="cat_nombre")
	private Categoria categoria;

	public Escenario(String esc_nombre, String esc_descripcion, String esc_foto, char esc_estado, Categoria categoria) {
		super();
		this.esc_nombre = esc_nombre;
		this.esc_descripcion = esc_descripcion;
		this.esc_foto = esc_foto;
		this.esc_estado = esc_estado;
		this.categoria = categoria;
	}

	public String getEsc_nombre() {
		return esc_nombre;
	}

	public void setEsc_nombre(String esc_nombre) {
		this.esc_nombre = esc_nombre;
	}

	public String getEsc_descripcion() {
		return esc_descripcion;
	}

	public void setEsc_descripcion(String esc_descripcion) {
		this.esc_descripcion = esc_descripcion;
	}

	public String getEsc_foto() {
		return esc_foto;
	}

	public void setEsc_foto(String esc_foto) {
		this.esc_foto = esc_foto;
	}

	public char getEsc_estado() {
		return esc_estado;
	}

	public void setEsc_estado(char esc_estado) {
		this.esc_estado = esc_estado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Escenario [esc_nombre=" + esc_nombre + ", esc_descripcion=" + esc_descripcion + ", esc_foto="
				+ esc_foto + ", esc_estado=" + esc_estado + ", categoria=" + categoria + "]";
	}

}
