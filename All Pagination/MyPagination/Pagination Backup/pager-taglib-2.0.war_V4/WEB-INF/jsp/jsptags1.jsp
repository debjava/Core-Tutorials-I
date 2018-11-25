<%@ page session="false" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>

<script>
	
	var startIndex;
	var lastIndex;

	function testPrevious( )
	{
		var urlTextString = document.getElementById("pageurlstring").value;
		var valueString = urlTextString.substring(urlTextString.lastIndexOf('=')+1,urlTextString.length);
		startIndex = eval(valueString)+1;
		lastIndex = eval(valueString)+10;
		
		alert("Start Index=====>>>>"+startIndex+"\n"+"Last Index======>>>>"+lastIndex);	
	}

	function testNext()
	{
		alert("You clicked Next");
	}

	function testNormal()
	{
		alert("You clicked Normal");
	}

</script>


<jsp:useBean id="currentPageNumber" type="java.lang.Integer" scope="request"/>

	<table color="none" border="0" cellspacing="0" cellpadding="2">
		<tr>
			<td>
				
				
			<%-- For Previous Click --%>
			<pg:prev export="pageUrl">

			<input type="hidden" id="pageurlstring" value="<%= pageUrl %>">

			

			  <a href="<%= pageUrl %>" class="nodec" onClick="testPrevious( )"><font color="RED">&lt;&lt;</font></a>
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
				<a href="<%= pageUrl %>" class="nodec" onClick="testNormal()"><font color="RED"><%= pageNumber %></font></a>
			<%
			  }
			%> &nbsp; 
			</pg:pages>

			
			<%-- For Next Click --%>
			<pg:next export="pageUrl">
			  <a href="<%= pageUrl %>" class="nodec" onClick="testNext()"><font color="RED">&gt;&gt;</font></a>
			</pg:next>

			</td>
		</tr>
	</table>