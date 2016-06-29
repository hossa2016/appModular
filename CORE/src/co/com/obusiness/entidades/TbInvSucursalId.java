package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TbInvSucursalId generated by hbm2java
 */
@Embeddable
public class TbInvSucursalId implements java.io.Serializable {

	private int idProducto;
	private int idSucursal;

	public TbInvSucursalId() {
	}

	public TbInvSucursalId(int idProducto, int idSucursal) {
		this.idProducto = idProducto;
		this.idSucursal = idSucursal;
	}

	@Column(name = "ID_PRODUCTO", nullable = false)
	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	@Column(name = "ID_SUCURSAL", nullable = false)
	public int getIdSucursal() {
		return this.idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbInvSucursalId))
			return false;
		TbInvSucursalId castOther = (TbInvSucursalId) other;

		return (this.getIdProducto() == castOther.getIdProducto())
				&& (this.getIdSucursal() == castOther.getIdSucursal());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdProducto();
		result = 37 * result + this.getIdSucursal();
		return result;
	}

}
