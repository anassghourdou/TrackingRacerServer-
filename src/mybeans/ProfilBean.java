package mybeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpSession;

import com.TrackingProject.Metier.UserImpl;

import login.Util;

@ManagedBean

@SessionScoped
public class ProfilBean implements Serializable {

	private static final long serialVersionUID = 1L;
	String val;
	/*String nom;
	String prenom;
	String age;
	String Calorie;
	String */
	@EJB
	UserImpl userImpl;
	
	public ProfilBean() {
		HttpSession ses = Util.getSession();
		 String val2 = ses.getAttribute("email").toString();	
		   
		   val = userImpl.getUserByEmail(val2).getPrenom();
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
   
}
