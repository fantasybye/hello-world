<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risks Management</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>

<body>
	<h3 align="center">Manage your risks</h3>
	<form class="edit" >
		<table align="center">
			<tr>
				<td width="150" align="center">风险内容</td>
				<td width="450"><input type="hidden" id="risk_rid" />
				<input type="text" id="risk_content" name="rcontent"></td>
			</tr>
			<tr>
				<td align="center">可能性</td>
				<td><input type="radio" value="high" id="risk_possibility" name="rpos" checked="checked">高
					<input type="radio" value="medium" id="risk_possibility" name="rpos" >中
					<input type="radio" value="low" id="risk_possibility" name="rpos" >低
				</td>
			</tr>
			<tr>
				<td align="center">影响程度</td>
				<td><input type="radio" value="high" id="risk_effect" name="reff" checked="checked">高
					<input type="radio" value="medium" id="risk_effect" name="reff">中
					<input type="radio" value="low" id="risk_effect" name="reff">低
				</td>
			</tr>
			<tr>
				<td align="center">触发器/阈值</td>
				<td><input type="text" id="risk_trigger"></td>
			</tr>
			<tr>
				<td align="center">提交者</td>
				<td><input type="text" id="risk_committer"></td>
			</tr>
			<tr>
				<td align="center">跟踪者</td>
				<td><input type="text" id="risk_tracker"></td>
			</tr>
		</table>
		<footer> 
			<input type="button" value="   添加学生   " onClick="addStudent()" id="submit_button"> 
			<input type="button" value="  切换  " onClick="qiehuan()" id="qiehuan_button"
			style="display: none" align="left"> 
		</footer>
		<p></p>
		<div id="showStudentDivID"></div>
	</form>
</body>

</html>