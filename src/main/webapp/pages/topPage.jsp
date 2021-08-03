<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Page</title>
</head>
<body>

 	<h1>I am the top page.</h1>

	<button onclick="load()">Load child pages</button>
	
	<div id="child-page"></div>

	
	<script type="text/javascript">
		
		async function load(){
			const div = document.querySelector("#child-page")
			
			const res = await fetch("bottomPage.jsp")
			div.innerHTML = await res.text()
		}
	
	</script>

</body>
</html>