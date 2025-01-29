import java.awt.*;
import javax.swing.JOptionPane;

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

	public void recommencer() {
		initialiserJeu();
	}

	public void verifierGagnant() {
		int black = 0, white = 0;
		for (int i = 0; i < Plateau.TAILLE; i++) {
			for (int j = 0; j < Plateau.TAILLE; j++) {
				Piece piece = plateau.getCase(i, j).getPiece();
				if (piece != null) {
					if (piece.getCouleur() == Color.WHITE) {
						white++;
					} else {
						black++;
					}
				}
			}
		}

		if (white == 0) {
			JOptionPane.showMessageDialog(interfaceGraphique, "Joueur 2 a gagné !");
			partieTerminee = true;
		} else if (black == 0) {
			JOptionPane.showMessageDialog(interfaceGraphique, "Joueur 1 a gagné !");
			partieTerminee = true;
		}
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
