package controllers;
 
import java.io.IOException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import adapters.UserAdapter;
import models.User;
 
/**
 * Servlet implementation class SignInServlet
 */
public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
         
        String error = "";
        request.setAttribute("errorMessage",error);
        RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_signin.jsp");
        disp.forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
         
        String user_name=request.getParameter("user_name").toString();
        String password=request.getParameter("password").toString();
         
        if(user_name.equals("")||password.equals(""))
        {
            String error = "**USERNAME & PASSWORD IS REQUIRED";
            request.setAttribute("errorMessage",error);
            RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_signin.jsp");
            disp.forward(request, response);
        }
        else
        {
            UserAdapter useradapt = new UserAdapter();
            User user= new User(); 
            user=useradapt.get(user_name, password);
             
            if(user==null)
            {
                String error = "**INVALID USERNAME & PASSWORD";
                request.setAttribute("errorMessage",error);
                RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/view_signin.jsp");
                disp.forward(request, response);
            }
            else
            {
                int user_id=user.getUser_id();
                String type=user.getType();
                 
                HttpSession session = request.getSession();
                session.setAttribute("user_id",user_id);
                session.setAttribute("type",type);
                 
                if(type.equals("user"))
                {
                    response.sendRedirect("/librarymanagement/user");
                }
                else if(type.equals("admin"))
                {
                    response.sendRedirect("/librarymanagement/admin");
                }
            }
        }
    }
}