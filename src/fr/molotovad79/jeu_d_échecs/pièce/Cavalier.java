package fr.molotovad79.jeu_d_�checs.pi�ce;

public class Cavalier extends Pi�ce implements FonctionPi�ces,Echec_Roi{
	private int num�ro;
	private Cavalier[][] posCH=(Cavalier[][]) getPosPi�ce();
	
	public Cavalier(CouleurPi�ce coulPi�ce,String initiale,Pi�ce [][] posPi�ce,int num�ro) {
		super(coulPi�ce, initiale,posPi�ce);
		this.num�ro=num�ro;
	}

	@Override
	public void manger(Pi�ce p) {
		int xCavalier=cavalier().getX(),yCavalier=cavalier().getY();
		Pi�ce[][] pos= p.getPosPi�ce();
//		pos[x][y]=pos[getX()][getY()];
		while(posCH[xCavalier+1][yCavalier-2]==pos[p.getX()][p.getY()] || posCH[xCavalier-1][yCavalier-2]==pos[p.getX()][p.getY()] 
				||posCH[xCavalier-2][yCavalier-1]==pos[p.getX()][p.getY()] || posCH[xCavalier-2][yCavalier+1]==pos[p.getX()][p.getY()]
				||posCH[xCavalier-1][yCavalier+2]==pos[p.getX()][p.getY()] || posCH[xCavalier+1][yCavalier+2]==pos[p.getX()][p.getY()]
				||posCH[xCavalier+2][yCavalier+1]==pos[p.getX()][p.getY()] || posCH[xCavalier+2][yCavalier-1]==pos[p.getX()][p.getY()]
				&& p!=null && p!=roi()) {
			//Le cavalier est la seule pi�ce qui peut sauter au dessus des autres pi�ces.
			cavalier().setInitiale(null);
			posCH[xCavalier][yCavalier]=(Cavalier) pos[p.getX()][p.getY()];
			cavalier().setPosPi�ce(pos);
			p.setInitiale("");
			cimetiere().ajouter_cimeti�re(p); 
			cimetiere().setNbPi�ces(cimetiere().getNbPi�ces()+1);
			
			if (p.getCoulPi�ce().equals(CouleurPi�ce.BLANC)==true) {
				cavalier().setInitiale("CH "+cavalier().getCoulPi�ce().name()+cavalier().getNum�ro());
			}
			else if(p.getCoulPi�ce().equals(CouleurPi�ce.NOIR)==true) {
				cavalier().setInitiale("CH "+cavalier().getCoulPi�ce().name()+cavalier().getNum�ro());
			}
			
			p.equals(null);
			
			
		}
	}
	
	/*
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * */	

	@Override
	public void bouger(int x, int y) {
		int xCavalier=cavalier().getX(),yCavalier=cavalier().getY();
		Pi�ce[][] pos= getPosPi�ce();
		pos[x][y]=pos[p1().getX()][p1().getY()];
		while(pos[xCavalier+1][yCavalier-2]==pos[x][y] ||pos[xCavalier-1][yCavalier-2]==pos[x][y] 
				||pos[xCavalier-2][yCavalier-1]==pos[x][y]||pos[xCavalier-2][yCavalier+1]==pos[x][y]
				||pos[xCavalier-1][yCavalier+2]==pos[x][y]||pos[xCavalier+1][yCavalier+2]==pos[x][y]
				||pos[xCavalier+2][yCavalier+1]==pos[x][y]||pos[xCavalier+2][yCavalier-1]==pos[x][y]
				 && pos[x][y]!=p1()&& pos[x][y]!=p2()) {
		
		}
		
	}
	
	/*
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * */	

	@Override
	public boolean mettre_en_�chec(Roi r) {
		
	}

	public int getNum�ro() {
		return num�ro;
	}

	public void setNum�ro(int num�ro) {
		this.num�ro = num�ro;
	}
	
	/*
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * ******************************************************************************************************************************************************
	 * */	
}
