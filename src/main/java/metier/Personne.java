package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public abstract class Personne implements Serializable{
	
	private long id;
	private String nom;
	private String prenom;
	private String motPasse;
	
	private Set<Exemplaire> exemplaires= new HashSet<Exemplaire>();

	public Personne() {	}
	
	public Personne(String nom, String prenom, String motPasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.motPasse = motPasse;
	}
	
	public long getId() { return id;}
	public void setId(long id) { this.id = id; }
	public String getNom() { return nom;}
	public void setNom(String nom) { 	this.nom = nom; }
	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) {	this.prenom = prenom; }
	public String getMotPasse() { return motPasse; }
	public void setMotPasse(String motPasse) { 	this.motPasse = motPasse;}

	public String getNomPrenom() {
		return (nom + " "+ prenom) ;
	}
	
	public Set<Exemplaire> getExemplaires() {
		return exemplaires;
	}

	public void setExemplaires(Set<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return " id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", motPasse=" + motPasse;
	}

	
}