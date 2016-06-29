package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TsEmpUsuariosId generated by hbm2java
 */
@Embeddable
public class TsEmpUsuariosId implements java.io.Serializable {

	private int id;
	private int idEmpresa;

	public TsEmpUsuariosId() {
	}

	public TsEmpUsuariosId(int id, int idEmpresa) {
		this.id = id;
		this.idEmpresa = idEmpresa;
	}

	@Column(name = "ID", nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ID_EMPRESA", nullable = false)
	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TsEmpUsuariosId))
			return false;
		TsEmpUsuariosId castOther = (TsEmpUsuariosId) other;

		return (this.getId() == castOther.getId()) && (this.getIdEmpresa() == castOther.getIdEmpresa());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getId();
		result = 37 * result + this.getIdEmpresa();
		return result;
	}

}
