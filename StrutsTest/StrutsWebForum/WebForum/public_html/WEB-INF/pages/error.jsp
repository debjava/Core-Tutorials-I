<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : error.jsp
 | Author       : John Topley
 | Description  : Error page.
 +--%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>
<bean:message key="app.doctype" />
<html:html locale="true" xhtml="true">
  <head>
    <bean:message key="app.content.language" />
    <bean:message key="app.content.type" />
    <link rel="stylesheet" type="text/css"
      href="<html:rewrite page="/assets/css/webforum.css" />" />
    <title>
      <bean:message key="error.title" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>    
    <h2><bean:message key="error.heading" /></h2>
    <p>
      <bean:message key="error.text" />
    </p>
    <h2><bean:message key="error.error.message" /></h2>
    <bean:define id="exception" name="org.apache.struts.action.EXCEPTION"
      type="java.lang.Throwable" />
    <p>
      <bean:write name="exception" />
    </p>
    <h2><bean:message key="error.error.details" /></h2>
    <p id="errordetails">
      <% exception.printStackTrace(new java.io.PrintWriter(out)); %>
    </p>
  </body>
</html:html>