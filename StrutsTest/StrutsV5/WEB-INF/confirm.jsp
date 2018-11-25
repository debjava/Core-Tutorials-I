<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
</HEAD>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<BODY>
<h1> Congratulations, you have logged in to the System. </h1>

<br>Your UserName : <bean:write name="loginForm" property="username"/></br>
Password : <bean:write name="loginForm" property="password"/>

</BODY>
</HTML>
