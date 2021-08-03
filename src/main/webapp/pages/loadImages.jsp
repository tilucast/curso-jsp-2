<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All images</title>
</head>
<body>

<h1>All images are listed below boi</h1>

<div>

	<c:forEach items="${listOfImages}" var="img">
	
		<img alt="" src="${img.getImage64b()}">
		<c:if test="${img.getType().equals('application/pdf')}">
			<img alt="" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/833px-PDF_file_icon.svg.png">
		</c:if>
		<a href="${img.getImage64b()}" download="${img.getName()}">Download</a>
	
	</c:forEach>

</div>

</body>
</html>