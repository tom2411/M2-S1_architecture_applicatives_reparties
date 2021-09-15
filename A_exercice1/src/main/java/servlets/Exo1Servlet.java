package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo1Servlet extends HttpServlet {

    String memoLogin="alice";
    String memoPassword="alice";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login=request.getParameter("login");
        String password=request.getParameter("password");

        if ( (memoLogin.equals(login)) && (memoPassword.equals(password)) ) {
            request.setAttribute("nom",login);
            request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request,response);
        } else {
            request.setAttribute("message","échec d'authentification");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }
}
