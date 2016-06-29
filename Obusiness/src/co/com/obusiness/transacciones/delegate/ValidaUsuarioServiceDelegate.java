package co.com.obusiness.transacciones.delegate;



import co.com.obusiness.common.AtributosSesion;
import co.com.obusiness.common.CodigoServicio;
import co.com.obusiness.common.ServiceLocator;
import co.com.obusiness.entidades.TsEmpUsuarios;
import co.com.obusiness.security.dto.AutenticacionDTO;
import co.com.obusiness.security.service.AutenticacionService;
import co.com.obusiness.services.ValidaUsuarioService;
import co.com.obusiness.transacciones.ContextoWeb;

/**
 * 
 * Delegado encargado de buscar el servicio correspondiente a la autenticaión del usuario

 */
public class ValidaUsuarioServiceDelegate {
	
	private ValidaUsuarioService service;



	/**
	 * constructor que crea una instancia del delegado
	 */
	public ValidaUsuarioServiceDelegate() {
		TsEmpUsuarios usuario = (TsEmpUsuarios) ContextoWeb.getInstance().get(AtributosSesion.USUARIO);
		this.service = (ValidaUsuarioService) ServiceLocator.getInstance()
				.getService(CodigoServicio.AUTENTICACION_SERVICE);
	}
	
	/**
	 * Obtiene el servicio a utilizar 
	 * 
	 * @return service : El servicio de autenticación
	 */
	public ValidaUsuarioService getService() {
		return this.service;
	}
}