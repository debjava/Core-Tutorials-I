<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : topic.jsp
 | Author       : John Topley
 | Description  : View Topic page.
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

    <%--
     | We need to look up the topic subject and store it in a bean because you
     | can't use a tag as a parameter to another tag.
     +--%>     
    <bean:define id="subject">
      <bean:write name="com.johntopley.webforum.postsubject" />
    </bean:define>
    <title>
      <bean:message key="topic.title" arg0="<%=subject%>" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>    
    <logic:iterate id="reply" name="com.johntopley.webforum.postlist"
      property="posts" length="1">
      <h2><bean:write name="reply" property="subject" filter="true" /></h2>
    </logic:iterate>    
    <table border="1" cellpadding="2" cellspacing="0"
      summary="<bean:message key="topic.table.summary" />">
      <thead>
        <tr>
          <th><bean:message key="topic.heading.column1" /></th>
          <th><bean:message key="topic.heading.column2" /></th>
        </tr>
      </thead>
      <tbody>
        <logic:iterate id="reply" name="com.johntopley.webforum.postlist"
          property="posts">
          <tr>
            <td class="author">
              <p>
                <bean:write name="reply" property="author" />
              </p>

              <%--
                | We need to look up the date the author joined and their post
                | count and store that information in beans, because you can't
                | use a tag as a parameter to another tag.
                +--%>
              <bean:define id="joineddate">
                <bean:write name="reply" property="authorJoinedDate"
                  formatKey="topic.author.joineddate.format" />
              </bean:define>
              <bean:define id="postcount" name="reply"
                property="authorPostCount" />
              <p class="authorinfo">
                <bean:message key="topic.author.joineddate"
                  arg0="<%=joineddate%>" /><br />
                <bean:message key="topic.author.postcount"
                  arg0="<%=(String) postcount%>" />
              </p>
            </td>
            <td class="message">

              <%--
                | We need to look up the timestamp and store it in a bean,
                | because you can't use a tag as a parameter to another tag.
                +--%>
              <bean:define id="timestamp">
                <bean:write name="reply" property="timestamp"
                  formatKey="app.date.format" />
              </bean:define>
                
              <p class="posted">
                <bean:message key="topic.posted" arg0="<%=timestamp%>" />
              </p>
              <p>
                <bean:write name="reply" property="message" filter="false" />
              </p>
            </td>             
          </tr>
        </logic:iterate>
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
        <bean:message key="app.bullet" /><html:link forward="NewReply">
          <bean:message key="topic.reply" />
        </html:link>
      </p>      
    </logic:present>
    <logic:notPresent name="com.johntopley.webforum.user">
      <p id="welcomemessage">
        <bean:message key="topic.guest.welcome.1" />
        <html:link forward="Register">
          <bean:message key="topic.guest.welcome.2" />
        </html:link>
        <bean:message key="topic.guest.welcome.3" />
        <html:link forward="Login">
          <bean:message key="topic.guest.welcome.4" />
        </html:link>
        <bean:message key="topic.guest.welcome.5" />
      </p>
    </logic:notPresent>
    <p>
      <bean:message key="app.bullet" /><html:link forward="ViewTopics">
        <bean:message key="topics.viewtopics" />
      </html:link>
    </p>
  </body>
</html:html>