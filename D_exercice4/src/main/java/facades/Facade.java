package facades;

public class Facade {
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;

    public String getaDeviner() {
        return aDeviner;
    }

    public StringBuilder getDevine() {
        return devine;
    }

    public int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public void setaDeviner(String aDeviner) {
        this.aDeviner=aDeviner;
        this.devine=new StringBuilder("_".repeat(aDeviner.length()));
        this.nbEssaisRestants=10;
    }

    public boolean test(char carac){
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
