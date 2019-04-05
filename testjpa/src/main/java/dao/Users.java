package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.EntityManagerHelper;
import jpa.Utilisateur;

public class Users {

	public ArrayList<Utilisateur> getUsers() {
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) EntityManagerHelper.getEntityManager().createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList();
	    return users;
	}
	
	public ArrayList<Utilisateur> getCreateurBySondageId(String id) {
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) EntityManagerHelper.getEntityManager().createQuery("Select u From Utilisateur u, Sondage s Where u.email = s.createur.email and s.id = "+id, Utilisateur.class).getResultList();
	    return users;
	}
	
	public ArrayList<Utilisateur> getParticipantsBySondageId(String id) {
		ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) EntityManagerHelper.getEntityManager().createQuery("Select u From Utilisateur u, Sondage s join s.participants part Where s.id = "+id+" and part.email = u.email", Utilisateur.class).getResultList();
	    return users;
	}
	
	public void saveUser(Utilisateur u) {
		EntityManagerHelper.beginTransaction();
		ArrayList<Utilisateur> resultList = (ArrayList<Utilisateur>) EntityManagerHelper.getEntityManager().createQuery("Select a From Utilisateur a where a.email = '"+u.getEmail()+"'", Utilisateur.class).getResultList();
		if(resultList != null && resultList.size() == 1) {
			EntityManagerHelper.getEntityManager().merge(u);
		}else {
			EntityManagerHelper.getEntityManager().persist(u);
		}
		EntityManagerHelper.commit();
	}
}
