package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.BookListAdapter;
import adapters.BorrowListAdapter;
import models.BookList;

public class BorrowConDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int borrow_id = Integer.parseInt(request.getParameter("id").toString());
		String msg = request.getParameter("msg").toString();
		
		if(msg.equals("delete"))
		{
			int book_id = Integer.parseInt(request.getParameter("book_id").toString());
			//response.getWriter().println(book_id);
			BorrowListAdapter bl = new BorrowListAdapter();
			bl.delete(borrow_id);
			
			BookListAdapter bka = new BookListAdapter();
			BookList param = new BookList();
			param = bka.get(book_id);
			int available_copy = param.getAvailable_copy();
			//response.getWriter().println(available_copy);
			available_copy++;
			bl.updateAvailable(book_id,available_copy);
		}
		
		else if(msg.equals("confirm"))
		{
			String status = "borrowed";
			BorrowListAdapter bl = new BorrowListAdapter();
			bl.updateStatus(borrow_id,status);
		}		
		
		response.sendRedirect("/librarymanagement/userBorrowList?status=requested");
	}
}
