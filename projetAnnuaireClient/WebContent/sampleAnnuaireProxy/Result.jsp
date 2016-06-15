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
        java.lang.String viewAllCategories25mtemp = sampleAnnuaireProxyid.viewAllCategories();
if(viewAllCategories25mtemp == null){
%>
<%=viewAllCategories25mtemp %>
<%
}else{
        String tempResultreturnp26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllCategories25mtemp));
        %>
        <%= tempResultreturnp26 %>
        <%
}
break;
case 28:
        gotMethod = true;
        String categorie_id_4id=  request.getParameter("categorie_id31");
            java.lang.String categorie_id_4idTemp = null;
        if(!categorie_id_4id.equals("")){
         categorie_id_4idTemp  = categorie_id_4id;
        }
        java.lang.String getCategorieByString28mtemp = sampleAnnuaireProxyid.getCategorieByString(categorie_id_4idTemp);
if(getCategorieByString28mtemp == null){
%>
<%=getCategorieByString28mtemp %>
<%
}else{
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorieByString28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
}
break;
case 33:
        gotMethod = true;
        String rue_5id=  request.getParameter("rue36");
            java.lang.String rue_5idTemp = null;
        if(!rue_5id.equals("")){
         rue_5idTemp  = rue_5id;
        }
        String ville_6id=  request.getParameter("ville38");
            java.lang.String ville_6idTemp = null;
        if(!ville_6id.equals("")){
         ville_6idTemp  = ville_6id;
        }
        String cp_7id=  request.getParameter("cp40");
            java.lang.String cp_7idTemp = null;
        if(!cp_7id.equals("")){
         cp_7idTemp  = cp_7id;
        }
        java.lang.String getAdresseByString33mtemp = sampleAnnuaireProxyid.getAdresseByString(rue_5idTemp,ville_6idTemp,cp_7idTemp);
if(getAdresseByString33mtemp == null){
%>
<%=getAdresseByString33mtemp %>
<%
}else{
        String tempResultreturnp34 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAdresseByString33mtemp));
        %>
        <%= tempResultreturnp34 %>
        <%
}
break;
case 42:
        gotMethod = true;
        String idAdr_8id=  request.getParameter("idAdr45");
        long idAdr_8idTemp  = Long.parseLong(idAdr_8id);
        java.lang.String viewAllAnnonceByAdr42mtemp = sampleAnnuaireProxyid.viewAllAnnonceByAdr(idAdr_8idTemp);
if(viewAllAnnonceByAdr42mtemp == null){
%>
<%=viewAllAnnonceByAdr42mtemp %>
<%
}else{
        String tempResultreturnp43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByAdr42mtemp));
        %>
        <%= tempResultreturnp43 %>
        <%
}
break;
case 47:
        gotMethod = true;
        String nom_9id=  request.getParameter("nom50");
            java.lang.String nom_9idTemp = null;
        if(!nom_9id.equals("")){
         nom_9idTemp  = nom_9id;
        }
        java.lang.String viewAllAnnonceByNom47mtemp = sampleAnnuaireProxyid.viewAllAnnonceByNom(nom_9idTemp);
if(viewAllAnnonceByNom47mtemp == null){
%>
<%=viewAllAnnonceByNom47mtemp %>
<%
}else{
        String tempResultreturnp48 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByNom47mtemp));
        %>
        <%= tempResultreturnp48 %>
        <%
}
break;
case 52:
        gotMethod = true;
        String idCat_10id=  request.getParameter("idCat55");
        long idCat_10idTemp  = Long.parseLong(idCat_10id);
        java.lang.String viewAllAnnonceByCat52mtemp = sampleAnnuaireProxyid.viewAllAnnonceByCat(idCat_10idTemp);
if(viewAllAnnonceByCat52mtemp == null){
%>
<%=viewAllAnnonceByCat52mtemp %>
<%
}else{
        String tempResultreturnp53 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByCat52mtemp));
        %>
        <%= tempResultreturnp53 %>
        <%
}
break;
case 57:
        gotMethod = true;
        String categorie_id_11id=  request.getParameter("categorie_id60");
        int categorie_id_11idTemp  = Integer.parseInt(categorie_id_11id);
        sampleAnnuaireProxyid.delCategorie(categorie_id_11idTemp);
break;
case 62:
        gotMethod = true;
        String categorie_id_12id=  request.getParameter("categorie_id65");
        int categorie_id_12idTemp  = Integer.parseInt(categorie_id_12id);
        String nouveau_nom_13id=  request.getParameter("nouveau_nom67");
            java.lang.String nouveau_nom_13idTemp = null;
        if(!nouveau_nom_13id.equals("")){
         nouveau_nom_13idTemp  = nouveau_nom_13id;
        }
        sampleAnnuaireProxyid.modifyCategorie(categorie_id_12idTemp,nouveau_nom_13idTemp);
break;
case 69:
        gotMethod = true;
        String rue_14id=  request.getParameter("rue72");
            java.lang.String rue_14idTemp = null;
        if(!rue_14id.equals("")){
         rue_14idTemp  = rue_14id;
        }
        String ville_15id=  request.getParameter("ville74");
            java.lang.String ville_15idTemp = null;
        if(!ville_15id.equals("")){
         ville_15idTemp  = ville_15id;
        }
        String cp_16id=  request.getParameter("cp76");
            java.lang.String cp_16idTemp = null;
        if(!cp_16id.equals("")){
         cp_16idTemp  = cp_16id;
        }
        sampleAnnuaireProxyid.createAdresse(rue_14idTemp,ville_15idTemp,cp_16idTemp);
break;
case 78:
        gotMethod = true;
        String categorie_id_17id=  request.getParameter("categorie_id81");
        int categorie_id_17idTemp  = Integer.parseInt(categorie_id_17id);
        java.lang.String getCategorie78mtemp = sampleAnnuaireProxyid.getCategorie(categorie_id_17idTemp);
if(getCategorie78mtemp == null){
%>
<%=getCategorie78mtemp %>
<%
}else{
        String tempResultreturnp79 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorie78mtemp));
        %>
        <%= tempResultreturnp79 %>
        <%
}
break;
case 83:
        gotMethod = true;
        java.lang.String viewAllAnnonce83mtemp = sampleAnnuaireProxyid.viewAllAnnonce();
if(viewAllAnnonce83mtemp == null){
%>
<%=viewAllAnnonce83mtemp %>
<%
}else{
        String tempResultreturnp84 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonce83mtemp));
        %>
        <%= tempResultreturnp84 %>
        <%
}
break;
case 86:
        gotMethod = true;
        String nom_18id=  request.getParameter("nom89");
            java.lang.String nom_18idTemp = null;
        if(!nom_18id.equals("")){
         nom_18idTemp  = nom_18id;
        }
        String idCat_19id=  request.getParameter("idCat91");
        int idCat_19idTemp  = Integer.parseInt(idCat_19id);
        String telephone_20id=  request.getParameter("telephone93");
            java.lang.String telephone_20idTemp = null;
        if(!telephone_20id.equals("")){
         telephone_20idTemp  = telephone_20id;
        }
        String idAdresse_21id=  request.getParameter("idAdresse95");
        long idAdresse_21idTemp  = Long.parseLong(idAdresse_21id);
        sampleAnnuaireProxyid.createAnnonce(nom_18idTemp,idCat_19idTemp,telephone_20idTemp,idAdresse_21idTemp);
break;
case 97:
        gotMethod = true;
        String annonce_id_22id=  request.getParameter("annonce_id100");
        int annonce_id_22idTemp  = Integer.parseInt(annonce_id_22id);
        sampleAnnuaireProxyid.delAnnonce(annonce_id_22idTemp);
break;
case 102:
        gotMethod = true;
        java.lang.String viewAllAdresse102mtemp = sampleAnnuaireProxyid.viewAllAdresse();
if(viewAllAdresse102mtemp == null){
%>
<%=viewAllAdresse102mtemp %>
<%
}else{
        String tempResultreturnp103 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAdresse102mtemp));
        %>
        <%= tempResultreturnp103 %>
        <%
}
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