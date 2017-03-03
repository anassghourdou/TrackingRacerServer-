package mybeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import com.TrackingProject.Entities.Activity;
import com.TrackingProject.Entities.Position;
import com.TrackingProject.Metier.ActivityLocal;
import com.TrackingProject.Metier.PositionLocal;
import com.TrackingProject.Metier.UserLocal;

/**
 * Session Bean implementation class ActivityBean
 */
@ManagedBean
@SessionScoped
public class ActivityBean implements Serializable {

	@EJB
	PositionLocal positionImpl;
	
	@EJB
	ActivityLocal activityImpl;
	@ManagedProperty(value="#{param.activityId}")
	private String activityId;
	private Activity activity;
	private MapModel simpleModel;

	

	
	 @PostConstruct
	   public void init() {
		   if(simpleModel==null)
	       simpleModel = new DefaultMapModel();

	   for(Position ps :  positionImpl.getPositionsActivityId(Long.valueOf(activityId))){
		   System.out.println("anass" +ps);
	 simpleModel.addOverlay(new Marker(new LatLng(ps.getLatitude(), ps.getLongitude()), "Konyaalti"));

	   }
	   }

	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public MapModel getSimpleModel() {
		return simpleModel;
	}
	public void setSimpleModel(MapModel simpleModel) {
		this.simpleModel = simpleModel;
	}
	
	
	
	public void anass(){
		
	//	System.out.println(activityImpl.getActivityByIdUser(1L));
		
	}
	public String showPage(){
	 
	         return "googlemaps";
	      }
	private Marker marker;
	public ActivityBean() {
		// TODO Auto-generated constructor stub
	}

}
