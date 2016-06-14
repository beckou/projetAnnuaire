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
        String newCategory_1id=  request.getParameter("newCategory16");
            java.lang.String newCategory_1idTemp = null;
        if(!newCategory_1id.equals("")){
         newCategory_1idTemp  = newCategory_1id;
        }
        sampleAnnuaireProxyid.createCategory(newCategory_1idTemp);
break;
case 18:
        gotMethod = true;
        String annonce_id_2id=  request.getParameter("annonce_id21");
        int annonce_id_2idTemp  = Integer.parseInt(annonce_id_2id);
        sampleAnnuaireProxyid.delAnnonce(annonce_id_2idTemp);
break;
case 23:
        gotMethod = true;
        String categorie_id_3id=  request.getParameter("categorie_id26");
        int categorie_id_3idTemp  = Integer.parseInt(categorie_id_3id);
        java.lang.String getCategorie23mtemp = sampleAnnuaireProxyid.getCategorie(categorie_id_3idTemp);
if(getCategorie23mtemp == null){
%>
<%=getCategorie23mtemp %>
<%
}else{
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorie23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
}
break;
case 28:
        gotMethod = true;
        java.lang.String viewAllCategories28mtemp = sampleAnnuaireProxyid.viewAllCategories();
if(viewAllCategories28mtemp == null){
%>
<%=viewAllCategories28mtemp %>
<%
}else{
        String tempResultreturnp29 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllCategories28mtemp));
        %>
        <%= tempResultreturnp29 %>
        <%
}
break;
case 31:
        gotMethod = true;
        java.lang.String viewAllAnnonce31mtemp = sampleAnnuaireProxyid.viewAllAnnonce();
if(viewAllAnnonce31mtemp == null){
%>
<%=viewAllAnnonce31mtemp %>
<%
}else{
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonce31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
}
break;
case 34:
        gotMethod = true;
        String idCat_4id=  request.getParameter("idCat37");
        long idCat_4idTemp  = Long.parseLong(idCat_4id);
        java.lang.String viewAllAnnonceByCat34mtemp = sampleAnnuaireProxyid.viewAllAnnonceByCat(idCat_4idTemp);
if(viewAllAnnonceByCat34mtemp == null){
%>
<%=viewAllAnnonceByCat34mtemp %>
<%
}else{
        String tempResultreturnp35 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByCat34mtemp));
        %>
        <%= tempResultreturnp35 %>
        <%
}
break;
case 39:
        gotMethod = true;
        String idAdr_5id=  request.getParameter("idAdr42");
        long idAdr_5idTemp  = Long.parseLong(idAdr_5id);
        java.lang.String viewAllAnnonceByAdr39mtemp = sampleAnnuaireProxyid.viewAllAnnonceByAdr(idAdr_5idTemp);
if(viewAllAnnonceByAdr39mtemp == null){
%>
<%=viewAllAnnonceByAdr39mtemp %>
<%
}else{
        String tempResultreturnp40 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByAdr39mtemp));
        %>
        <%= tempResultreturnp40 %>
        <%
}
break;
case 44:
        gotMethod = true;
        String nom_6id=  request.getParameter("nom47");
            java.lang.String nom_6idTemp = null;
        if(!nom_6id.equals("")){
         nom_6idTemp  = nom_6id;
        }
        String idCat_7id=  request.getParameter("idCat49");
        int idCat_7idTemp  = Integer.parseInt(idCat_7id);
        String telephone_8id=  request.getParameter("telephone51");
            java.lang.String telephone_8idTemp = null;
        if(!telephone_8id.equals("")){
         telephone_8idTemp  = telephone_8id;
        }
        String idAdresse_9id=  request.getParameter("idAdresse53");
        long idAdresse_9idTemp  = Long.parseLong(idAdresse_9id);
        sampleAnnuaireProxyid.createAnnonce(nom_6idTemp,idCat_7idTemp,telephone_8idTemp,idAdresse_9idTemp);
break;
case 55:
        gotMethod = true;
        String rue_10id=  request.getParameter("rue58");
            java.lang.String rue_10idTemp = null;
        if(!rue_10id.equals("")){
         rue_10idTemp  = rue_10id;
        }
        String ville_11id=  request.getParameter("ville60");
            java.lang.String ville_11idTemp = null;
        if(!ville_11id.equals("")){
         ville_11idTemp  = ville_11id;
        }
        String cp_12id=  request.getParameter("cp62");
            java.lang.String cp_12idTemp = null;
        if(!cp_12id.equals("")){
         cp_12idTemp  = cp_12id;
        }
        java.lang.String getAdresseByString55mtemp = sampleAnnuaireProxyid.getAdresseByString(rue_10idTemp,ville_11idTemp,cp_12idTemp);
if(getAdresseByString55mtemp == null){
%>
<%=getAdresseByString55mtemp %>
<%
}else{
        String tempResultreturnp56 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getAdresseByString55mtemp));
        %>
        <%= tempResultreturnp56 %>
        <%
}
break;
case 64:
        gotMethod = true;
        String categorie_id_13id=  request.getParameter("categorie_id67");
        int categorie_id_13idTemp  = Integer.parseInt(categorie_id_13id);
        sampleAnnuaireProxyid.delCategorie(categorie_id_13idTemp);
break;
case 69:
        gotMethod = true;
        String categorie_id_14id=  request.getParameter("categorie_id72");
        int categorie_id_14idTemp  = Integer.parseInt(categorie_id_14id);
        String nouveau_nom_15id=  request.getParameter("nouveau_nom74");
            java.lang.String nouveau_nom_15idTemp = null;
        if(!nouveau_nom_15id.equals("")){
         nouveau_nom_15idTemp  = nouveau_nom_15id;
        }
        sampleAnnuaireProxyid.modifyCategorie(categorie_id_14idTemp,nouveau_nom_15idTemp);
break;
case 76:
        gotMethod = true;
        String categorie_id_16id=  request.getParameter("categorie_id79");
            java.lang.String categorie_id_16idTemp = null;
        if(!categorie_id_16id.equals("")){
         categorie_id_16idTemp  = categorie_id_16id;
        }
        java.lang.String getCategorieByString76mtemp = sampleAnnuaireProxyid.getCategorieByString(categorie_id_16idTemp);
if(getCategorieByString76mtemp == null){
%>
<%=getCategorieByString76mtemp %>
<%
}else{
        String tempResultreturnp77 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorieByString76mtemp));
        %>
        <%= tempResultreturnp77 %>
        <%
}
break;
case 81:
        gotMethod = true;
        String rue_17id=  request.getParameter("rue84");
            java.lang.String rue_17idTemp = null;
        if(!rue_17id.equals("")){
         rue_17idTemp  = rue_17id;
        }
        String ville_18id=  request.getParameter("ville86");
            java.lang.String ville_18idTemp = null;
        if(!ville_18id.equals("")){
         ville_18idTemp  = ville_18id;
        }
        String cp_19id=  request.getParameter("cp88");
            java.lang.String cp_19idTemp = null;
        if(!cp_19id.equals("")){
         cp_19idTemp  = cp_19id;
        }
        sampleAnnuaireProxyid.createAdresse(rue_17idTemp,ville_18idTemp,cp_19idTemp);
break;
case 90:
        gotMethod = true;
        String val1_20id=  request.getParameter("val193");
        int val1_20idTemp  = Integer.parseInt(val1_20id);
        String val2_21id=  request.getParameter("val295");
        int val2_21idTemp  = Integer.parseInt(val2_21id);
        int add90mtemp = sampleAnnuaireProxyid.add(val1_20idTemp,val2_21idTemp);
        String tempResultreturnp91 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add90mtemp));
        %>
        <%= tempResultreturnp91 %>
        <%
break;
case 97:
        gotMethod = true;
        String nom_22id=  request.getParameter("nom100");
            java.lang.String nom_22idTemp = null;
        if(!nom_22id.equals("")){
         nom_22idTemp  = nom_22id;
        }
        java.lang.String viewAllAnnonceByNom97mtemp = sampleAnnuaireProxyid.viewAllAnnonceByNom(nom_22idTemp);
if(viewAllAnnonceByNom97mtemp == null){
%>
<%=viewAllAnnonceByNom97mtemp %>
<%
}else{
        String tempResultreturnp98 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllAnnonceByNom97mtemp));
        %>
        <%= tempResultreturnp98 %>
        <%
}
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