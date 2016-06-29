package co.com.obusiness.entidades;
// Generated 25/06/2016 12:08:16 PM by Hibernate Tools 4.3.4.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbInvProductos generated by hbm2java
 */
@Entity
@Table(name = "tb_inv_productos", catalog = "obusiness")
public class TbInvProductos implements java.io.Serializable {

	private int id;
	private String producto;
	private String unidad;
	private int idEmpProveedor;
	private int idPerProveedor;
	private int idEmpresa;
	private String tipoProducto;
	private int cantidad;

	public TbInvProductos() {
	}

	public TbInvProductos(int id, int idEmpProveedor, int idPerProveedor, int idEmpresa, int cantidad) {
		this.id = id;
		this.idEmpProveedor = idEmpProveedor;
		this.idPerProveedor = idPerProveedor;
		this.idEmpresa = idEmpresa;
		this.cantidad = cantidad;
	}

	public TbInvProductos(int id, String producto, String unidad, int idEmpProveedor, int idPerProveedor, int idEmpresa,
			String tipoProducto, int cantidad) {
		this.id = id;
		this.producto = producto;
		this.unidad = unidad;
		this.idEmpProveedor = idEmpProveedor;
		this.idPerProveedor = idPerProveedor;
		this.idEmpresa = idEmpresa;
		this.tipoProducto = tipoProducto;
		this.cantidad = cantidad;
	}

	@Id

	@Column(name = "ID", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "PRODUCTO", length = 45)
	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@Column(name = "UNIDAD", length = 45)
	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Column(name = "ID_EMP_PROVEEDOR", nullable = false)
	public int getIdEmpProveedor() {
		return this.idEmpProveedor;
	}

	public void setIdEmpProveedor(int idEmpProveedor) {
		this.idEmpProveedor = idEmpProveedor;
	}

	@Column(name = "ID_PER_PROVEEDOR", nullable = false)
	public int getIdPerProveedor() {
		return this.idPerProveedor;
	}

	public void setIdPerProveedor(int idPerProveedor) {
		this.idPerProveedor = idPerProveedor;
	}

	@Column(name = "ID_EMPRESA", nullable = false)
	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Column(name = "TIPO_PRODUCTO", length = 6)
	public String getTipoProducto() {
		return this.tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	@Column(name = "CANTIDAD", nullable = false)
	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
