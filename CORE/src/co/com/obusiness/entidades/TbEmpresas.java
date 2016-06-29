package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbEmpresas generated by hbm2java
 */
@Entity
@Table(name = "tb_empresas", catalog = "obusiness")
public class TbEmpresas implements java.io.Serializable {

	private Integer id;
	private String nombre;
	private String descripcion;

	public TbEmpresas() {
	}

	public TbEmpresas(String nombre) {
		this.nombre = nombre;
	}

	public TbEmpresas(String nombre, String descripcion) {
		this.nombre = nombre;
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

	@Column(name = "NOMBRE", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "DESCRIPCION", length = 1000)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
