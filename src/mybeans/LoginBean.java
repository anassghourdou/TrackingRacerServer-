package mybeans;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.TrackingProject.Metier.UserLocal;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
	@EJB
	UserLocal userImpl;
	String email;
	String pswd;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public void connexion() {
		if(userImpl.getUserByEmail(getEmail()).getPassword().equals(getPswd()))
			System.out.println("password ok");
		else
			System.out.println("password not ok "); 



	}


}
