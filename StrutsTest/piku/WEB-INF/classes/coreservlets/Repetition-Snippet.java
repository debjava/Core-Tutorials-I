public ActionForward execute
                       (ActionMapping mapping,
                        ActionForm form,
                        HttpServletRequest request,
                        HttpServletResponse response)
    throws Exception {
  UserFormBean formBean = (UserFormBean)form;
  if (radioButtonMatches(formBean, "createAccount")) {
    return(createAccount(mapping, formBean, request, response));
  } else if (radioButtonMatches(formBean, "changePassword")) {
    return(changePassword(mapping, formBean, request, response));
  } else if (radioButtonMatches(formBean, "deleteAccount")) {
    return(deleteAccount(mapping, formBean, request, response));
  } else {
    return(makeErrorMessage());
  }
}

private boolean radioButtonMatches(UserFormBean formBean,
                                   String value) {
  String operation = formBean.getOperation();
  return((operation != null) && operation.equals(value));
}

public ActionForward createAccount
                       (ActionMapping mapping,
                        ActionForm form,
                        HttpServletRequest request,
                        HttpServletResponse response)
    throws Exception {
  ...
}

public ActionForward changePassword
                       (ActionMapping mapping,
                        ActionForm form,
                        HttpServletRequest request,
                        HttpServletResponse response)
    throws Exception {
  ...
}

public ActionForward deleteAccount
                       (ActionMapping mapping,
                        ActionForm form,
                        HttpServletRequest request,
                        HttpServletResponse response)
    throws Exception {
  ...
}

  private boolean isComplexBusinessLogicSuccessful(String type) {
    return(Math.random() > 0.5);
  }
}
