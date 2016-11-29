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
 * Servlet implementation class DeleteBookListServlet
 */
public class DeleteBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("user")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		int book_id=Integer.parseInt(request.getParameter("book_id").toString());
		BookListAdapter deletebook=new BookListAdapter();
		request.setAttribute("deletebook", deletebook.get(book_id));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_deletebook.jsp");
		disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int book_id=Integer.parseInt(request.getParameter("book_id").toString());
		BookListAdapter deletebook=new BookListAdapter();
		deletebook.delete(book_id);
		response.sendRedirect("/librarymanagement/booklist");
	}

}
