package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbSucursales generated by hbm2java
 */
@Entity
@Table(name = "tb_sucursales", catalog = "obusiness")
public class TbSucursales implements java.io.Serializable {

	private int id;
	private String sucursal;
	private String logo;
	private int idEmpresa;
	private int idPersonas;

	public TbSucursales() {
	}

	public TbSucursales(int id, int idEmpresa, int idPersonas) {
		this.id = id;
		this.idEmpresa = idEmpresa;
		this.idPersonas = idPersonas;
	}

	public TbSucursales(int id, String sucursal, String logo, int idEmpresa, int idPersonas) {
		this.id = id;
		this.sucursal = sucursal;
		this.logo = logo;
		this.idEmpresa = idEmpresa;
		this.idPersonas = idPersonas;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "SUCURSAL", length = 200)
	public String getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "LOGO", length = 200)
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Column(name = "ID_EMPRESA", nullable = false)
	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Column(name = "ID_PERSONAS", nullable = false)
	public int getIdPersonas() {
		return this.idPersonas;
	}

	public void setIdPersonas(int idPersonas) {
		this.idPersonas = idPersonas;
	}

}
