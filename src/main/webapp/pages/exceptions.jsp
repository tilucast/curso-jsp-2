<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exceptions</title>
</head>
<body>

<form action="/curso-jsp-2/ServletExceptions">

	<input type="text">
	
	<button type="button" onclick="somefunction()">Benis</button>
</form>


<script type="text/javascript">
	async function somefunction(){
		const form = document.querySelector("form")
		try{
			
			const result = await fetch(form.action + "?param=" + form.children[0].value)
			
			const errorCodes = [400, 401, 403, 404, 406, 409, 410, 500, 501, 502, ,503 ,504]
			
			if(errorCodes.includes(result.status)){
				throw new Error(await result.text())
				
			}
			
			console.log(await result.text())
			
		}catch(error){
			alert(error)
			console.error(error)
		}
		
	}
</script>

</body>
</html>