package mybeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.TrackingProject.Metier.ActivityLocal;
import com.TrackingProject.Metier.PositionLocal;

@Stateless
@LocalBean
public class StatsBean implements Serializable{
	@EJB
	PositionLocal positionImpl;
	
	@EJB
	ActivityLocal activityImpl;

    public StatsBean() {
    }

}
