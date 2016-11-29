package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.BookListAdapter;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_guesthome.jsp");
		disp.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search").toString();
		BookListAdapter ba= new BookListAdapter();
		request.setAttribute("blist", ba.getSearchBook(search));
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_guestsearchbooklist.jsp");
		disp.forward(request, response);
	}

}
