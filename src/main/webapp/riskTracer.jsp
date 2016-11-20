<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
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
	<form class="tracer" action="riskfollowadd">
		<table align = 'center' bgcolor="#ffffff">
			<tr>
				<td class="firstline" align="left"><label>风险名称</label></td>
			</tr>
			<tr>
				<td align="center"><textarea readonly='readonly'
						tabindex="1" name="riskname">${risk.riskName}</textarea></td>
			</tr>
			<tr>
				<td align="left"><label>风险内容</label></td>
			</tr>
			<tr>
				<td align="center"><textarea tabindex="2" readonly='readonly'
						name="riskcontent" style="height: 60px;">${risk.riskContent}</textarea>
				</td>
			</tr>
			<tr>
				<td align="left"><label>触发器/阀值</label></td>
			</tr>
			<tr>
				<td align="center"><textarea name="risktrigger" style="height:30px;"></textarea>
				</td>
			</tr>
			<tr>
				<td align="left"><label>可能性</label></td>
			</tr>
			<tr>
				<td class="radio" align="left">
					<input type="radio" value="high"name="rpos" checked>高 
					<input type="radio" value="medium" name="rpos">中
					<input type="radio" value="low" name="rpos">低
				</td>
			</tr>
			<tr>
				<td align="left"><label>影响程度</label></td>
			</tr>
			<tr>
				<td class="radio" align="left">
					<input type="radio" value="high"name="reff" checked>高 
					<input type="radio" value="medium" name="reff">中
					<input type="radio" value="low" name="reff">低
				</td>
			</tr>
			<tr>
				<td align="left"><label>是否发生</label></td>
			</tr>
			<tr>
				<td class="radio" align="left">
					<input type="radio" value="ishappend"name="ishap" checked>已发生
					<input type="radio" value="nothappend" name="ishap">未发生
				</td>
			</tr>
			<tr>
				<td align="left"><label>跟踪描述</label></td>
			</tr>
			<tr>
				<td align="center"><textarea tabindex="3"
						placeholder="Description" name="description"
						style="height: 150px;"></textarea> <br /></td>
			</tr>
		</table>
		<footer> <input type="submit" value="确认追踪信息" onClick=""
			class="submit_button"> </footer>
	</form>
	
	<h3 align="center">Tracer records</h3>
		<table width='600' border='0' align='center' cellpadding='0' cellspacing='1' bgcolor='#0099FF'>
		<tr>
				<td bgcolor='#FFFFFF'><table width='100%' border='0' cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
					<tr>
						<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><strong>可能性</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>影响程度</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>触发器/阀值</strong></td>							
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>是否发生</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>跟踪者</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>跟踪描述</strong></td>
					</tr>
					<s:iterator id="riskfollow" value="riskfollowlist" status="st">
						<tr>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#riskfollow.riskPossibility"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#riskfollow.riskEfficiency"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#riskfollow.riskTrigger"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#riskfollow.problem"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#riskfollow.follower"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#riskfollow.description"></s:property></td>
						</tr>
					</s:iterator>
				</table></td>
		</tr>
		</table>
	
</body>
</html>