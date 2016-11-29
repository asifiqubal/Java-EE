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
 * Servlet implementation class AddBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("user")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addbook.jsp");
		disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookList addbook = new BookList();
		addbook.setBook_name(request.getParameter("book_name").toString());
		addbook.setEdition(request.getParameter("edition").toString());
		addbook.setAuthor_name(request.getParameter("author_name").toString());
		addbook.setCategory(request.getParameter("category").toString());
		addbook.setAvailable_copy(Integer.parseInt(request.getParameter("available_copy").toString()));
		addbook.setTotal_copy(Integer.parseInt(request.getParameter("total_copy").toString()));
		
		BookListAdapter bl= new BookListAdapter();
		bl.insert(addbook);
		
		response.sendRedirect("/librarymanagement/booklist");
	}

}
