package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.BookListAdapter;

/**
 * Servlet implementation class GuestBookListServlet
 */
public class GuestBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookListAdapter bl = new BookListAdapter();
		request.setAttribute("booklist", bl.getAll());
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_guestbooklist.jsp");
		disp.forward(request, response);
	}

}
