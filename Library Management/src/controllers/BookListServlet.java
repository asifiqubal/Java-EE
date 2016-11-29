package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.BookListAdapter;

/**
 * Servlet implementation class BookListServlet
 */
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		BookListAdapter bl = new BookListAdapter();
		request.setAttribute("booklist", bl.getAll());
		
		HttpSession session = request.getSession();
		int user_id= Integer.parseInt(session.getAttribute("user_id").toString());
		String type=session.getAttribute("type").toString();
		
		request.setAttribute("user_id", user_id);
		//response.getWriter().println(type+"sdds"+user_id);
		
		if(type.equals("user"))
		{
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_userbooklist.jsp");
			disp.forward(request, response);
		}
		
		else if(type.equals("admin"))
		{
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_adminbooklist.jsp");
			disp.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
