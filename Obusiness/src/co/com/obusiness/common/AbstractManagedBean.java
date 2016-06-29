package co.com.obusiness.common;

import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
  
  
public class AbstractManagedBean {  
  
    protected FacesContext getCurrentContext() {  
        return FacesContext.getCurrentInstance();  
    }  
      
    public void addInfo(String msg) {  
        addMessage(msg, FacesMessage.SEVERITY_INFO);  
    }  
      
    public void addError(String msg) {  
        addMessage(msg, FacesMessage.SEVERITY_ERROR);  
    }  

    public void addFatal(String msg) {  
        addMessage(msg, FacesMessage.SEVERITY_FATAL);  
    }  
      
    public void addWarning(String msg) {  
        addMessage(msg, FacesMessage.SEVERITY_WARN);  
    }  

    private void addMessage(String msg,Severity severity) {  
		int existe = 0;
    	if ( getCurrentContext().getMessageList().size() != 0){
	    	for (int i = 0; i < getCurrentContext().getMessageList().size(); i++) {
	    		if (getCurrentContext().getMessageList().get(i).getDetail() != null){
		    		if (getCurrentContext().getMessageList().get(i).getDetail().equals(msg)){
		    			existe = 1;
		    		}
	    		}	
	    	}
    	}	
    	if (existe == 0){
	        FacesMessage message=new FacesMessage(msg);  
	        message.setSeverity(severity);  
	        FacesContext ctx=getCurrentContext();  
	        ctx.addMessage(null, message);  	    		
    	}
    }  

    
	public void getRemoveMessage() {  
        FacesContext ctx=getCurrentContext();  
        ctx.getMessages().remove();  
    }  
    
    
    public String getMessage(String key) {  
        return (String)getExpression("label['"+key+"']");  
    }  
      
    private Object getExpression(String expression) {  
        FacesContext ctx=getCurrentContext();  
        ExpressionFactory factory=ctx.getApplication().getExpressionFactory();  
        ValueExpression ex=factory.createValueExpression(ctx.getELContext(), "#{"+expression+"}", Object.class);  
        return ex.getValue(ctx.getELContext());  
          
    }  
}  
