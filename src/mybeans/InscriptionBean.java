package mybeans;
import java.io.Serializable;



import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.TrackingProject.Entities.User;
import com.TrackingProject.Metier.UserLocal;

@ManagedBean(name="inscriptionBean")
@SessionScoped
public class InscriptionBean implements Serializable  {
	private static final long serialVersionUID = 1L;
	private User newUser;
	@EJB
	UserLocal userImpl;

    public InscriptionBean(){
    	super();
    	newUser = new User();
    }
    public void  inscription(){
		 userImpl.ajoutUser(newUser);
		 FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
         FacesContext.getCurrentInstance().addMessage( null, message );
    }
    public User getNewUser() {
		return newUser;
	}
	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}
	
}
