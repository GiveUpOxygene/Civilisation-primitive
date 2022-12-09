public class Bois extends Ressource implements Transportable{
    public Bois(int quantite, int x, int y) {
        super("Bois", quantite);
        this.setPosition(x, y);
    }
}
