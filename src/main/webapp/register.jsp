<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Sign up to PRM</title>
<link rel="stylesheet" type="text/css" href="CSS/reset.css">
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>

<body>
<h1>Sign up to PRM</h1>
<form class="box signup" action = "register">	
	<fieldset class="boxBody">
	  <label>Username</label>
	  <input type="text" tabindex="1" placeholder="Username" name="rusername" required>
	  <label>Password</label>
	  <input type="password" tabindex="2" placeholder="Password"  name="rpassword" required>
	  <label>Comfirm Password</label>
	  <input type="password" tabindex="3" placeholder="Password again" name="crpassword" required>
	</fieldset>
	<footer>
	  <input type="submit" class="btnLogin" value="Sign up" tabindex="4">
	</footer>
</form>
</body>
</html>