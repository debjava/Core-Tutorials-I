<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>



<% int totalSize =2;  %>

 
<html>
<head>
<title> New ProcessMate Pagination </title>
	<body>
		<form  method="get">

		

		============ <c:out value='${totalSize}' />

			<center> 
		
				<pg:pager
				items="<%=totalSize%>"
						index="<%= "center" %>"
						maxPageItems="<%= 10 %>"
						maxIndexPages="<%= 10 %>"
						isOffset="<%= true %>"
						export="offset,currentPageNumber=pageNumber"
						scope="request">
					<%-- save pager offset during form changes --%>
					<input type="hidden" name="pager.offset" value="<%= offset %>">
				
				   <table border="0" width="90%" cellspacing="4" cellpadding="4" > 
		************************* Printing the values the JSP Pages *********************
						 
						  <%
							for (int i = offset.intValue(),
									 l = Math.min(i + 10, 216);
								 i < l; i++)
							{
						  %>

						  <pg:item>
								<tr>
									<table width="90%" cellspacing="2" cellpadding="1">
										<tr>
											ZZZZZZZZ==== <%= i + 1 %>
										</tr>
									</table>
								</tr>
						  </pg:item>

						  <%
							}
						  %>

						  </table>

	
				   <p> ##################### Including the Pagination JSP Pages ######################## </p>

						<jsp:include page="/WEB-INF/jsp/jsptags1.jsp" flush="true"/>

				</pg:pager>

			</center>

	</body>

</head>
</html>
