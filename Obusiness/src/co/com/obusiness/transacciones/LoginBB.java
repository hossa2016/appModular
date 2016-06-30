package co.com.obusiness.transacciones;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.com.obusiness.entidades.TsEmpUsuarios;
import co.com.obusiness.entidades.TsEmpUsuariosId;
import co.com.obusiness.security.CotrafaSecurityException;
import co.com.obusiness.services.ValidaUsuarioService;
import co.com.obusiness.transacciones.delegate.ValidaUsuarioServiceDelegate;



@Controller
public class LoginBB implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TsEmpUsuarios usuario = new TsEmpUsuarios();
	private String password;
	

	
	
	public String validaUsuario(){
		FacesMessage msg = null;
		//msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario.getUsuario());
		
		ContextoWeb contextoWeb = ContextoWeb.getInstance();
		contextoWeb.set("nameBB", this.getClass().getName());
		//Autenticacion autenticacion = new Autenticacion();
		
		try {
			//autenticacion.autenticar();
			ValidaUsuarioService informacionLaboralService = (new ValidaUsuarioServiceDelegate()).getService();
			TsEmpUsuariosId usuarioId = new TsEmpUsuariosId();
			usuarioId.setId(1);
			usuarioId.setIdEmpresa(1);
			usuario.setId(usuarioId);
			String respuesta = informacionLaboralService.validaUsuario(usuario);
			if (respuesta == null || respuesta.isEmpty()){
				respuesta = "NO";
			}
			if (respuesta.equals("SI")){
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, respuesta+"Bienvenid@", usuario.getUsuario());
			}
			else {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, respuesta+"No cnccgBienvenid@", usuario.getUsuario());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "login";
			}
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fallo", usuario.getUsuario());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			e1.printStackTrace();
		}

		return "menu";
		
	}

	public TsEmpUsuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(TsEmpUsuarios usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
