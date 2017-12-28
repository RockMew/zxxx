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
		// �����������
		request.setCharacterEncoding("gb2312");
		// ������Ӧ����
		response.setContentType("gb2312");
		// ��ȡtitle����
		String title = request.getParameter("title");
		// ��ȡmessage����
		String message = request.getParameter("message");
		
		String iname = request.getParameter("ifname");
        
		// ��session��ȡ����ǰ�û�����
		// Login leaveMessageBoard=(Login)
		// request.getSession().getAttribute("login");
		User us = (User) request.getSession().getAttribute("User");
		// �������Ա��ӦJavaBean���󣬰����ݷ�װ��ȥ
		MessBoar mb = new MessBoar();
		mb.setId( (int) us.getId() );
		// ����Ϊ��ȡ�ĵ�ǰʱ��
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
		// ��DB���еķ����ж��Ƿ����ɹ�
		if (new Func().addInfo(mb)) 
		{
			HttpSession session = request.getSession();
			List<MessBoar> al = new ArrayList<MessBoar>();
			al = Func.findMbInfo();       //��ȡ���԰�����ݣ�����һ������
			session.setAttribute("al", al);               //�����鱣������
			response.sendRedirect("main.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
