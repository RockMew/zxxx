<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@page import="model.MessBoar" %>
<%@page import="funtion.*" %>

<html>
  <head>  
    <title>���԰����</title>
  </head>

  <div style="margin-left:35%;margin-top:100px;font-family:Microsoft YaHei">
   <h1 style="margin-left:12%">���԰�</h1>
   <form  action="leavemessage.jsp" method="post">
  		<table border="1">
  			<caption>����������Ϣ</caption>
  			<tr><th>����������</th><th>����ʱ��</th>
				<th>���Ա���</th><th>��������</th></tr>
  		<%
  			ArrayList<MessBoar> al=new ArrayList<MessBoar>();
  			al= (ArrayList)session.getAttribute("al");
  			if(al!=null)
  			{
  				Iterator iter=al.iterator();
  				while(iter.hasNext())
  				{
  				MessBoar mb=(MessBoar)iter.next();
  		%>
  				<tr><td><%= mb.getName() %></td>
  					<td><%= mb.getTime().toString() %></td>
  					<td><%= mb.getTitle() %></td>
  					<td><%= mb.getMessage() %></td></tr>
  		<% 
  			}
  			}
  		 %>
  		</table>
  	</form>
  	 <a style="margin-left:10%" href="Login.jsp">ע��</a>
   <a style="margin-left:20%" href="leavemessage.jsp">����</a>
    </div>
  </body>
</html>
