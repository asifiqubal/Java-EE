package controllers;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.MemberListAdapter;
import adapters.UserAdapter;
import models.MemberList;
import models.User;

/**
 * Servlet implementation class AddMemberServlet
 */
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("user")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_membercreate.jsp");
			disp.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random RANDOM = new SecureRandom();
		final int PASSWORD_LENGTH = 6;
		String letters = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@";
		String pw = "";
		
		for (int i=0; i<PASSWORD_LENGTH; i++)
		{
			int index = (int)(RANDOM.nextDouble()*letters.length());
			pw += letters.substring(index, index+1);
		}
      
		User user=new User();
		user.setPassword(pw);
		user.setUser_name(request.getParameter("email").toString());
		user.setType("user");
		UserAdapter ua =new UserAdapter();
				ua.insert(user);
		response.getWriter().println(request.getParameter("email"));
		response.getWriter().println(pw);
				
		
		UserAdapter ua2 = new UserAdapter();
		User user2=new User();
		user2=ua2.get(request.getParameter("email"), pw);
		
		MemberList mem = new MemberList();
		mem.setUser_id(user2.getUser_id());
		mem.setMember_name(request.getParameter("mname").toString());
		mem.setPhone(request.getParameter("phone").toString());
		mem.setEmail(request.getParameter("email").toString());
		mem.setAddress(request.getParameter("address").toString());
		mem.setDob(request.getParameter("dob").toString());
		mem.setStatus("Active");
		MemberListAdapter ea = new MemberListAdapter();
		response.getWriter().println(user2.getUser_id());
		ea.insert(mem);
		
		response.sendRedirect("/librarymanagement/addmember");
	}

}
