package co.com.obusiness.common;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.obusiness.bo.MensajeValidacionBo;
import co.com.obusiness.common.error.CotrafaError;
import co.com.obusiness.common.error.CotrafaException;
import co.com.obusiness.transacciones.Mensajes;



/**
 * 
 * @author jacevedo
 *
 */
@SuppressWarnings("serial")
@ManagedBean(name="messageException")
@SessionScoped
public class MessageException extends AbstractManagedBean implements Serializable{
	
	private String mensaje;
	private String metodo;
	private String nombreClase;
	private String render;
	private boolean validar;
	private String metodoAceptacion;
	private String popUpCerrarAcepta;
	private String renderAcepta;
	private String execute;
	
	public MessageException(){
		
	}
	
	public static MessageException getInstance(){
		return new MessageException();
	}
	
	public String getMensaje(){
		return this.mensaje;
	}
	
	public boolean isMuestraMensaje(){
		this.mensaje = Mensajes.getInstance().consumeMensaje();
		return (mensaje != null && mensaje.trim().length() > 0);
	}

    public boolean isError() {
    	for (int i = 0; i < getCurrentContext().getMessageList().size(); i++) {
    		if (getCurrentContext().getMessageList().get(i).getSeverity().getOrdinal() != 0){    		    			
    			return true;
    		}
    	}
        return false;  
//        return !getCurrentContext().getMessageList().isEmpty();  
    }    
    
    public boolean isMaximumSeverity(){    
    	
    	/*for (int i = 0; i < getCurrentContext().getMessageList().size(); i++) {
    	System.out.println("prueba de mensajes isMaximumSeverity " + getCurrentContext().getMessageList().size() + " " + getCurrentContext().getMessageList().get(i).getSeverity());
    	System.out.println("prueba de mensajes isMaximumSeverity " + i + " " + getCurrentContext().getMessageList().get(i).getDetail());
    	System.out.println("prueba de mensajes isMaximumSeverity " + i + " " + getCurrentContext().getMessageList().get(i).getSummary());
    	}*/
    	if (getCurrentContext().getMaximumSeverity() == FacesMessage.SEVERITY_ERROR){
    		return true;
    	}
    	return false;
    }
    
    
    public boolean isMensajeInformacion() {
    	for (int i = 0; i < getCurrentContext().getMessageList().size(); i++) {
    		if (getCurrentContext().getMessageList().get(i).getSeverity().getOrdinal() == 0){    		    			
    			return true;
    		}
    	}
        return false;  
    }

    
    public void almacenarErrores(List<MensajeValidacionBo> msj) throws CotrafaException {
    	String mensaje = null;
    	if (msj != null && msj.size() > 0) {
			Utiles.eliminaElementosRepetidos(msj, "descripcion");
			
    		for( MensajeValidacionBo mv : msj ){
		        mensaje = mv.getDescripcion();
		        //if (!mensaje.equals("NO")){
			        if (mv.getTipoMensaje() != null && mv.getTipoMensaje().equals("WARNING")){
			        	addWarning(mensaje);
			        }
			        if (mv.getTipoMensaje() != null && mv.getTipoMensaje().equals("ERROR")){
			        	addError(mensaje);
			        }
		        //}    
			}            		
			if( isMaximumSeverity() ){
	        	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	            ResourceBundle bundle = ResourceBundle.getBundle("MensajesValidacionPersonalizados", locale);
		        mensaje = bundle.getString("mensajeErrorGrave");
				throw new CotrafaException(mensaje);
			}    
    	}
    }
    
    public void borrarError() {  
    	getRemoveMessage();
        this.validar = true;
    }

	public boolean isValidar() {
		return validar;
	}

	public void setValidar(boolean validar) {
		this.validar = validar;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	
	/**
	 * Ejecuta por introspecci�n el m�todo de aceptaci�n o rechazo, de acuerdo al par�metro de ingreso.
	 * @param snAcepta
	 * @throws CotrafaException 
	 * @throws CotrafaError 
	 */
	public void ejecutarMetodo( boolean snAcepta ) throws CotrafaError, CotrafaException{
		ClassContextUtils classContextUtils = new ClassContextUtils();
		if( snAcepta && this.metodoAceptacion != null && !this.metodoAceptacion.equals("") ){
			classContextUtils.executeMethodVoid(this.nombreClase, this.metodoAceptacion);
		} 
		else if( !snAcepta && this.metodo != null && !this.metodo.equals("") ){
			classContextUtils.executeMethodVoid(this.nombreClase, this.metodo);
		}
	}

	public String getRender() {
		return render;
	}

	public void setRender(String render) {
		this.render = render;
	}

	/**
	 * @return the metodoAceptacion
	 */
	public String getMetodoAceptacion() {
		return metodoAceptacion;
	}

	/**
	 * @param metodoAceptacion the metodoAceptacion to set
	 */
	public void setMetodoAceptacion(String metodoAceptacion) {
		this.metodoAceptacion = metodoAceptacion;
	}

	/**
	 * @return the popUpCerrarAcepta
	 */
	public String getPopUpCerrarAcepta() {
		return popUpCerrarAcepta;
	}

	/**
	 * @param popUpCerrarAcepta the popUpCerrarAcepta to set
	 */
	public void setPopUpCerrarAcepta(String popUpCerrarAcepta) {
		this.popUpCerrarAcepta = popUpCerrarAcepta;
	}

	/**
	 * @return the renderAcepta
	 */
	public String getRenderAcepta() {
		if( this.renderAcepta == null ){
			this.renderAcepta = render;
		}
		return renderAcepta;
	}

	/**
	 * @param renderAcepta the renderAcepta to set
	 */
	public void setRenderAcepta(String renderAcepta) {
		this.renderAcepta = renderAcepta;
	}

	/**
	 * @return the execute
	 */
	public String getExecute() {
		if( this.execute == null ){
			this.execute = "this";
		}
		return execute;
	}

	/**
	 * @param execute the execute to set
	 */
	public void setExecute(String execute) {
		this.execute = execute;
	}
    
}
