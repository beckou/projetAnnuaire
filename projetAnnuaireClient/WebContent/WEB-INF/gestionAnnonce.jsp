<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  

    <fieldset>
        <form method="get" action="createAnnonce">
                <legend>Bienvenue dans la gestion des Annonces</legend>
                <p>Voici vos actions possibles:  </p>

                <br />

                <input type="submit" value="creerAnnonce" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>
        
        </fieldset>
        
         <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Annonce ID</th>
            <th>Annonce Name</th>
             <th>Category ID</th>
                    <th>Adresse ID</th>
                      <th>Tel</th>
          
            <th>Action</th>

        </tr>
 
        <c:forEach var="annonce" items="${listeAnn}">
            <tr>
                <td>${annonce.id}</td>
                <td>${annonce.name}</td>
                <td>${annonce.nameCategorie}</td>
                <td>${annonce.idAdresse}</td>
                <td>${annonce.tel}</td>
            	<td>        <form method="get" action="modifAnnonce">
            	<button type="submit" name="questID" value="${annonce.id}">Modifier Annonce</button></form>
            	<form method="post" action="gestionAnnonce">
            	<button type="submit" name="questID" value="${annonce.id}">Supprimer Annonce</button></form>
            	</td>
            </tr>
        </c:forEach>
    </table>
    
        
</body>
</html>