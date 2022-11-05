package dao;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;

import metier.*;

public class ServiceDao {
	
	public static Etudiant getEtudiant(String cne) throws Exception {
		Etudiant etudiant = new Etudiant();
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		etudiant = (Etudiant) sessionHib.load(Etudiant.class, cne);
	    if(etudiant==null) return null;	
	    return etudiant; 
	}
	
	public static Etudiant getEtudiant(String cne, String motPasse) throws Exception {
		Etudiant etudiant= null;
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
	
		Query query = sessionHib.createQuery("from Personne where cne like :p and motPasse like :pp");
		query.setString("p", cne);
		query.setString("pp", motPasse);
		
		if(query.list().size()==0)
			return null;
		return (Etudiant) query.list().get(0);
	}
	
	public static void addEtudiant(Etudiant etudiant) throws Exception {
		
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		sessionHib.save(etudiant);
		sessionHib.getTransaction().commit();
	
	}
	
	public static List<Object> getExemplaireDispo() throws Exception {
		
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		Query req = sessionHib.createQuery("Select ex.code, liv.titre FROM Exemplaire ex"
				+ " JOIN ex.livre liv where ex.disponible=true");
		
		
		if(req.list().size()==0)
		return null;
		return req.list();
		
	}
	
	public static List<String> getCodeExemplaireDispo() throws Exception {
		
		List<String> codeExemplaires = new ArrayList<String>();
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		
		Query req = sessionHib.createQuery("select code from Exemplaire where disponible=true");
		
		/*for(Exemplaire e : (ArrayList<Exemplaire>) req.list()) {
			codeExemplaires.add(e.getCode());
		}*/
		
		return req.list();
	}
	
	public static boolean addExemplaire(Exemplaire exemplaire) throws Exception {
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		
		sessionHib.beginTransaction();
		sessionHib.save(exemplaire);
		sessionHib.getTransaction().commit();
		return true;
	}
	

	public static List<String> getAllCodeExempl() {
		List<String> codeExemplaires = new ArrayList<String>();
		Session sessionHib =  HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		Query req = sessionHib.createQuery("select code from Exemplaire");
		/*for(Exemplaire e : (ArrayList<Exemplaire>) req.list()) {
			codeExemplaires.add(e.getCode());
		}*/
		return req.list();
	}
	
	public static boolean addEmprunt(long idPersonne, String codeExemplaire) throws Exception {
		
		Session sessionHib = HibernateUtil.getSessionFactory().getCurrentSession();
		sessionHib.beginTransaction();
		Personne personne = (Personne) sessionHib.load(Personne.class, idPersonne);
		Exemplaire e = (Exemplaire) sessionHib.load(Exemplaire.class, codeExemplaire);
		e.setDisponible(false);
		//personne.getExemplaires().add(e);
		e.getPersonnes().add(personne);
		sessionHib.getTransaction().commit();
		
		/*List<Object> exs = ServiceMetier.getExemplaireDispo();
		
		for(Object ee : exs) {
			Exemplaire e1 = (Exemplaire) ee;
		}*/
		
		
		
		
		
		return true;
		
	}
	
	
	
}
