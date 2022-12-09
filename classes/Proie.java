public class Proie extends Animal {
    public Proie(int quantite, int x, int y) {
        super("Proie", quantite);
        this.setPosition(x, y);
    }

    public void fuir(Agent ag) {
        if(ag instanceof Chasseur) {
            Chasseur ch = (Chasseur) ag;
            if(ch.getIsArmed()) {
                this.setQuantite(this.getQuantite() - 1);
            } else {
                this.setQuantite(this.getQuantite() - 2);
            }
            System.out.println(this.toString() + " fuie.");
        } 
        else {
            this.setQuantite(this.getQuantite()/2);
            System.out.println("La moitie de " + this.toString() + " s'enfuient.");
        }
    }
}
