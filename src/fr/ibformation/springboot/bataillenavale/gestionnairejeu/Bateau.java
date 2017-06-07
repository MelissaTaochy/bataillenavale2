package fr.ibformation.springboot.bataillenavale.gestionnairejeu;



public class Bateau {
	int taille;
	int position_x;
	int position_y;
	boolean orientation;
	int vie;
	
	public Bateau() {
	
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getPosition_x() {
		return position_x;
	}
	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}
	public int getPosition_y() {
		return position_y;
	}
	public void setPosition_y(int position_y) {
		this.position_y = position_y;
	}
	public boolean getOrientation() {
		return orientation;
	}
	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}
	public int getVie() {
		vie = taille;
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	public Bateau(int taille, int position_x, int position_y, boolean orientation) {
		super();
		this.taille = taille;
		this.position_x = position_x;
		this.position_y = position_y;
		this.orientation = orientation;
	}
	
	
	

}
