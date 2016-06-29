package co.com.obusiness.transacciones;


import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.jboss.logging.Logger;

import co.com.obusiness.common.AtributosSesion;
import co.com.obusiness.common.Utiles;
import co.com.obusiness.common.error.CotrafaError;
import co.com.obusiness.common.error.CotrafaException;

public class Mensajes {
	private static Logger logger = Logger.getLogger(Mensajes.class);
	private static Mensajes instance;



	/**
	 * Obtiene la unica instancia de la clase
	 * 
	 * @return Instancia de la clase
	 */
	public static Mensajes getInstance() {
		if (instance == null)
			instance = new Mensajes();
		return instance;
	}

	/**
	 * Indica el mensaje que se desea mostrar la usuario
	 * 
	 * @param mensaje
	 *            Texto del mensaje a mostrar
	 */
	public void Mostrar(String mensaje) {
		ContextoWeb.getInstance().set(AtributosSesion.MENSAJE, mensaje);
	}

	/**
	 * Indica el mensaje que se desea mostrar la usuario
	 * 
	 * @param mensaje
	 *            Texto del mensaje a mostrar
	 * @param cause
	 *            Excepcion que se desea realizar log
	 */
	public void MostrarConLog(String mensaje, Exception cause) {
		// realiza log
		if (cause instanceof CotrafaException)
			logger.warn("Excepci�n Cotrafa >>>", cause);
		else
			logger.error("Excepci�n >>>", cause);

		// Indica el mensaje
		Mostrar(mensaje);
	}

	/**
	 * Indica el mensaje que se desea mostrar la usuario desde el archivo de
	 * recursos
	 * 
	 * @param claveMensaje
	 *            Clave del del mensaje a mostrar
	 * @param argsMensaje
	 *            Argumentos del mensaje a mostrar
	 */
	public void MostrarMsg(String claveMensaje, Object... argsMensaje) {
		FacesContext context = FacesContext.getCurrentInstance();

		// obtiene el mensaje
		Locale locale = context.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("MsgPaginas", locale);
		String mensaje = bundle.getString(claveMensaje);

		// formato del mensaje
		if (argsMensaje.length > 0)
			mensaje = MessageFormat.format(mensaje, argsMensaje);

		// Indica el mensaje
		Mostrar(mensaje);
	}

	/**
	 * Indica el mensaje que se desea mostrar la usuario desde el archivo de
	 * recursos
	 * 
	 * @param claveMensaje
	 *            Clave del del mensaje a mostrar
	 * @param argsMensaje
	 *            Argumentos del mensaje a mostrar
	 */
	public String obtenerMensaje(String claveMensaje, Object... argsMensaje) {
		FacesContext context = FacesContext.getCurrentInstance();
		// obtiene el mensaje
		Locale locale = context.getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("MsgPaginas", locale);
		String mensaje = bundle.getString(claveMensaje);
		// formato del mensaje
		if (argsMensaje.length > 0)
			mensaje = MessageFormat.format(mensaje, argsMensaje);
		return mensaje;
	}

	/**
	 * Indica el mensaje que se desea mostrar la usuario desde el archivo de
	 * recursos
	 * 
	 * @param claveMensaje
	 *            Clave del del mensaje a mostrar
	 * @param cause
	 *            Excepcion que se desea realizar log
	 * @param argsMensaje
	 *            Argumentos del mensaje a mostrar
	 */
	public void MostrarMsgConLog(String claveMensaje, Exception cause,
			Object... argsMensaje) {
		// realiza log
		if (cause instanceof CotrafaException)
			logger.warn("Excepci�n Cotrafa >>>", cause);
		if (cause instanceof CotrafaError)
			logger.warn("Excepci�n error Cotrafa >>>", cause);
		else
			logger.error("Excepci�n >>>", cause);

		// Indica el mensaje
		MostrarMsg(claveMensaje);
	}

	/**
	 * Consume el mensaje
	 * 
	 * @return Mensaje consumido o null si no hay
	 */
	public String consumeMensaje() {
		String msg = (String) ContextoWeb.getInstance().get(
				AtributosSesion.MENSAJE);
		if (msg == null)
			return null;

		// consume y retorna
		ContextoWeb.getInstance().set(AtributosSesion.MENSAJE, null);
		return msg;
	}

	/**
	 * Realiza log
	 * 
	 * @param cause
	 *            Causa del error
	 */
	public void Log(Exception cause) {
		// realiza log
		if (cause instanceof CotrafaException)
			logger.warn("Excepci�n Cotrafa >>>", cause);
		if (cause instanceof CotrafaError)
			logger.warn("Excepci�n error Cotrafa >>>", cause);
		else
			logger.error("Excepci�n >>>", cause);
	}
	
	/**
	 * realiza log de un mensaje
	 */
	public void realizarLog(String mensaje) {
		logger.info("Alerta de seguimiento >>> " + mensaje);
	}	
	
	public void addMessage(String summary, String detail){
    	Utiles.adicionarError(summary);		
	}

	
	/*Validaciones por modulos*/
	
	/*INFORMACION GENERAL*/
	/*public void validaFechaExpedion(Date fecha1, Date fecha2){

	    Date fechaAct = new Date();
		//SimpleDateFormat fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    
	   /* Verificamos cual es la mayor de las dos fechas, para no tener sorpresas al momento
	    * de realizar la resta.
	    *
	   if (fecha2.compareTo(fecha1) > 0){
	    enviarError("La fecha de expedici�n debe ser mayor que la fecha nacimiento.");
	   }
	   if (fecha1.compareTo(fechaAct) > 0){
		    enviarError("La fecha de expedici�n debe ser menor o igual a la fecha actual.");
		   }	   
	}*/

	
	public String CapturarMsg(String claveMensaje, Object... argsMensaje) {
		FacesContext context = FacesContext.getCurrentInstance(); 

		// obtiene el mensaje
        Locale locale = context.getViewRoot().getLocale(); 
        ResourceBundle bundle = ResourceBundle.getBundle("MensajesValidacionPersonalizados", locale);
        String mensaje = bundle.getString(claveMensaje);
        
        // formato del mensaje
        if (argsMensaje.length > 0) mensaje = MessageFormat.format(mensaje, argsMensaje);
		
        // Indica el mensaje
        return mensaje;
	}


	
}
