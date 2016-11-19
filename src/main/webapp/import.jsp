<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Import Risks</title>
<link rel="stylesheet" type="text/css" href="CSS/structure.css">
</head>
<body>
	<h3>Import risks</h3>
 	<form class="import">
 	<table>
 	<tr>
 	<td>
	<label>开始时间</label><input type=date></td>
	<td>
	<label>结束时间</label><input type=date></td>
	<td>
	<select>
		<option value="volvo" selected="selected">无</option>
  		<option value="saab">被识别最多的风险</option>
  		<option value="opel">演化成问题最多的风险</option>
	</select></td>
	</tr>
	<tr>
	<td bgcolor='#FFFFFF'><table width='100%' border='0'
					cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>
					<tr>
						<td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><input type="checkbox" id="checkAll" name="checkAll"/></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险名称</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>风险内容</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>可能性</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>影响程度</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>触发器/阀值</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>提交者</strong></td>
						<td align='center' valign='middle' bgcolor='#B9E3FF'><strong>跟踪者</strong></td>
					</tr>
					<tr>
						<td><input type="checkbox"  value="${item.id}"/></td>
					</tr>
					</table></td></tr>
	</table>
	<script>
	var $thr = $('table tr');   
	var $checkAll = $thr.find('input');   
		$checkAll.click(function(event){  	     
	    $thr.find('input').prop('checked',$(this).prop('checked'));  	     
	    if ($(this).prop('checked')) {  
	        $thr.find('input').parent().parent().addClass('warning');  
	    } else{  
	        $thr.find('input').parent().parent().removeClass('warning');  
	    }  
	    event.stopPropagation();  
	});  
	</script>
	</form>
</body>
</html>