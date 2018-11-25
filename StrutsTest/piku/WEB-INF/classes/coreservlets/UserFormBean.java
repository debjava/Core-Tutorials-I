package coreservlets;

import org.apache.struts.action.*;

public class UserFormBean extends ActionForm {
  private String email = "";
  private String password = "";
  private String operation="createAccount";

  public String getEmail() {
    return(email);
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return(password);
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getOperation() {
    return(operation);
  }
}
