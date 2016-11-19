<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risk Management Plan</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>
<body class="arrangebody">
	<h3 align="center">Risks Management Plan</h3>
	<form class="arrange">
		<table width='800' align="center" cellpadding='0' cellspacing='1' bgcolor='#0099FF'>
			<tr>
				<td bgcolor='#FFFFFF'>
					<table width='100%' border='0' cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
						<tr>
							<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险计划名称</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>操作</strong></td>
						</tr>
						
						<s:iterator id="project" value="projectlist" status="st">
						<tr>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#project.projectName"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'>[
								<a
								href='projectDetail?selectedprojectid=<s:property value="#project.id"></s:property>'
								type="submit">查看</a><input name="selectedprojectid" type="hidden"
								value='<s:property value="#risk.id"></s:property>'>][ 
								<a
								href='projectDel?selectedprojectid=<s:property value="#project.id"></s:property>'
								type="submit">删除</a><input name="selectedprojectid" type="hidden"
								value='<s:property value="#project.id"></s:property>'>]
							</td>
						</tr>
					</s:iterator>
					</table>
				</td>
			</tr>
		</table>
			</form>
		<p></p>
		<footer class="footer"> 
			<form class="addProject" action="addProject">
				<label>新建计划名称</label> 
				<input type="text" name="plan_name"> 
				<input type="submit" value="添加风险计划" class="submit_button">
			</form>
			<form class="getAllRisk" action="getAllRisk">
				<input type="submit" value="查询所有风险" class="submit_button"> 
			</form>
		</footer>
		<p>${message}</p>
		
</body>
</html>