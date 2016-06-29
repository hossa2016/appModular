package co.com.obusiness.security;

import java.sql.SQLException;

import org.apache.commons.lang.StringUtils;

import co.com.obusiness.common.error.CotrafaError;


/**
 * Clase de ayuda para controlar los errores en en la capa de seguridad
 * @author Copia de SUCURSAL VIRTUAL COTRAFA
 */
public class FalloSeguridad {
	
	/**
	 * Verifica y lanza excepcion en caso que el resultado no sea exitoso
	 * @param res Resultado del la operacion
	 * @throws CotrafaException Excepcion lanzada por condicion de negocio
	 * @throws CotrafaError Error lanzada por fallo en bd
	 */
	/*
	public static void ThrowCotrafaExceptionAlFallar(ResultadoSp res) throws CotrafaSecurityException {
		// verifica la variable de exito
		if (res == null || res.getExitoso() == null || res.getExitoso().length() == 0) 
			throw new CotrafaError("Valor de exito no establecido");
		
		// si es exito retorna sin error
		if (res.getExitoso().equalsIgnoreCase("SI")) return;

        // verifica el mensaje tecnico y si no viene utiliza el mensaje a usuario
		if (res.getMensajeTecnico() == null || res.getMensajeTecnico().length() == 0) 
			res.setMensajeTecnico(res.getMensajeUsuario());

		// verifica si es un error grave
		if (res.getMensajeTecnico().contains("ORA-")) 
			throw new CotrafaError(res.getMensajeTecnico());
		
		// si fallo y no es grave lanza excepcion de negocio
		throw new CotrafaSecurityException(res.getMensajeTecnico(), res.getMensajeUsuario());
	}
	*/
	/**
	 * Verifica y lanza error en caso que el resultado no sea exitoso
	 * @param res Resultado del la operacion
	 * @throws CotrafaError Error lanzada por fallo en bd
	 */
	/*
	public static void ThrowCotrafaErrorAlFallar(ResultadoSp res) throws CotrafaSecurityError {
		// verifica la variable de exito
		if (res == null || res.getExitoso() == null || res.getExitoso().length() == 0) 
			throw new CotrafaError("Valor de exito no establecido");
		
		// si es exito retorna sin error
		if (res.getExitoso().equalsIgnoreCase("SI")) return;

		// verifica el mensaje tecnico
		if (res.getMensajeTecnico() == null || res.getMensajeTecnico().length() == 0) 
            res.setMensajeTecnico(res.getMensajeUsuario());

		// verifica si es un error grave
		if (res.getMensajeTecnico().contains("ORA-")) 
			throw new CotrafaError(res.getMensajeTecnico());
		
		// si fallo y no es grave lanza excepcion de negocio
		throw new CotrafaSecurityError(res.getMensajeTecnico());
	}
	*/
	/**
	 * Verifica y lanza excepcion en caso que el resultado no sea exitoso
	 * @param res Resultado del la operacion
	 * @throws CotrafaException Excepcion lanzada por condicion de negocio
	 * @throws CotrafaError Error lanzada por fallo en bd
	 */
	public static void ThrowCotrafaSecurityException(String msj, Throwable ex) throws CotrafaSecurityException {
		if (ex != null && ex instanceof CotrafaSecurityException){
			msj += ((CotrafaSecurityException)ex).getMensajeUsuario();
		}
		// verifica si es un generado por la logica contenida error grave pero que no corresponda a un error de sesion
		if (ex != null && ex.getMessage().contains("ORA-01017")) 
			msj +=  "Nombre de usuario o contraseņa invalida.";
		// verifica si es un generado por la logica contenida error grave pero que no corresponda a un error de sesion
		if (ex != null && ex.getMessage().contains("ORA-20001")){ 
			msj +=  StringUtils.substringBetween(ex.getMessage(), "ORA-20001", "\n");
		
		// verifica si es un error grave pero que no corresponda a un error de sesion
		}else if (ex != null && ex instanceof SQLException && !ex.getMessage().contains("SESSION-ERROR")){ 
			throw new CotrafaError(ex.getMessage(), ex);
		}
		// si fallo y no es grave lanza excepcion de negocio
		throw new CotrafaSecurityException((ex == null ? msj: ex.getMessage()),
								           msj, ex);
	}

}
