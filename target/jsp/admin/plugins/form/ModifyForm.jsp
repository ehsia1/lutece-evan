<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />
<jsp:useBean id="formForm" scope="session" class="fr.paris.lutece.plugins.form.web.FormEntryJspBean" />
<% formForm.init( request,formForm.RIGHT_MANAGE_FORM ); %>
<%= formForm.getModifyForm( request ) %>

<%@ include file="../../AdminFooter.jsp" %>