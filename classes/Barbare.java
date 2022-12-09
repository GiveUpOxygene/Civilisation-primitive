public class Barbare extends Agent {
    private boolean isArmed;
    public Barbare(int x, int y, int energie, int largeur, int hauteur) {
        super("Barbare", x, y, energie, largeur, hauteur);
        this.isArmed = false;
    }

    public void chasser(Animal animal) {
        if(animal instanceof Predateur) {
            if(!(this.getIsArmed())) {
               this.setEnergie(this.getEnergie() - 1);
                System.out.println(this.toString() + " rate sa chasse.");
            }
        }
        else {
            this.setEnergie(this.getEnergie() + 1);
            animal.setQuantite(animal.getQuantite() - 1);
            System.out.println(this.toString() + " chasse " + animal.toString() + " et mange.");
        }
    }

    public void fabriqueArme(Transportable transportable) {
        if(transportable instanceof Pierre) {
            Pierre pierre = (Pierre) transportable;
            if(pierre.getQuantite() > 0) {
                this.setIsArmed(true);
                pierre.setQuantite(pierre.getQuantite() - 1);
            }
            System.out.println(this.toString() + " fabrique une hache.");
        }
    }

    public void attaquer(Agent ag) {
        if(ag instanceof Chasseur) {
            Chasseur ch = (Chasseur) ag;
            if(!(ch.getIsArmed())) {
                ch.setEnergie(ch.getEnergie() - 2);
            }
            else {
                ch.setEnergie(ch.getEnergie() - 1);
                this.setEnergie(this.getEnergie() - 1);
            }
            System.out.println(this.toString() + " attaque " + ch.toString());
        }
    }

    public void transporter(Ressource r,int xnew, int ynew){
        r.setPosition(xnew, ynew);
        System.out.println(this.toString() + " transporte " + r.toString() + " en (" + xnew + "," + ynew + ")");
        this.seDeplacer(xnew, ynew);
    }

    //#region Getters/Setters


    public boolean getIsArmed(){
        return this.isArmed;
    }

    public void setIsArmed(boolean isArmed){
        this.isArmed = isArmed;
    }

    //#endregion

    @Override
    public String toString() {
        return this.type + " " + this.ident;
    }
}