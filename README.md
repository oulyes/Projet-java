 

Jeu de Dames en Java 

Ce projet est une implémentation du jeu de dames international en Java, avec une interface graphique réalisée à l'aide de la bibliothèque Swing. Le jeu permet à deux joueurs de s'affronter sur le même ordinateur en respectant les règles officielles du jeu de dames. 

Fonctionnalités 

Jeu à deux joueurs : Les joueurs peuvent jouer à tour de rôle sur le même ordinateur. 

Règles officielles : Le jeu respecte les règles classiques des dames, y compris les déplacements diagonaux, les captures obligatoires, les rafles et la promotion des pions en dames. 

Interface graphique intuitive : L'interface permet une interaction fluide avec le jeu, avec des cases cliquables pour déplacer les pièces. 

Option "Recommencer" : Permet de réinitialiser le jeu sans quitter la fenêtre actuelle. 

Règles du jeu 

Déplacement des pièces 

Pions : Les pions se déplacent d'une case en diagonale vers l'avant. 

Dames : Les dames peuvent se déplacer d'autant de cases que souhaité en diagonale, en avant ou en arrière. 

Promotion : Un pion qui atteint la dernière rangée devient une dame. 

Rafles 

Les pions capturés sont retirés du plateau après la rafle. 

Fin de partie 

La partie se termine lorsqu'un joueur n'a plus de pièces ou ne peut plus jouer. 

Comment jouer 

Lancer le jeu : Exécutez la classe TestJeuDames pour démarrer le jeu. 

Déplacer une pièce : Cliquez sur une pièce pour la sélectionner, puis cliquez sur la case de destination pour la déplacer. 

Recommencer : Cliquez sur le bouton "Recommencer" pour réinitialiser le jeu. 

Structure du projet 

Le projet est organisé en plusieurs classes principales : 

Jeu : Gère le déroulement du jeu, l'alternance des tours et les conditions de victoire. 

Plateau : Représente le plateau de jeu avec les cases et les pièces. 

Case : Représente une case du plateau, qui peut contenir une pièce ou être vide. 

Piece : Classe de base pour les pièces (pions et dames). 

Pion : Représente un pion sur le plateau. 

Dame : Représente une dame sur le plateau. 

Joueur : Représente un joueur avec un nom et une couleur. 

InterfaceGraphique : Gère l'interface graphique du jeu. 

Comment exécuter le projet 

Compilez les fichiers Java :javac *.java 
  

Exécutez le jeu :java TestJeuDames 
  
