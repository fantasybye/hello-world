<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.STYLE1 {
	font-size: 12px
}
</style>
</head>
<script>
	var students;
	function initData() {
		students = [];
	}
	initData();
	function showStudents() {
		var html = "";
		html += " <table width='651' border='0' align='center' cellpadding='0' cellspacing='1' bgcolor='#0099FF'>";
		html += "    <tr>";
		html += "      <td bgcolor='#FFFFFF'><table width='100%' border='0' cellpadding='0' cellspacing='1' bgcolor='#B9E3FF'>";
		html += "          <tr>";
		html += "            <td height='24' align='center' valign='middle' bgcolor='#B9E3FF'><strong>学生名字</strong></td>";
		html += "            <td align='center' valign='middle' bgcolor='#B9E3FF'><strong>年龄</strong></td>";
		html += "            <td align='center' valign='middle' bgcolor='#B9E3FF'><strong>性别</strong></td>";
		html += "            <td align='center' valign='middle' bgcolor='#B9E3FF'><strong>电话</strong></td>";
		html += "            <td align='center' valign='middle' bgcolor='#B9E3FF'><strong>地址</strong></td>";
		html += "            <td align='center' valign='middle' bgcolor='#B9E3FF'><strong>操作</strong></td>";
		html += "          </tr>";
		for (var i = 0; i < students.length; i++) {
			html += "<tr>";

			html += "            <td height='20' align='center' bgcolor='#FFFFFF'>"
					+ students[i].sname + "</td>";
			html += "            <td height='20' align='center' bgcolor='#FFFFFF'>"
					+ students[i].age + "</td>";
			html += "            <td align='center' bgcolor='#FFFFFF'>"
					+ students[i].sex + "</td>";
			html += "            <td align='center' bgcolor='#FFFFFF'>"
					+ students[i].phoneNumber + "</td>";
			html += "            <td bgcolor='#FFFFFF'>" + students[i].address
					+ "</td>";
			html += "            <td align='center' valign='middle' bgcolor='#FFFFFF'>";

			html += "[<a href='javascript:void(0)' onclick='DeleteStudent(\""
					+ students[i].sid + "\")'>删除</a>]";
			html += "[<a href='javascript:void(0)' onclick='showStudent(\""
					+ students[i].sid + "\")'>修改</a>]";

			html += "</td>";

			html += "</tr>";

		}

		html += "      </table></td>";
		html += "    </tr>";
		html += "  </table>";

		showStudentDivID.innerHTML = html;

	}

	function showStudent(sid) {
		for (var i = 0; i < students.length; i++) {

			if (students[i].sid == sid) {
				student_name.value = students[i].sname;
				if (students[i].sex == "男") {
					student_sex[0].checked = true;
				} else {
					student_sex[1].checked = true;
				}

				student_age.value = students[i].age;
				student_sid.value = sid;
				submit_button.onclick = editStudent;
				student_phoneNumber.value = students[i].phoneNumber;
				student_address.value = students[i].address;

				submit_button.value = "修改信息";
				qiehuan_button.style.display = "block";
				break;
			}
		}
	}

	function addStudent() {
		var sname = student_name.value;

		var age = student_age.value;
		var s = "";

		if (student_sex[0].checked) {
			s = "女";
		} else {
			s = "男";
		}

		var sex = s;

		var phoneNumber = student_phoneNumber.value;
		var address = student_address.value;

		var student = [ {
			"sid" : "1",
			"sname" : "",
			"sex" : "",
			"age" : "",
			"phoneNumber" : "",
			"address" : ""
		} ];

		student[0].sid = new Date().getTime() + "";
		student[0].sname = sname;
		student[0].age = age;
		student[0].sex = sex;
		student[0].phoneNumber = phoneNumber;
		student[0].address = address;

		students.push(student[0]);

		showStudents();

		clear();

		student_name.focus();

	}

	
	function DeleteStudent(sid) {
		var sname = "";
		var flag = false;
		for (var i = 0; i < students.length; i++) {
			if (students[i].sid == sid) {
				sname = students[i].sname;
				flag = true;
				break;
			}
		}
		if (!confirm("您确定要删除[" + sname + "]吗？")) {
			return;
		}
		if (flag) {
			var newStudents = new Array(students.length - 1);

			var index = 0;
			for (var i = 0; i < students.length; i++) {

				if (students[i].sid != sid) {
					var student = [ {
						"sid" : "1",
						"sname" : "",
						"age" : "",
						"sex" : "",
						"phoneNumber" : "",
						"address" : ""
					} ];
					student[0].sid = students[i].sid;
					student[0].sname = students[i].sname;
					student[0].age = students[i].age;
					student[0].sex = students[i].sex;
					student[0].phoneNumber = students[i].phoneNumber;
					student[0].address = students[i].address;
					newStudents[index] = student[0];
					index++;
				}

			}
			students = newStudents;

			showStudents();

		}
	}

	function qiehuan() {
		submit_button.onclik = addStudent;
		submit_button.value = "添加学生";
		qiehuan_button.style.display = "none";

	}

	function editStudent() {

		for (var i = 0; i < students.length; i++) {

			if (students[i].sid == student_sid.value) {
				var sname = student_name.value;
				var age = student_age.value;
				var s = "";
				if (student_sex[0].checked) {
					s = "女";
				} else {
					s = "男";

				}
				var sex = s;
				var phoneNumber = student_phoneNumber.value;
				var address = student_address.value;
				students[i].sname = sname;
				students[i].age = age;
				students[i].sex = sex;
				students[i].phoneNumber = phoneNumber;
				students[i].address = address;

				break;
			}
		}
		qiehuan();
		showStudents();
		clear();
	}

	function clear() {

		student_name.value = "";
		student_age.value = "";
		student_sex[0].checked = true;
		student_phoneNumber.value = "";
		student_address.value = "";

	}
</script>


<body>
	<h1 align="center">添加学生信息</h1>

	<table width="570" height="206" border="1" align="center"
		cellpadding="0" cellspacing="1">
		<tr>
			<td width="48" align="center" bgcolor="#A7FAF1">姓名</td>
			<td width="315"><input type="hidden" id="student_sid" /> <input
				type="text" id="student_name" name="sname"></td>
			<td width="195"><div id="d1"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#A7FAF1">年龄</td>
			<td><input type="text" id="student_age" name="sage"></td>
			<td><div id="d2"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#A7FAF1">性别</td>
			<td><input type="radio" name="sex" id="student_sex" value="女"
				checked="checked">女 <input type="radio" name="sex"
				id="student_sex" value="男">男</td>
			<td><div id="d3"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#A7FAF1">电话</td>
			<td><input type="text" id="student_phoneNumber"></td>
			<td><div id="d4"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="#A7FAF1">住址</td>
			<td><input type="text" id="student_address"></td>
			<td><div id="d5"></td>
		</tr>
		<tr align="center">
			<td colspan="2" bgcolor="#A7FAF1"><input type="button"
				value="  确认信息  " onClick="formTest()">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
				value="   添加学生   " onClick="addStudent()" id="submit_button">
			</td>
			<td bgcolor="#A7FAF1"><input type="button" value="  切换  "
				onClick="qiehuan()" id="qiehuan_button" style="display: none"
				align="left"></td>
		</tr>
	</table>
	<p></p>
<div id="showStudentDivID"></div>
</body>

</html>