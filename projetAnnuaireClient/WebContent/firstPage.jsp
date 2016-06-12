<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>firstPage</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />   
 </head>
    <body>
    <fieldset>
        <form method="get" action="CreateCategorie">
                <legend>Bienvenue dans la gestion de l'annuaire</legend>
                <p>Voici vos actions possibles: </p>

           
                <br />

                <input type="submit" value="Créer une catégorie" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>
        <form method="get" action="CreateAnnonce">
             
                <br />

                <input type="submit" value="Créer une annonce" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>

        
        </fieldset>
    </body>
</html>