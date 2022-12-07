public class Loup extends Animal{

    public Loup() {
        super("Loup");
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
     * Reproduction entre deux loups
     * @param other : le loups avec lequel on veut faire se reproduire <b>this</b>
     * @return un nouveau loup si les deux loups sont de sexe opposé, null sinon
     */

    public Loup reproduction(Loup other) {
        if (!(this.getSexe() == other.getSexe())) {
            return new Loup();
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
