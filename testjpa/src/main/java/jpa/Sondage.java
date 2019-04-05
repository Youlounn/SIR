package jpa;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;


@Entity
public class Sondage {
	
	int id;
	Date dateValidee;
	List<Date> dates;
	List<Utilisateur> participants;
	Utilisateur createur;
	Reunion reunion;
	
	public Sondage() {
		
	}
	
	public Sondage(List<Utilisateur> participants, Utilisateur createur) {
		this.participants = participants;
		this.createur = createur;
	}
	
	@JsonBackReference(value = "participants")
	@ManyToMany(fetch=FetchType.LAZY)
	public List<Utilisateur> getParticipants() {
		return participants;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setParticipants(List<Utilisateur> participants) {
		this.participants = participants;
	}
	
	@JsonBackReference(value = "createur")
    @ManyToOne(fetch=FetchType.LAZY)
	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	
	@OneToOne
	public Date getDateValidee() {
		return dateValidee;
	}
	public void setDateValidee(Date dateValidee) {
		this.dateValidee = dateValidee;
	}
	
	@OneToMany(mappedBy="sondage", fetch=FetchType.LAZY)
	public List<Date> getDates() {
		return dates;
	}
	
	public void setDates(List<Date> dates) {
		this.dates = dates;
	}

	@OneToOne
	public Reunion getReunion() {
		return reunion;
	}

	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
}