package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShowColors1 extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    ColorBean1 colorBean =
      (ColorBean1)session.getAttribute("colorBean1");
    if (colorBean == null) {
      colorBean = new ColorBean1();
      session.setAttribute("colorBean1", colorBean);
    }
    colorBean.setForegroundColor
      (request.getParameter("foregroundColor"));
    colorBean.setBackgroundColor
      (request.getParameter("backgroundColor"));
    if (colorBean.getForegroundColor().equals
        (colorBean.getBackgroundColor())) {
      colorBean = new ColorBean1();
      session.setAttribute("colorBean1", colorBean);
    }
    String address = "/WEB-INF/results/show-colors1.jsp";
    RequestDispatcher dispatcher =
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
