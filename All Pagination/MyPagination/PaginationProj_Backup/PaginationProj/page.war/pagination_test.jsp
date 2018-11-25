<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
    you must also add the JSTL library to the project. The Add Library... action
    on Libraries node in Projects view can be used to add the JSTL 1.1 library.
    --%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
     
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
        
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<STYLE type="text/css">
.pagingLink {text-decoration: none}
</STYLE>
</head>
<body>
<h1>Parent Lists</h1>
<c:forEach begin="0" end="${parentTotal-1}" var="indx" varStatus="loopStat">
<c:choose>
<c:when test="${parentId == indx}">
<b>${loopStat.count}</b>
</c:when>
<c:otherwise>
<a href="PaginationTest?parentId=${indx}">${loopStat.count}</a>
</c:otherwise>
</c:choose>
</c:forEach>
<h1>Items</h1>
<ol start="${pageStart}">
<c:forEach var="item" items="${pageItems}" varStatus="loopStat">
<li>${item}
</c:forEach>
</ol>
<table border="0" cellpadding="2" cellspacing="1">
<tr>
<c:if test="${itemPg-1 >= 0}">
<td><a class="pagingLink" href="PaginationTest?parentId=${parentId}&itemPg=${itemPg-1}"><<</a>
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
<a class="pagingLink" href="PaginationTest?parentId=${parentId}&itemPg=${pg}">${pg+1}</a>
<c:if test="${loopStat.count == 1 && itemPg > defaultPageCursorPosition}">...</c:if>
</c:otherwise>
</c:choose>
</td>
</c:if>
</c:forEach>
<c:if test="${itemPg+1 < totalPages}">
<td><a class="pagingLink" href="PaginationTest?parentId=${parentId}&itemPg=${itemPg+1}">>></a>
</td>
</c:if>
</tr>
</table>
</body>
</html>
