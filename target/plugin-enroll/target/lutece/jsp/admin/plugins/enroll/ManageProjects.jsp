<jsp:useBean id="manageenrollProject" scope="session" class="fr.paris.lutece.plugins.enroll.web.ProjectJspBean" />
<% String strContent = manageenrollProject.processController ( request , response ); %>

<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />

<%= strContent %>

<%@ include file="../../AdminFooter.jsp" %>
