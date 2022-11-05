package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Livre implements Serializable {
	
	private long num;
	private String titre;
	
	private Set<Exemplaire> exemplaires= new HashSet<Exemplaire>();
	
	public Livre() {	}
	public Livre(long num, String titre) {
		this.num = num;
		this.titre = titre;
	}
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Set<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	public void setExemplaires(Set<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livre other = (Livre) obj;
		if (num != other.num)
			return false;
		if (titre == null) {
			if (other.titre != null)
				return false;
		} else if (!titre.equals(other.titre))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Livre [num=" + num + ", titre=" + titre + "]";
	}
	
}
