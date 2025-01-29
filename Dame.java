import java.awt.Color;

public class Dame extends Piece {
    
    public boolean estDame = true;

    public Dame(Color couleur) {
        super(couleur);
    }
    
    @Override
    public boolean peutDeplacer(Case depart, Case arrivee) {
        int diffX = Math.abs(arrivee.getX() - depart.getX());
        int diffY = Math.abs(arrivee.getY() - depart.getY());
        
        return diffX == diffY;
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 33ea72ed644392ae77a03b6a338f7ca61c20b29d
