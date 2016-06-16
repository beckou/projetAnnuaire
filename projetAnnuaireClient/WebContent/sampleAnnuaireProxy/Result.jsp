<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleAnnuaireProxyid" scope="session" class="service.AnnuaireProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleAnnuaireProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleAnnuaireProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleAnnuaireProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        service.Annuaire getAnnuaire10mtemp = sampleAnnuaireProxyid.getAnnuaire();
if(getAnnuaire10mtemp == null){
%>
<%=getAnnuaire10mtemp %>
<%
}else{
        if(getAnnuaire10mtemp!= null){
        String tempreturnp11 = getAnnuaire10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String val1_1id=  request.getParameter("val116");
        int val1_1idTemp  = Integer.parseInt(val1_1id);
        String val2_2id=  request.getParameter("val218");
        int val2_2idTemp  = Integer.parseInt(val2_2id);
        int add13mtemp = sampleAnnuaireProxyid.add(val1_1idTemp,val2_2idTemp);
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
break;
case 20:
        gotMethod = true;
        String newCategory_3id=  request.getParameter("newCategory23");
            java.lang.String newCategory_3idTemp = null;
        if(!newCategory_3id.equals("")){
         newCategory_3idTemp  = newCategory_3id;
        }
        sampleAnnuaireProxyid.createCategory(newCategory_3idTemp);
break;
case 25:
        gotMethod = true;
        String idCat_4id=  request.getParameter("idCat28");
        long idCat_4idTemp  = Long.parseLong(idCat_4id);
        java.lang.String viewAllAnnonceByCat25mtemp = sampleAnnuaireProxyid.viewAllAnnonceByCat(idCat_4idTemp);
if(viewAllAnnonceByCat25mtemp == null){
%>
<%=viewAllAnnonceByCat25mtemp %>
<%
}else{
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByCat25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
}
break;
case 30:
        gotMethod = true;
        String idAdr_5id=  request.getParameter("idAdr33");
        long idAdr_5idTemp  = Long.parseLong(idAdr_5id);
        java.lang.String viewAllAnnonceByAdr30mtemp = sampleAnnuaireProxyid.viewAllAnnonceByAdr(idAdr_5idTemp);
if(viewAllAnnonceByAdr30mtemp == null){
%>
<%=viewAllAnnonceByAdr30mtemp %>
<%
}else{
        String tempResultreturnp31 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByAdr30mtemp));
        %>
        <%= tempResultreturnp31 %>
        <%
}
break;
case 35:
        gotMethod = true;
        String nom_6id=  request.getParameter("nom38");
            java.lang.String nom_6idTemp = null;
        if(!nom_6id.equals("")){
         nom_6idTemp  = nom_6id;
        }
        java.lang.String viewAllAnnonceByNom35mtemp = sampleAnnuaireProxyid.viewAllAnnonceByNom(nom_6idTemp);
if(viewAllAnnonceByNom35mtemp == null){
%>
<%=viewAllAnnonceByNom35mtemp %>
<%
}else{
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByNom35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
}
break;
case 40:
        gotMethod = true;
        String categorie_id_7id=  request.getParameter("categorie_id43");
            java.lang.String categorie_id_7idTemp = null;
        if(!categorie_id_7id.equals("")){
         categorie_id_7idTemp  = categorie_id_7id;
        }
        java.lang.String getCategorieByString40mtemp = sampleAnnuaireProxyid.getCategorieByString(categorie_id_7idTemp);
if(getCategorieByString40mtemp == null){
%>
<%=getCategorieByString40mtemp %>
<%
}else{
        String tempResultreturnp41 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorieByString40mtemp));
        %>
        <%= tempResultreturnp41 %>
        <%
}
break;
case 45:
        gotMethod = true;
        String rue_8id=  request.getParameter("rue48");
            java.lang.String rue_8idTemp = null;
        if(!rue_8id.equals("")){
         rue_8idTemp  = rue_8id;
        }
        String ville_9id=  request.getParameter("ville50");
            java.lang.String ville_9idTemp = null;
        if(!ville_9id.equals("")){
         ville_9idTemp  = ville_9id;
        }
        String cp_10id=  request.getParameter("cp52");
            java.lang.String cp_10idTemp = null;
        if(!cp_10id.equals("")){
         cp_10idTemp  = cp_10id;
        }
        java.lang.String getAdresseByString45mtemp = sampleAnnuaireProxyid.getAdresseByString(rue_8idTemp,ville_9idTemp,cp_10idTemp);
if(getAdresseByString45mtemp == null){
%>
<%=getAdresseByString45mtemp %>
<%
}else{
        String tempResultreturnp46 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAdresseByString45mtemp));
        %>
        <%= tempResultreturnp46 %>
        <%
}
break;
case 54:
        gotMethod = true;
        java.lang.String viewAllCategories54mtemp = sampleAnnuaireProxyid.viewAllCategories();
if(viewAllCategories54mtemp == null){
%>
<%=viewAllCategories54mtemp %>
<%
}else{
        String tempResultreturnp55 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllCategories54mtemp));
        %>
        <%= tempResultreturnp55 %>
        <%
}
break;
case 57:
        gotMethod = true;
        String categorie_id_11id=  request.getParameter("categorie_id60");
        int categorie_id_11idTemp  = Integer.parseInt(categorie_id_11id);
        java.lang.String getCategorie57mtemp = sampleAnnuaireProxyid.getCategorie(categorie_id_11idTemp);
if(getCategorie57mtemp == null){
%>
<%=getCategorie57mtemp %>
<%
}else{
        String tempResultreturnp58 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorie57mtemp));
        %>
        <%= tempResultreturnp58 %>
        <%
}
break;
case 62:
        gotMethod = true;
        String rue_12id=  request.getParameter("rue65");
            java.lang.String rue_12idTemp = null;
        if(!rue_12id.equals("")){
         rue_12idTemp  = rue_12id;
        }
        String ville_13id=  request.getParameter("ville67");
            java.lang.String ville_13idTemp = null;
        if(!ville_13id.equals("")){
         ville_13idTemp  = ville_13id;
        }
        String cp_14id=  request.getParameter("cp69");
            java.lang.String cp_14idTemp = null;
        if(!cp_14id.equals("")){
         cp_14idTemp  = cp_14id;
        }
        sampleAnnuaireProxyid.createAdresse(rue_12idTemp,ville_13idTemp,cp_14idTemp);
break;
case 71:
        gotMethod = true;
        String categorie_id_15id=  request.getParameter("categorie_id74");
        int categorie_id_15idTemp  = Integer.parseInt(categorie_id_15id);
        sampleAnnuaireProxyid.delCategorie(categorie_id_15idTemp);
break;
case 76:
        gotMethod = true;
        String annonce_id_16id=  request.getParameter("annonce_id79");
        int annonce_id_16idTemp  = Integer.parseInt(annonce_id_16id);
        sampleAnnuaireProxyid.delAnnonce(annonce_id_16idTemp);
break;
case 81:
        gotMethod = true;
        java.lang.String viewAllAdresse81mtemp = sampleAnnuaireProxyid.viewAllAdresse();
if(viewAllAdresse81mtemp == null){
%>
<%=viewAllAdresse81mtemp %>
<%
}else{
        String tempResultreturnp82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAdresse81mtemp));
        %>
        <%= tempResultreturnp82 %>
        <%
}
break;
case 84:
        gotMethod = true;
        java.lang.String viewAllAnnonce84mtemp = sampleAnnuaireProxyid.viewAllAnnonce();
if(viewAllAnnonce84mtemp == null){
%>
<%=viewAllAnnonce84mtemp %>
<%
}else{
        String tempResultreturnp85 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonce84mtemp));
        %>
        <%= tempResultreturnp85 %>
        <%
}
break;
case 87:
        gotMethod = true;
        String nom_17id=  request.getParameter("nom90");
            java.lang.String nom_17idTemp = null;
        if(!nom_17id.equals("")){
         nom_17idTemp  = nom_17id;
        }
        String idCat_18id=  request.getParameter("idCat92");
        int idCat_18idTemp  = Integer.parseInt(idCat_18id);
        String telephone_19id=  request.getParameter("telephone94");
            java.lang.String telephone_19idTemp = null;
        if(!telephone_19id.equals("")){
         telephone_19idTemp  = telephone_19id;
        }
        String idAdresse_20id=  request.getParameter("idAdresse96");
        long idAdresse_20idTemp  = Long.parseLong(idAdresse_20id);
        sampleAnnuaireProxyid.createAnnonce(nom_17idTemp,idCat_18idTemp,telephone_19idTemp,idAdresse_20idTemp);
break;
case 98:
        gotMethod = true;
        String categorie_id_21id=  request.getParameter("categorie_id101");
        int categorie_id_21idTemp  = Integer.parseInt(categorie_id_21id);
        String nouveau_nom_22id=  request.getParameter("nouveau_nom103");
            java.lang.String nouveau_nom_22idTemp = null;
        if(!nouveau_nom_22id.equals("")){
         nouveau_nom_22idTemp  = nouveau_nom_22id;
        }
        sampleAnnuaireProxyid.modifyCategorie(categorie_id_21idTemp,nouveau_nom_22idTemp);
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>