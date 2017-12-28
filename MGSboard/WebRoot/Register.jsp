<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册</title>

<script type="text/javascript">
	function check(form) {
		with (form) {
			if (name.value == "") {
				alert("名称不能为空");
				return false;
			}

			if (pass.value == "") {
				alert("密码不能为空");
				return false;
			}

		}
	}
	

</script>

</head>
<body>
欢迎${User.name }<br>
<br>
    <form action="RegisterServlet" method = "post" onsubmit="return check(this)">
    
    <table align="center" width="450" border="0"> 
    
		<tr>
			<td align="center" colspan="2">
				<h2>注册</h2>
				<hr>
			</td>
		</tr>

		<tr>
			<td width="40%" align="right" colspan="1">姓名：</td>
			<td align="left"><input type = "text" name = "name" style="width:120px"><td>
		<tr>
			<td width="40%" align="right">密码：</td>
			<td align="left"><input  type = "password" name = "password" style="width:120px"> <br></td>
		</tr>
		
		<tr> <td height=20></td></tr>
		
		<tr>
			<td width="40%" align="center" colspan="2"><input type="submit" name = "slogin" value="注   册"></td>
			
		</tr>
	  </table>
    
    
    </form>
    
<h2 align="center">
	<a href="Login.jsp">返回登录</a>
</h2>

</body>
</html>