<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image Upload</title>
</head>
<body>

<h1>Image Upload Page Boi</h1>

<input id="file" name="file" type="file" onchange="loadImage(event)">
<img alt="uploaded image" id="image" src="#">

<a href="/curso-jsp-2/FileUpload">See images</a>

<script type="text/javascript">

	async function loadImage(){
		const imageHolder = document.querySelector("#image")
		const xinput = document.querySelector("#x")
		
		const file = event.explicitOriginalTarget.files[0]
		imageHolder.src = URL.createObjectURL(file)
		const path = new URLSearchParams()
		
		try{
			
			const r = new FileReader()
			r.onload = async (event) => {
				path.append("file", event.target.result)
				path.append("name", file.name)
				path.append("type", file.type)
				
				const sendImage = await fetch("/curso-jsp-2/FileUpload", {
					method: 'POST',
					body: path
				})
				
				console.log(sendImage)
				console.log(await sendImage.text())
			}
			
			r.readAsDataURL(file)
			
		}catch(error){
			console.log(error)
		}
	}
	
</script>

</body>
</html>