package metier;

import java.util.ArrayList;
import java.util.List;

import dao.ServiceDao;

public class ServiceMetier {
	
	public static Etudiant getEtudiant(String cne) throws Exception {
		return ServiceDao.getEtudiant(cne);
	}
	
	public static Etudiant getEtudiant(String cne, String motPasse) throws Exception {
		return ServiceDao.getEtudiant(cne, motPasse);
	}
	
	public static void addEtudiant(Etudiant etudiant) throws Exception {
		ServiceDao.addEtudiant(etudiant);
	}
	
	public static List<Object> getExemplaireDispo() throws Exception {
		return ServiceDao.getExemplaireDispo();
	}
	
	public static List<String> getCodeExemplaireDispo() throws Exception {
		return ServiceDao.getCodeExemplaireDispo();
	}
	
	public static List<String> getAllCodeExempl() throws Exception {
		return ServiceDao.getAllCodeExempl();
	}
	
	public static boolean addEmprunt (long idPersonne, String codeExemplaire) throws Exception {
		return ServiceDao.addEmprunt(idPersonne, codeExemplaire);
	}
}
