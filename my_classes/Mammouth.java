public class Mammouth extends Animal {


    public Mammouth() {
        super("Mammouth");
    }

    //#region accesseurs
    public String getEspece() {
        return super.getEspece();
    }
    public int getPuissance() {
        return super.getPuissance();
    }
    public int getValeur() {
        return super.getValeur();
    }
    public boolean isPredator() {
        return false;
    }
    public boolean getSexe() {
        return super.getSexe();
    }
    public void seDeplacer(int xnew, int ynew) {
        this.setPosition(xnew, ynew);
    }

    //#endregion


    /**
     * Reproduction entre deux mammouths
     * @param other : le mammouth avec lequel on veut faire se reproduire <b>this</b>
     * @return un nouveau mammouth si les deux mammouths sont de sexe opposé, null sinon
     */

    public Mammouth reproduction(Mammouth other) {
        if (!(this.getSexe() == other.getSexe())) {
            return new Mammouth();
        }
        return null;
    }

    /**
     * Détruit l'instance de l'animal
     */
    public void kill() {
        super.kill();
    }
}
