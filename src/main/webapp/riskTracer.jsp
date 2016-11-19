<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risks Tracer</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>
<body>
	<h3 align="center">Risks tracer</h3>
	<form class="tracer" action="riskfollowmodify">
	<fieldset>
		<input type="hidden" name="riskfollow_id" value="${riskfollow.id}"/> 
		<label>风险名称</label>
			<textarea type="text" readonly='readonly' tabindex="1" name="riskname" >${riskfollow.riskName}</textarea>
		<label>风险内容</label>
			<textarea tabindex="2" readonly='readonly' name="riskcontent" style="height:60px;" >${riskfollow.riskContent}</textarea>
		<label>跟踪描述</label> 
			<textarea tabindex="3" placeholder="Description" name="description" style="height:150px;">${riskfollow.description}</textarea>
		<input type="hidden" name="riskfollow_follower" value="${riskfollow.follower}"/> 
		<br/>	
	</fieldset>
	<footer> <input type="submit" value="确认追踪信息"
			onClick="" class="submit_button"> </footer>
	</form>
	<h3 align="center">Tracer records</h3>
</body>
</html>