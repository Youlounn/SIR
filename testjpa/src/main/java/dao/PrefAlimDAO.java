package dao;

import java.util.ArrayList;

import jpa.PrefAlim;
import jpa.EntityManagerHelper;

public class PrefAlimDAO {

	
	public ArrayList<PrefAlim> getPrefAlim() {
		ArrayList<PrefAlim> prefAlim = (ArrayList<PrefAlim>) EntityManagerHelper.getEntityManager().createQuery("Select p From PrefAlim p", PrefAlim.class).getResultList();
	    return prefAlim;
	}
	
	public ArrayList<PrefAlim> getPrefAlimById(String id) {
		ArrayList<PrefAlim> prefAlim = (ArrayList<PrefAlim>) EntityManagerHelper.getEntityManager().createQuery("Select p From PrefAlim p, PrefAlim p Where p.id = " + id, PrefAlim.class).getResultList();
	    return prefAlim;
	}
	
	public void savePrefAlim(PrefAlim p) {
		EntityManagerHelper.beginTransaction();
		ArrayList<PrefAlim> resultList = (ArrayList<PrefAlim>) EntityManagerHelper.getEntityManager().createQuery("Select p From PrefAlim p where p.id = '" + p.getId() + "'", PrefAlim.class).getResultList();
		if(resultList != null && resultList.size() == 1) {
			EntityManagerHelper.getEntityManager().merge(p);
		}else {
			EntityManagerHelper.getEntityManager().persist(p);
		}
		EntityManagerHelper.commit();
	}
	
	public void deletePrefAlim(PrefAlim p) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().contains(p) ? p : EntityManagerHelper.getEntityManager().merge(p));
		EntityManagerHelper.commit();
	}

}
