package fr.molotovad79.jeu_d_échecs.pièce;

import fr.molotovad79.jeu_d_échecs.plateau.Cimetière;

public class Pièce{
	private CouleurPièce coulPièce;
	private String initiale;
	private Pièce[][] posPièce=new Pièce[8][8];//Ce sont les coordonnées max sur le plateau, de taille 8*8.
	private int x,y;
	
	public Pièce(CouleurPièce coulPièce,String initiale,Pièce [][] posPièce) {
		this.coulPièce=coulPièce;
		this.setInitiale(initiale);
		this.setPosPièce(posPièce);
	}
	
	public CouleurPièce getCoulPièce() {
		return coulPièce;
	}

	public void setCoulPièce(CouleurPièce coulPièce) {
		this.coulPièce = coulPièce;
	}

	
	public String getInitiale() {
		return initiale;
	}

	public void setInitiale(String initiale) {
		this.initiale = initiale;
	}

	public Pièce[][] getPosPièce() {
		return posPièce;
	}

	public void setPosPièce(Pièce [][] posPièce) {
		this.posPièce = posPièce;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Cimetière cimetiere() {
		return cimetiere();
	}
	
	public static Roi roi() {	
		return roi();	
	}
	public static Reine reine() {
		return reine();
	}
	public Pièce p1() {
		return p1();
	}
	public Pièce p2() {
		return Pièce.this;
	}
	
	public static Pion pion() {
		return pion();
	}
	public static Tour tour() {
		return	tour();
	}
	
	public static Fou fou() {
		return fou();
	}
	
	public static Cavalier cavalier() {
		return cavalier();
	}
}