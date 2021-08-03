<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Progress Indicator</title>


<style type="text/css">

	#background {
		width: 100%;
		height: 30px;
		background-color: #c1bfbf;
	}
	
	#filling{
		width: 1%;
		height: 100%;
		background-color: green;
	}

</style>

</head>
<body>

	<h1>Progress Indicator</h1>
	
	<button onclick="startLoading()">Start loading</button>
	
	<div id="background">
	
		<section id="filling"></section>
	
	</div>

	<script type="text/javascript">
		function startLoading(){
			const filling = document.querySelector("#filling")
			let percent = 1;
			const progress = () => {
				if(percent >= 100){
					percent = 100;
					clearInterval(interval);
				}
				filling.style.width = percent + '%'
				percent += 2;
			}
			const interval = setInterval(progress, 20)
		}
	</script>

</body>
</html>