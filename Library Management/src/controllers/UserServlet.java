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
 * Servlet implementation class User
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("admin")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_userhome.jsp");
		disp.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search").toString();
		BookListAdapter ba= new BookListAdapter();
		request.setAttribute("blist", ba.getSearchBook(search));
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_usersearchbooklist.jsp");
		disp.forward(request, response);
	}

}
