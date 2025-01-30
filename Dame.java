import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

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

	public List<Case> getCasesIntermediaires(Case depart, Case arrivee) {
		List<Case> casesIntermediaires = new ArrayList<>();
		int dx = arrivee.getX() - depart.getX();
		int dy = arrivee.getY() - depart.getY();

		int stepX = dx / Math.abs(dx);
		int stepY = dy / Math.abs(dy);

		int x = depart.getX() + stepX;
		int y = depart.getY() + stepY;

		while (x != arrivee.getX() && y != arrivee.getY()) {
			casesIntermediaires.add(new Case(x, y, (x + y) % 2 == 1));
			x += stepX;
			y += stepY;
		}

		return casesIntermediaires;
	}

    public boolean isEstDame() {
        return estDame;
    }

    public void setEstDame(boolean estDame) {
        this.estDame = estDame;
    }
}
