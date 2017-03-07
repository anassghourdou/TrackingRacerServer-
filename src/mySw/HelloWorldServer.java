package mySw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldServer {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(){
		System.out.println("je ss appelé");
		return "hello";
	}
	
	/*@GET
	@Produces(MediaType.TEXT_HTML)
	public void process() throws IOException{
		int port = 2017;
	    ServerSocket ss = new ServerSocket(port);
	    for (;;) {
	        Socket client = ss.accept();
	        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	        PrintWriter out = new PrintWriter(client.getOutputStream());
	        out.print("ok");
	        
	        String line;
	        while ((line = in.readLine()) != null) {
	            if (line.length() == 0)
	              break;
	            out.print(line + "\r\n");
	          }
	          out.close(); 
	          in.close(); 
	          client.close();
	        } 
	        }
	    */

		
	}

