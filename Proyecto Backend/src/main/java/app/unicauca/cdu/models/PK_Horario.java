package app.unicauca.cdu.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PK_Horario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PK_Horario() {
		super();
	}

	@Column(name = "hor_hora_inicio")
	private int hor_hora_inicio;

	@Column(name = "hor_hora_fin")
	private int hor_hora_fin;
	
	@Column(name = "hor_dia")
	private String hor_dia;
	
	@Column(name = "hor_fecha_inicio")
	private String hor_fecha_inicio;
	
	@Column(name = "hor_fecha_fin")
	private String hor_fecha_fin;

	@Column(name = "esc_nombre")
	private String esc_nombre;

	public int getHor_hora_inicio() {
		return hor_hora_inicio;
	}

	public void setHor_hora_inicio(int hor_hora_inicio) {
		this.hor_hora_inicio = hor_hora_inicio;
	}

	public int getHor_hora_fin() {
		return hor_hora_fin;
	}

	public void setHor_hora_fin(int hor_hora_fin) {
		this.hor_hora_fin = hor_hora_fin;
	}

	public String getHor_dia() {
		return hor_dia;
	}

	public void setHor_dia(String hor_dia) {
		this.hor_dia = hor_dia;
	}

	public String getHor_fecha_inicio() {
		return hor_fecha_inicio;
	}

	public void setHor_fecha_inicio(String hor_fecha_inicio) {
		this.hor_fecha_inicio = hor_fecha_inicio;
	}

	public String getHor_fecha_fin() {
		return hor_fecha_fin;
	}

	public void setHor_fecha_fin(String hor_fecha_fin) {
		this.hor_fecha_fin = hor_fecha_fin;
	}

	public String getEsc_nombre() {
		return esc_nombre;
	}

	public void setEsc_nombre(String esc_nombre) {
		this.esc_nombre = esc_nombre;
	}

	@Override
	public String toString() {
		return "PK_Horario [hor_hora_inicio=" + hor_hora_inicio + ", hor_hora_fin=" + hor_hora_fin + ", hor_dia="
				+ hor_dia + ", hor_fecha_inicio=" + hor_fecha_inicio + ", hor_fecha_fin=" + hor_fecha_fin
				+ ", esc_nombre=" + esc_nombre + "]";
	}

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        return true;
	    }
	
	
}
