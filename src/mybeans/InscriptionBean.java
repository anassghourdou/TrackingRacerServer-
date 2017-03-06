package mybeans;
import java.io.Serializable;
import java.sql.Timestamp;



import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.TrackingProject.Entities.User;
import com.TrackingProject.Metier.UserLocal;

@ManagedBean(name="inscriptionBean")
@SessionScoped
public class InscriptionBean implements Serializable  {
	private User newUser;
	@EJB
	UserLocal userImpl;
    private String message;
    
	private static final long serialVersionUID = 1L;
	private User utilisateur;

	public InscriptionBean() {
		super();
			utilisateur= new User();
	
		
	}

	 public User getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}


	public void inscrire() {
			initialiserDateInscription();
			userImpl.ajoutUser(utilisateur);
	        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
	        FacesContext.getCurrentInstance().addMessage( "info", message );
	    }
	
	
	
    private void initialiserDateInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
        utilisateur.setDateCnx( date+"" );
    }
	
}
