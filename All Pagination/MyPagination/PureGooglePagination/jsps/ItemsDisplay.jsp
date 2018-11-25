<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

    <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>Items Display</title>
	<body>
		<h1> Displayed Items </h1>
		<table>
			<c:forEach var="item" items="${param.someitems}" varStatus="loopStat">
			<tr>
				<td>
						<c:out value="${item}"/>
				</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</head>
</html>