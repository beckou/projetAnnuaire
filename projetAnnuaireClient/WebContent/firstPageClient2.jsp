<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>firstPageAnnuaire</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />   
 </head>
    <body>
    <fieldset>
        <form method="get" action="CreateCategorie">
                <legend>Bienvenue dans l'annuaire d'annonce</legend>
                <p>Vous pouvez rechercher vos annonces par adresse, catégorie ou par nom:  </p>
                <br />
			
 				 <input type="radio" name="rechercheType" value="adresse" checked> Adresse<br>
				 <input type="radio" name="rechercheType" value="categorie"> Catégorie<br>
				 <input type="radio" name="rechercheType" value="nom"> Nom<br>
				 
				 <br />
                <input type="text" name="recherche" value="recherche"> <input type="submit" value="chercher" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>


        
        </fieldset>
    </body>
</html>