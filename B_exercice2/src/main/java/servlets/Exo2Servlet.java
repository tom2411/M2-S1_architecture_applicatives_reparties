package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * L'usage de la session se justifie dans cet exercice car plusieurs utilisateurs peuvent accéder au même servlet...
 * Donc à la même liste d'options...
 */
@WebServlet(urlPatterns = "/")
public class Exo2Servlet extends HttpServlet {
    // Une Map serait plus efficace...
    private final Option[] options={new Option("Beau",1),new Option("Couvert",2),new Option("Pluie",3), new Option("Neige",4)};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meteoStr=request.getParameter("meteo");
        try {
            int meteo=Integer.parseInt(meteoStr);
            for (Option opt: options) {
                if (opt.getKey()==meteo) {
                    // on va incrémenter en session un variable qui porte le nom de l'option
                    // Si elle n'existe pas on l'initialise
                    Integer nbr=(Integer) request.getSession().getAttribute(opt.getValue());
                    if (nbr==null) {
                        nbr=0;
                    }
                    nbr++;
                    request.getSession().setAttribute(opt.getValue(),nbr);
                    break;
                }
            }

        } catch (NumberFormatException nfe) {}
        toJsp(request,response);
    }

    private void toJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("options",options);
        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request,response);
    }

    public class Option{
        private String value;
        private int key;

        public Option(String value, int key) {
            this.value = value;
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public int getKey() {
            return key;
        }
    }
}
