import java.awt.Color;

public class Dame extends Piece {
	public Dame(Color couleur) {
		super(couleur);
	}
	
	@Override
	public boolean peutDeplacer(Case depart, Case arrivee) {
		int diffX = Math.abs(arrivee.getX() - depart.getX());
		int diffY = Math.abs(arrivee.getY() - depart.getY());
		
		return diffX == diffY;
	}
}