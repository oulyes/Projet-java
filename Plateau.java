import java.awt.Color;

public class Plateau {
    public final Case[][] cases;
    public static final int TAILLE = 10;

    public Plateau() {
        cases = new Case[TAILLE][TAILLE];
        initialiserPlateau();
    }

    private void initialiserPlateau() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                boolean estNoire = (i + j) % 2 == 1;
                cases[i][j] = new Case(i, j, estNoire);
                
                if (estNoire) {
                    if (i < 4) {
                        cases[i][j].setPiece(new Pion(Color.BLACK));
                    } else if (i > 5) {
                        cases[i][j].setPiece(new Pion(Color.WHITE));
                    }
                }
            }
        }
    }

    public Case getCase(int x, int y) {
        if (x >= 0 && x < TAILLE && y >= 0 && y < TAILLE) {
            return cases[x][y];
        }
        return null;
    }

    public boolean deplacerPiece(Case depart, Case arrivee) {
        if (mouvementValide(depart, arrivee)) {
            effectuerDeplacement(depart, arrivee);
            return true;
        }
        return false;
    }

    private void effectuerDeplacement(Case depart, Case arrivee) {
        if (!depart.getPiece().estDame) {
            if (Math.abs(depart.getX() - arrivee.getX()) == 2) {
                int captureX = (depart.getX() + arrivee.getX()) / 2;
                int captureY = (depart.getY() + arrivee.getY()) / 2;
                cases[captureX][captureY].setPiece(null);
            }
        }else{
            int dx = arrivee.getX() - depart.getX();
            int dy = arrivee.getY() - depart.getY();

            if (Math.abs(dx) != Math.abs(dy)) {

                int stepX = dx / Math.abs(dx);
                int stepY = dy / Math.abs(dy);

                int x = depart.getX();
                int y = depart.getY();


                for (int i = 1; i < Math.abs(dx); i++) {
                    x += stepX;
                    y += stepY;

                    if (cases[x][y].getPiece() != null) {
                        if (cases[x][y].getPiece().getCouleur() != depart.getPiece().getCouleur()) {
                            cases[x][y].setPiece(null);
                        } 
                    }
                }
            }
        }

        arrivee.setPiece(depart.getPiece());
        depart.setPiece(null);
        verifierPromotion(arrivee); 
    }

    private boolean mouvementValide(Case depart, Case arrivee) {
        if (depart.getPiece() == null || !arrivee.estNoire() || arrivee.getPiece() != null) {
            return false;
        }

        int diffX = arrivee.getX() - depart.getX();
        int diffY = arrivee.getY() - depart.getY();
        Piece piece = depart.getPiece();

        if (piece instanceof Pion) {
            int direction = (piece.getCouleur() == Color.WHITE) ? -1 : 1;
            
            if (Math.abs(diffY) == 1 && diffX == direction) {
                return true;
            }
            
            if (Math.abs(diffY) == 2 && diffX == 2 * direction) {
                Case caseIntermediaire = cases[(depart.getX() + arrivee.getX()) / 2]
                                            [(depart.getY() + arrivee.getY()) / 2];
                return caseIntermediaire.getPiece() != null && 
                       caseIntermediaire.getPiece().getCouleur() != piece.getCouleur();
            }
        }

        if (piece instanceof Dame) {
            return Math.abs(diffX) == Math.abs(diffY);
        }

        return false;
    }

    private void verifierPromotion(Case caseArrivee) {
        Piece piece = caseArrivee.getPiece();
        if (piece instanceof Pion) {
            if ((piece.getCouleur() == Color.WHITE && caseArrivee.getX() == 0) ||
                (piece.getCouleur() == Color.BLACK && caseArrivee.getX() == TAILLE - 1)) {
                caseArrivee.setPiece(new Dame(piece.getCouleur()));
            }
        }
    }
}