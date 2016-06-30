package co.com.obusiness.security.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import co.com.obusiness.common.error.CotrafaException;
import co.com.obusiness.entidades.TsEmpUsuarios;


public class UsuarioDAOImpl extends HibernateDaoSupport implements UsuarioDAO {
		
	/* (non-Javadoc)
	 * @see co.com.cotrafa.sic.security.dao.UsuarioDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<TsEmpUsuarios> findAll() {
		List<TsEmpUsuarios> usuarios = (List<TsEmpUsuarios>) this.getHibernateTemplate().findByNamedQuery("Usuario.findAll");
		return usuarios;
	}
	
	/* (non-Javadoc)
	 * @see co.com.cotrafa.sic.security.dao.UsuarioDAO#findById(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public TsEmpUsuarios findById(String nombre) {
		TsEmpUsuarios usuario = new TsEmpUsuarios();
		List<TsEmpUsuarios> usuarios = (List<TsEmpUsuarios>) this.getHibernateTemplate().findByNamedQueryAndNamedParam(
				   "Usuario.findById", "nombre", nombre);
		for (TsEmpUsuarios u: usuarios){
			usuario=u;
		}
		return usuario;
		
		//return (Usuario) getHibernateTemplate().get(Usuario.class, nombre);
	}
	
	/* (non-Javadoc)
	 * @see co.com.cotrafa.sic.security.dao.UsuarioDAO#save(co.com.cotrafa.sic.security.bo.Usuario)
	 */
	public void save(TsEmpUsuarios usuario){
		this.getHibernateTemplate().saveOrUpdate(usuario);
	}	
	
	public TsEmpUsuarios getUsuario( String nombre ){
		TsEmpUsuarios retorno = null;

		try {
			Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from Usuario u where u.nombre = ? and u.estado='ACTIVO' and u.agsSegTipoUsuarios.codigo = 'USUARIO-INTERNO'");
			query.setParameter(0, nombre);

			retorno = (TsEmpUsuarios)query.uniqueResult();
		} 
		catch (HibernateException he) {
			he.printStackTrace();
			//throw new CotrafaError(he);
		}

		return retorno;
	}
	
	public boolean autenticarUsuario( String usuario, String password ) throws CotrafaException {
		boolean retorno = false;
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-datasource.xml");
		
		MysqlDataSource dataSource = (MysqlDataSource) ctx.getBean("obusinessDataSource");
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(dataSource.getURL(), usuario, password);
			
			retorno = true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new CotrafaException("Usuario y/o contrase�a no v�lidos.");
		} finally {
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) {
		        	e.printStackTrace();
		        }
		    }
		}
		
		return retorno;
	}
}
