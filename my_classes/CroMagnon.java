public class CroMagnon {
    private String nom;
    private int energy;
    private boolean isAlive;
    private boolean sexe;
    private int x;
    private int y;

    public CroMagnon(String nom) {
        this.nom = nom;
        this.energy = 100;
        this.sexe = (int)(Math.random() * 2) == 0;
    }

    //#region accesseurs
    public String getNom() {
        return this.nom;
    }

    public int getEnergy() {
        return this.energy;
    }

    public boolean getIsAlive() {
        return this.isAlive;
    }

    public boolean getSexe() {
        return this.sexe;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    //#endregion


    public String toString() {
        return String.valueOf(this.nom) + " est un CroMagnon avec " + this.energy + " points d'energie.";
    }
    
    public CroMagnon reproduction(CroMagnon other) {
        if (this.sexe != other.sexe) {
            return new CroMagnon("CroMagnon");
        }
        return null;
    }

    //Chasse et cueillette

    /**
     * Chasse un animal
     * @param cible l'animal à chasser
     * @see Animal
     * @see Mammouth
     */

    public void chasser(Animal cible) {
        if (cible.isPredator() && cible.getPuissance() > this.energy){
            this.isAlive = false;
        }else if ((cible.isPredator() && cible.getPuissance() <= this.energy) || !cible.isPredator()){
            this.energy += cible.getPuissance();
            cible.kill();
        }
    }

    /**
     * Cueille un fruit
     * @param cible
     * @see Fruit
     */
    public void cueillir(Fruit cible) {
        if (cible.getIsToxique()){
            this.energy -= cible.getEnergy();
            if (this.energy <= 0){
                this.isAlive = false;
            }
        }else{
            this.energy += cible.getEnergy();
        }
    }
}