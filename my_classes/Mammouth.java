public class Mammouth extends Ressource implements Animal {
    private String espece;
    private boolean sexe;
    private int puissance;
    private int valeur;
    private boolean isAlive;

    public Mammouth() {
        super("Mammouth", 1);
        this.espece = "Mammouth";
        this.isAlive = true;
        this.sexe = (int)(Math.random() * 2) == 0;
    }

    //#region accesseurs
    public String getEspece() {
        return this.espece;
    }

    public int getPuissance() {
        return this.puissance;
    }

    public int getValeur() {
        return this.valeur;
    }

    public boolean isPredator() {
        return false;
    }
    public void seDeplacer(int xnew, int ynew) {
        this.setPosition(xnew, ynew);
    }
    //#endregion


    /**
     * Reproduction entre deux mammouths
     * @param other : le mammouth avec lequel on veut faire se reproduire <b>this</b>
     * @return un nouveau mammouth si les deux mammouths sont de la même espèce et de sexe opposé, null sinon
     */

    public Mammouth reproduction(Mammouth other) {
        if (this.espece.equals(other.espece) && !(this.sexe == other.sexe)) {
            return new Mammouth();
        }
        return null;
    }

    /**
     * Détruit l'instance de l'animal
     */
    public void kill() {
        this.isAlive = false;
    }
}
