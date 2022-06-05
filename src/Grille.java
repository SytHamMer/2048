import javax.swing.*;
import java.awt.*;
import java.util.Random;

import fr.univsavoie.java.jeu2048.*;

public class Grille extends JPanel {
    int taille;
    JLabel tab[][];
    private Jeu2048 jeu;

    public Grille(int n, Jeu2048 j){
        this.jeu = j;
        this.setLayout(new GridLayout(n,n));
        int l;
        int c;
        tab = new JLabel[n][n];
        this.taille  = n;
        for(l=0;l<taille;l++){
            for(c=0;c<taille;c++){
               // System.out.println( "l: " + l + " c: " + c  );
                tab[l][c] = new JLabel(jeu.getGrilleString()[l][c]);
                tab[l][c].setFont(new Font("Serif",Font.BOLD, 30));
                tab[l][c].setVerticalAlignment(SwingConstants.CENTER);
                tab[l][c].setHorizontalAlignment(SwingConstants.CENTER);
                tab[l][c].setBackground(Color.BLACK);
                tab[l][c].setOpaque(true);
                tab[l][c].setBorder(BorderFactory.createLineBorder(Color.GRAY, 3));
                tab[l][c].setFocusable(true);
                this.add(tab[l][c]);
            }

        }
        this.setFocusable(true);
    }
    /* ############################################################################################################

    Cette fonction permet de realiser les différentes couleurs pour les valeurs de cases différentes
    ############################################################################################################ */
    public void MajColor(int l, int c){
        
        switch(jeu.getGrilleInt()[l][c]){

            case 0:
                tab[l][c].setText("");
                tab[l][c].setBackground(Color.BLACK);

                break;
            case 2:
                tab[l][c].setBackground(new Color(255,0,0));

                break;
            case 4:
                tab[l][c].setBackground(new Color(255,85,0));
                break;
            case 8:
                tab[l][c].setBackground(new Color(255,205,0));
                break;
            case 16:
                tab[l][c].setBackground(new Color(185,205,0));
                break;
            case 32:
                tab[l][c].setBackground(new Color(0,255,0));
                break;
            case 64:
                tab[l][c].setBackground(new Color(0,255,155));
                break;
            case 128:
                tab[l][c].setBackground(new Color(0,240,255));
                break;
            case 256:
                tab[l][c].setBackground(new Color(0,155,255));
                break;
            case 512:
                tab[l][c].setBackground(new Color(0,31,255));
                break;
            case 1024:
                tab[l][c].setBackground(new Color(162,0,255));
                break;
            case 2048:
                tab[l][c].setBackground(new Color(255,0,255));
                break; 
        }
    }
    /* ############################################################################################################
Ici on met à jour la grille cette fonction est appelé à chaque action sur le clavier
    ############################################################################################################ */
    public void MajGrille(){
        int l;
        int c;
        for(l=0;l<taille;l++){
            for(c=0;c<taille;c++){
                tab[l][c].setText(jeu.getGrilleString()[l][c]);
                MajColor(l, c);
            }
        }

    }


    public void defaite(){
        if(jeu.estTermine()==true && jeu.estVainqueur() == false){
            int l;
            int c;
            for(l=0;l<taille;l++){
                for(c=0;c<taille;c++){
                    tab[l][c].setText("LOST");
                    tab[l][c].setBackground(Color.RED);
                }
            }
                /* ############################################################################################################
Cette partie de la fonction premet d'afficher dans les labels la défaite ainsi que le score et le temps mis pour le faire
    ############################################################################################################ */
            tab[1][1].setText("Score : ");
            tab[1][1].setBackground(new Color(255,0,255));
            tab[1][2].setText(""+jeu.getScore());
            tab[1][2].setBackground(Color.WHITE);
            tab[2][1].setText("Time : ");
            tab[2][1].setBackground(new Color(255,0,255));
            tab[2][2].setText(""+Windows.getTime());
            tab[2][2].setBackground(Color.WHITE);


            System.out.println( "Perdu !" );
        }
    }
    public void victoire(){
        if(jeu.estTermine()==true && jeu.estVainqueur() == true){
            int l;
            int c;
            Random random = new Random();
            int nbr,nbg,nbb;
    /* ############################################################################################################
Cette partie est purement esthétique, sur le même principe que la défaite on affiche "GG" dans chaque label
mais avec un fond de couleur généré aléatoirement
Le temps et le score sont aussi affiché au centre
    ############################################################################################################ */
            for(l=0;l<taille;l++){
                for(c=0;c<taille;c++){
                    nbr= random.nextInt(255);
                    nbg= random.nextInt(255);
                    nbb= random.nextInt(255);
                    tab[l][c].setText("GG");

                    tab[l][c].setBackground(new Color(nbr,nbg,nbb));
                }
            }
            tab[1][1].setText("Score : ");
            tab[1][1].setBackground(new Color(255,0,255));
            tab[1][2].setText(""+jeu.getScore());
            tab[1][2].setBackground(Color.WHITE);
            tab[2][1].setText("Time : ");
            tab[2][1].setBackground(new Color(255,0,255));
            tab[2][2].setText(""+Windows.getTime());
            tab[2][2].setBackground(Color.WHITE);


            System.out.println( "Victoire !" );
        }
    }
    
   
    
}
