import java.util.ArrayList;
public class Simulation{
    private Terrain ter;
    private ArrayList<Agent> ag;
    public final int largeur;
    public final int hauteur;
    public Simulation(int n, int m, int largeur, int hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
        // init grille
        Agent agtest= new Chasseur(-1,-1,-1,largeur,hauteur);
        // init terrain
        ter = new Terrain(this.largeur, this.hauteur);
        // init tab agents
        ag = new ArrayList<Agent> ();
        for(int i =0; i<m ; i++){
            double rand = Math.random();
            if(rand<0.25){
                int x = -1;
                int y = -1;
                while(!(ter.sontValides(x, y) && ter.caseEstVide(x,y))){
                    x = (int)(Math.random() * this.largeur);
                    y = (int)(Math.random() * this.hauteur);
                }
                Bois bnew = new Bois((int)(Math.random()*15)+16, x, y);
                ter.setCase(x,y,bnew);
            } else if (rand < 0.5){
                int x = -1;
                int y = -1;
                while(!(ter.sontValides(x, y) && ter.caseEstVide(x,y))){
                    x = (int)(Math.random() * this.largeur);
                    y = (int)(Math.random() * this.hauteur);
                }
                Pierre pnew = new Pierre((int)(Math.random()*15)+16, x, y);
                ter.setCase(x,y,pnew);
            } else if (rand < 0.75){
                int x = -1;
                int y = -1;
                while(!(ter.sontValides(x, y) && ter.caseEstVide(x,y))){
                    x = (int)(Math.random() * this.largeur);
                    y = (int)(Math.random() * this.hauteur);
                }
                Proie pr = new Proie((int)(Math.random()*15)+16, x, y);
                ter.setCase(x,y,pr);
            }
            else {
                int x = -1;
                int y = -1;
                while(!(ter.sontValides(x, y) && ter.caseEstVide(x,y))){
                    x = (int)(Math.random() * this.largeur);
                    y = (int)(Math.random() * this.hauteur);
                }
                Predateur pre = new Predateur((int)(Math.random()*15)+16, x, y);
                ter.setCase(x,y,pre);
            }
        }
        for(int i =0; i<n; i++){
            double rand = Math.random();
            if (rand < 0.5){
                boolean b = false;
                int x = -1;
                int y = -1;
                while(!b){
                    b = true;
                    x = (int)(Math.random() * this.largeur);
                    y = (int)(Math.random() * this.hauteur);
                    if (Agent.grille[x][y]==false){
                            b= false; 
                    }  
                }
                ag.add(new Chasseur(x,y,(int)(Math.random()*15)+16,largeur,hauteur));
            } else {
                boolean b = false;
                int x = -1;
                int y = -1;
                while(!b){
                    b = true;
                    x = (int)(Math.random() * this.largeur);
                    y = (int)(Math.random() * this.hauteur);
                    if (Agent.grille[x][y]==false){
                        b= false;
                    }
                }
                ag.add(new Barbare(x,y,(int)(Math.random()*30)+21,largeur,hauteur));
            }
        }
    }
    public Simulation(int n,int m) {
        this(n,m,Terrain.NBLIGNESMAX,Terrain.NBCOLONNESMAX);
    }
    public void simulate(int iter){
        ArrayList<Ressource> res = ter.lesRessources();
        for(int i =0; i< iter; i++){
            if(ag.size() == 0){
                System.out.println("Tous les agents sont morts");
                break;
            }
            ter.affiche(4);
            for(Agent agt : ag){
                int x = agt.getX();
                int y = agt.getY();
                if(agt instanceof Barbare && !ter.caseEstVide(x,y)) {
                    Barbare ba = (Barbare) agt;
                    Ressource r = ter.getCase(x, y);
                    if (r instanceof Transportable) {
                        ba.transporter(r,(int)(Math.random() * this.largeur), (int)(Math.random() * this.hauteur));
                    }
                } else if (agt instanceof Barbare){
                    Barbare ba = (Barbare) agt;
                     ba.seDeplacer((int)(Math.random() * this.largeur), (int)(Math.random() * this.hauteur));
                } else if (agt instanceof Chasseur){
                    Chasseur ch = (Chasseur) agt;
                     ch.seDeplacer((int)(Math.random() * this.largeur), (int)(Math.random() * this.hauteur));
                }
                int x2 = agt.getX();
                int y2 = agt.getY();
                if(agt instanceof Chasseur){
                    Chasseur ch = (Chasseur) agt;
                    if(!ter.caseEstVide(x2,y2)){
                        Ressource r = ter.getCase(x2, y2);
                        if (r instanceof Animal){
                            Animal an = (Animal) r;
                            ch.chasser(an);
                        }
                        else if (r instanceof Transportable) {
                            Transportable tr = (Transportable) r;
                            ch.fabriqueArme(tr);
                        }
                    }
                    for (Agent agt2 : ag){
                        if (agt2 instanceof Barbare && ch.distance(agt2) < 2){
                            Barbare ba = (Barbare) agt2;
                            ch.attaquer(ba);
                        }
                    }
                }
                if(agt instanceof Barbare){
                    Barbare ba = (Barbare) agt;
                    if(!ter.caseEstVide(x2,y2)){
                        Ressource r = ter.getCase(x2, y2);
                        if (r instanceof Animal) {
                            Animal an = (Animal) r;
                            ba.chasser(an);
                        }
                        else if (r instanceof Transportable) {
                            Transportable tr = (Transportable) r;
                            ba.fabriqueArme(tr);
                        }
                    }
                    for (Agent agt2 : ag){
                        if (agt2 instanceof Chasseur && ba.distance(agt2) < 2) {
                            Chasseur ch = (Chasseur) agt2;
                            ba.attaquer(ch);
                        }
                    }
                    
                    
                }
            }
            for(int k=0; k<ag.size();k++){
                Agent at = ag.get(k);
                if (at.getEnergie() <= 0){
                    at.kill();
                    ag.remove(k);
                }
            }
            for (Ressource r : res){
                if (r instanceof Modifiable){
                    Modifiable md = (Modifiable) r;
                    double rand = Math.random();
                    if (rand < 0.5){
                        md.seReproduire();
                    } else {
                        md.vieillir();
                    }
                    if(md instanceof Proie){
                        Proie pr = (Proie) md;
                        for (Agent agt : ag){
                            if (agt.getX()==pr.getX() && agt.getY()==pr.getY()){
                                pr.fuir(agt);
                            }
                        }
                    }
                    if(md instanceof Predateur){
                        Predateur pre = (Predateur) md;
                        for (Agent agt : ag){
                            if (agt.getX()==pre.getX() && agt.getY()==pre.getY()){
                                pre.attaquer(agt);
                            }
                        }
                    }
                }
            }
            for (int k=0; k<res.size();k++){
                Ressource r = res.get(k);
                if (r.getQuantite() <= 0){
                    ter.videCase(r.getX(), r.getY());
                    res.remove(k);
                    System.out.println(r.toString() + " a disparu.");
                }
            }
        }
    }
}