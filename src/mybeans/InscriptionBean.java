package mybeans;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.TrackingProject.Metier.UserLocal;
@ManagedBean
@SessionScoped
public class InscriptionBean implements Serializable  {

	@EJB
	UserLocal userImpl;
    private String message;
    
	private static final long serialVersionUID = 1L;
	private String nom;
	private String email;
	private String password;
	public String getNom() {
		return userImpl.getUser(1L).getNom();
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
}


