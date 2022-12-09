public abstract class Animal extends Ressource implements Modifiable{
    public Animal(String type, int quantite) {
        super(type, quantite);
    }

    public void vieillir() {
        this.setQuantite(this.getQuantite() - 1);
    }

    public void seReproduire() {
        if(this.getQuantite() > 1) {
            this.setQuantite(this.getQuantite() + 1);
        }
    }
}
