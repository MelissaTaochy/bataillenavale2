package fr.ibformation.springboot.bataillenavale.gestionnairepartie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Joueur implements Serializable {
	
	long idJoueur;
	String nomJoueur;
	int nbPartiesGagnees;
	Partie partieEnCours;
	
	private List<Partie> parties = new ArrayList<>();
	
	public Joueur() {
	}
	public Joueur(String nomJoueur) {
		this.nomJoueur=nomJoueur;
	}
	

	public long getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(long idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	public int getNbPartiesGagnees() {
		return nbPartiesGagnees;
	}

	public void setNbPartiesGagnees(int nbPartiesGagnees) {
		this.nbPartiesGagnees = nbPartiesGagnees;
	}
	
	
	
	
	
	///////METHODES DE JOUEUR
	
	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + ", nbPartiesGagnees=" + nbPartiesGagnees
				+ ", partieEnCours=" + partieEnCours + ", parties=" + parties + "]";
	}
	public void seConnecter(){
		System.out.println("connecte");
	}
	
	public Partie creerPartie(){
		Partie p = new Partie();
		p.setJoueur1(this);
		p.setStatut(TypeStatut.OUVERTE);
		System.out.println("partie ouverte");
		System.out.println(p.getIdPartie());
		this.partieEnCours=p;
		return p;
				
	
	}
	
	public void rejoindrePartie(Partie p){
		
		if (p.getJoueur2()==null){
			p.setJoueur2(this);
			p.setStatut(TypeStatut.ENCOURS);
			this.partieEnCours=p;
		}
		System.out.println("partie rejointe");
		
	}
	
	public void tirer(int x, int y ){
		Tir tir = new Tir(x, y, this);
		partieEnCours.gererTirJoueur(tir);
	
		
		
	}
	
	public void quitterPartie(){
		partieEnCours=null;
		
	}
	
	

}
