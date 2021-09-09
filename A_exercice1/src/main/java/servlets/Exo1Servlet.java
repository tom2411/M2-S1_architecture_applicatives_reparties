package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.StringReader;

@WebServlet(urlPatterns = "/")
public class Exo1Servlet extends HttpServlet {

    private final String login = "Tom";
    private final String mdp = "Tom";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//TODO récupérer le login et le mdp et les comparer avec la paire stockée statiquement; appeler la jsp bonjour en cas de succès et la jsp de login sinon
        String login=request.getParameter("login");
        String mdp=request.getParameter("mdp");
        if (this.login.equals(login) && this.mdp.equals(mdp)){
            request.setAttribute("login", login);
            request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request,response);
        }else {
            String erreur ="Il y a eut une erreur lors de la saisie";
            request.setAttribute("erreur", erreur);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }
}
