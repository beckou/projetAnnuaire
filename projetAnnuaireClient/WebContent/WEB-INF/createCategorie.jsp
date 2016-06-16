<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CreateCategorie</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />   

</head>
<body>   

 <fieldset>
        <form method="post" action="createCategorie">
                <legend>Bienvenue dans la gestion de l'annuaire</legend>
                <p>Voici vos actions possibles:  </p>

                           <label for="nomCat">Nom Pour Votre Categorie</label>
                <input type="text" id="nomCat" name="nomCat" value="" size="20" maxlength="20" />
                <br />
                <br />

                <input type="submit" value="creerCategorie" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>
        
        </fieldset>
        
        </body>
</html>