<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ModifCategorie</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />   

</head>

<body>   

 <fieldset>
        <form method="post" action="modifCategorie">
                <legend>Bienvenue dans la gestion d'une Categorie</legend>
                <p>Voici vos actions possibles:  </p>

                           <label for="nomCat">Modifier le nom</label>
                <input type="text" id="nomCat" name="nomCat" value="${NomCat}" size="20" maxlength="20" />
                <br />
                <br />
 				<input type="hidden" name="idCat" value="${IdCat}">

                <input type="submit" value="modifCategorie" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
        </form>
        
        </fieldset>
        
        </body>
        
        </html>