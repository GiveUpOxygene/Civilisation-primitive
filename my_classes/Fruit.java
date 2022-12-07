public class Fruit extends Ressource {
    private String nom;
    private int energy;
    private boolean isToxique;

    public Fruit(String nom) {
        super("fruit", 1);
        this.nom = nom;
        this.energy = 10;
    }

    public String getNom() {
        return this.nom;
    }

    public int getEnergy() {
        return this.energy;
    }

    public boolean getIsToxique() {
        return this.isToxique;
    }
}