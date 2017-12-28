<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<div>
	<table>
	<tr> <td height=20></td></tr>
        <tr>
            <td align="center">主菜单</td>
        </tr>
        <tr>
            <td><a href="admin.jsp" target="fun">修改密码</a></td>
        </tr> 
        <tr>
            <td><a href="leavemessage.jsp" target="fun">留言</a></td>
        </tr>
        <tr>
            <td><a href="Login.jsp" target="fun">注销</a></td>
        </tr>
    </table>
</div>
</body>
</html>