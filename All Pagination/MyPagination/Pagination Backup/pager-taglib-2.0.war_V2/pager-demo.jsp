<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<html>
<head>
<title> Google Type Pagination </title>
<style type="text/css">
A.nodec { text-decoration: none; }
</style>
</head>
<body bgcolor="#ffffff">
		
<form action="<%= request.getRequestURI() %>" method="get">
<center>
<!-- First Outer Table -->
<table border="0" width="90%" cellpadding="4">

		<tr valign="top">
			<td rowspan="2" align="center">
				
				<!-- First Inner Table for All radio Buttons -->

				<table border="0" cellspacing="2" cellpadding="0">
						
						<tr>
							<td>
								<input type="radio" name="style" value="jsptags" checked onChange="this.form.submit();">
							</td>
							<td>ProcessMate</td>
						</tr>
				</table>

			</td>

			<td rowspan="2" width="100%">
					<p>
						This is the pagination Deba is trying to achieve
					</p>

			</td>
	 </tr>

</table>

##################################################################################################

<pg:pager

    items="<%= 216 %>"
    index="<%= "center" %>"
    maxPageItems="<%= 10 %>"
    maxIndexPages="<%= 10 %>"
    isOffset="<%= true %>"
    export="offset,currentPageNumber=pageNumber"
    scope="request">


	<%-- save pager offset during form changes --%>
	   <input type="hidden" name="pager.offset" value="<%= offset %>">
	   <p> Including the JSP Pages </p>
	   <jsp:include page="/WEB-INF/jsp/jsptags.jsp" flush="true"/>
  <hr>
  <table width="90%" cellspacing="4" cellpadding="4">
  ************************* Adding the JSP Pages *********************
  <%
	for (int i = offset.intValue(),
	         l = Math.min(i + 10, 216);
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
