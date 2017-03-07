package mybeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import java.io.Serializable;
import java.text.DateFormat.Field;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;

import com.TrackingProject.Entities.Activity;
import com.TrackingProject.Metier.ActivityLocal;

import org.primefaces.model.chart.ChartSeries;
 
@ManagedBean
public class ChartBean implements Serializable {
 @EJB
 ActivityLocal activityImpl;
    private BarChartModel barModel;
 
    @PostConstruct
    public void init() {
        createBarModel();
        
      
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries activity_ch = new ChartSeries();
        
        activity_ch.setLabel("activities");
  	  Map<Integer, Double> map=new HashMap<Integer,Double>();

  for(Activity act:activityImpl.getActivitydates("2007-10-14T10:08:57Z", "2012-10-14T12:59:59Z")){
	  Instant date1 = Instant.parse(act.getDateDebut());
      LocalDateTime result = LocalDateTime.ofInstant(date1, ZoneId.of(ZoneOffset.UTC.getId()));
      
      Double v=(Double) map.get(result.getYear());
      if(v!=null){
    	  map.put(result.getYear(), v+act.getDistance());

      }
      else{
    	  map.put(result.getYear(), act.getDistance());
 

  
      }

	  activity_ch.set(result.getYear(), (Double) map.get(result.getYear()));	
        	
        }
  
 
        model.addSeries(activity_ch);
         
        return model;
    }
     
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("miles");
        yAxis.setMin(0);
        yAxis.setMax(500);
    }
 
}