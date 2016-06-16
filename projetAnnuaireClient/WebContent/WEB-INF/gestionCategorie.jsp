<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>gestionCategorie</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />   

</head>
<body>  

    <fieldset>
        <form method="get" action="createCategorie">
                <legend>Bienvenue dans la gestion des Categories</legend>
                <p>Voici vos actions possibles:  </p>

                <br />

                <input type="submit" value="creerCategorie" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>
        
        </fieldset>
        
         <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Cat ID</th>
            <th>Cat Name</th>
            <th>Action</th>

        </tr>
 
        <c:forEach var="categorie" items="${listeCat}">
            <tr>
                <td>${categorie.id}</td>
                <td>${categorie.name}</td>
            	<td>        <form method="get" action="modifCategorie">
            	<button type="submit" name="questID" value="${categorie.id}">Modifier Categorie</button></form>
            	<form method="post" action="gestionCategorie">
            	<button type="submit" name="questID" value="${categorie.id}">Supprimer Categorie</button></form>
            	</td>
            </tr>
        </c:forEach>
    </table>
    
        
</body>
</html>