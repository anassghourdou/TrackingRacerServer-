package mybeans;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.event.map.StateChangeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

import com.TrackingProject.Metier.PositionLocal;
 

public class markersView implements Serializable{
	
	
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 5657575802869907969L;

private MapModel simpleModel;
 
   private Marker marker;
   
	@EJB
	PositionLocal positionImp;
 
   @PostConstruct
   public void init() {
	   if(simpleModel==null)
       simpleModel = new DefaultMapModel();

   }
   
   
   public  void updateanass(){
    System.out.println("anass ok");
     //Shared coordinates
     LatLng coord1 = new LatLng(36.879466, 30.667648);
     LatLng coord2 = new LatLng(36.883707, 30.689216);
     LatLng coord3 = new LatLng(36.879703, 30.706707);
     LatLng coord4 = new LatLng(36.885233, 30.702323);
     Polyline polyline = new Polyline();
     polyline.getPaths().add(coord1);
     polyline.getPaths().add(coord2);
     polyline.getPaths().add(coord3);
     polyline.getPaths().add(coord4);
     polyline.setStrokeWeight(10);
     polyline.setStrokeColor("#0000FF");
     polyline.setStrokeOpacity(0.7);
       
     //Basic marker
     simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));
     simpleModel.addOverlay(new Marker(coord2, "Ataturk Parki"));
     simpleModel.addOverlay(new Marker(coord3, "Karaalioglu Parki"));
     simpleModel.addOverlay(new Marker(coord4, "Kaleici"));
     simpleModel.addOverlay(polyline);

     RequestContext context = RequestContext.getCurrentInstance();
     context.addCallbackParam("nomatt", simpleModel);
      //simpleModel.getMarkers();
   }
   
   public void onStateChange(StateChangeEvent event){

	}
     
   public MapModel getSimpleModel() {
	   
       return simpleModel;
   }
     
   public void onMarkerSelect(OverlaySelectEvent event) {
       marker = (Marker) event.getOverlay();
        
       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
   }
     

}
