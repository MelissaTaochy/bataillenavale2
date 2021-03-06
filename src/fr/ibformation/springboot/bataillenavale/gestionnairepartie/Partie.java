package fr.ibformation.springboot.bataillenavale.gestionnairepartie;

import fr.ibformation.springboot.bataillenavale.gestionnairejeu.Map;

public class Partie {

	private long idPartie = 1;
	private Joueur joueur1;
	private Joueur joueur2;
	private Joueur joueurEnCours;
	private int nbToursMax = 6;
	private int tourEnCours = 0;

	private TypeStatut statut;
	private Joueur gagnant;
	private Map map1;
	private Map map2;

	public Partie() {

	}

	public long getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(long idPartie) {
		this.idPartie = idPartie;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public int getNbToursMax() {
		return nbToursMax;
	}

	public void setNbTours(int nbToursMax) {
		this.nbToursMax = nbToursMax;
	}

	public int getTourEnCours() {
		return tourEnCours;
	}

	public void setTourEnCours(int tourEnCours) {
		this.tourEnCours = tourEnCours;
	}

	public TypeStatut getStatut() {
		return statut;
	}

	public void setStatut(TypeStatut statut) {
		this.statut = statut;
	}

	public Joueur getGagnant() {
		return gagnant;
	}

	public Joueur setGagnant(Joueur gagnant) {

		return gagnant;
	}

	public Map getMap1() {
		return map1;
	}

	public void setMap1(Map map1) {
		this.map1 = map1;
	}

	public Map getMap2() {
		return map2;
	}

	public void setMap2(Map map2) {
		this.map2 = map2;
	}

	public void demarrerPartie() {
		if (statut == TypeStatut.ENCOURS) {
			map1 = new Map(10);
			map2 = new Map(10);
			System.out.println("NB INIT VIE :  " + map1.getVieTotale());
			joueurEnCours=joueur1;

			System.out.println(joueurEnCours.getNomJoueur());
		}
	}

	public void gererTirJoueur(Tir tir) {
		while (tourEnCours < nbToursMax) {
			System.out.println("tour en cours" + tourEnCours);
			if (joueurEnCours == joueur1) {
				System.out.println("joueur en cours : " + joueurEnCours.getNomJoueur());
				map2.gererTir(tir);
				tourEnCours++;
				joueurEnCours = joueur2;
				System.out.println("joueur en cours : " + joueurEnCours.getNomJoueur());
				System.out.println("tour en cours " + tourEnCours);
				break;
			}

			else if (joueurEnCours == joueur2) {
				System.out.println("joueur en cours : " + joueurEnCours.getNomJoueur());
				map1.gererTir(tir);
				tourEnCours++;
				joueurEnCours = joueur1;
				System.out.println("joueur en cours : " + joueurEnCours.getNomJoueur());
				break;
			}
			
		}
		
		if (tourEnCours==nbToursMax){
			System.out.println("nombre max de tour atteint");
			int scorej1 = map2.getVieTotale();
			int scorej2 = map1.getVieTotale();
			if(scorej1<scorej2){
				gagnant=joueur1;
			} else if (scorej1>scorej2){
				gagnant=joueur2;
				
			} else {
				System.out.println("egalite");
				gagnant=null;
			}
			System.out.println("GAGNANT  " + gagnant.getNomJoueur());
		}
		
	}

}
