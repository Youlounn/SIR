package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PrefAlim {
	
	int id;
	String prefAlim;
	
	public PrefAlim(){
	}
	
	public PrefAlim(String pa) {
		this.prefAlim = pa;
	}
	
	@Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrefAlim() {
		return prefAlim;
	}

	public void setPrefAlim(String prefAlim) {
		this.prefAlim = prefAlim;
	}
	
}