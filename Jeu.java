import javax.swing.*;
import java.awt.*;

public class Jeu {
    private Plateau plateau;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueurCourant;
    private InterfaceGraphique interfaceGraphique;
    private boolean partieTerminee;

    public Jeu() {
        initialiserJeu();
    }

    private void initialiserJeu() {
        plateau = new Plateau();
        joueur1 = new Joueur("Joueur 1", Color.WHITE);
        joueur2 = new Joueur("Joueur 2", Color.BLACK);
        joueurCourant = joueur1;
        partieTerminee = false;
        interfaceGraphique = new InterfaceGraphique(this);
    }

    public void changerJoueur() {
        joueurCourant = (joueurCourant == joueur1) ? joueur2 : joueur1;
        interfaceGraphique.mettreAJourStatut("Tour de " + joueurCourant.getNom());
    }

    public Joueur getJoueurCourant() {
        return joueurCourant;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public boolean estPartieTerminee() {
        return partieTerminee;
    }
}