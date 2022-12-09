import java.util.Scanner;

public class TestSimulation {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrez le nombre de lignes de la grille : ");
            int largeur = sc.nextInt();
            System.out.println(largeur);
            System.out.print("Entrez le nombre de colonnes de la grille : ");
            int hauteur = sc.nextInt();
            System.out.println(hauteur);
            if(largeur <= 0 || hauteur <= 0 || largeur > Terrain.NBLIGNESMAX || hauteur > Terrain.NBCOLONNESMAX) {
                sc.close();
                throw new TerrainException("les dimensions du terrain doivent être positives et inférieures à " + Terrain.NBLIGNESMAX + " lignes et " + Terrain.NBCOLONNESMAX + " colonnes.");
            }
            System.out.print("Entrez le nombre d'agents : ");
            int n = sc.nextInt();
            System.out.println(n);
            System.out.print("Entrez le nombre de ressources : ");
            int m = sc.nextInt();
            System.out.println(m);
            if ( n > largeur * hauteur || m > largeur * hauteur) {
                sc.close();
                throw new OverflowTerrainException("le nombre d'agents et de ressources ne peut pas dépasser le nombre de cases du terrain : " + "(" + largeur * hauteur + " cases).");
            }
            Simulation sim = new Simulation(n, m, largeur, hauteur);
            System.out.print("Entrez le nombre de tours : ");
            int iter = sc.nextInt();
            System.out.println(iter);
            if (iter < 0) {
                sc.close();
                throw new NegateIterateException("le nombre de tours doit être positif.");
            }
            sc.close();
            sim.simulate(iter);

        } catch (TerrainException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (OverflowTerrainException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (NegateIterateException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
