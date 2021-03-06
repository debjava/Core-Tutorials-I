<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
        
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>

</head>
	<body>


		<%--
			Include the JSP page,
			where you can display the items
		--%>

		<jsp:include page="/ItemsDisplay.jsp">

			<jsp:param name="someitems"				value='${requestScope.pageItems}' />

			<jsp:param name="TOTAL_RECORDS"			value='${requestScope.inputText}' />
			<jsp:param name="PAGE_SIZE"				value='${requestScope.pageSizeText}' />
			<jsp:param name="PAGE_GRP_SIZE"			value='${requestScope.pageSizeText}' />

		</jsp:include>
		



		<table border="0" cellpadding="2" cellspacing="1">
		

		<%--
			For Previous
		--%>

		<tr>
		<c:if test="${itemPg-1 >= 0}">
		<td><a class="pagingLink" href="test.do?itemPg=${itemPg-1}
			&inputText=${requestScope.inputText}
			&pageSizeText=${requestScope.pageSizeText}
			&pageGrpSize=${requestScope.pageGrpSize}"><<</a>
		</td>
		</c:if>


		<%-- Loop through paging numbers list --%>
		<c:forEach var="pg" items="${pageList}" varStatus="loopStat">
		<c:if test="${!(loopStat.index eq 0 and loopStat.last)}">
		<td>
		<c:if test="${loopStat.count > 1}">
		|
		</c:if>

		<c:choose>
		<c:when test="${itemPg == pg}">
		<b>${pg+1}</b>
		</c:when>
		<c:otherwise>
		<a class="pagingLink" href="test.do?itemPg=${pg}
			&inputText=${requestScope.inputText}
			&pageSizeText=${requestScope.pageSizeText}
			&pageGrpSize=${requestScope.pageGrpSize}">${pg+1}</a>


<%--
		Added here
--%>



		</c:otherwise>
		</c:choose>
		</td>
		</c:if>
		</c:forEach>
		
		<%--
			For Next
		--%>

		<c:if test="${itemPg+1 < totalPages}">
			<td>
			<a class="pagingLink" href="test.do?itemPg=${itemPg+1}
			&inputText=${requestScope.inputText}
			&pageSizeText=${requestScope.pageSizeText}
			&pageGrpSize=${requestScope.pageGrpSize}">>></a>
			</td>




<%--
		Add second
--%>



		</c:if>

		</tr>
		</table>
	</body>
</html>
