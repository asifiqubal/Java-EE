package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.MemberListAdapter;


public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("user")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		int user_id=Integer.parseInt(request.getParameter("id").toString());
		MemberListAdapter mlist=new MemberListAdapter();
		response.getWriter().println(user_id);
		request.setAttribute("mlist", mlist.get(user_id));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_deleteuser.jsp");
		disp.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int user_id=Integer.parseInt(request.getParameter("id").toString());
		MemberListAdapter mlist=new MemberListAdapter();
		mlist.delete(user_id);
		response.sendRedirect("/librarymanagement/memberlist");
		
	}
}
