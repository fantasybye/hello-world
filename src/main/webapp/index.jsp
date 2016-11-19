<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
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
<form class="box login" action = "login" method="post">	
	<fieldset class="boxBody">
	  <label>Username</label> 
	  <input type="text" tabindex="1" placeholder="Username" name="username" required>
	  <label>Password</label>
	  <input type="password" tabindex="2" placeholder="Password" name="password" required>
	  <p>${message}</p>
	</fieldset>
	<footer>
	  <input type="submit" class="btnLogin" value="Login" tabindex="4">
	  <p><label>New to PRM? </label><a href ="/PRM/register.jsp">Create a new account</a></p>
	</footer>
</form>

</body>
</html>