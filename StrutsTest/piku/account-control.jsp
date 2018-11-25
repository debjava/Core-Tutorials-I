<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Account Control</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<CENTER>
<H1>Account Control</H1>
<%@ taglib uri="http://struts.apache.org/tags-html"
           prefix="html" %>
<html:form action="/accountMod">
  Email address: <html:text property="email"/><BR>
  Password: <html:password property="password"/><BR>
  <TABLE CELLSPACING="10">
    <TR>
      <TD><html:radio property="operation" 
                      value="createAccount"/>
          Create Account</TD>
      <TD><html:radio property="operation" 
                      value="changePassword"/>
          Change Password</TD>
      <TD><html:radio property="operation" 
                      value="deleteAccount"/>
          Delete Account</TD>
    </TR>
  </TABLE>
  <html:submit value="Perform Selected Operation"/>
</html:form>
</CENTER>
</BODY></HTML>