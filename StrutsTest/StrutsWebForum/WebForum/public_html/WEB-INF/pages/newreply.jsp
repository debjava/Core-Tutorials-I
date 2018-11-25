<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : newreply.jsp
 | Author       : John Topley
 | Description  : New Reply page.
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
      <bean:message key="newreply.title" arg0="<%=subject%>" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>    
    <h2><bean:message key="newreply.heading" arg0="<%=subject%>" /></h2>    
    <div id="form">
      <html:form action="/NewReplySubmit" focus="message">
        <fieldset>
          
          <%-- Message field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.messageerror">              
              <span class="formlabel">
                <label for="message">
                  <bean:message key="newreply.message" />&nbsp;
                </label>
                <span class="required">
                  <html:errors property="com.johntopley.webforum.messageerror"
                    bundle="GlobalErrors" />
                </span>
              </span>
              <span class="formfieldreq">
                <html:textarea property="message" styleId="message"
                  cols="50" rows="14" />
              </span>
            </logic:messagesPresent>
            <logic:messagesNotPresent
              property="com.johntopley.webforum.messageerror">
              <span class="formlabel">
                <label for="message">
                  <bean:message key="newreply.message" />
                </label>                
              </span>
              <span class="formfield">
                <html:textarea property="message" styleId="message"
                  cols="50" rows="14" />
              </span>
            </logic:messagesNotPresent>
          </div>
          <div class="row">
            <span class="tagnote">
              <bean:message key="app.tagnote" />
            </span>
          </div>

          <%-- Buttons. --%>
          <div class="row">
            <span class="formbuttons">
              <html:submit styleClass="button">
                <bean:message key="newreply.submit" />
              </html:submit>
              <html:cancel styleClass="button">
                <bean:message key="app.cancel" />
              </html:cancel>
            </span>
          </div>
        </fieldset>      
      </html:form>
    </div>
  </body>
</html:html>