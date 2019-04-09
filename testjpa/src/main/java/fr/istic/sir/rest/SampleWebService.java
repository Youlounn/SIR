package fr.istic.sir.rest;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    	UtilisateurDAO usersEntity = new UtilisateurDAO();
    	return usersEntity.getUsers();
    }
    
    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public void addUsers(Utilisateur u) {
    	UtilisateurDAO usersEntity = new UtilisateurDAO();
    	usersEntity.saveUser(u);
    }
    
    @DELETE
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUsers(Utilisateur u) {
    	UtilisateurDAO usersEntity = new UtilisateurDAO();
    	usersEntity.deleteUser(u);
    }
    
    @GET
    @Path("/users/sondageCrea/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getCreateurBySondageId(@PathParam("id") String id) {
    	UtilisateurDAO usersEntity = new UtilisateurDAO();
    	System.out.println("id = "+id);
    	return usersEntity.getCreateurBySondageId(id);
    }
    
    @GET
    @Path("/users/sondageParticipants/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Utilisateur> getParticipantsBySondageId(@PathParam("id") String id) {
    	UtilisateurDAO usersEntity = new UtilisateurDAO();
    	return usersEntity.getParticipantsBySondageId(id);
    }
    
    @GET
    @Path("/sondages")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Sondage> getSondages() {
    	SondageDAO sondagesEntity = new SondageDAO();
    	return sondagesEntity.getSondages();
    }
}

