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
        String categorie_id_2id=  request.getParameter("categorie_id21");
            java.lang.String categorie_id_2idTemp = null;
        if(!categorie_id_2id.equals("")){
         categorie_id_2idTemp  = categorie_id_2id;
        }
        java.lang.String getCategorieByString18mtemp = sampleAnnuaireProxyid.getCategorieByString(categorie_id_2idTemp);
if(getCategorieByString18mtemp == null){
%>
<%=getCategorieByString18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorieByString18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
}
break;
case 23:
        gotMethod = true;
        String categorie_id_3id=  request.getParameter("categorie_id26");
        int categorie_id_3idTemp  = Integer.parseInt(categorie_id_3id);
        sampleAnnuaireProxyid.delCategorie(categorie_id_3idTemp);
break;
case 28:
        gotMethod = true;
        String categorie_id_4id=  request.getParameter("categorie_id31");
        int categorie_id_4idTemp  = Integer.parseInt(categorie_id_4id);
        String nouveau_nom_5id=  request.getParameter("nouveau_nom33");
            java.lang.String nouveau_nom_5idTemp = null;
        if(!nouveau_nom_5id.equals("")){
         nouveau_nom_5idTemp  = nouveau_nom_5id;
        }
        sampleAnnuaireProxyid.modifyCategorie(categorie_id_4idTemp,nouveau_nom_5idTemp);
break;
case 35:
        gotMethod = true;
        java.lang.String viewAllCategories35mtemp = sampleAnnuaireProxyid.viewAllCategories();
if(viewAllCategories35mtemp == null){
%>
<%=viewAllCategories35mtemp %>
<%
}else{
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllCategories35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
}
break;
case 38:
        gotMethod = true;
        String categorie_id_6id=  request.getParameter("categorie_id41");
        int categorie_id_6idTemp  = Integer.parseInt(categorie_id_6id);
        java.lang.String getCategorie38mtemp = sampleAnnuaireProxyid.getCategorie(categorie_id_6idTemp);
if(getCategorie38mtemp == null){
%>
<%=getCategorie38mtemp %>
<%
}else{
        String tempResultreturnp39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorie38mtemp));
        %>
        <%= tempResultreturnp39 %>
        <%
}
break;
case 43:
        gotMethod = true;
        String val1_7id=  request.getParameter("val146");
        int val1_7idTemp  = Integer.parseInt(val1_7id);
        String val2_8id=  request.getParameter("val248");
        int val2_8idTemp  = Integer.parseInt(val2_8id);
        int add43mtemp = sampleAnnuaireProxyid.add(val1_7idTemp,val2_8idTemp);
        String tempResultreturnp44 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add43mtemp));
        %>
        <%= tempResultreturnp44 %>
        <%
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