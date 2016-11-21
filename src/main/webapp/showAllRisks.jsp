<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Risks Info</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>
<body>
<h3>Risks info</h3>

 	<div class="import">
<table width='800' border='0' align='center' cellpadding='0'
		cellspacing='1' bgcolor='#FFFFFF'>
			<tr>
			<form action="riskSearch">
				<td width="30%"><label>开始时间</label><input type="date" id="startTime" name="startTime"></td>
				<td width="30%"><label>结束时间</label><input type="date" id="endTime" name="endTime"></td>
				<td width="30%" style="text-align:right;"><input type="submit" class="submit_button" value="查询"></td>
			</form>
			<form action="forChart">
				<input type="hidden" id="hidStart" name="hidStart"><input type="hidden" id="hidEnd" name="hidEnd">
				<td style="text-align:right;"><input type="submit" class="submit_button" onclick="myFunc()" value="图表"></td>
			</form>
			</tr>
			<tr>
				<td colspan="4" bgcolor='#FFFFFF'><table width='100%' border='0'
						cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
						<tr>
							<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险名称</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险内容</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>可能性</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>影响程度</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>触发器/阀值</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>提交者</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>跟踪者</strong></td>
						</tr>
						<s:iterator id="risk" value="risklist" status="st">
						<tr>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskName"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskContent"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskPossibility"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskEfficiency"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.riskTrigger"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.creatorName"></s:property></td>
							<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><s:property
									value="#risk.follower"></s:property></td>
						</tr>
					</s:iterator>
				</table></td>
			</tr>
		</table>
	</div>
<script>
function myFunc(){
	document.getElementById("hidStart").value=document.getElementById("startTime").value;
	document.getElementById("hidEnd").value=document.getElementById("endTime").value;
}
</script>
</body>
</html>