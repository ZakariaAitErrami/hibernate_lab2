package metier;

public class Etudiant extends Personne{
	
	private String cne;
	
	public Etudiant() { super();}

	public Etudiant(String cne, String nom, String prenom, String motPasse) {
		super(nom, prenom, motPasse);
		this.cne = cne;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Etudiant other = (Etudiant) obj;
		if (cne == null) {
			if (other.cne != null)
				return false;
		} else if (!cne.equals(other.cne))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Etudiant [cne=" + cne + super.toString() + "]";
	}

	
}
