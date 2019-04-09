package dao;

import java.util.ArrayList;

import jpa.EntityManagerHelper;
import jpa.Allergie;

public class AllergieDAO {
	
	
	public ArrayList<Allergie> getAllergies() {
		ArrayList<Allergie> allergies = (ArrayList<Allergie>) EntityManagerHelper.getEntityManager().createQuery("Select a From Allergie a", Allergie.class).getResultList();
	    return allergies;
	}
	
	public ArrayList<Allergie> getAllergieById(String id) {
		ArrayList<Allergie> allergies = (ArrayList<Allergie>) EntityManagerHelper.getEntityManager().createQuery("Select a From Allergie a, Allergie a Where a.id = " + id, Allergie.class).getResultList();
	    return allergies;
	}
	
	public void saveAllergie(Allergie a) {
		EntityManagerHelper.beginTransaction();
		ArrayList<Allergie> resultList = (ArrayList<Allergie>) EntityManagerHelper.getEntityManager().createQuery("Select a From Allergie a where a.id = '" + a.getId() + "'", Allergie.class).getResultList();
		if(resultList != null && resultList.size() == 1) {
			EntityManagerHelper.getEntityManager().merge(a);
		}else {
			EntityManagerHelper.getEntityManager().persist(a);
		}
		EntityManagerHelper.commit();
	}
	
	public void deleteAllergie(Allergie a) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().contains(a) ? a : EntityManagerHelper.getEntityManager().merge(a));
		EntityManagerHelper.commit();
	}

}
