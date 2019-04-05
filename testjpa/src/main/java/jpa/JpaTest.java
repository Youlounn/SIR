package jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {
	
	private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }


	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		
		JpaTest test = new JpaTest(manager);


		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			
			test.initDB();
			/*Utilisateur user1 = new Utilisateur();
			user1.setPrenom("Rrrobine");
			user1.setNom("Lemancel");
			user1.setEmail("r.leeemeaencel@gmail.com");
			manager.persist(user1);
			
			Date date1 = new Date();
			date1.setPause(false);
			date1.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			manager.persist(date1);
			
			Date date2 = new Date();
			date2.setPause(false);
			date2.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			manager.persist(date2);
			
			ArrayList<Date> datesSelectionnees = new ArrayList<Date>();
			datesSelectionnees.add(date1);
			datesSelectionnees.add(date2);
			user1.setDatesSelectionnees(datesSelectionnees);
			manager.persist(user1);*/
			
			//test.manager.createQuery("DELETE FROM SONDAGE", Sondage.class);
	
            test.listUtilisateurs();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
//		String s = "SELECT e FROM Person as e where e.name=:name";
		
//		Query q = manager.createQuery(s,Person.class);
//		q.setParameter("name", "martin"); 
//		List<Person> res = q.getResultList();
		
//		System.err.println(res.size());
//		System.err.println(res.get(0).getName());
		
		manager.close();
		factory.close();
	}
	
	private void initDB() {
        int numOfEmployees = manager.createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList().size();
        if (numOfEmployees == 0) {
        	
        	Utilisateur robin = new Utilisateur("Lemancel", "Robin", "robin.lemancel@gmail.com");
        	Utilisateur yohan = new Utilisateur("Rialet", "Yohan", "yohan.rialet@gmail.com");
        	Utilisateur pierre = new Utilisateur("Brillu", "Pierre", "pierre.brillu@gmail.com");
        	
        	PrefAlim vegetarien = new PrefAlim("Végétarien");
        	PrefAlim vegan = new PrefAlim("Vegan");
        	PrefAlim carnivore = new PrefAlim("Carnivore");
        	
        	Allergie fruitsmer = new Allergie("fruits de mer");
        	Allergie lait = new Allergie("lait");
        	Allergie noix = new Allergie("noix");
        	
            manager.persist(robin);
            manager.persist(yohan);
            manager.persist(pierre);
            
            manager.persist(vegetarien);
            manager.persist(vegan);
            manager.persist(carnivore);
            
            manager.persist(fruitsmer);
            manager.persist(lait);
            manager.persist(noix);
            
            robin.setAllergies(Arrays.asList(fruitsmer));
            robin.setPrefAlim(Arrays.asList(carnivore));
            yohan.setAllergies(Arrays.asList(lait));
            yohan.setPrefAlim(Arrays.asList(vegan));
            pierre.setAllergies(Arrays.asList(noix));
            pierre.setPrefAlim(Arrays.asList(vegetarien));
            
            manager.persist(robin);
            manager.persist(yohan);
            manager.persist(pierre);
            
            Sondage sondage = new Sondage();
            sondage.setCreateur(pierre);
            sondage.setParticipants(Arrays.asList(robin, yohan, pierre));
            
            Date date1 = new Date(false, new java.sql.Date(2019,01,12), sondage);
            Date date2 = new Date(true, new java.sql.Date(2019,01,13), sondage);
            date2.setParticipants(Arrays.asList(robin, pierre));
            Date date3 = new Date(false, new java.sql.Date(2019,01,14), sondage);
            date3.setParticipants(Arrays.asList(robin, yohan, pierre));
            Date date4 = new Date(false, new java.sql.Date(2019,01,15), sondage);
            date4.setParticipants(Arrays.asList(pierre));
            Date date5 = new Date(true, new java.sql.Date(2019,01,16), sondage);

            sondage.setDates(Arrays.asList(date2, date3, date5));
            sondage.setDateValidee(date3);
            
            Reunion reunion1 = new Reunion("Marketing", "Revu des prix des produits A et B");
            Reunion reunion2 = new Reunion("Pot de départ", "Petits fours pour le départ de Philippe");

            sondage.setReunion(reunion2);
            
            manager.persist(reunion1);
            manager.persist(reunion2);
            manager.persist(date1);
            manager.persist(date2);
            manager.persist(date3);
            manager.persist(date4);
            manager.persist(date5);
            manager.persist(sondage);
            
        }
    }

	private void listUtilisateurs() {
        List<Utilisateur> resultList = manager.createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList();
        System.out.println("number of user:" + resultList.size());
        for (Utilisateur next : resultList) {
            System.out.println("next user: " + next);
        }
    }

}
