<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
 <link href="https://fonts.googleapis.com/css?family=Assistant:400,700" rel="stylesheet"><link rel="stylesheet" href="./css/style.css">

</head>
<body>

<!-- partial:index.partial.html -->
<section class='login' id='login'>
  <div class='head'>
  <h1 class='company'>HarmonyHUB</h1>
  </div>
  <p class='msg'>Welcome back</p>
  <div class='form'>
			<form action="${pageContext.request.contextPath}/LoginServlet"
				method="post">
				<input type="text" placeholder='Username' class='text' id='username'
					required><br> <input type="password"
					placeholder='••••••••••••••' class='password'><br>
				<button type="submit" class='btn-login' id='do-login'>Login</button>
				<a href="#" class='forgot'>Forgot?</a>
			</form>
		</div>
</section>

<!-- partial -->
  <script  src="./js/script.js"></script>


</body>
</html>