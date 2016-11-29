package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.RequestAdapter;
import models.Request;

/**
 * Servlet implementation class AddRequestServlet
 */
public class AddRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_addrequest.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		
		HttpSession session = request.getSession();
		int user_id= Integer.parseInt(session.getAttribute("user_id").toString());
		
		Request req = new Request();
		req.setUser_id(user_id);
		req.setBook_name(request.getParameter("book_name").toString());
		req.setEdition(request.getParameter("edition").toString());
		req.setAuthor_name(request.getParameter("author_name").toString());
		req.setRequest_date(timeStamp);

		RequestAdapter ra = new RequestAdapter();
		ra.insert(req);
		
		response.sendRedirect("/librarymanagement/requestlist");
	}

}
