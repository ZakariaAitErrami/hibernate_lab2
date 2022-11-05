<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, metier.*" %>
    
<!DOCTYPE html>
<html>
<head>

<title>Formulaire d'ajout d'emprunt</title>
</head>
<body>

	<% Etudiant user=(Etudiant) session.getAttribute("user"); 
	List<String> listCodes= new ArrayList<String>(); 
	listCodes = ServiceMetier.getCodeExemplaireDispo();%>
	
	<p style="text-align:right"> <b>Nom: </b> <%= user.getNom() %> <br> <a href="login.jsp">	Se deconnecter ... </a>  </p>
	<form action="Service" method="post">
		<TABLE >
		<TR>
			<TD> <b>CNE </b>  </TD>
			<TD> <input type="text"  name="CNE" disabled value=<%=user.getCne() %> style="width:300px"/> </TD>
		</TR>
		<TR>
			<TD> <b>Code Exemplaire </b>  </TD>
			<TD>
			<select name="code">
			<% for(String code : listCodes){%>
			<option><%=code %></option>
			<% }%>
			</select>
			</TD>
		</TR>
		<TR><td colspan="2"> <input type="submit" value="Valider" name="valider"></td> </TR>
	</TABLE>
	</form>
	<BR><BR>
		<a href="ConsultDisponible.jsp">Consulter les exemplaires disponible... </a>
     <% session.setAttribute("page", "AjoutEmprunt");  %>
     <%
	   String erreur= (String) request.getAttribute("error");
	   if (erreur!=null ){
			out.print(erreur);
	   }
  %>
</body>
</html>