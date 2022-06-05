import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import fr.univsavoie.java.jeu2048.*;
            /* ############################################################################################################
Cette partie permet de contrôler l'action de chacune des touches du clavier.
On utilise ici les fleches directionnels mais aussi les touches plus répandues pour la direction ZQSD

Il est aussi important de remarquer que pour l'appui de n'importe quel touche (même hors les 8 utilisées pour la
direction) l'affichage de la grille est mise à jour ainsi que les affichages des différents scores
Les conditions de victoire et défaite sont aussi vérifier pour chaque touches.
    ############################################################################################################ */

public class KeyController extends KeyAdapter {
    private Scores score;
    private Jeu2048 jeu;
    private Grille grille;

    public KeyController(Scores s){
        this.score =s;
        this.jeu = s.getJeu();
        this.grille = s.getGrille();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //super.keyPressed(e);
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                jeu.decaler(jeu.HAUT);
                    break;
            case KeyEvent.VK_LEFT:
                jeu.decaler(jeu.GAUCHE);

                    break;
            case KeyEvent.VK_RIGHT:
                jeu.decaler(jeu.DROITE);
                    break;
            case KeyEvent.VK_DOWN:
                jeu.decaler(jeu.BAS);
                break;
            case KeyEvent.VK_Z:
                jeu.decaler(jeu.HAUT);

                    break;
            case KeyEvent.VK_Q:
                jeu.decaler(jeu.GAUCHE);

                    break;
            case KeyEvent.VK_D:
                jeu.decaler(jeu.DROITE);
                    break;
            case KeyEvent.VK_S:
                jeu.decaler(jeu.BAS);

                break;
        }
        grille.MajGrille();
        score.s.setText("Score : " + jeu.getScore());
        score.bs.setText("BestScore : " + jeu.getBestScore());
        grille.defaite();
        grille.victoire();


    }

    
}
