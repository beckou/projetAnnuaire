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
			
 				 <input type="radio" name="rechercheType" onclick="handleClick(this)" value="adresse"  checked="checked" > Adresse<br>
				 <input type="radio" name="rechercheType" onclick="handleClick(this)" value="categorie"> Catégorie<br>
				 <input type="radio" name="rechercheType" onclick="handleClick(this)" value="nom"> Nom<br>
				 
                <br />
                
                
                <div id="mySelectCategorie">
                                <SELECT name="Categorie" maxlength="20">
       				 <c:forEach var="categorie" items="${listeCat}">

             			     <option value="${categorie.name}">${categorie.name}</option>

        				</c:forEach>

							</SELECT> <input name="b1" type="submit" value="chercher" class="sansLabel" />    
                </div>
                <div id="mySelectAdresse">
                               <SELECT name="Adresse" maxlength="20">
       				 <c:forEach var="adresse" items="${listeAdr}">

             			     <option value="${adresse.idAdresse}">${adresse.rue}  ${adresse.ville} ${adresse.cp}</option>

        				</c:forEach>

							</SELECT> <input name="b1" type="submit" value="chercher" class="sansLabel" />                  
							  </div>
                                <div id="mySelectNom">
                                <SELECT name="Nom" maxlength="20">
       				 <c:forEach var="annonce" items="${listeAnn}">

             			     <option value="${annonce.name}">${annonce.name}</option>

        				</c:forEach>

							</SELECT>           
							 <input name="b1" type="submit" value="chercher" class="sansLabel" />      </div>         
							
							
							<br>
                <input id="annonce" name="annonce" value="" size="20" maxlength="20" /> 							        
                 <input name="b1" type="submit" value="chercher2" class="sansLabel" />      </div>         
                
					 <br>
							
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                				 <br />
                
        </form>


        
        </fieldset>
        
              <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Annonce ID</th>
            <th>Annonce Name</th>
             <th>Categorie</th>
                    <th>Adresse ID</th>
                      <th>Tel</th>
        
        </tr>
 
        <c:forEach var="annonce" items="${listeAnn}">
            <tr>
                <td>${annonce.id}</td>
                <td>${annonce.name}</td>
                <td>${annonce.nameCategorie}</td>
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