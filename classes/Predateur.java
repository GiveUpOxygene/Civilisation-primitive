public class Predateur extends Animal {
    public Predateur(int quantite, int x, int y) {
        super("Predateur", quantite);
        this.setPosition(x, y);
    }

    public void attaquer(Agent ag) {
        if(ag instanceof Chasseur) {
            Chasseur ch = (Chasseur) ag;
            if(ch.getIsArmed()) {
                ch.setEnergie(ch.getEnergie() - 1);
                this.setQuantite(this.getQuantite() - 1);
            }
        }
        else if(ag instanceof Barbare) {
            Barbare ba = (Barbare) ag;
            if(ba.getIsArmed()) {
                ba.setEnergie(ba.getEnergie() - 1);
                this.setQuantite(this.getQuantite() - 1);
            }
        }
        else {
            ag.setEnergie(ag.getEnergie() - 2);
        }
    }
}
