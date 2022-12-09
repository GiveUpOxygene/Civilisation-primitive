public class Pierre extends Ressource implements Transportable{
    public Pierre(int quantite, int x, int y) {
        super("Pierre", quantite);
        this.setPosition(x, y);
    }
    
}
