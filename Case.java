public class Case {
	private final int x;
	private final int y;
	private final boolean estNoire;
	private Piece piece;

	public Case(int x, int y, boolean estNoire) {
		this.x = x;
		this.y = y;
		this.estNoire = estNoire;
	}

	public int getX() { return x; }
	public int getY() { return y; }
	public boolean estNoire() { return estNoire; }
	public Piece getPiece() { return piece; }
	public void setPiece(Piece piece) { this.piece = piece; }
}