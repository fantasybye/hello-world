<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome to PRM!</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="CSS/reset.css">
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>

<body>
<h1>Sign in to PRM</h1>
<form class="box login" action = "login">	
	<fieldset class="boxBody">
	  <label>Username</label>
	  <input type="text" tabindex="1" placeholder="Username" name="username" required>
	  <label>Password</label>
	  <input type="password" tabindex="2" placeholder="Password" name="password" required>
	</fieldset>
	<footer>
	  <input type="submit" class="btnLogin" value="Login" tabindex="4">
	  <p><label>New to PRM? </label><a>Create a new accout</a></p>
	</footer>
</form>

</body>
</html>