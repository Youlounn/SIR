package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.Sondage;

public class Sondages {

	EntityManager manager;
	
	public Sondages() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		manager = factory.createEntityManager();
	}
	
	public ArrayList<Sondage> getSondages() {
		ArrayList<Sondage> sondages = (ArrayList<Sondage>) manager.createQuery("Select s From Sondage s", Sondage.class).getResultList();
	    return sondages;
	}
}
