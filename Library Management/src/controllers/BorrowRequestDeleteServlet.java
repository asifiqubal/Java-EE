package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.BorrowListAdapter;

public class BorrowRequestDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		if (session.getAttribute("type")==null ||session.getAttribute("type").toString().equals("admin")) {
			response.sendRedirect("/librarymanagement/signin");
		}
		else{
		int borrow_id = Integer.parseInt(request.getParameter("id").toString());
		BorrowListAdapter bl = new BorrowListAdapter();
		request.setAttribute("list", bl.getInfo(borrow_id));
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_userConDelRequest.jsp");
		disp.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int borrow_id = Integer.parseInt(request.getParameter("borrow_id").toString());
		int book_id = Integer.parseInt(request.getParameter("book_id").toString());
		int available_copy =Integer.parseInt(request.getParameter("available_copy").toString());
		
		//response.getWriter().println(borrow_id+" "+book_id +" "+available_copy);
		BorrowListAdapter bl = new BorrowListAdapter();
		bl.delete(borrow_id);
		available_copy++;
		bl.updateAvailable(book_id,available_copy);
		
		response.sendRedirect("/librarymanagement/userBorrowList?err=2");
	}
}
