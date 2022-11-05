package metier;

import java.util.HashSet;
import java.util.Set;

public class Exemplaire {
	
	private String code;
	private boolean disponible;
	
	private Livre livre;
	
	private Set<Personne> personnes= new HashSet<Personne>();
	
	public Exemplaire() {}
	public Exemplaire(String code, Livre livre ) {
		this.code = code;
		this.disponible = true;
		this.livre = livre;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public Set<Personne> getPersonnes() {
		return personnes;
	}
	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exemplaire other = (Exemplaire) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Exemplaire [code=" + code + ", disponible=" + disponible + "]";
	}
	
}
