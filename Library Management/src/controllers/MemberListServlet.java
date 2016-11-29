package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.MemberListAdapter;


public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("user")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		MemberListAdapter mlist =new MemberListAdapter();
		
		request.setAttribute("mlist", mlist.getAll());
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_memberlist.jsp");
		disp.forward(request, response);
		}
		
	}

}
