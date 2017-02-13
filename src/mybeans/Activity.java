package mybeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@Named("activity")
@ManagedBean
@SessionScoped
public class Activity implements Serializable {
	
	int id;
	float calories;
	float distance;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getCalories() {
		return calories;
	}


	public void setCalories(float calories) {
		this.calories = calories;
	}


	public float getDistance() {
		return distance;
	}


	public void setDistance(float distance) {
		this.distance = distance;
	}


	public Activity() {
		// TODO Auto-generated constructor stub
	}

}
