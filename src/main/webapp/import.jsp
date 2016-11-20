<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.*,java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Import Risks</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
<script type="text/javascript" src="jquery-3.1.1.min.js"></script>
</head>
<body>
	<h3>Import risks</h3>

	<table width='800' border='0' align='center' cellpadding='0'
		cellspacing='1' bgcolor='#FFFFFF'>
		<tr>
			<form class="import" action="importDateChoice" method="post">
				<td><label>开始时间</label><input name="startTime" type="date"></td>
				<td><label>结束时间</label><input name="endTime" type="date"></td>
				<td><label>筛选</label><select name="type">
						<option value="volvo" selected="selected">无</option>
						<option value="saab">被识别最多的风险</option>
						<option value="opel">演化成问题最多的风险</option>
				</select></td>
				<td><input type="submit" class="submit_button" value="查询"></td>
			</form>
		</tr>
		<tr>
			<form class="chosedcheckbox" action="importRiskId" method="post">
				<td colspan="4" bgcolor='#FFFFFF'><table width='100%'
						border='0' cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
						<tr>
							<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><input
								type="checkbox" id="checkAll" name="checkAll" /></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险名称</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险内容</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>可能性</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>影响程度</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>触发器/阀值</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>提交者</strong></td>
							<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>跟踪者</strong></td>
						</tr>
						<s:iterator id="risk" value="risklist" status="st">
							<tr>
								<td height='20' align='center' valign='middle' bgcolor='#FFFFFF'><input type="checkbox" name="checkedValue"
									value='<s:property value="#risk.id"></s:property>'></td>
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
							</tr>
						</s:iterator>						
					</table></td>
					<tr><td colspan=8 style="text-align:right">
						<footer style="text-align:right"> <input type="submit" value="导入风险条目" class="submit_button"> </footer>	
					</td></tr>	
			</form>
		</tr>
	</table>
	

	<script>
		var $thr = $('table tr');
		var $checkAll = $thr.find('#checkAll');
		$checkAll.click(function(event) {
			$thr.find('input').prop('checked', $(this).prop('checked'));
			if ($(this).prop('checked')) {
				$thr.find('input').parent().parent().addClass('warning');
			} else {
				$thr.find('input').parent().parent().removeClass('warning');
			}
			event.stopPropagation();
		});
	</script>
</body>
</html>