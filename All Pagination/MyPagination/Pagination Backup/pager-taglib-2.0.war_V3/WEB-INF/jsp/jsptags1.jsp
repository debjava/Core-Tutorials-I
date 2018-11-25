<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>

<jsp:useBean id="currentPageNumber" type="java.lang.Integer" scope="request"/>

	<table color="none" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td>
				
			<%-- For Previous Click --%>
			<pg:prev export="pageUrl">
			  <a href="<%= pageUrl %>" class="nodec"><font color="RED">&lt;&lt;</font></a>
			</pg:prev>


			<pg:pages> &nbsp;
			<%
			  if (pageNumber == currentPageNumber) 
			  {
			%>
				<font color="GREEN"><%= pageNumber %></font>
			<%
			  }
			  else 
			  {
			%>
				<a href="<%= pageUrl %>" class="nodec"><font color="RED"><%= pageNumber %></font></a>
			<%
			  }
			%> &nbsp; 
			</pg:pages>

			
			<%-- For Next Click --%>
			<pg:next export="pageUrl">
			  <a href="<%= pageUrl %>" class="nodec"><font color="RED">&gt;&gt;</font></a>
			</pg:next>

			</td>
		</tr>
	</table>