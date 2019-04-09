package dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpa.EntityManagerHelper;
import jpa.Sondage;
import jpa.Utilisateur;

public class SondageDAO {
	
	
	public ArrayList<Sondage> getSondages() {
		ArrayList<Sondage> sondages = (ArrayList<Sondage>) EntityManagerHelper.getEntityManager().createQuery("Select s From Sondage s", Sondage.class).getResultList();
	    return sondages;
	}
	
	public ArrayList<Sondage> getSondageById(String id) {
		ArrayList<Sondage> sondages = (ArrayList<Sondage>) EntityManagerHelper.getEntityManager().createQuery("Select s From Sondage s, Sondage s Where s.id = " + id, Sondage.class).getResultList();
	    return sondages;
	}
	
	public void saveSondage(Sondage s) {
		EntityManagerHelper.beginTransaction();
		ArrayList<Sondage> resultList = (ArrayList<Sondage>) EntityManagerHelper.getEntityManager().createQuery("Select s From Sondage s where s.email = '" + s.getId() + "'", Sondage.class).getResultList();
		if(resultList != null && resultList.size() == 1) {
			EntityManagerHelper.getEntityManager().merge(s);
		}else {
			EntityManagerHelper.getEntityManager().persist(s);
		}
		EntityManagerHelper.commit();
	}
	
	public void deleteSondage(Sondage s) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().contains(s) ? s : EntityManagerHelper.getEntityManager().merge(s));
		EntityManagerHelper.commit();
	}
	
}
