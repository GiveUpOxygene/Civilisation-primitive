public abstract class Agent {
    public static boolean [][] grille;
    private int x, y;
    private int energie;
    private static int nbAgentsCreees = 0;
    public final int ident;
    public String type;

    public Agent(String type, int x, int y, int energie, int largeur, int hauteur) {
        if (nbAgentsCreees == 0) {
            grille = new boolean[largeur][hauteur];
            for (int i = 0; i < largeur; i++) {
                for (int j = 0; j < hauteur; j++) {
                    grille[i][j] = true;
                }
            }
        }
        this.type = type;
        this.x = x;
        this.y = y;
        if (x >= 0 && y >= 0 && x < largeur && y < hauteur) {
            grille[x][y] = false;
        }
        this.energie = energie;
        this.ident = nbAgentsCreees++;
    }

    public double distance(Agent ag) {
        return Math.sqrt((ag.x - this.x) * (ag.x - this.x) + (ag.y - this.y) * (ag.y - this.y));
    }

    public boolean seDeplacer(int xnew, int ynew) {
        if (grille[xnew][ynew] == true) {
            grille[x][y] = true;
            grille[xnew][ynew] = false;
            x = xnew;
            y = ynew;
            energie = energie - 1;
            System.out.println(this.toString() + " se deplace en (" + x + "," + y + ").");
            return true;
        }
        System.out.println(this.toString() + " ne peut pas se deplacer en (" + xnew + "," + ynew + ").");
        return false;
    }

    public void kill() {
        grille[x][y] = true;
        x = -1;
        y = -1;
        System.out.println(this.toString() + " est mort.");
    }

    public abstract void chasser(Animal animal);
    public abstract void fabriqueArme(Transportable transportable);
    public abstract void attaquer(Agent ag);

    //#region Getters/Setters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getEnergie() {
        return energie;
    }

    public static int getNbAgentsCreees() {
        return nbAgentsCreees;
    }

    public String getType() {
        return type;
    }

    public void setEnergie(int energie) {
        this.energie = energie;
    }

    //#endregion
}