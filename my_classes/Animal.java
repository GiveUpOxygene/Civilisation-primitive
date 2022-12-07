public abstract class Animal extends Ressource{
    private String espece;
    private boolean sexe;
    private int puissance;
    private int valeur;
    private boolean isAlive;

    public Animal(String espece) {
        super(espece, 1);
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
    public boolean getIsAlive() {
        return this.isAlive;
    }
    public void seDeplacer(int xnew, int ynew) {
        this.setPosition(xnew, ynew);
    }
    public boolean getSexe() {
        return this.sexe;
    }

    //#endregion


    /**
     * Reproduction entre deux mammouths
     * @param other : le mammouth avec lequel on veut faire se reproduire <b>this</b>
     * @return un nouveau mammouth si les deux mammouths sont de sexe opposé, null sinon
     */

    public Animal reproduction(Animal other) {
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
