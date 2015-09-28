<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring form</title>
</head>
<body>
<h2>this is what you are looking for</h2>
<%-- <table align="center" border="1">
    <tr>
        <td>Nr:</td><td>Name:</td><td>Email</td><td>Modify?</td>
    </tr> 
    <c:forEach var="user" items="${basicList}">
        <tr>
            <td><c:out value="${user}"/></td><td>Modify</td>
        </tr>   
    </c:forEach>
    
    
</table> --%>
<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>
</body>
</html>