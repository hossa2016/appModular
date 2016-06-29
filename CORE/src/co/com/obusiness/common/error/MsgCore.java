package co.com.obusiness.common.error;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Singleton para obtener los mensajes 
 * @author jmarin
 */
public class MsgCore {
	private static MsgCore instance;
	
	/**
	 * Evita que se construya una instancia directamente
	 */
	private MsgCore() { }
	
	/**
	 * Obtiene la unica instancia de la clase
	 */
	public static MsgCore getInstance() {
		if (instance == null) 
			instance = new MsgCore();
		
		return instance;
	}
	
	/**
	 * Obtiene el mensaje que se desea mostrar la usuario desde el archivo de recursos
	 */
	public String get(String claveMensaje, Object... argsMensaje) {
		
		// obtiene el mensaje
        ResourceBundle bundle = ResourceBundle.getBundle("co/com/cotrafa/common/error/MsgCore");
        String mensaje = bundle.getString(claveMensaje);
        
        // formato del mensaje
        if (argsMensaje.length > 0) mensaje = MessageFormat.format(mensaje, argsMensaje);
		
        // Indica el mensaje
        return mensaje;
	}
}

