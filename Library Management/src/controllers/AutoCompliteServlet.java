package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.BookListAdapter;
import models.BookList;

/**
 * Servlet implementation class AutoCompliteServlet
 */
public class AutoCompliteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=request.getParameter("search").toString();
		BookListAdapter ba= new BookListAdapter();
		ArrayList<BookList> ba2=new ArrayList<BookList>();
		ba2= ba.getSearchBook(search);
		String elist = "[";
		for (BookList bookList : ba2) {
			elist+="\"" + bookList.getBook_name() + "\",";
			
		}
		if (elist != null && elist.length() > 0 && elist.charAt(elist.length()-1)==',') {
			elist = elist.substring(0, elist.length()-1);
		    }
		elist += "]";
		response.getWriter().print(elist);
	}

}
