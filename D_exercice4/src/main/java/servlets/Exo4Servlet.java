package servlets;

import facades.Facade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class Exo4Servlet extends HttpServlet {
    private Facade facade;

    @Override
    public void init() throws ServletException {
        super.init();
        facade=new Facade();
    }


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
                        facade.setaDeviner(lemot);
                        forwardEssai(request,response);
                    }
                    break;
                case "essai":
                    String caractere=request.getParameter("lecaractere");
                    if (caractere.length()>0) {
                        if (facade.test(caractere.charAt(0))) {
                            // Le joueur a gagné
                            request.setAttribute("victoire",true);
                            request.setAttribute("mot",facade.getaDeviner());
                            request.getRequestDispatcher("/WEB-INF/fin.jsp").forward(request,response);
                        } else {
                            if (facade.getNbEssaisRestants()>0) {
                                forwardEssai(request,response);
                            } else {
                                // Le joueur a perdu
                                request.setAttribute("victoire",false);
                                request.setAttribute("mot",facade.getaDeviner());
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
        request.setAttribute("etatCourant",facade.getDevine());
        request.setAttribute("nbEssaisRestants",facade.getNbEssaisRestants());
        request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request,response);
    }




}
