<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'inscription</title>
</head>
<body>
  <FORM action = "Service" method ="post">
     <TABLE>
		<TR>
			<TD> <b>CNE</b>  </TD>
			<TD> <input type="text"  name="cne" style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Nom</b>  </TD>
			<TD> <input type="text"  name="nom"    style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Prenom </b>  </TD>
			<TD> <input type="text"  name="prenom"   style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Mot de Passe </b>  </TD>
			<TD> <input type="text"  name="motPasse"   style="width:300px"> </TD>
		</TR>
		<TR> 
			<TD colspan =2 align=center >
			<INPUT type ="submit" name="Valider" value="valider"> 
			</TD>
		</TR>
	</TABLE>
	<a href="login.jsp">Back to login page</a>
    </FORM>
    
    <% session.setAttribute("page", "inscription"); 
	   String erreur= (String) request.getAttribute("error");
	   if (erreur!=null ){
	        	out.print(erreur);
	   }
    %>	
</body>
</html>
