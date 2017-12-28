<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>

<script type="text/javascript">
	function check(form) {
		with (form) {
			if (name.value == "") {
				alert("名称不能为空");
				return false;
			}

			if (password.value == "") {
				alert("密码不能为空");
				return false;
			}

		}
	}
	
</script>

</head>
<body>
<br>
<div class="header">
		<table width="100%">
			<tr>
				<td align="right">你好！</td>
			</tr>
		</table>
	</div>
    <form action="LoginServlet" method = "post" onsubmit="return check(this)">
    
    <table align="center" width="450" border="0"> 
    
		<tr>
			<td align="center" colspan="2">
				<h2>登录</h2>
				<hr>
			</td>
		</tr>

		<tr>
			<td width="40%" align="right" colspan="1">姓名：</td>
			<td align="left"><input type = "text" name = "name" style="width:120px"> <br>

		<tr>
			<td width="40%" align="right">密码：</td>
			<td align="left"><input  type = "password" name = "password" style="width:120px"> <br></td>
		</tr>
		
		<tr> <td height=20></td></tr>
		
		<tr>
			<td width="40%" align="center" colspan="2"><input type="submit" name = "slogin" value="登  录"></td>
			
		</tr>
		
	  </table>
    
    </form>
    
<h2 align="center">
	<a href="Register.jsp">注册新用户</a>
</h2>

</body>
</html>