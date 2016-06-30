package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbPerAcompananteId generated by hbm2java
 */
@Embeddable
public class TbPerAcompananteId implements java.io.Serializable {

	private String nombre;
	private int id;

	public TbPerAcompananteId() {
	}

	public TbPerAcompananteId(String nombre, int id) {
		this.nombre = nombre;
		this.id = id;
	}

	@Column(name = "NOMBRE", nullable = false, length = 300)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbPerAcompananteId))
			return false;
		TbPerAcompananteId castOther = (TbPerAcompananteId) other;

		return ((this.getNombre() == castOther.getNombre()) || (this.getNombre() != null
				&& castOther.getNombre() != null && this.getNombre().equals(castOther.getNombre())))
				&& (this.getId() == castOther.getId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getNombre() == null ? 0 : this.getNombre().hashCode());
		result = 37 * result + this.getId();
		return result;
	}

}