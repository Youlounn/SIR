package fr.istic.sir.rest;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jpa.Sondage;
import jpa.Utilisateur;
import dao.*;

@Path("/home")
public class SampleWebService {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }
    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getUsers() {
    	Users usersEntity = new Users();
    	return usersEntity.getUsers();
    	//return u;
    	/*String html = "<html><body><h1> Liste des utilisateurs </h1>";
    	for(Utilisateur u : users) {
    		html += "<ul><li>"+u.getNom()+"</li><li>"+u.getPrenom()+"</li><li>"+u.getEmail()+"</li></ul></br>";
    	}
    	html+= "</body></html>";
    	return html;*/
    }
    @GET
    @Path("/users/sondageCrea/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getCreateurBySondageId(@PathParam("id") String id) {
    	Users usersEntity = new Users();
    	System.out.println("id = "+id);
    	return usersEntity.getCreateurBySondageId(id);
    	//return u;
    	/*String html = "<html><body><h1> Liste des utilisateurs </h1>";
    	for(Utilisateur u : users) {
    		html += "<ul><li>"+u.getNom()+"</li><li>"+u.getPrenom()+"</li><li>"+u.getEmail()+"</li></ul></br>";
    	}
    	html+= "</body></html>";
    	return html;*/
    }
    @GET
    @Path("/users/sondageParticipants/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getParticipantsBySondageId(@PathParam("id") String id) {
    	Users usersEntity = new Users();
    	System.out.println("id = "+id);
    	return usersEntity.getParticipantsBySondageId(id);
    	//return u;
    	/*String html = "<html><body><h1> Liste des utilisateurs </h1>";
    	for(Utilisateur u : users) {
    		html += "<ul><li>"+u.getNom()+"</li><li>"+u.getPrenom()+"</li><li>"+u.getEmail()+"</li></ul></br>";
    	}
    	html+= "</body></html>";
    	return html;*/
    }
    @GET
    @Path("/sondages")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sondage> getSondages() {
    	Sondages sondagesEntity = new Sondages();
    	return sondagesEntity.getSondages();
    	//return u;
    	/*String html = "<html><body><h1> Liste des utilisateurs </h1>";
    	for(Utilisateur u : users) {
    		html += "<ul><li>"+u.getNom()+"</li><li>"+u.getPrenom()+"</li><li>"+u.getEmail()+"</li></ul></br>";
    	}
    	html+= "</body></html>";
    	return html;*/
    }
}
