package fr.ibformation.springboot.bataillenavale.gestionnairejeu;

import java.util.ArrayList;
import java.util.List;

import fr.ibformation.springboot.bataillenavale.gestionnairepartie.Tir;

public class Map {
	private long idMap;
	private int taille;
	private List<Emplacement> grille = new ArrayList<>();
	private List<Bateau> bateaux = new ArrayList<>();
	private int vieTotale;
	
	
	public Map() {

	}
	
	

	public int getVieTotale() {
		return vieTotale;
	}



	public void setVieTotale(int vieTotale) {
		this.vieTotale = vieTotale;
	}



	public Map(int taille) {
		this.taille = taille;
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				grille.add(new Emplacement(i, j));
			
			}
		}
		
		Bateau b = new Bateau (3,1,1,true);
		Bateau b2 = new Bateau (2,3,3,false);
		bateaux.add(b);
		bateaux.add(b2);
		
		ajouterBateau(b);
		ajouterBateau(b2);
		
		for (int i = 0; i<bateaux.size(); i++){
			vieTotale = vieTotale + bateaux.get(i).getVie();
			
		}
		
		//utiliser random pour generer un nombre aleatoire puis randomiser x, y et orientation
	
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public void ajouterBateau(Bateau b) {
	
		int i = b.getPosition_x();
		int j = b.getPosition_y();
		boolean orientation = b.getOrientation();
		int tailleBateau = b.getTaille();
		
		Emplacement e = grille.get(convertCoordToIndex(i, j));
		
		if (orientation == true) { //bateau vertical
			for (int t = 0; t < tailleBateau; t++) {
				grille.get(convertCoordToIndex(i + t, j)).setType(TypeType.BATEAU);
			}
		} else {
			for (int t = 0; t < tailleBateau; t++) { //bateau horizontal
				grille.get(convertCoordToIndex(i, j + t)).setType(TypeType.BATEAU);
			}

		}

	}

	public void gererTir(Tir tir) {
		Emplacement e = grille.get(convertCoordToIndex(tir.getPosition_x(), tir.getPosition_y()));
		switch (e.type) {
		case MER:
			e.statut = TypeStatutCase.DECOUVERT;
			System.out.println("plouf");
			System.out.println("vie restantes :  " + vieTotale);
			break;

		case BATEAU:
			e.statut = TypeStatutCase.DECOUVERT;
			System.out.println("BOOM");
			vieTotale = vieTotale - 1;
			System.out.println("vie restantes :  " + vieTotale);
			break;
		}
	}

	private int convertCoordToIndex(int x, int y) {
		return (y * taille) + x;

	}
	
	//toString personnalisr 2 boucles for, explorer les cases et afficher en fonction du statut

}
