public class TestJeuDames {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			try {
				new Jeu();
			} catch (Exception e) {
				System.err.println("Erreur lors du lancement du jeu : " + e.getMessage());
			}
		});
	}
}
