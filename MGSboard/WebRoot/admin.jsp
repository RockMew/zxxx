<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">



<script>

function show(){
 var myTable= document.getElementById("user"); 
 myTable.style.display="block";
 
 var myTable2= document.getElementById("alterdata"); 
 myTable2.style.display="block";
 
 var myTable3= document.getElementById("deldata"); 
 myTable3.style.display="block";
 
 return;

}

function hid(){

var myTable= document.getElementById('user');
myTable.style.display ="none";

var myTable2= document.getElementById('alterdata');
myTable2.style.display ="none";

var myTable2= document.getElementById("deldata"); 
myTable3.style.display="none";

return;
}

function check(form) {
	 var radios = document.getElementsByName("select");
	 var planid;

	 var result = false;
	 for ( var i = 0; i < radios.length; i++) {
	  if (radios[i].checked) {

	   planid = radios[i].value;
	   result = true;
	   break;
	  }
	 }
	 // alert(planid);
	 if (!result) {
	  alert("单选框不能为空！")
	  return false;
	 }
}

</script>


<title>admin</title>
</head>
<body>


<div class="header">
		<table width="100%" border="0">
			<tr>
				<td colspan="6" align="right">欢迎 ${User.name }</td>
			</tr>
			<tr> <td height=50></td></tr>
			<tr>
				<td colspan="6" align="center"><h2>管理员功能</h2></td>
			</tr>
			<tr>
			    <td width ="40%" align ="right"><input type="button" name="button" value="修改用户" onclick="show()"></td>
			    <td align="center"><input type="button" name="button" value="关闭" onclick="hid()"></td>
			</tr>
			
		</table>
	</div>	


	  <form id = "alterTable" action="AdminServlet" method = "post" onsubmit="return check(this)">
	  
	  <div class="userdata" id="user" style="display: none">
        <table id="userTable" align="center" border="0">
        <c:set var="index" value="1" />
			<c:forEach  items = "${userlist }" var = "list">
			    <tr>
			        <td><input width = "20" type="radio" name="select" value="${index }"></td>
			        <td width = 50>ID:${list.id }</td>
			    	<td width = 100>姓名:${list.name }</td>
			    	<td width = 100>密码 :${list.password } </td>
				    <td width = 100>管理员 :${list.administrator }</td>
				    <c:set var="index" value="${index+1}" />
			    </tr>
			</c:forEach>
			</table>
		</div>
		
		<div class="alter" id = "alterdata" style="display: none">
			<table  id = "altertable" align="center" border="0">
			<tr> <td height=50></td></tr>
	        <tr>
	        <td>用户名：：<input  size="50px"  type = "text" name = "newname"></td>
	        <td>密码：<input  size="50px"  type = "text" name = "newpassword"></td>
	        <td>是否管理员：<input  size="50px"  type = "text" name = "newadministrator"></td>
	         <td><input type="submit" id="updatebutton" name="updatebutton" value="修  改"></td>
	        </tr>   
         </table>
         </div> 
         
         <div class="delter" id = "deldata" style="display: none">
			<table  id = "deltable" align="center" border="0">
			<tr> <td height=50></td></tr>
	        <tr>
	        <td><input type="submit" id="delbutton" name="delbutton" value="删  除"></td>
	        </tr>   
         </table>
         </div> 
	 </form>
</body>


</html>