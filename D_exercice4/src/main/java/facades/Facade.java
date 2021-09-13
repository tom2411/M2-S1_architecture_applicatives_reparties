package facades;

/**
 * on va un peu bricoler pour avoir un singleton...
 */
public class Facade {

    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants;

    public static Facade instance=null;
    /**
     *
     * @return l'unique instance
     */
    public static synchronized Facade getInstance(){
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    /**
     * Constructeur privé, ne peut etre appelé que depuis la classe...
     */
    private Facade() {

    }

    public void setaDeviner(String Deviner) {
        this.aDeviner=Deviner;
        this.devine=new StringBuilder("_".repeat(Deviner.length()));
        this.nbEssaisRestants=10;
    }

    public boolean test(char carac){
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

    public String getaDeviner() {
        return aDeviner;
    }

    public StringBuilder getDevine() {
        return devine;
    }

    public void setDevine(StringBuilder devine) {
        this.devine = devine;
    }

    public int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public void setNbEssaisRestants(int nbEssaisRestants) {
        this.nbEssaisRestants = nbEssaisRestants;
    }
}
