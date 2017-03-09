package mybeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import login.Util;

import com.TrackingProject.Entities.User;
import com.TrackingProject.Metier.UserLocal;


@ManagedBean(name="auth")
@SessionScoped
public class AuthenticationBean implements Serializable  {
    
	static HttpSession hs;
	private static final long serialVersionUID = 1L;
	@EJB
	UserLocal userImpl;	
    User userA;
	public User getUserA() {
		return userA;
	}
	public void setUserA(User userA) {
		this.userA = userA;
	}
	public AuthenticationBean() {
		super();
		userA = new User();
	}
	
	public String authentication(){
		if(userImpl.getUserByEmail(userA.getEmail())!= null  ){
			if(userA.getPassword().equals(userImpl.getUserByEmail(userA.getEmail()).getPassword())){
				System.out.println(" passe de l'authentification");
				setHs();
				hs.setAttribute("email", userA.getEmail());
				return "profil.xhtml";
			} else { System.out.println("erreur1");return "Login_Inscription.xhtml";}
		}else {
			System.out.println(userImpl.getUserByEmail(userA.getEmail()).getPassword()+"0000");
		    return "Login_Inscription.xhtml";}
	}
    public static HttpSession getHs() {
		return hs;
	}
	public void setHs() {
		this.hs = Util.getSession();
	    
	}
	public String logout() {
        HttpSession session = Util.getSession();
        session.invalidate();
        return "Login_Inscription.xhtml";
     }
}
	