package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.Utilisateur;

public class Users {

	EntityManager manager;
	
	public Users() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		manager = factory.createEntityManager();
	}

	public ArrayList<Utilisateur> getUsers() {
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) manager.createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList();
	    return users;
	}
	
	public ArrayList<Utilisateur> getCreateurBySondageId(String id) {
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) manager.createQuery("Select u From Utilisateur u, Sondage s Where u.email = s.createur.email and s.id = "+id, Utilisateur.class).getResultList();
	    return users;
	}
	
	public ArrayList<Utilisateur> getParticipantsBySondageId(String id) {
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) manager.createQuery("Select u From Utilisateur u Where s..email in and s.id = "+id, Utilisateur.class).getResultList();
	    return users;
	}
	
	
}
