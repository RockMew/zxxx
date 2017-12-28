package control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import funtion.Func;
import model.MessBoar;
import model.User;

public class LeaveMessageServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码
		request.setCharacterEncoding("gb2312");
		// 设置响应编码
		response.setContentType("gb2312");
		// 获取title内容
		String title = request.getParameter("title");
		// 获取message内容
		String message = request.getParameter("message");
		
		String iname = request.getParameter("ifname");
        
		// 从session中取出当前用户对象
		// Login leaveMessageBoard=(Login)
		// request.getSession().getAttribute("login");
		User us = (User) request.getSession().getAttribute("User");
		// 建立留言表对应JavaBean对象，把数据封装进去
		MessBoar mb = new MessBoar();
		mb.setId( (int) us.getId() );
		// 参数为获取的当前时间
		if(iname == null)
		{
			mb.setName(us.getName());
		}
		else
		{
			mb.setName("unknow");
		}
		mb.setTime(new Date(System.currentTimeMillis()));
		//mb.setTime(new Date(0));
		mb.setTitle(title);
		mb.setMessage(message);
		// 调DB类中的方法判断是否插入成功
		if (new Func().addInfo(mb)) 
		{
			HttpSession session = request.getSession();
			List<MessBoar> al = new ArrayList<MessBoar>();
			al = Func.findMbInfo();       //获取留言板的内容，返回一个数组
			session.setAttribute("al", al);               //把数组保存起来
			response.sendRedirect("main.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
