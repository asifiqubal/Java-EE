package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.BookListAdapter;
import models.BookList;

/**
 * Servlet implementation class EditBookListServlet
 */
public class EditBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("user")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		int book_id=Integer.parseInt(request.getParameter("book_id").toString());
		BookListAdapter editbook=new BookListAdapter();
		request.setAttribute("editbook", editbook.get(book_id));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_editbooklist.jsp");
		disp.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int book_id=Integer.parseInt(request.getParameter("book_id").toString());
		BookList editbooklist = new BookList();
		editbooklist.setBook_id(book_id);
		editbooklist.setBook_name(request.getParameter("book_name").toString());
		editbooklist.setEdition(request.getParameter("edition").toString());
		editbooklist.setAuthor_name(request.getParameter("author_name").toString());
		editbooklist.setCategory(request.getParameter("category").toString());
		editbooklist.setAvailable_copy(Integer.parseInt(request.getParameter("available_copy").toString()));
		editbooklist.setTotal_copy(Integer.parseInt(request.getParameter("total_copy").toString()));
		BookListAdapter bl = new BookListAdapter();
		bl.update(editbooklist);
		response.sendRedirect("/librarymanagement/booklist");
	}

}
