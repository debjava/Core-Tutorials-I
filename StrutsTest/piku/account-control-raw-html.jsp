<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD><TITLE>Account Control</TITLE></HEAD>
<BODY BGCOLOR="#FDF5E6">
<CENTER>
<H1>Account Control</H1>
<FORM ACTION="accountMod.do" METHOD="POST">
  Email address: <INPUT TYPE="TEXT" NAME="email"><BR>
  Password: <INPUT TYPE="PASSWORD" NAME="password"><BR>
  <TABLE CELLSPACING="10">
    <TR>
      <TD><INPUT TYPE="RADIO" NAME="operation" 
                 VALUE="createAccount" CHECKED>
          Create Account</TD>
      <TD><INPUT TYPE="RADIO" NAME="operation" 
                 VALUE="changePassword">
          Change Password</TD>
      <TD><INPUT TYPE="RADIO" NAME="operation" 
                 VALUE="deleteAccount">
          Delete Account</TD>
    </TR>
  </TABLE>
  <INPUT TYPE="SUBMIT" VALUE="Perform Selected Operation">
</FORM>
</CENTER>
</BODY></HTML>