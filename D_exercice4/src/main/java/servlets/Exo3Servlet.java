package servlets;

import facades.Facade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {

    private final Facade facade=Facade.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait au premier appel
        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait pour les appels suivants...
        if (this.facade.getaDeviner()==null){
            String lemot = request.getParameter("lemot");
            facade.setaDeviner(lemot);
            request.setAttribute("devine", this.facade.getDevine());
            request.setAttribute("coupRestant", this.facade.getNbEssaisRestants());
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }else {
            if (request.getParameter("lecaractere").length()==0){
                request.setAttribute("devine", this.facade.getDevine());
                request.setAttribute("erreur", "Vous êtes obligés de choisir une lettre.");
            }else{
                char caractere = request.getParameter("lecaractere").charAt(0);
                if (this.facade.getNbEssaisRestants()>0 && !this.facade.getDevine().equals(this.facade.getaDeviner())){
                    System.out.println(caractere);
                    boolean res = this.facade.test(caractere);
                    System.out.println(res);
                    request.setAttribute("coupRestant", this.facade.getNbEssaisRestants());
                    System.out.println("devine="+this.facade.getDevine());
                    request.setAttribute("devine", this.facade.getDevine());
                    if (this.facade.getDevine().indexOf("_")==-1){
                        request.setAttribute("coup",this.facade.getNbEssaisRestants());
                        request.setAttribute("fin", true);
                    }
                }
            }
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }
    }



}
