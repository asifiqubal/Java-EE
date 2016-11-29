package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.MemberListAdapter;
import models.MemberList;

/**
 * Servlet implementation class EditMemberServlrt
 */
public class EditMemberServlrt extends HttpServlet {
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
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_editmember.jsp");
		disp.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id=Integer.parseInt(request.getParameter("id").toString());
		MemberList mem = new MemberList();
		mem.setUser_id(user_id);
		mem.setMember_name(request.getParameter("mname").toString());
		mem.setPhone(request.getParameter("phone").toString());
		mem.setEmail(request.getParameter("email").toString());
		mem.setAddress(request.getParameter("address").toString());
		mem.setDob(request.getParameter("dob").toString());
		mem.setStatus("Active");
		MemberListAdapter ea = new MemberListAdapter();
		//response.getWriter().println(user2.getUser_id());
		ea.update(mem);
		response.sendRedirect("/librarymanagement/memberlist");
	}

}
