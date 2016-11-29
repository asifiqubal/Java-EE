package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.BorrowListAdapter;

public class BorrowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		BorrowListAdapter bl = new BorrowListAdapter();
		int err=0;
		HttpSession session = request.getSession();
		int user_id= Integer.parseInt(session.getAttribute("user_id").toString());
		
		//response.getWriter().println(user_id);
		String type=session.getAttribute("type").toString();
		
	
		if(type.equals("user"))
		{
			err= Integer.parseInt(request.getParameter("err").toString());
			String error="";
			
			if(err==1)
			{
				error = "**You cann't request for more than three books";
			}
			else if(err==2)
			{
				error = "";
			}
			else if(err==3)
			{
				error = "**Curently the book is unavailable";
			}
			else if(err==4)
			{
				error = "**You already borrowed/request for the book";
			}
			request.setAttribute("errorMessage",error);
			request.setAttribute("borrowHistory", bl.getBorrowHistory(user_id,"borrowed"));
			request.setAttribute("pendingRequest", bl.getBorrowHistory(user_id,"requested"));
			//request.setAttribute("pendingRequest", bl.getPendingRequest(id,"requested"));
			
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_userBorrowList.jsp");
			disp.forward(request, response);
			
		}
		
		else if(type.equals("admin"))
		{
			String status = request.getParameter("status").toString();
			
			if(status.equals("borrowed"))
			{
				request.setAttribute("borrowHistory", bl.getAllBorrowHistory(status));
				
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_borrowHistory.jsp");
				disp.forward(request, response);
			}
			
			else if(status.equals("requested"))
			{
				request.setAttribute("borrowRequest", bl.getAllBorrowHistory(status));
				
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_borrowRequest.jsp");
				disp.forward(request, response);
			}
		}
	}

}
