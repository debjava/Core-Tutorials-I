package coreservlets;

import javax.servlet.http.*;

public class SignupAction2 extends SignupAction1 {
  protected void makeWarning(HttpServletRequest request,
                             String message) {
    ContactFormBean contactFormBean =
      (ContactFormBean)request.getAttribute("contactFormBean");
    contactFormBean.setWarning(message);
  }
}
