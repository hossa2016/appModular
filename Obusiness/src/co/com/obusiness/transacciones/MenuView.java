package co.com.obusiness.transacciones;
 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuColumn;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import co.com.obusiness.bo.Menu;
 
@ManagedBean
public class MenuView {
    
	private List<Menu> menu  = new ArrayList<Menu>();
    private MenuModel model;
    private List<Menu> hijos = new ArrayList<Menu>() ;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
         
        cargarMenu();
        
        //First submenu
        //DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
        DefaultSubMenu voidSubmenu = new DefaultSubMenu("Void Submenu");        
        for(Menu m: menu){
        	
        	if(m.getHijos() != null && m.getHijos().size()>0){
        		DefaultMenuColumn column = new DefaultMenuColumn();
        		DefaultSubMenu secondSubmenu = new DefaultSubMenu();
        		DefaultSubMenu submenu = new DefaultSubMenu(m.getNombre());
        		cargarSubMenu(m, secondSubmenu);
            	column.addElement(secondSubmenu);
            	submenu.addElement(column);
        		model.addElement(submenu);
        		

        	}
        	else{
        		DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
                item.setUrl(m.getUrl());
                item.setIcon("ui-icon-home");
                //DefaultSubMenu submenu = new DefaultSubMenu(m.getNombre());
                model.addElement(item);
               
        	}
        	
        }
		System.out.println("hhhh");
        /*
        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);
         
        model.addElement(firstSubmenu);
         
        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
 
        item = new DefaultMenuItem("Save");
        item.setIcon("ui-icon-disk");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Delete");
        item.setIcon("ui-icon-close");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);
         
        item = new DefaultMenuItem("Redirect");
        item.setIcon("ui-icon-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);*/
 
        
    }
    
    public void cargarSubMenu(Menu m, DefaultSubMenu subMMenu ){
    	
    	for(Menu m1: m.getHijos()){
        	if(m1.getHijos() != null && m1.getHijos().size()>0){

        		DefaultMenuColumn column = new DefaultMenuColumn();
        		DefaultSubMenu secondSubmenu = new DefaultSubMenu(m1.getNombre());
        		DefaultSubMenu submenu = new DefaultSubMenu(m1.getNombre());
        		cargarSubMenu(m1, secondSubmenu);
        		column.addElement(secondSubmenu);
        		submenu.addElement(column);
        		subMMenu.addElement(submenu);

        	}
        	else{
        		DefaultMenuItem item = new DefaultMenuItem(m1.getNombre());
                item.setUrl(m1.getUrl());
                item.setIcon("ui-icon-home");
                //DefaultSubMenu submenu = new DefaultSubMenu(m.getNombre());
                subMMenu.addElement(item);

        	}
        }    	

    }
    
    public void cargarMenu(){
    	Menu opcion = new Menu();
    	Menu opcion2 = new Menu();
    	Menu opcion3 = new Menu();
    	Menu opcion1 = new Menu();
    	Menu opcion4 = new Menu();
    	List<Menu> hijos2 = new ArrayList<Menu>();
    	
    	opcion.setId(1);
    	opcion.setIdPadre(0);
    	opcion.setNombre("opcion1");
    	opcion.setUrl("");

    	

    	opcion1.setId(2);
    	opcion1.setIdPadre(1);
    	opcion1.setNombre("opcion1.2");
    	opcion1.setUrl("opcion1.xhtml"); 
    	
    	/*opcion4.setId(7);
    	opcion4.setIdPadre(2);
    	opcion4.setNombre("opcion4.2");
    	opcion4.setUrl(""); 
    	hijos2.add(opcion4);
    	
    	opcion4 = new Menu();
    	opcion4.setId(8);
    	opcion4.setIdPadre(2);
    	opcion4.setNombre("opcion4.2");
    	opcion4.setUrl("");     	
    	hijos2.add(opcion4); 
    	
    	opcion1.setHijos(hijos2);*/
    	
    	hijos.add(opcion1);
    	
    	opcion1 = new Menu();
    	opcion1.setId(3);
    	opcion1.setIdPadre(1);
    	opcion1.setNombre("opcion1.3");
    	opcion1.setUrl("opcion2.xhtml");    	
    	hijos.add(opcion1);    	
    	
    	opcion.setHijos(hijos);
    	menu.add(opcion);
    	
    	opcion2.setId(2);
    	opcion2.setIdPadre(0);
    	opcion2.setNombre("opcion2");
    	opcion2.setUrl("");

    	
    	 hijos = new ArrayList<Menu>();
    	opcion1.setId(4);
    	opcion1.setIdPadre(2);
    	opcion1.setNombre("opcion2.2");
    	opcion1.setUrl("opcion3.xhtml");    	
    	hijos.add(opcion1);
    	
    	opcion1 = new Menu();
    	opcion1.setId(5);
    	opcion1.setIdPadre(2);
    	opcion1.setNombre("opcion2.3");
    	opcion1.setUrl("");    	
    	hijos.add(opcion1);    	
    	
    	opcion2.setHijos(hijos);
    	menu.add(opcion2);
    	
    	opcion3.setId(3);
    	opcion3.setIdPadre(0);
    	opcion3.setNombre("opcion3");
    	opcion3.setUrl("");
    	menu.add(opcion3);
    }
 
    public MenuModel getModel() {
        return model;
    }   
     
    public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public List<Menu> getMenu() {
		return menu;
	}

	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
}