package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
public class Utilisateur {
	
	String nom, prenom, email;
	List<PrefAlim> prefAlim = new ArrayList<PrefAlim>();
	List<Allergie> allergies= new ArrayList<Allergie>();
	List<Date> datesSelectionnees= new ArrayList<Date>();
	List<Sondage> sondagesCrees = new ArrayList<Sondage>();
	List<Sondage> sondagesParticipation = new ArrayList<Sondage>();
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Id
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany
	public List<PrefAlim> getPrefAlim() {
		return prefAlim;
	}

	public void setPrefAlim(List<PrefAlim> prefAlim) {
		this.prefAlim = prefAlim;
	}

	@OneToMany
	public List<Allergie> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergie> allergies) {
		this.allergies = allergies;
	}

	@ManyToMany(mappedBy="participants")
	public List<Date> getDatesSelectionnees() {
		return datesSelectionnees;
	}

	public void setDatesSelectionnees(List<Date> datesSelectionnees) {
		this.datesSelectionnees = datesSelectionnees;
	}
	
	@JsonManagedReference
	@OneToMany(mappedBy="createur", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public List<Sondage> getSondagesCrees() {
		return sondagesCrees;
	}

	public void setSondagesCrees(List<Sondage> sondagesCrees) {
		this.sondagesCrees = sondagesCrees;
	}

	@JsonManagedReference
	@ManyToMany(mappedBy="participants", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public List<Sondage> getSondagesParticipation() {
		return sondagesParticipation;
	}

	public void setSondagesParticipation(List<Sondage> sondagesParticipation) {
		this.sondagesParticipation = sondagesParticipation;
	}
	
}