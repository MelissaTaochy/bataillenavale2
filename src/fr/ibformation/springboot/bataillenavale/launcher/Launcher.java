package fr.ibformation.springboot.bataillenavale.launcher;

import fr.ibformation.springboot.bataillenavale.gestionnairepartie.Joueur;
import fr.ibformation.springboot.bataillenavale.gestionnairepartie.Partie;

public class Launcher {

	public static void main(String[] args) {
		Joueur joueur1=new Joueur("joueur1");
		Joueur joueur2=new Joueur("joueur2");

		Partie p = joueur1.creerPartie();
		joueur2.rejoindrePartie(p);
		
		p.demarrerPartie();
		System.out.println("partie démarrée");
		System.out.println("joueur1 tire");
		joueur1.tirer(1, 1);
		System.out.println("joueur2 tire");
		joueur1.tirer(2, 1);
		System.out.println("joueur2 tire");
		joueur1.tirer(3, 1);
		System.out.println("joueur2 tire");
		joueur1.tirer(3, 3);
		System.out.println("joueur2 tire");
		joueur1.tirer(3, 4);
		System.out.println("joueur2 tire");
		
		
		
		
		
		
		System.out.println("FIN");

	}

}
