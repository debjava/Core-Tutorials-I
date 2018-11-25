package coreservlets;

import org.apache.struts.action.*;

public class ColorBean2 extends ActionForm {
  private String foregroundColor = "BLACK";
  private String backgroundColor = "WHITE";

  public String getForegroundColor() {
    return(foregroundColor);
  }

  public void setForegroundColor(String fgColor) {
    foregroundColor = fgColor;
  }

  public String getBackgroundColor() {
    return(backgroundColor);
  }

  public void setBackgroundColor(String bgColor) {
    backgroundColor = bgColor;
  }
}
