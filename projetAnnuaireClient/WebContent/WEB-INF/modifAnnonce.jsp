<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>createAnnonce</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />   

</head>
<body>   

 <fieldset>
        <form method="post" action="modifAnnonce">
                <legend>Bienvenue dans la modification d'Annonce</legend>
                <p>Champs � modifier:  </p>

                           <label for="nomAnnonce">Nom Pour Votre Annonce</label>
                <input type="text" id="nomAnnonce" name="nomAnnonce" value="${monAnnonce.name}" size="20" maxlength="20" />             
                <br />
                           <label for="Categorie">Categorie Associee</label>

                <SELECT name="Categorie" maxlength="20">
        <c:forEach var="categorie" items="${listeCat}">

                  <option value="${categorie.id}">${categorie.name}</option>

        </c:forEach>

				</SELECT>
				
				                <br />
                                           <label for="telephone">votre Telephone</label>
                <input type="text" id="telephone" name="telephone" value="${monAnnonce.tel}" size="20" maxlength="20" />
                <br />
                Adresse : 
                <br />
                
                                                          <label for="rue">Rue</label>
                <input type="text" id="rue" name="rue" value="${monAdresse.rue}" size="20" maxlength="20" />
                <br />
                
                                                          <label for="ville">Ville</label>
                <input type="text" id="ville" name="ville" value="${monAdresse.ville}" size="20" maxlength="20" />
                <br />
                
                                                          <label for="cp">Code Postal</label>
                <input type="text" id="cp" name="cp" value="${monAdresse.cp}" size="20" maxlength="20" />
                <br />
                 				<input type="hidden" name="idAnn" value="${monAnnonce.id}">
                
                                 				<input type="hidden" name="idAdr" value="${monAnnonce.idAdresse}">
                
                
                <br />

                <input type="submit" value="creerAnnonce" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>
        
        </fieldset>
        
        </body>
</html>