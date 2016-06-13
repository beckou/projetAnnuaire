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
        String categorie_id_1id=  request.getParameter("categorie_id16");
        int categorie_id_1idTemp  = Integer.parseInt(categorie_id_1id);
        sampleAnnuaireProxyid.delCategorie(categorie_id_1idTemp);
break;
case 18:
        gotMethod = true;
        java.lang.String viewAllCategories18mtemp = sampleAnnuaireProxyid.viewAllCategories();
if(viewAllCategories18mtemp == null){
%>
<%=viewAllCategories18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(viewAllCategories18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
}
break;
case 21:
        gotMethod = true;
        String categorie_id_2id=  request.getParameter("categorie_id24");
        int categorie_id_2idTemp  = Integer.parseInt(categorie_id_2id);
        java.lang.String getCategorie21mtemp = sampleAnnuaireProxyid.getCategorie(categorie_id_2idTemp);
if(getCategorie21mtemp == null){
%>
<%=getCategorie21mtemp %>
<%
}else{
        String tempResultreturnp22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getCategorie21mtemp));
        %>
        <%= tempResultreturnp22 %>
        <%
}
break;
case 26:
        gotMethod = true;
        String newCategory_3id=  request.getParameter("newCategory29");
            java.lang.String newCategory_3idTemp = null;
        if(!newCategory_3id.equals("")){
         newCategory_3idTemp  = newCategory_3id;
        }
        sampleAnnuaireProxyid.createCategory(newCategory_3idTemp);
break;
case 31:
        gotMethod = true;
        String val1_4id=  request.getParameter("val134");
        int val1_4idTemp  = Integer.parseInt(val1_4id);
        String val2_5id=  request.getParameter("val236");
        int val2_5idTemp  = Integer.parseInt(val2_5id);
        int add31mtemp = sampleAnnuaireProxyid.add(val1_4idTemp,val2_5idTemp);
        String tempResultreturnp32 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(add31mtemp));
        %>
        <%= tempResultreturnp32 %>
        <%
break;
case 38:
        gotMethod = true;
        String categorie_id_6id=  request.getParameter("categorie_id41");
        int categorie_id_6idTemp  = Integer.parseInt(categorie_id_6id);
        String nouveau_nom_7id=  request.getParameter("nouveau_nom43");
            java.lang.String nouveau_nom_7idTemp = null;
        if(!nouveau_nom_7id.equals("")){
         nouveau_nom_7idTemp  = nouveau_nom_7id;
        }
        sampleAnnuaireProxyid.modifyCategorie(categorie_id_6idTemp,nouveau_nom_7idTemp);
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