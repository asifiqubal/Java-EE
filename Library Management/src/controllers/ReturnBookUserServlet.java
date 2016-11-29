package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.BorrowListAdapter;

public class ReturnBookUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BorrowListAdapter bl = new BorrowListAdapter();
		HttpSession session = request.getSession();
		int user_id= Integer.parseInt(session.getAttribute("user_id").toString());
		
		String type=session.getAttribute("type").toString();
		
		if(type.equals("user"))
		{
			request.setAttribute("borrowHistory", bl.getBorrowHistory(user_id,"returned"));
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_returnBookUser.jsp");
			disp.forward(request, response);
			
		}
		
		else if(type.equals("admin"))
		{
				String status = "returned";

				request.setAttribute("borrowHistory", bl.getAllBorrowHistory(status));
				
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_returnBookAdmin.jsp");
				disp.forward(request, response);
		}
	}

}
