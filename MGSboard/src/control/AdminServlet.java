package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Adminserverlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		// TODO Auto-generated method stub
		try {
			/*
			Class.forName("com.mysql.jdbc.Driver");  
			String url = "jdbc:mysql://localhost:3306/1400310120lzzpicturedb"; 
			String username = "sa";
			String password = "123456";
			
			Connection conn = DriverManager.getConnection(url, username,password);
			*/
			Connection conn = null;
			conn = Getcon.getConnection();
			
			int select = Integer.parseInt( request.getParameter("select") );
			String sname = request.getParameter("newname");
			String spassword = request.getParameter("newpassword");
			String sadmin = request.getParameter("newadministrator");
			String sbutton = request.getParameter("delbutton");
			
			/*System.out.println(select + sname + spassword);*/
			
			
			
			if(sbutton != null)
			{
				String del = "delete from login where id=?";
				java.sql.PreparedStatement delID = conn.prepareStatement(del);
				
				delID.setLong(1, select);
				
				delID.executeUpdate();
				
				response.getWriter().write("<SCRIPT>alert('用户已被删除！');history.back();</SCRIPT>");
				
				return;
			}
			
			//System.out.println(select + sname + spassword + sadmin);
			
			String checkname = "select * from login";
			java.sql.PreparedStatement check = conn.prepareStatement(checkname);
			check.executeQuery();
			
			ResultSet checkresultset = check.getResultSet();
			
			while(checkresultset.next())
		       {
				if(sname.equals(checkresultset.getString("name") ) 
						&& select != (checkresultset.getInt("id")) )
				{
				
				    response.getWriter().write("<SCRIPT>alert('用户名已被使用！');history.back();location.reload();</SCRIPT>");
		
				return;
				}
		       }
			if(sname.equals(""))
			{
                response.getWriter().write("<SCRIPT>alert('请输入姓名！');history.back();location.reload();</SCRIPT>");
				
				return;
			}
			if(spassword.equals(""))
			{
                response.getWriter().write("<SCRIPT>alert('请输入密码！');history.back();location.reload();</SCRIPT>");
				
				return;
			}
			

			String sql = "update login set name=?, password=?, administrator=? where id=?";
			conn.prepareStatement(sql);
			java.sql.PreparedStatement cs = conn.prepareStatement(sql);
			
			if(sadmin.equals("1"))
			{
				cs.setString(3, "1");
			}
			else
			{
				cs.setString(3, "0");
			}
			
			cs.setString(1, sname);
			cs.setString(2, spassword);
			cs.setInt(4, select);
			
			
			cs.executeUpdate();
			
			response.getWriter().write("<SCRIPT>alert('修改成功!');history.back();</SCRIPT>");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error!");
		}
	}

}
