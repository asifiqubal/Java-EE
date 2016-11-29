package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.BorrowListAdapter;
import models.BorrowBookList;

/**
 * Servlet implementation class ReturnBookServlet
 */
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int borrow_id = Integer.parseInt(request.getParameter("borrow_id").toString());
		BorrowListAdapter blist=new BorrowListAdapter();
		BorrowBookList blist2=new BorrowBookList();
		blist2=blist.getInfo(borrow_id);
		String dateStop = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		String dateStart=blist2.getExpected_return_date();
		
		response.getWriter().println(dateStop+" "+blist2.getExpected_return_date());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		
		int diffDays=0;
		java.util.Date d1 = null;
		java.util.Date d2 = null;
		int fine=0;
		try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);

			//in milliseconds
			int diff = (int) (d2.getTime() - d1.getTime());
			diffDays = diff / (24 * 60 * 60 * 1000);

			response.getWriter().println(diffDays);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(diffDays>0)
		{
			fine=diffDays*5;
		}

		request.setAttribute("blist", blist2);
		request.setAttribute("fine", fine);
		request.setAttribute("rdate", dateStop);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_conreturn.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int borrow_id = Integer.parseInt(request.getParameter("borrow_id").toString());
		int fine=Integer.parseInt(request.getParameter("fine").toString());
		String rdate=request.getParameter("rdate").toString();
		
		BorrowListAdapter bl=new BorrowListAdapter();
		BorrowBookList blm=new BorrowBookList();
		blm.setBorrow_id(borrow_id);
		blm.setFine(fine);
		blm.setReturn_date(rdate);
		blm.setStatus("returned");
		
		bl.update(blm);
		response.sendRedirect("/librarymanagement/userBorrowList?status=borrowed");
		
	}

}
