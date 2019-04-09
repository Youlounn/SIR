package dao;

import java.util.ArrayList;

import jpa.Date;
import jpa.EntityManagerHelper;

public class DateDAO {
	
	
	public ArrayList<Date> getDates() {
		ArrayList<Date> dates = (ArrayList<Date>) EntityManagerHelper.getEntityManager().createQuery("Select d From Date d", Date.class).getResultList();
	    return dates;
	}
	
	public ArrayList<Date> getDatesById(String id) {
		ArrayList<Date> dates = (ArrayList<Date>) EntityManagerHelper.getEntityManager().createQuery("Select d From Date d, Date d Where d.id = " + id, Date.class).getResultList();
	    return dates;
	}
	
	public void saveDate(Date d) {
		EntityManagerHelper.beginTransaction();
		ArrayList<Date> resultList = (ArrayList<Date>) EntityManagerHelper.getEntityManager().createQuery("Select d From Date d where d.id = '" + d.getId() + "'", Date.class).getResultList();
		if(resultList != null && resultList.size() == 1) {
			EntityManagerHelper.getEntityManager().merge(d);
		}else {
			EntityManagerHelper.getEntityManager().persist(d);
		}
		EntityManagerHelper.commit();
	}
	
	public void deleteDate(Date d) {
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().contains(d) ? d : EntityManagerHelper.getEntityManager().merge(d));
		EntityManagerHelper.commit();
	}

}
