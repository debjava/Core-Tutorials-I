<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : topics.jsp
 | Author       : John Topley
 | Description  : Topics page.
 +--%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<bean:message key="app.doctype" />
<html:html locale="true" xhtml="true">
  <head>
    <bean:message key="app.content.language" />
    <bean:message key="app.content.type" />
    <link rel="stylesheet" type="text/css"
      href="<html:rewrite page="/assets/css/webforum.css" />" />
    <title>
      <bean:message key="topics.title" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>
    <h2><bean:message key="topics.title" /></h2>    
    <table border="1" cellpadding="2" cellspacing="0"
      summary="<bean:message key="topics.table.summary" />">
      <thead>
        <tr>
          <th><bean:message key="topics.heading.column1" /></th>
          <th><bean:message key="topics.heading.column2" /></th>
          <th><bean:message key="topics.heading.column3" /></th>
          <th><bean:message key="topics.heading.column4" /></th>
        </tr>
      </thead>
      <tbody>

        <%--
         | Because each topic link has multiple URL parameters, we need to
         | create a bean containing a Map of the parameters that the html:link
         | tag can use.
         +--%>
        <jsp:useBean id="params" class="java.util.HashMap" scope="page" />
        <logic:notEmpty name="com.johntopley.webforum.postlist" property="posts">
          <logic:iterate id="topic" name="com.johntopley.webforum.postlist"
            type="com.johntopley.webforum.model.Post"
            property="posts" length="16">
            <%
              params.put("r", topic.getReplyCount());            
              params.put("pid", topic.getPostID());
             %>
            <tr>
              <td class="topics">                
                <html:link forward="ViewTopic" name="params">
                  <bean:write name="topic" property="subject" filter="true" />
                </html:link>
              </td>
              <td class="replies">
                <bean:write name="topic" property="replyCount" />
              </td>
              <td class="author">
                <bean:write name="topic" property="author" />
              </td>
              <td class="posted">
                <bean:write name="topic" property="timestamp"
                  formatKey="app.date.format" />
              </td>
            </tr>
          </logic:iterate>
        </logic:notEmpty>
        <logic:empty name="com.johntopley.webforum.postlist" property="posts">
          <tr>
            <td class="topics">
              <bean:message key="topics.notopics" />
            </td>
            <td class="replies"></td>
            <td class="author"></td>
            <td class="posted"></td>
          </tr>
        </logic:empty>
      </tbody>
    </table>
    <logic:present name="com.johntopley.webforum.user">

      <%--
       | We need to look up the logged in user's forenames and store them in a
       | bean because you can't use a tag as a parameter to another tag.
       +--%>    
      <bean:define id="forenames">
        <bean:write name="com.johntopley.webforum.user" property="forenames" />
      </bean:define>
      <p id="welcomemessage">
        <bean:message key="app.user.welcome" arg0="<%=forenames%>" />
        <html:link forward="Logout">
          <bean:message key="app.logout" />
        </html:link>
      </p>
      <p>
        <bean:message key="app.bullet" /><html:link forward="NewTopic">
          <bean:message key="topics.newtopic" />
        </html:link>
      </p>
    </logic:present>
    <logic:notPresent name="com.johntopley.webforum.user">
      <p id="welcomemessage">
        <bean:message key="topics.guest.welcome.1" />
        <html:link forward="Register">
          <bean:message key="topics.guest.welcome.2" />
        </html:link>
        <bean:message key="topics.guest.welcome.3" />
        <html:link forward="Login">
          <bean:message key="topics.guest.welcome.4" />
        </html:link>
        <bean:message key="topics.guest.welcome.5" />
      </p>
    </logic:notPresent>       
  </body>
</html:html>