package servlets;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait au premier appel
        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO ce qui est fait pour les appels suivants...
        if (this.aDeviner==null){
            String lemot = request.getParameter("lemot");
            setaDeviner(lemot);
            request.setAttribute("devine", this.devine);
            request.setAttribute("coupRestant", this.nbEssaisRestants);
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }else {
            if (request.getParameter("lecaractere").length()==0){
                request.setAttribute("devine", this.devine);
                request.setAttribute("erreur", "Vous êtes obligés de choisir une lettre.");
            }else{
                char caractere = request.getParameter("lecaractere").charAt(0);
                if (this.nbEssaisRestants>0 && !this.devine.equals(this.aDeviner)){
                    System.out.println(caractere);
                    boolean res = test(caractere);
                    System.out.println(res);
                    request.setAttribute("coupRestant", this.nbEssaisRestants);
                    System.out.println("devine="+this.devine);
                    request.setAttribute("devine", this.devine);
                    if (this.devine.indexOf("_")==-1){
                        request.setAttribute("coup",this.nbEssaisRestants);
                        request.setAttribute("fin", true);
                    }
                }
            }
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }
    }


    private void setaDeviner(String Deviner) {
        this.aDeviner=Deviner;
        this.devine=new StringBuilder("_".repeat(Deviner.length()));
        this.nbEssaisRestants=10;
    }

    private boolean test(char carac){
        int i=0;
        if (aDeviner.indexOf(carac, i)==-1){
            nbEssaisRestants--;
            return false;
        }
        while (i!=aDeviner.length()-1){
            int index_premiere_lettre = aDeviner.indexOf(carac, i);
            if (index_premiere_lettre==-1){
                return true;
            }
            devine.setCharAt(index_premiere_lettre,carac);
            i++;
        }
        return true;
    }
}
