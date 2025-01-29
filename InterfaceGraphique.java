import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InterfaceGraphique extends JFrame {
	private final Jeu jeu;
	private JPanel plateauPanel;
	private Case caseSelectionnee = null;
	private JLabel statutLabel;

	private static final String DAME_SYMBOL = "\u265b";
	private static final String PION_SYMBOL = "\u26c0";

	public InterfaceGraphique(Jeu jeu) {
		this.jeu = jeu;
		initialiserInterface();
	}

	private void initialiserInterface() {
		setTitle("Jeu de Dames");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setLayout(new BorderLayout());

		JPanel infoPanel = new JPanel();
		statutLabel = new JLabel("Tour du Joueur 1 (Blancs)");
		infoPanel.add(statutLabel);
		add(infoPanel, BorderLayout.NORTH);

		plateauPanel = new JPanel(new GridLayout(10, 10));
		rafraichirPlateau();
		add(plateauPanel, BorderLayout.CENTER);

		JPanel boutonPanel = new JPanel();
		JButton btnQuitter = new JButton("Quitter");
		JButton btnRecommencer = new JButton("Recommencer");

		btnQuitter.addActionListener(e -> System.exit(0));
		btnRecommencer.addActionListener(e -> {
			jeu.recommencer();
			rafraichirPlateau();
		});

		boutonPanel.add(btnQuitter);
		boutonPanel.add(btnRecommencer);
		add(boutonPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public void mettreAJourStatut(String message) {
		statutLabel.setText(message);
	}

	private void rafraichirPlateau() {
		plateauPanel.removeAll();
		Plateau plateau = jeu.getPlateau();

		for (int i = 0; i < Plateau.TAILLE; i++) {
			for (int j = 0; j < Plateau.TAILLE; j++) {
				JPanel casePanel = creerPanelCase(plateau.getCase(i, j));
				plateauPanel.add(casePanel);
			}
		}

		plateauPanel.revalidate();
		plateauPanel.repaint();
	}

	private JPanel creerPanelCase(Case case_) {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setBackground(case_.estNoire() ? Color.DARK_GRAY : Color.LIGHT_GRAY);

		if (case_ == caseSelectionnee) {
			panel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));
		}

		if (case_.getPiece() != null) {
			JLabel pieceLabel = new JLabel(case_.getPiece() instanceof Dame ? DAME_SYMBOL : PION_SYMBOL, SwingConstants.CENTER);
			pieceLabel.setFont(new Font("Dialog", Font.BOLD, 40));
			pieceLabel.setForeground(case_.getPiece().getCouleur());
			panel.add(pieceLabel);
		}

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				gererClicCase(case_);
			}
		});

		return panel;
	}

	private void gererClicCase(Case caseCliquee) {
		if (jeu.estPartieTerminee()) {
			JOptionPane.showMessageDialog(this, "La partie est terminée !");
			return;
		}

		if (caseSelectionnee == null) {
			if (caseCliquee.getPiece() != null && caseCliquee.getPiece().getCouleur() == jeu.getJoueurCourant().getCouleur()) {
				caseSelectionnee = caseCliquee;
				rafraichirPlateau();
			}
		} else {
			if (!Case.equals(caseSelectionnee, caseCliquee)) {
				if (jeu.getPlateau().deplacerPiece(caseSelectionnee, caseCliquee)) {
					jeu.verifierGagnant();
					jeu.changerJoueur();
				} else {
					JOptionPane.showMessageDialog(this, "Coup invalide !");
				}
			}
			caseSelectionnee = null;
			rafraichirPlateau();
		}
	}
}
