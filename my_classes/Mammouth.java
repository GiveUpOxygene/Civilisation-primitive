public class Mammouth extends Ressource implements Animal, Proie {
    private String espece;
    private boolean sexe;
    private int puissance;
    private int valeur;

    public Mammouth() {
        super("Mammouth", 1);
        this.espece = "Mammouth";
    }

    public String getEspece() {
        return this.espece;
    }

    public void seDeplacer(int xnew, int ynew) {
        this.setPosition(xnew, ynew);
    }

    public Mammouth reproduction(Mammouth other) {
        if (this.espece.equals(other.espece) && !(this.sexe == other.sexe)) {
            return new Mammouth();
        }
        return null;
    }
    
    public int getPuissance() {
        return this.puissance;
    }

    public int getValeur() {
        return this.valeur;
    }

}
