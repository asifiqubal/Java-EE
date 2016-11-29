package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.RequestAdapter;

/**
 * Servlet implementation class RequestListServlet
 */
public class RequestListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			RequestAdapter ra = new RequestAdapter();
			
			HttpSession session = request.getSession();
			int user_id= Integer.parseInt(session.getAttribute("user_id").toString());
			String type=session.getAttribute("type").toString();
			
			if(type.equals("user"))
			{
				request.setAttribute("requestlist",ra.get(user_id));
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_userrequestlist.jsp");
				disp.forward(request, response);
			}
			
			else if(type.equals("admin"))
			{
				request.setAttribute("requestlist", ra.getAll());
				RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_adminrequestlist.jsp");
				disp.forward(request, response);
			}	
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
