package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo=request.getParameter("TODO");

        if (todo==null) {
            // ne devrait pas se produire...
            request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
        } else {
            switch (todo) {
                case "setMot" :
                    String lemot=request.getParameter("lemot");
                    if ((lemot==null) || (lemot.equals(""))) {
                        // on ne peut pas chercher un mot vide...
                        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
                    } else {
                        setaDeviner(lemot);
                        forwardEssai(request,response);
                    }
                    break;
                case "essai":
                    String caractere=request.getParameter("lecaractere");
                    if (caractere.length()>0) {
                        if (test(caractere.charAt(0))) {
                            // Le joueur a gagné
                            request.setAttribute("victoire",true);
                            request.setAttribute("mot",aDeviner);
                            request.getRequestDispatcher("/WEB-INF/fin.jsp").forward(request,response);
                        } else {
                            if (nbEssaisRestants>0) {
                                forwardEssai(request,response);
                            } else {
                                // Le joueur a perdu
                                request.setAttribute("victoire",false);
                                request.setAttribute("mot",aDeviner);
                                request.getRequestDispatcher("/WEB-INF/fin.jsp").forward(request,response);
                            }
                        }
                    } else {
                        forwardEssai(request,response);
                    }
                    break;
                default:
                    forwardEssai(request,response);
            }
        }
    }

    private void forwardEssai(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("etatCourant",devine);
        request.setAttribute("nbEssaisRestants",nbEssaisRestants);
        request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request,response);
    }


    private void setaDeviner(String aDeviner) {
        this.aDeviner=aDeviner;
        this.devine=new StringBuilder("_".repeat(aDeviner.length()));
        this.nbEssaisRestants=10;
    }

    private boolean test(char carac){
        boolean res=false;
        // FOR MODIFIE
        for (int last=aDeviner.indexOf(carac);last!=-1;last=aDeviner.indexOf(carac,last+1)) {
            res = true;
            devine.setCharAt(last, carac);
        }
        if (res==false) {
            nbEssaisRestants--;
        }
        // RETOUR MODIFIE
        return (devine.indexOf("_")==-1);
    }

}
