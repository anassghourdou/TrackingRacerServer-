package mybeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@Named("user")
@ManagedBean
@SessionScoped
public class User implements Serializable{
	
	int id;
	String name;
	String email;
	float weigth;
	float Tdistance;
	float Tcalories;


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getWeigth() {
		return weigth;
	}
	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}
	public float getTdistance() {
		return Tdistance;
	}
	public void setTdistance(float tdistance) {
		Tdistance = tdistance;
	}
	public float getTcalories() {
		return Tcalories;
	}
	public void setTcalories(float tcalories) {
		Tcalories = tcalories;
	}
	public int getNactivities(){
		int nactivities = 0;
		return nactivities ;	
	}
	public Activity getActivities(){
		Activity act = new Activity();
		
		return act;
	}
	

}
