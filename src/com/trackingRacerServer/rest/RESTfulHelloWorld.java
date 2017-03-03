package com.trackingRacerServer.rest;

import java.util.Date;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.TrackingProject.Metier.UserLocal;
@RequestScoped 
@Path("/anass")
public class RESTfulHelloWorld 
{
	
	@EJB
	UserLocal userImpl;
	@GET
	@Produces("text/html")
	public String getStartingPage()
	{
		String st= userImpl.getUser(51L).getNom();
	
		return "Hello "+st;
	}
}