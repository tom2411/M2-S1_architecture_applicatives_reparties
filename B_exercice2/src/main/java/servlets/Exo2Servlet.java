package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo2Servlet extends HttpServlet {
    private final Option[] options={new Option("Beau",1),new Option("Couvert",2),new Option("Pluie",3), new Option("Neige",4)};

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("meteo");
        request.setAttribute("key",key);
        for (Option option: options) {
            if (key.equals(String.valueOf(option.key))){

            }
        }
        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request,response);

    }

    private void toJsp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("options",options);
        HttpSession session = request.getSession();
        session.setAttribute("options", options);
        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request,response);
    }

    public class Option{
        private String value;
        private int key;
        private int cpt;

        public Option(String value, int key) {
            this.value = value;
            this.key = key;
            this.cpt = 0 ;
        }

        public String getValue() {
            return value;
        }

        public int getKey() {
            return key;
        }

        public int getCpt() { return cpt;}

        public void incr() { this.cpt++;}
    }
}
