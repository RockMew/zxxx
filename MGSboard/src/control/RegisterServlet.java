package control;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;


/**
 * Servlet implementation class Register
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");
		
		try{
			/*
			 * Class.forName("com.mysql.jdbc.Driver"); String url =
			 * "jdbc:mysql://localhost:3306/1400310120lzzpicturedb"; String
			 * username = "sa"; String password = "123456";
			 * 
			 * Connection conn = DriverManager.getConnection(url,
			 * username,password);
			 */
			Connection conn = null;
			conn = Getcon.getConnection();
			
			String strname = request.getParameter("name");
			String strpassword = request.getParameter("password");
			
			String checkname = "select * from login";
			PreparedStatement cs = conn.prepareStatement(checkname);
			cs.executeQuery();
			
			ResultSet checkresultset = cs.getResultSet();
			
			while(checkresultset.next())
		       {
				if(strname.equals(checkresultset.getString("name")))
				{
				
				response.getWriter().write("<SCRIPT>alert('The user has already existed £¡');history.back();</SCRIPT>");
				
				return;
				}
		       }
			
			long max = 1;
			checkresultset.beforeFirst();
			while(checkresultset.next())
			{
				if(checkresultset.getInt("ID") > max)
				{
					max = checkresultset.getInt("ID");
				}
			}
			max = max +1;
			
			String sql = "insert into login values(?,?,0,?)";
			PreparedStatement rs = conn.prepareStatement(sql);
			
			rs.setString(1, strname);
			rs.setString(2, strpassword);
			rs.setInt(3, (int) max);
			
			rs.executeUpdate();
			
			
			String wpath = request.getSession().getServletContext().getRealPath("") ;
			String dirname = wpath + "\\user\\" + strname;
			
			System.out.println(dirname);
			File file = new File(dirname);
			file.mkdirs();

			
			User newuser = new User();
			newuser.setName(strname);
			
			request.setAttribute("User", newuser);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
