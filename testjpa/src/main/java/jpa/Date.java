package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Date {
	
	int id;
	java.sql.Date date;
	boolean pause;
	//@JsonIgnore
	List<Utilisateur> participants = new ArrayList<Utilisateur>();
	//@JsonIgnore
	Sondage sondage;
	
	public Date() {
	}
	
	public Date(boolean pause, java.sql.Date d, Sondage sondage) {
		this.date = d;
		this.pause = pause;
		this.sondage = sondage;
	}
	
	@ManyToOne
	public Sondage getSondage() {
		return sondage;
	}

	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}

	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.sql.Date getDate() {
		return date;
	}

	public void setDate(java.sql.Date date) {
		this.date = date;
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	@ManyToMany(fetch=FetchType.LAZY)
	public List<Utilisateur> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Utilisateur> participants) {
		this.participants = participants;
	}
	
}