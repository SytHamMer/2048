import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import fr.univsavoie.java.jeu2048.*;

public class Windows  extends JFrame{
    final static int HAUTEUR = 600;
    final static int LARGEUR = 600;
    static Jeu2048 jeu;
    private static int time;
    public Windows(){

    /* ############################################################################################################
Je vous invite à modifier la troisième valeur afin de tester les affichages de victoire (par exemple 32 car simple à
à faire pour vous j'en ai aucun doute)
    ############################################################################################################ */
        jeu =  new Jeu2048(4,4,2048);

        Grille g = new Grille(4,jeu);
        Scores score = new Scores(jeu,g);
        setTitle("2048");
        setSize(LARGEUR,HAUTEUR);
        this.getContentPane().setLayout(new BorderLayout());
        this.add(score,BorderLayout.SOUTH);
        this.add(g,BorderLayout.CENTER);
        this.addKeyListener(new KeyController(score));
        this.setFocusable(true);
        this.requestFocus();
            /* ############################################################################################################
Cette partie permet de réaliser des actions à la fermeture et ouverture de la fenètre.
Dans ce cas save dans un fichier à la fermeture et lancer le timer à l'ouverture
    ############################################################################################################ */
        this.addWindowListener(new WindowAdapter(){
            private Thread timThread;
            public void windowClosing(WindowEvent e){
              save("save.txt");
            }
            public void windowOpened(WindowEvent e){
                if(this.timThread == null || ! this.timThread.isAlive()){
                    timThread = new Thread(new Timer(score,jeu));
                    timThread.start();
                }
             
            }
          }
        );
        
        //score.setFocusable(false);
            /* ############################################################################################################
Partie permettant de gérer le timer, passer en static afin de pouvoir le réinitialiser avec le bouton "NEW GAME"
CF: la classe NewGameListenr
    ############################################################################################################ */
    }
    public static int getTime() {
        return time;
    }


    public static int reset(int t){
        t= 0;
        return t;
    }
    public static int add(int t){
        return t+1;
    }

    public static void setTime(int time) {
        Windows.time = time;
    }

    public class Timer implements Runnable{
        private Scores score;
        private Jeu2048 jeu;

        public Timer(Scores s, Jeu2048 j){
            this.score=s;
            this.jeu = j;
        }
        @Override
        public void run() {
            time = getTime();
            while(true){

                score.timer.setText("Time : " + time);
                System.out.println(time);
                time = add(time);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
            }
            // TODO Auto-generated method stub
            
        }
        
    }



       



            /* ############################################################################################################
Voici la fonction servant à sauvegarder, la partie charger n'ayant pas été réussite
    ############################################################################################################ */

    void save(String path) {
        System.out.println( "je suis dans save" );
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
        oos.writeObject(this);
        } catch (IOException e) {
        e.getStackTrace();
        } 
        }





    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        Windows f = new Windows();
        jeu.nouveauJeu();
        f.setVisible(true);

    }
}
