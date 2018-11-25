<%--
 | Copyright (c) 2004 John Topley
 | Directory    : public_html/WEB-INF/pages
 | Project      : Web Forum
 | File         : register.jsp
 | Author       : John Topley
 | Description  : User registration page.
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
      <bean:message key="register.title" /> - <bean:message key="app.title" />
    </title>
  </head>
  <body>
    <h1><bean:message key="app.title" /></h1>
    <h2><bean:message key="register.title" /></h2>    
    <div id="form">
      <img src="<html:rewrite page="/assets/images/register.gif" />"
        alt="" height="48" width="48" />
      <html:form action="/RegisterSubmit" focus="username">
        <logic:messagesPresent property="com.johntopley.webforum.usernameexistserror">
          <p id="error">
            <html:errors property="com.johntopley.webforum.usernameexistserror"
              bundle="GlobalErrors" />
          </p>
        </logic:messagesPresent>
        <logic:messagesPresent property="com.johntopley.webforum.passwordmatcherror">
          <p id="error">
            <html:errors property="com.johntopley.webforum.passwordmatcherror"
              bundle="GlobalErrors" />
          </p>
        </logic:messagesPresent>
        <fieldset>

          <%-- User name field. --%>
          <div class="row">
            <logic:messagesPresent
              property="com.johntopley.webforum.usernameerror">
              <span class="formlabel">
                <label for="username">
                  <bean:message key="register.username" />&nbsp;
                  <span class="required">
                    <html:errors property="com.johntopley.webforum.usernameerror"
                      bundle="GlobalErrors" />
                  </span>
                </label>
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
                  <bean:message key="register.username" />
                </label>
              </span>
              <span class="formfield">
                <html:text property="username" styleId="username"
                  maxlength="8" size="8" />
              </span>
            </logic:messagesNotPresent>
          </div>
          
          <%-- Forenames field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.forenameserror">              
              <span class="formlabel">
                <label for="forenames">
                  <bean:message key="register.forenames" />&nbsp;
                </label>
                <span class="required">
                  <html:errors property="com.johntopley.webforum.forenameserror"
                    bundle="GlobalErrors" />
                </span>
              </span>
              <span class="formfieldreq">
                <html:text property="forenames" styleId="forenames"
                  maxlength="64" size="64" />
              </span>              
            </logic:messagesPresent>
            <logic:messagesNotPresent
              property="com.johntopley.webforum.forenameserror">
              <span class="formlabel">
                <label for="forenames">
                  <bean:message key="register.forenames" />
                </label>                
              </span>
              <span class="formfield">
                <html:text property="forenames" styleId="forenames"
                  maxlength="64" size="64" />
              </span>              
            </logic:messagesNotPresent>
          </div>

          <%-- Surname field. --%>
          <div class="row">            
            <span class="formlabel">
              <label for="surname">
                <bean:message key="register.surname" />
              </label>                
            </span>
            <span class="formfield">
              <html:text property="surname" styleId="surname"
                maxlength="64" size="64" />
            </span>
          </div>

          <%-- Password field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.passworderror">              
              <span class="formlabel">
                <label for="password">
                  <bean:message key="register.password" />&nbsp;
                </label>
                <span class="required">
                  <html:errors property="com.johntopley.webforum.passworderror"
                    bundle="GlobalErrors" />
                </span>
              </span>
              <span class="formfieldreq">
                <html:password property="password" styleId="password"
                  maxlength="16" size="16" />
              </span>              
            </logic:messagesPresent>
            <logic:messagesNotPresent
              property="com.johntopley.webforum.passworderror">
              <span class="formlabel">
                <label for="password">
                  <bean:message key="register.password" />
                </label>                
              </span>
              <span class="formfield">
                <html:password property="password" styleId="password"
                  maxlength="16" size="16" />
              </span>              
            </logic:messagesNotPresent>
          </div>

          <%-- Password confirmation field. --%>
          <div class="row">            
            <logic:messagesPresent
              property="com.johntopley.webforum.password2error">              
              <span class="formlabel">
                <label for="password2">
                  <bean:message key="register.password2" />&nbsp;
                </label>
                <span class="required">
                  <html:errors property="com.johntopley.webforum.password2error"
                    bundle="GlobalErrors" />
                </span>
              </span>
              <span class="formfieldreq">
                <html:password property="password2" styleId="password2"
                  maxlength="16" size="16" />
              </span>              
            </logic:messagesPresent>
            <logic:messagesNotPresent
              property="com.johntopley.webforum.password2error">
              <span class="formlabel">
                <label for="password2">
                  <bean:message key="register.password2" />
                </label>                
              </span>
              <span class="formfield">
                <html:password property="password2" styleId="password2"
                  maxlength="16" size="16" />
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
                <bean:message key="register.submit" />
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