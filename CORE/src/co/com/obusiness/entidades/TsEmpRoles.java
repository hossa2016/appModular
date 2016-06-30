package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * TsEmpRoles generated by hbm2java
 */
@Entity
@Table(name = "ts_emp_roles", catalog = "obusiness", uniqueConstraints = @UniqueConstraint(columnNames = {
		"ID_EMPRESAS", "ROL" }))
public class TsEmpRoles implements java.io.Serializable {

	private Integer id;
	private int idEmpresas;
	private String rol;
	private String descripcion;

	public TsEmpRoles() {
	}

	public TsEmpRoles(int idEmpresas, String rol) {
		this.idEmpresas = idEmpresas;
		this.rol = rol;
	}

	public TsEmpRoles(int idEmpresas, String rol, String descripcion) {
		this.idEmpresas = idEmpresas;
		this.rol = rol;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "ID_EMPRESAS", nullable = false)
	public int getIdEmpresas() {
		return this.idEmpresas;
	}

	public void setIdEmpresas(int idEmpresas) {
		this.idEmpresas = idEmpresas;
	}

	@Column(name = "ROL", nullable = false, length = 100)
	public String getRol() {
		return this.rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Column(name = "DESCRIPCION", length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}