<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risks Management</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>

<%
	List<risk> risks = new ArrayList<risk>();
	risks.add(new risk(1, "TEST","111", 1, 1, "w", "z", "y"));
	risks.add(new risk(2, "TEST","111", 1, 1, "w", "z", "y"));
	risks.add(new risk(3, "TEST","111", 1, 1, "w", "z", "y"));
%>
<body>
	<h3 align="center">Manage your risks</h3>
	<form class="edit">
		<table align="center">
			<tr>
				<td width="150" align="center">风险内容</td>
				<td width="450"><input type="hidden" id="risk_rid" /> <input
					type="text" id="risk_content" name="rcontent"></td>
			</tr>
			<tr>
				<td align="center">可能性</td>
				<td><input type="radio" value="high" id="risk_possibility"
					name="rpos" checked="checked">高 <input type="radio"
					value="medium" id="risk_possibility" name="rpos">中 <input
					type="radio" value="low" id="risk_possibility" name="rpos">低
				</td>
			</tr>
			<tr>
				<td align="center">影响程度</td>
				<td><input type="radio" value="high" id="risk_effect"
					name="reff" checked="checked">高 <input type="radio"
					value="medium" id="risk_effect" name="reff">中 <input
					type="radio" value="low" id="risk_effect" name="reff">低</td>
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
		<footer> <input type="button" value="添加风险条目"
			onClick="addStudent()" id="submit_button"> </footer>
		<p></p>
	<!--  <table width='651' border='0' align='center' cellpadding='0'
			cellspacing='1' bgcolor='#0099FF'>
			<tr>
				<td bgcolor='#FFFFFF'><table width='100%' border='0'
						cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
						<tr>
							<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><strong>学生名字</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>年龄</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>性别</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>电话</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>地址</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>操作</strong></td>
						</tr>
						
					</table></td>
			</tr>
		</table>-->	

	</form>
</body>

</html>