<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risks Tracer</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>
<body>
	<h3 align="center">Risks tracer</h3>
	<form class=tracer>
	<fieldset class="boxBody" width='600'>
		<label>风险名称</label>
			<input type="text" tabindex="1" name="riskname">
		<label>风险内容</label>
			<input type="text" tabindex="2" name="riskcontent">
		<label>风险描述</label> 
			<input type="text" tabindex="3" placeholder="Description" name="description">
	</fieldset>
	<footer> <input type="button" value="确认追踪信息"
			onClick="" class="submit_button"> </footer>
	</form>
</body>
</html>