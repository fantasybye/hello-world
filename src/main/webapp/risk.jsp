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
	String possibility= "低";
	String effect = "高";
	List<risk> risks = new ArrayList<risk>();
	risks.add(new risk(1, "TEST","111", 1, 1, "w", "z", "y"));
	risks.add(new risk(2, "TEST","111", 1, 1, "w", "z", "y"));
	risks.add(new risk(3, "TEST","111", 1, 1, "w", "z", "y"));
%>
<body>
	<h3 align="center">Manage your risks</h3>
	<form class="edit">
		<table width='600' align="center">
			<tr>
			<td width='150' align="center">风险名称</td>
				<td width='450'><input type="hidden" id="risk_rid" /> <input
					type="text" id="risk_name" name="rname"></td>
			</tr>
			<tr>
				<td width="150" align="center">风险内容</td>
				<td><input type="text" id="risk_content" name="rcontent"></td>
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
			onClick="" id="submit_button"> </footer>
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
						<%
							for (risk risk:risks){
								switch(risk.getRiskPossibility()){
								case 1:possibility = "低";break;
								case 2:possibility = "中";break;
								case 3:possibility = "高";break;
								default:break;	
								}
								
								switch(risk.getRiskEfficiency()){
								case 1:effect = "低";break;
								case 2:effect = "中";break;
								case 3:effect = "高";break;
								default:break;	
								}
						%>
						<tr>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=risk.getRiskName() %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=risk.getRiskContent() %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=possibility %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=effect %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=risk.getRiskTrigger() %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=risk.getCreatorName() %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><%=risk.getFollower() %></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'>[<a href='javascript:void(0)' onClick="" >修改</a>][<a href='javascript:void(0)' onClick="" >删除</a>]</td>
						</tr>
						<%
							}
						%>
					</table></td>
			</tr>
	</table>

	</form>
</body>

</html>