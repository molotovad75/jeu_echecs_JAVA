package fr.molotovad79.jeu_d_�checs.pi�ce;

import fr.molotovad79.jeu_d_�checs.plateau.Cimeti�re;

public class Pi�ce{
	private CouleurPi�ce coulPi�ce;
	private String initiale;
	private Pi�ce[][] posPi�ce=new Pi�ce[8][8];//Ce sont les coordonn�es max sur le plateau, de taille 8*8.
	private int x,y;
	
	public Pi�ce(CouleurPi�ce coulPi�ce,String initiale,Pi�ce [][] posPi�ce) {
		this.coulPi�ce=coulPi�ce;
		this.setInitiale(initiale);
		this.setPosPi�ce(posPi�ce);
	}
	
	public CouleurPi�ce getCoulPi�ce() {
		return coulPi�ce;
	}

	public void setCoulPi�ce(CouleurPi�ce coulPi�ce) {
		this.coulPi�ce = coulPi�ce;
	}

	
	public String getInitiale() {
		return initiale;
	}

	public void setInitiale(String initiale) {
		this.initiale = initiale;
	}

	public Pi�ce[][] getPosPi�ce() {
		return posPi�ce;
	}

	public void setPosPi�ce(Pi�ce [][] posPi�ce) {
		this.posPi�ce = posPi�ce;
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
	
	public Cimeti�re cimetiere() {
		return cimetiere();
	}
	
	public static Roi roi() {	
		return roi();	
	}
	public static Reine reine() {
		return reine();
	}
	public Pi�ce p1() {
		return p1();
	}
	public Pi�ce p2() {
		return Pi�ce.this;
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