<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>firstPageAnnuaire</title>
		<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" /> 
		 <script src="jquery-1.12.2.min.js"></script>
		  
 </head>
    <body>
    <fieldset>
        <form method="post" action="firstPageClient2">
                <legend>Bienvenue dans l'annuaire d'annonce</legend>
                <p>Vous pouvez rechercher vos annonces par adresse, catégorie ou par nom:  </p>
                <br />
			
 				 <input type="radio" name="rechercheType" onclick="handleClick(this)" value="adresse" > Adresse<br>
				 <input type="radio" name="rechercheType" onclick="handleClick(this)" value="categorie"> Catégorie<br>
				 <input type="radio" name="rechercheType" onclick="handleClick(this)" value="nom"> Nom<br>
				 
                <br />
                <div id="mySelectCategorie">
                	hahahaha
                                <SELECT name="Categorie" maxlength="20">
       				 <c:forEach var="categorie" items="${listeCat}">

             			     <option value="${categorie.name}">${categorie.name}</option>

        				</c:forEach>

							</SELECT>
                </div>
                <div id="mySelectAdresse">
                               <SELECT name="Adresse" maxlength="20">
       				 <c:forEach var="adresse" items="${listeAdr}">

             			     <option value="${adresse.idAdresse}">${adresse.rue}  ${adresse.ville} ${adresse.cp}</option>

        				</c:forEach>

							</SELECT>              
							  </div>
                                <div id="mySelectNom">
                                <SELECT name="Nom" maxlength="20">
       				 <c:forEach var="annonce" items="${listeAnn}">

             			     <option value="${annonce.name}">${annonce.name}</option>

        				</c:forEach>

							</SELECT>                </div>
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                				 <br />
                
                <input type="submit" value="chercher" class="sansLabel" />
        </form>


        
        </fieldset>
        
              <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Annonce ID</th>
            <th>Annonce Name</th>
             <th>Category ID</th>
                    <th>Adresse ID</th>
                      <th>Tel</th>
        
        </tr>
 
        <c:forEach var="annonce" items="${listeAnn}">
            <tr>
                <td>${annonce.id}</td>
                <td>${annonce.name}</td>
                <td>${annonce.category}</td>
                <td>${annonce.idAdresse}</td>
                <td>${annonce.tel}</td>

        </c:forEach>
    </table>
        
        
        <script>
        document.getElementById('mySelectCategorie').style.visibility='hidden';
        document.getElementById('mySelectAdresse').style.visibility='hidden';
        document.getElementById('mySelectNom').style.visibility='hidden';

        function handleClick(myRadio) {

            if(myRadio.value == "categorie"){

                document.getElementById('mySelectCategorie').style.visibility='visible';
            }else{
                document.getElementById('mySelectCategorie').style.visibility='hidden';

            }
            
            if(myRadio.value == "adresse"){
                document.getElementById('mySelectAdresse').style.visibility='visible';
            }else{
                document.getElementById('mySelectAdresse').style.visibility='hidden';

            }
            
            if(myRadio.value == "nom"){
                document.getElementById('mySelectNom').style.visibility='visible';
            }else{
                document.getElementById('mySelectNom').style.visibility='hidden';

            }
            }
        
        </script>
        
    </body>
</html>