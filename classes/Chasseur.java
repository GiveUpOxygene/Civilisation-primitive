public class Chasseur extends Agent{
    private boolean isArmed;
    public Chasseur(int x, int y, int energie, int largeur, int hauteur){
        super("Chasseur", x, y, energie, largeur, hauteur);
        this.isArmed = false;
    }

    public void chasser(Animal animal) {
        if(animal instanceof Proie) {
            Proie proie = (Proie) animal;
            if(!(this.getIsArmed())) {
                proie.setQuantite(proie.getQuantite() - 1);
                this.setEnergie(this.getEnergie() + 1);
            } 
            else {
                proie.setQuantite(proie.getQuantite() - 2);
                this.setEnergie(this.getEnergie() + 2);
            }
            System.out.println(this.toString() + " chasse " + proie.toString() + " et mange.");
        } else if(animal instanceof Predateur) {
            Predateur predateur = (Predateur) animal;
            if(this.getIsArmed()) {
                predateur.setQuantite(predateur.getQuantite() - 1);
                this.setEnergie(this.getEnergie() + 1);
                System.out.println(this.toString() + " chasse " + predateur.toString() + " et mange.");
            }
            else {
                this.setEnergie(this.getEnergie() - 1);
                System.out.println(this.toString() + " rate sa chasse.");
            }
        }
    }

    public void fabriqueArme(Transportable transportable) {
        if(transportable instanceof Bois) {
            Bois bois= (Bois) transportable;
            if(bois.getQuantite() > 0) {
                this.setIsArmed(true);
                bois.setQuantite(bois.getQuantite() - 1);
            }
            System.out.println(this.toString() + " fabrique un arc.");
        }
    }

    

    public void attaquer(Agent ag) {
        if(ag instanceof Barbare) {
            Barbare ba = (Barbare) ag;
            if(!(ba.getIsArmed())) {
                ba.setEnergie(ba.getEnergie() - 2);
            }
            else {
                ba.setEnergie(ba.getEnergie() - 1);
                this.setEnergie(this.getEnergie() - 1);
            }
            System.out.println(this.toString() + " attaque " + ba.toString());
        }
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
