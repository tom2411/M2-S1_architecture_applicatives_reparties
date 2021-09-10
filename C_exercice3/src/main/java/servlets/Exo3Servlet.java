package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
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
            request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);
        }else {
            char caractere = request.getParameter("lecaractere").charAt(0);
            if (this.nbEssaisRestants>0 && !this.devine.equals(this.aDeviner)){
                System.out.println(caractere);
                boolean res = test(caractere);
                System.out.println(res);
                System.out.println("devine="+this.devine);
                request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request, response);

            }
        }
    }


    private void setaDeviner(String Deviner) {
        this.aDeviner=Deviner;
        this.devine=new StringBuilder("_".repeat(Deviner.length()));
        this.nbEssaisRestants=10;
    }

    private boolean test(char carac){
        System.out.println("debut");
        boolean res=false;
        for (int last=0;last!=-1;last=aDeviner.indexOf(carac,last)) {
            res = true;
            System.out.println("last dans le for = "+aDeviner.indexOf(carac,last));
            last = aDeviner.indexOf(carac,last);
            devine.setCharAt(last, carac);
            System.out.println(last);
            last++;
        }
        if (res==false) {
            System.out.println("nbEssai--");
            nbEssaisRestants--;
        }
        System.out.println("sortie");
        return res;
    }
}
