<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : login.jsp
 | Author       : John Topley
 | Description  : Login page.
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
      <bean:message key="login.title" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>
    <h2><bean:message key="login.title" /></h2>    
    <div id="form">
      <img src="<html:rewrite page="/assets/images/register.gif" />"
        alt="" height="48" width="48" />
      <html:form action="/LoginSubmit" focus="username">
        <logic:messagesPresent property="com.johntopley.webforum.loginerror">
          <p id="error">
            <html:errors property="com.johntopley.webforum.loginerror"
              bundle="GlobalErrors" />
          </p>
        </logic:messagesPresent>
        <fieldset>
          
          <%-- Username field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.usernameerror">              
              <span class="formlabel">
                <label for="username">&nbsp;
                  <bean:message key="login.username" />
                </label>
                <span class="required">
                  <html:errors property="com.johntopley.webforum.usernameerror"
                    bundle="GlobalErrors" />
                </span>
              </span>
              <span class="formfieldreq">
                <html:text property="username" styleId="username"
                  maxlength="8" size="8" />
              </span>
            </logic:messagesPresent>
            <logic:messagesNotPresent
              property="com.johntopley.webforum.usernameerror">
              <span class="formlabel">
                <label for="username">
                  <bean:message key="login.username" />
                </label>                
              </span>
              <span class="formfield">
                <html:text property="username" styleId="username"
                  maxlength="8" size="8" />
              </span>
            </logic:messagesNotPresent>
          </div>

          <%-- Password field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.passworderror">              
              <span class="formlabel">
                <label for="password">&nbsp;
                  <bean:message key="login.password" />
                </label>
                <span class="required">
                  <html:errors property="com.johntopley.webforum.passworderror"
                    bundle="GlobalErrors" />
                </span>
              </span>
              <span class="formfieldreq">
                <html:password property="password" styleId="password"
                  maxlength="8" size="8" />
              </span>
            </logic:messagesPresent>
            <logic:messagesNotPresent
              property="com.johntopley.webforum.passworderror">
              <span class="formlabel">
                <label for="password">
                  <bean:message key="login.password" />
                </label>                
              </span>
              <span class="formfield">
                <html:password property="password" styleId="password"
                  maxlength="8" size="8" />
              </span>
            </logic:messagesNotPresent>
          </div>

          <%-- Auto login. --%>
          <div class="row autologin">
            <html:checkbox property="autoLogin" styleId="autologin" /><label for="autologin"><bean:message key="app.autologin" /></label>
          </div>

          <%-- Buttons. --%>
          <div class="row">
            <span class="formbuttons">
              <html:submit styleClass="button">
                <bean:message key="login.submit" />
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