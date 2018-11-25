<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html
 | Project      : Web Forum
 | File         : index.jsp
 | Author       : John Topley
 | Description  : Index page.
 +--%>
<%--  
 | Forward to the "ViewTopics" Struts Global ActionForward. The only reason
 | this page exists is to allow our web.xml file to declare a welcome-file
 | which allows the unqualified URL of http://<servername>/webforum/
 | to start the application.
 +--%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@ page session="false" %>
<logic:redirect forward="ViewTopics" />