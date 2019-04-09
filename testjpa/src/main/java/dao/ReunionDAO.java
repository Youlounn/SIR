package dao;

import java.util.ArrayList;

import jpa.EntityManagerHelper;
import jpa.Reunion;

public class ReunionDAO {
	
	
	public ArrayList<Reunion> getReunions() {
		ArrayList<Reunion> reunions = (ArrayList<Reunion>) EntityManagerHelper.getEntityManager().createQuery("Select r From Reunion r", Reunion.class).getResultList();
	    return reunions;
	}
	
	public ArrayList<Reunion> getReunionById(String id) {
		ArrayList<Reunion> reunions = (ArrayList<Reunion>) EntityManagerHelper.getEntityManager().createQuery("Select r From Reunion r, Reunion r Where r.id = " + id, Reunion.class).getResultList();
	    return reunions;
	}
	
	public void saveReunion(Reunion r) {
		EntityManagerHelper.beginTransaction();
		ArrayList<Reunion> resultList = (ArrayList<Reunion>) EntityManagerHelper.getEntityManager().createQuery("Select r From Reunion r where r.id = '" + r.getId() + "'", Reunion.class).getResultList();
		if(resultList != null && resultList.size() == 1) {
			EntityManagerHelper.getEntityManager().merge(r);
		}else {
			EntityManagerHelper.getEntityManager().persist(r);
		}
		EntityManagerHelper.commit();
	}
	
	public void deleteReunion(Reunion r) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().contains(r) ? r : EntityManagerHelper.getEntityManager().merge(r));
		EntityManagerHelper.commit();
	}

}
