<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : newtopic.jsp
 | Author       : John Topley
 | Description  : New Topic page.
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
      <bean:message key="newtopic.title" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>
    <h2><bean:message key="newtopic.title" /></h2>
    <div id="form">
      <html:form action="/NewTopicSubmit" focus="subject">
        <fieldset>

          <%-- Subject field. --%>
          <div class="row">
            <logic:messagesPresent
              property="com.johntopley.webforum.subjecterror">
              <span class="formlabel">
                <label for="subject">
                  <bean:message key="newtopic.subject" />&nbsp;
                  <span class="required">
                    <html:errors property="com.johntopley.webforum.subjecterror"
                      bundle="GlobalErrors" />
                  </span>
                </label>
              </span> 
              <span class="formfieldreq">
                <html:text property="subject" styleId="subject"
                  maxlength="128" size="64" />
              </span>              
            </logic:messagesPresent>            
            <logic:messagesNotPresent
              property="com.johntopley.webforum.subjecterror">
              <span class="formlabel">
                <label for="subject">
                  <bean:message key="newtopic.subject" />
                </label>
              </span>
              <span class="formfield">
                <html:text property="subject" styleId="subject"
                  maxlength="128" size="64" />
              </span>
            </logic:messagesNotPresent>
          </div>
          
          <%-- Message field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.messageerror">              
              <span class="formlabel">
                <label for="message">&nbsp;
                  <bean:message key="newtopic.message" />
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
                  <bean:message key="newtopic.message" />
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
                <bean:message key="newtopic.submit" />
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