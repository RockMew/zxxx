package control;

import java.sql.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funtion.Func;
import model.*;

/**
 * Servlet implementation class Loginserverlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// // TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");

		try {
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

			User myuser = new User();
			myuser.setName(strname);

			String checkname = "select * from login order by ID";
			PreparedStatement cs = conn.prepareStatement(checkname);
			cs.executeQuery();

			ResultSet checkresultset = cs.getResultSet();
			List<User> userlist = new ArrayList<User>();

			checkresultset.beforeFirst();

			while (checkresultset.next()) {

				User userall = new User();

				userall.setName(checkresultset.getString("name"));
				userall.setPassword(checkresultset.getString("password"));
				userall.setAdministrator(checkresultset
						.getString("Administrator"));
				userall.setId(checkresultset.getInt("id"));

				userlist.add(userall);
			}

			checkresultset.beforeFirst();
			while (checkresultset.next()) {
				if (strname.equals(checkresultset.getString("name"))
						&& strpassword.equals(checkresultset
								.getString("password")))

				{

					HttpSession session = request.getSession();

					session.setAttribute("User", myuser);
					List<MessBoar> al = new ArrayList<MessBoar>();
					al = Func.findMbInfo();       //获取留言板的内容，返回一个数组
					session.setAttribute("al", al);               //把数组保存起来

					if (checkresultset.getString("administrator").equals("1")) {
						request.setAttribute("userlist", userlist);
						request.getRequestDispatcher("admin.jsp").forward(
								request, response);

						return;
					}

					request.getRequestDispatcher("User.jsp").forward(request,
							response);

					return;
				}

			}

			response.getWriter().write(
					"<SCRIPT>alert('用户名或密码不正确！');history.back();</SCRIPT>");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error!");
		}
	}

}
