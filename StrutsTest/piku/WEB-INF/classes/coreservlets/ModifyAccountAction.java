package coreservlets;

import javax.servlet.http.*;
import org.apache.struts.action.*;  // Action, ActionForm, etc.
import org.apache.struts.actions.*; // DispatchAction

public class ModifyAccountAction extends DispatchAction {
  public ActionForward createAccount
                         (ActionMapping mapping,
                          ActionForm form,
                          HttpServletRequest request,
                          HttpServletResponse response)
      throws Exception {
    if (isComplexBusinessLogicSuccessful("create")) {
      return(mapping.findForward("create-success"));
    } else {
      return(mapping.findForward("create-failed"));
    }
  }

  public ActionForward changePassword
                         (ActionMapping mapping,
                          ActionForm form,
                          HttpServletRequest request,
                          HttpServletResponse response)
      throws Exception {
    if (isComplexBusinessLogicSuccessful("change")) {
      return(mapping.findForward("change-success"));
    } else {
      return(mapping.findForward("change-failed"));
    }
  }

  public ActionForward deleteAccount
                         (ActionMapping mapping,
                          ActionForm form,
                          HttpServletRequest request,
                          HttpServletResponse response)
      throws Exception {
    if (isComplexBusinessLogicSuccessful("delete")) {
      return(mapping.findForward("delete-success"));
    } else {
      return(mapping.findForward("delete-failed"));
    }
  }

  private boolean isComplexBusinessLogicSuccessful(String type) {
    return(Math.random() > 0.5);
  }
}
