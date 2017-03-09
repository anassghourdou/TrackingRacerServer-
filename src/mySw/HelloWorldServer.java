package mySw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import mybeans.AuthenticationBean;

import com.TrackingProject.Entities.Activity;
import com.TrackingProject.Entities.Position;
import com.TrackingProject.Entities.User;
import com.TrackingProject.Metier.ActivityLocal;
import com.TrackingProject.Metier.PositionLocal;
import com.TrackingProject.Metier.UserImpl;
import com.TrackingProject.Metier.UserLocal;

@Path("/hello")
public class HelloWorldServer {
	
	Position position;
	
	@EJB
	PositionLocal positionImpl;
	
	@EJB
    UserLocal userImpl;
	@EJB
	ActivityLocal activityImpl;
	
	@GET
	@Produces("text/html")
	@Path("/f1")
	public String getStartingPage(@QueryParam("name") String name,@QueryParam("lat") Double lat,@QueryParam("lon") Double lon,@QueryParam("bpm") String bpm,@QueryParam("tmp") String tmp,@QueryParam("time") String time)
	{  
		Activity actCurrent =(Activity) AuthenticationBean.getHs().getAttribute("userActivity");
		
	  
	   position = new Position( lon, lat,1, tmp,actCurrent);
       positionImpl.ajoutPosition(position);
       return " affectation d'une ativity à des position 2";
	
	}
	@GET
	@Produces("text/html")
	@Path("/f2")
	public String startActivity(){
		
		Activity act = new Activity("2017-10-14T10:08:57Z","2017-10-14T11:08:57Z",210,1.30,38,7);		
		String var = (String) AuthenticationBean.getHs().getAttribute("email");
		User us = userImpl.getUserByEmail(var);
		act.setUser(us);
		AuthenticationBean.getHs().setAttribute("userActivity", act);
		System.out.println(var);
		activityImpl.ajouterActivity(act);	
		return var;
	}
			
			
	
	
	
     
    

		
	}

