<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<html>
<head>
<title>Deba Google Type Pagination </title>
<style type="text/css">
A.nodec { text-decoration: none; }
</style>
</head>
<body bgcolor="#ffffff">
		
		<%-- 
			style prints jsptags 
			position prints top
			index prints center
			maxPageItems prints 10
			maxIndexPages prints 10
		--%>

<%
    String style = "jsptags";
	
    String position = "top";

	
    String index = "center";
	
    int maxPageItems = 10;//getParam(request, "maxPageItems", 10);
	
    int maxIndexPages = 10;//getParam(request, "maxIndexPages", 10);

	
%>

<form action="<%= request.getRequestURI() %>" method="get">
<center>
<table border="0" width="90%" cellpadding="4">
<tr valign="top">
<td rowspan="2" align="center">
	
	<!-- First Table for All radio Buttons -->
    <table border="0" cellspacing="2" cellpadding="0">
			<tr><th colspan="2">Style</th></tr>
			<tr>
				
				
			</tr>
			<tr>
				
			</tr>

			<tr>
				<td><% radio(pageContext, "style", "jsptags", false); %></td>
				<td><a target="_blank" href="http://jsptags.com/">JSPTags.com</a></td>
			</tr>

			<tr>
				
			</tr>

			<tr>
				
			</tr>

			<tr>
				
			</tr>

			<tr>
				
			</tr>

			<tr>
				
			</tr>
    </table>
</td>
<td>

</td>

<td>


</td>
<td rowspan="2" width="100%">
	<p>
		This is the pagination Deba is trying to achieve
	</p>


  <% if ("jsptags".equals(style)) 
	  { 
  %>



  
  <% 
	 }
  %>
</td>
</tr>
<tr>

	<td colspan="2" align="center" valign="top">




	</td>

</tr>
</table>

##################################################################################################

<pg:pager
    items="<%= 216 %>"
    index="<%= index %>"
    maxPageItems="<%= maxPageItems %>"
    maxIndexPages="<%= maxIndexPages %>"
    isOffset="<%= true %>"
    export="offset,currentPageNumber=pageNumber"
    scope="request">
<%-- keep track of preference --%>
  <pg:param name="style"/>
  <pg:param name="position"/>
  <pg:param name="index"/>
  <pg:param name="maxPageItems"/>
  <pg:param name="maxIndexPages"/>

  <%-- save pager offset during form changes --%>
  <input type="hidden" name="pager.offset" value="<%= offset %>">

  <%-- warn if offset is not a multiple of maxPageItems --%>
  <% if (offset.intValue() % maxPageItems != 0 &&
         ("alltheweb".equals(style) || "lycos".equals(style)) )
     {
  %>
    <p>Warning: The current page offset is not a multiple of Max. Page Items.
    <br>Please
    <pg:first><a href="<%= pageUrl %>">return to the first page</a></pg:first>
    if any displayed range numbers appear incorrect.</p>
  <% } %>

  <%-- the pg:pager items attribute must be set to the total number of
       items for index before items to work properly --%>
  <% if ("top".equals(position) || "both".equals(position)) { %>
    <br>
			<p> Including the JSP Pages </p>
    <pg:index>

		 <%
		 if( "jsptags".equals(style))
		 {
		 %>
			<jsp:include page="/WEB-INF/jsp/jsptags.jsp" flush="true"/>
		 <%
		  }						
		%>
  			
		
    </pg:index>

  <% 
  }
  %>

  <hr>
  <table width="90%" cellspacing="4" cellpadding="4">
  ************************* Adding the JSP Pages *********************
  <%--
    Since the data source is static, it's easy to offset and limit the
    loop for efficiency. If the data set size is not known or cannot
    be easily offset, the pager tag library can count the items and display
    the correct subset for you.

    The following is an example using an enumeration data source of
    unknown size. The pg:pager items and isOffset attributes must
    not be set for this example:

    <% while (enumeration.hasMoreElements()) { %>
	<pg:item><%= enumeration.nextElement() %><br></pg:item>
    <% } %>

   --%>
   
   <%--
		webPalette.length is 216 
   --%>
  <%
  
  
	for (int i = offset.intValue(),
	         l = Math.min(i + maxPageItems, 216);
	     i < l; i++)
	{
  %>



  <pg:item>
		<tr>
					
				
				ZZZZZZZZ==== <%= i + 1 %>

				
		</tr>
  </pg:item>



  <%
	}
  %>
  </table>
  



	

</pg:pager>


</center>
</body>
</html>
<%!




private static final String getParam(ServletRequest request, String name,
    String defval)
{
    String param = request.getParameter(name);
    return (param != null ? param : defval);
}

private static final int getParam(ServletRequest request, String name,
    int defval)
{
    String param = request.getParameter(name);
    int value = defval;
    if (param != null) {
	try { value = Integer.parseInt(param); }
	catch (NumberFormatException ignore) { }
    }
    return value;
}

private static void radio(PageContext pc, String name, String value,
    boolean isDefault) throws java.io.IOException
{
    JspWriter out = pc.getOut();
    String param = pc.getRequest().getParameter(name);
    out.write("<input type=\"radio\" name=\"");
    out.write(name);
    out.write("\" value=\"");
    out.write(value);
    out.write("\" onChange=\"this.form.submit();\"");
    if (value.equals(param) || (isDefault && param == null))
	out.write(" checked");
    out.write('>');
}
%>
