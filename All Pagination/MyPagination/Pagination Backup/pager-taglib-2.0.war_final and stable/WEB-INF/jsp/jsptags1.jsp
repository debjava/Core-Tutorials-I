<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>

<script>
	var valueString ;
	var startIndex;
	var lastIndex;
	var currentPageIndex;

	function processValues( statusString , pageNo )
	{
		if( pageNo == '')
		{
			valueString = statusString.substring(statusString.lastIndexOf('=')+1,statusString.length);
			startIndex = eval( valueString ) + 1;
			lastIndex = eval( valueString ) + 10;
			//currentPageIndex = eval( lastIndex ) / 10;
			//alert("Start Index===="+startIndex+"\n"+"Last Index======"+lastIndex+"\n"+"Current Page No====>>"+currentPageIndex);
		}
		else
		{
			lastIndex = eval( pageNo ) * 10;
			startIndex = eval( lastIndex ) - 9 ;
			//currentPageIndex = eval( lastIndex ) / 10;
			//alert("Start Index===="+startIndex+"\n"+"Last Index======"+lastIndex+"\n"+"Current Page No====>>"+currentPageIndex);
		}
		currentPageIndex = eval( lastIndex ) / 10;
		alert("Start Index===="+startIndex+"\n"+"Last Index======"+lastIndex+"\n"+"Current Page No====>>"+currentPageIndex);
		
	}
</script>

<jsp:useBean id="currentPageNumber" type="java.lang.Integer" scope="request"/>

	<table color="none" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td>	
				<%-- For Previous Click --%>
				<pg:prev export="pageUrl">
					<a href="<%= pageUrl %>" class="nodec" onClick="processValues( '<%= pageUrl %>' ,'' )"><font color="RED">&lt;&lt;</font></a>
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
					<input type="hidden" name="t" value="<%= pageUrl %>">
					<a  href="<%= pageUrl %>"  class="nodec" onClick="processValues( '<%= pageUrl %>','<%= pageNumber %>')"><font color="RED"><%= pageNumber %></font></a>
				<%
				  }
				%> &nbsp; 
				</pg:pages>
			
				<%-- For Next Click --%>
				<pg:next export="pageUrl">
					<a href="<%= pageUrl %>" class="nodec" onClick="processValues( '<%= pageUrl %>' ,'' )"><font color="RED">&gt;&gt;</font></a>
				</pg:next>
			</td>
		</tr>
	</table>