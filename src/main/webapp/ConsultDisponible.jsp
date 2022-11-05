<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, metier.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire de consultation<</title>
<link rel="stylesheet" type="text/css" href="Style.css" />
<link rel="stylesheet" type="text/css" href="Style2.css" />
</head>
<body>
<h1>Consultation des exemplaires disponibles</h1>
<% List<Object> exs =  ServiceMetier.getExemplaireDispo();
   Iterator it = exs.iterator();
	
	Etudiant e = (Etudiant) session.getAttribute("user"); %>
	
	<p style="text-align:right"> <b>Nom: </b> <%= e.getNom() %> <br> <a href="./login.jsp">	Se deconnecter ... </a>  </p>
	
	<%if(exs.size()>0) { %>
		<TABLE>
			<tr>
				<th>Code</th>
				<th>Titre</th>
			</tr>
			<%  while(it.hasNext()) {%>	
				<%Object obj[] = (Object[])it.next();%>
				<tr>
					<td><%= obj[0] %></td>
					<td><%= obj[1] %></td>
				</tr>
			<%} %>		
		
		</TABLE>
		
	<%} else { %>
		<p>Aucune Exemplaire </p>
	<%} %>
	<BR><BR>
		<a href="AjoutEmprunt.jsp">Emprunter un exemplaire de livre... </a>
	<% session.setAttribute("page", "AjoutEmprunt");
	   String erreur= (String) request.getAttribute("error");
	   if (erreur!=null ){
			out.print(erreur);
	   }
  %>
</body>
</html>