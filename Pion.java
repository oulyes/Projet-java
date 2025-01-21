import java.awt.Color;

public class Pion extends Piece {
    public Pion(Color couleur) {
        super(couleur);
    }
    
    @Override
    public boolean peutDeplacer(Case depart, Case arrivee) {
        int direction = (couleur == Color.WHITE) ? -1 : 1;
        int diffX = arrivee.getX() - depart.getX();
        int diffY = Math.abs(arrivee.getY() - depart.getY());
        
        return diffY == 1 && diffX == direction;
    }
}
