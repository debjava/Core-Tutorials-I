package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowColors2 extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    ColorBean2 colorBean =
      (ColorBean2)session.getAttribute("colorBean2");
    if (colorBean.getForegroundColor().equals
        (colorBean.getBackgroundColor())) {
      colorBean = new ColorBean2();
      session.setAttribute("colorBean2", colorBean);
    }
    String address = "/WEB-INF/results/show-colors2.jsp";
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
