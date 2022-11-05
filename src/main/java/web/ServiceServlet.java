package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import metier.*;


@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ServiceServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().setAttribute("user", null);
		getServletContext().getRequestDispatcher("/login.jsp").forward(request,  response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session= request.getSession();
	    
	    String page= (String) session.getAttribute("page");
	    
	    Etudiant etudiant=null; 
	    
	    if(page.equals("inscription")) {
	    	String cne = request.getParameter("cne");
	    	
	    	try {
	    		etudiant = ServiceMetier.getEtudiant(cne);
	    		doGet(request,response);
	    	} catch(Exception e) {
	    		request.setAttribute("error", "An error");
	    		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	    	}
	    	
	    	
	    	if(etudiant==null) {
	    		Etudiant e2=new Etudiant();
	    		e2.setCne(cne);
	    		e2.setNom(request.getParameter("nom"));
	    		e2.setPrenom(request.getParameter("prenom"));
	    		e2.setMotPasse(request.getParameter("motPasse"));
	    		
	    		try {
	    			ServiceMetier.addEtudiant(e2);
	    			doGet(request,response);
	    		} catch(Exception e) {
	    			request.setAttribute("error", "An error");
		    		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	    		}
	    	
	    	} else {
	    		request.setAttribute("error", "CNE already exists (An account is already created with this CNE)");
	    		getServletContext().getRequestDispatcher("/inscription.jsp").forward(request, response);
	    	}
	    
	    	
	    }
	    
	    else
	    if(page.equals("login")) {
	    	etudiant=null;
	    	String cne=request.getParameter("cne");
	    	String motPasse=request.getParameter("motPasse");
	    	try {
	    		etudiant = ServiceMetier.getEtudiant(cne, motPasse);
	    	} catch (Exception e) {
	    		request.setAttribute("error", "An error: " + e.getMessage());
	    		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	    	}
	    	if(etudiant!=null) {
	    		session.setAttribute("user", etudiant);
	    		getServletContext().getRequestDispatcher("/ConsultDisponible.jsp").forward(request, response);
	    	}
	    	
	    	else {
	    		request.setAttribute("error", "Login or Password is incorrect");
	    		getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	    	}
	    }
	    
	    else
	    if(page.equals("AjoutEmprunt")) {
	    	Etudiant et = (Etudiant) session.getAttribute("user");
	    	String code = request.getParameter("code");
	    	try {
	    		ServiceMetier.addEmprunt(et.getId(), code);
	    		getServletContext().getRequestDispatcher("/AjoutEmprunt.jsp").forward(request, response);
	    	} catch (Exception e) {
	    		request.setAttribute("error", "Error ajout emprunt");
	    		getServletContext().getRequestDispatcher("/AjoutEmprunt.jsp").forward(request, response);
	    	}
	    	
	    }
	    
	}

}
