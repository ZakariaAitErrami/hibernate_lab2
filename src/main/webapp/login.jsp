<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'autentification</title>
</head>
<body>
	<FORM action = "Service" method ="post">
     <TABLE>
		<TR>
			<TD> <b>Login </b>  </TD>
			<TD> <input type="text"  name="cne"    style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Mot de passe </b>  </TD>
			<TD> <input type="text"  name="motPasse"   style="width:300px"> </TD>
		</TR>
		
		<TR> 
			<TD  colspan =2 align=center >
			<INPUT type ="submit" name="login" value="OK"> 
			<a href="inscription.jsp">S'inscrire ... </a>
			</TD>
		</TR>
	</TABLE>
	
  </FORM>
   <% session.setAttribute("page", "login");
	   String erreur= (String) request.getAttribute("erreur");
	   if (erreur!=null ){
			out.print(erreur);
	   }
  %>
</body>
</html>
