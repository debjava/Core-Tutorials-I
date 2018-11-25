<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>

<html>
<head>
<title> Google Type Pagination </title>

</head>
<body>
		
		<form action="<%= request.getRequestURI() %>" method="get">
			<center>



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
	    <p> ##################### Including the JSP Pages ######################## </p>
		<jsp:include page="/WEB-INF/jsp/jsptags1.jsp" flush="true"/>

  <hr>

  <table width="90%" cellspacing="4" cellpadding="4">
  ************************* Printing the values the JSP Pages *********************
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
