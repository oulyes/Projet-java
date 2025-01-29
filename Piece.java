import java.awt.Color;

public abstract class Piece {
	protected Color couleur;
	public boolean estDame = false;

	public Piece(Color couleur) {
		this.couleur = couleur;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public abstract boolean peutDeplacer(Case depart, Case arrivee);
}
