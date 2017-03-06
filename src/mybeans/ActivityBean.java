package mybeans;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

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


	private static final long serialVersionUID = 1L;

	@EJB
	PositionLocal positionImpl;
	
	@EJB
	ActivityLocal activityImpl;
	@ManagedProperty(value="#{param.activityId}")
	private String activityId;
	private Activity activity;
	public Activity getActivity() {
		System.out.println("ansous"+activity);
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	private MapModel simpleModel;

	

	
	 @PostConstruct
	   public void init() {
		   if(simpleModel==null)
	       simpleModel = new DefaultMapModel();
		   Polyline polyline = new Polyline();
		   polyline.setStrokeWeight(10);
		     polyline.setStrokeColor("#0000FF");
		     polyline.setStrokeOpacity(0.7);
		       
		   LatLng coord ;

		   this.activity= activityImpl.getActivityById(Long.valueOf(activityId));
	   for(Position ps :  positionImpl.getPositionsActivity(activity)){
		   coord = new LatLng(ps.getLatitude(), ps.getLongitude());
		   polyline.getPaths().add(coord);
	 simpleModel.addOverlay(new Marker(coord, "Konyaalti"));

	   }
	     simpleModel.addOverlay(polyline);

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
	 
	         return "TBoard";
	      }
	private Marker marker;
	public ActivityBean() {
	}
	
	public String getTemps(){
		if(!this.activity.getDateFin().isEmpty()){
				 Instant  date2 = Instant.parse(this.activity.getDateFin());
				 Instant  date1 = Instant.parse(this.activity.getDateDebut());

				 Long heurs = Duration.between(date1, date2).toHours();
				 Long minutes = Duration.between(date1, date2).toMinutes()-heurs*60;
				 Long secondes = Duration.between(date1, date2).getSeconds()-(Duration.between(date1, date2).toMinutes()*60);
				 System.out.println("duration between two dates"+heurs+":"+minutes+" secondes :"+secondes);
	
				
			String fin=this.activity.getDateFin();
			String debut=this.activity.getDateDebut();
			return heurs+":"+minutes+":"+secondes;
		}
		else return "En cours";
			

		
	}
	
	public String getCalories(){
		if(this.activity.getCalories()<1){
			
			return "";
		}
		return "";
		
	}
	
	public List<Activity> getActivities(){
		System.out.println("test "+activityImpl.getActivityByIdUser(1L));
		return activityImpl.getActivityByIdUser(1L);
		
		
	}

}
