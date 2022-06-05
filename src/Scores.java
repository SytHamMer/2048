import javax.swing.*;
import java.awt.*;
import fr.univsavoie.java.jeu2048.*;

public class Scores extends JPanel {

    private Jeu2048 jeu;
    private Grille grille;
    JLabel bs;
    JLabel s;
    JButton ng;
    JLabel timer;
                /* ############################################################################################################
Ici est le panel gérant les différents boutons et labels de scores
    ############################################################################################################ */

    public Scores(Jeu2048 j, Grille g){

        bs = new JLabel("BestScore :" + Windows.jeu.getBestScore());
        s = new JLabel("Score : " + Windows.jeu.getScore());
        ng = new JButton("NEW GAME");
        timer = new JLabel("Time : ");
        this.grille =g;
        this.jeu =j;
        this.setLayout(new FlowLayout());
        this.add(s);
        this.add(ng);
        this.add(bs);
        this.add(timer);
        ng.addActionListener(new NewGameListener(jeu));


    }

    public Jeu2048 getJeu() {
        return jeu;
    }

    public Grille getGrille() {
        return grille;
    }
    
}
