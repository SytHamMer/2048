

import java.awt.event.*;
import fr.univsavoie.java.jeu2048.*;
import javax.swing.*;

public class NewGameListener implements ActionListener {

    private Jeu2048 jeu;

    public NewGameListener(Jeu2048 j){
        this.jeu=j;

    }
            /* ############################################################################################################
lors de l'appui du bouton on relance un nouveau jeu mais aussi reset le timer
    ############################################################################################################ */
    @Override
    public void actionPerformed(ActionEvent e) {
        int t;
        jeu.nouveauJeu();
        t = Windows.reset(Windows.getTime());
        Windows.setTime(t);

        
        
    }
    
}
