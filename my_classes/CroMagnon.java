public class CroMagnon {
    private String nom;
    private int energy;
    private boolean isAlive;
    private boolean sexe;

    public CroMagnon(String nom) {
        this.nom = nom;
        this.energy = 100;
        this.sexe = (int)(Math.random() * 2) == 0;
    }

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

    public void chasser(Animal cible) {
        if (this.energy >= cible.getPuissance()) {
            this.energy += cible.getValeur();
        }else if (cible instanceof Predateur){
            this.isAlive = false;
        }else if (cible instanceof Proie){
            this.energy -= cible.getPuissance();
            if (this.energy <= 0){
                this.isAlive = false;
            }
        }
    }

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

