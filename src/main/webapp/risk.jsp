<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.*,java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risks Management</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>


<body>
	<h3 align="center">View of risks</h3>
	<table width='751' border='0' align='center' cellpadding='0'
		cellspacing='1' bgcolor='#0099FF'>
		<tr>
			<td bgcolor='#FFFFFF'><table width='100%' border='0'
					cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
					<tr>
						<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险名称</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险内容</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>可能性</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>影响程度</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>触发器/阀值</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>提交者</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>跟踪者</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>操作</strong></td>
					</tr>

					<s:iterator id="risk" value="risklist" status="st">
						<tr>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskName"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskContent"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskPossibilityStr"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskEfficiencyStr"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskTrigger"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.creatorName"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.follower"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'>[ <a
								href='riskdel?selectedriskid=<s:property value="#risk.id"></s:property>'
								type="submit">删除</a><input name="selectedriskid" type="hidden"
								value='<s:property value="#risk.id"></s:property>'>][ <a
								href='riskfollow?selectedriskid=<s:property value="#risk.id"></s:property>'
								type="submit">跟踪</a><input name="selectedriskid" type="hidden"
								value='<s:property value="#risk.id"></s:property>'>]
							</td>
						</tr>
					</s:iterator>
				</table></td>
		</tr>
	</table>
	<p></p>
	<h3 align="center">Manage your risks</h3>
	<form class="edit" action="addProjectRisk" method="post">
		<table width='600' align="center">
			<tr>
				<td width='150' align="center">风险名称</td>
				<td width='450'><input type="hidden" name="risk_rid" /> <input
					type="text" name="rname"></td>
			</tr>
			<tr>
				<td width="150" align="center">风险内容</td>
				<td><input type="text" name="rcontent"></td>
			</tr>
			<tr>
				<td align="center">可能性</td>
				<td class="radiotd"><input type="radio" value="high" name="rpos" checked>高
					<input type="radio" value="medium" name="rpos">中 <input
					type="radio" value="low" name="rpos">低</td>
			</tr>
			<tr>
				<td align="center">影响程度</td>
				<td class="radiotd"><input type="radio" value="high" name="reff" checked>高
					<input type="radio" value="medium" name="reff">中 <input
					type="radio" value="low" name="reff">低</td>
			</tr>
			<tr>
				<td align="center">触发器/阈值</td>
				<td><input type="text" name="risk_trigger"></td>
			</tr>
			<tr>
				<td align="center">跟踪者</td>
				<td><input type="text" name="risk_tracker"></td>
			</tr>
		</table>
		<p></p>
		<footer style="text-align: right;">  <input type="submit" value="添加风险条目"
			> </footer>
	</form>
	<form class="edit" action="importRisk" method="post">
	<footer style="	text-align: left;"> 
		<input type="submit" value="导入风险条目">
	</footer>
	</form>

</body>



</html>