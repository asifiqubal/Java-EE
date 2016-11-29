package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.BookListAdapter;
import adapters.BorrowListAdapter;
import models.BookList;
import models.BorrowList;


public class BorrowBookServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		BorrowListAdapter bla = new BorrowListAdapter();
		HttpSession session = request.getSession();
		int user_id= Integer.parseInt(session.getAttribute("user_id").toString());
		int book_id = Integer.parseInt(request.getParameter("book_id").toString());
		
		int error=0;
		
		Boolean b = bla.checking(user_id, book_id);
		//response.getWriter().println(b);
		if(b==true)
			{
				error=4;
			}
		
		else if(b==false)
		{
		
		int count;
		String status = "requested";
		count = bla.countRequest(user_id,status);
		error=2;
		
			if(count==3)
			{
				//response.getWriter().println("hello");
				error = 1;
			}
		else
		{
			error=2;
			//int book_id = Integer.parseInt(request.getParameter("book_id").toString());
			
			BookListAdapter bka = new BookListAdapter();
			BookList param = new BookList();
			param = bka.get(book_id);
			int available_copy = param.getAvailable_copy();
			
			if(available_copy==1)
			{
				//response.getWriter().println("hello");
				error =3;
			}
			else
			{
			String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			try {
				c.setTime(sdf.parse(timeStamp));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			c.add(Calendar.DATE, 7);  // number of days to add
			String timeStamp1 = sdf.format(c.getTime()); 
			//response.getWriter().println(timeStamp1);
			//response.getWriter().println(book_id+" "+user_id +" "+timeStamp1);
			
			BorrowList bl = new BorrowList();
			bl.setBook_id(book_id);
			bl.setUser_id(user_id);
			bl.setBorrow_date(timeStamp);
			bl.setExpected_return_date(timeStamp1);
			bl.setStatus("requested");
			bla.insert(bl);
			
			//BookListAdapter bka = new BookListAdapter();
			//request.setAttribute("bookInfo", bka.get(book_id));
			//BookList param = new BookList();
			//param = bka.get(book_id);
			//int available_copy = param.getAvailable_copy();
			//response.getWriter().println(available_copy);
			available_copy--;
			bla.updateAvailable(book_id,available_copy);
			}
		}
		}
		response.sendRedirect("/librarymanagement/userBorrowList?err="+error);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
