package fr.molotovad79.jeu_d_�checs.pi�ce;


public class Roi extends Pi�ce implements FonctionPi�ces {

	private boolean est_en_�chec;
	private boolean echec_et_mat;
	
	public Roi(CouleurPi�ce coulPi�ce,String initiale,Pi�ce[][] posPi�ce) {
		super(coulPi�ce, initiale,posPi�ce);
		this.est_en_�chec=false;
		this.echec_et_mat=false;
	}

	/**
	 * @return the echec_et_mat
	 */
	public boolean isEchec_et_mat() {
		return echec_et_mat;
	}

	/**
	 * @param echec_et_mat the echec_et_mat to set
	 */
	public void setEchec_et_mat(boolean echec_et_mat) {
		this.echec_et_mat = echec_et_mat;
	}
	public boolean est_en_�chec() {
		return est_en_�chec;
	}
	
	public void setest_en_�chec(boolean est_en_�chec) {
		this.est_en_�chec=est_en_�chec;
	}
	
	
	@Override
	public void manger(Pi�ce p) { //m�thode valid�e
		int xRoi=roi().getX(),yRoi=roi().getY();
		Pi�ce[][] pos= getPosPi�ce();
		//pos[x][y]=pos[p1().getX()][p1().getY()];			
			while((pos[p.getX()-1][p.getY()-1]==pos[xRoi][yRoi]   ||pos[p.getX()][p.getY()-1]==pos[xRoi][yRoi] 
					||pos[p.getX()+1][p.getY()-1]==pos[xRoi][yRoi] ||pos[p.getX()+1][p.getY()]==pos[xRoi][yRoi]
					||pos[p.getX()+1][p.getY()+1]==pos[xRoi][yRoi] ||pos[p.getX()][p.getY()+1]==pos[xRoi][yRoi] 
					||pos[p.getX()-1][p.getY()+1]==pos[xRoi][yRoi] ||pos[p.getX()-1][p.getY()]==pos[xRoi][yRoi]) 
					&&  p1()!=roi() &&  p1()!=null) {
				
				if(p.equals(roi())==true) {
					System.out.println("Deux roi ne peuvent pas s'entre manger !\n "
							+ "De plus ils ne peuvent se mettrent en �chec tous les deux.");
				}else {
					roi().setInitiale("");
					pos[xRoi][yRoi]=pos[p.getX()][p.getY()];	
					roi().setPosPi�ce(pos);
					p.setInitiale("");
					cimetiere().ajouter_cimeti�re(p);
					cimetiere().setNbPi�ces(cimetiere().getNbPi�ces()+1);
					
					
					if (p.getCoulPi�ce().equals(CouleurPi�ce.BLANC)==true) {
						roi().setInitiale("KN");
					}else if (p.getCoulPi�ce().equals(CouleurPi�ce.NOIR)==true ) {
						roi().setInitiale("K"+roi().getCoulPi�ce().name());
					}
					p.equals(null);
					
				}
				
			}
			/* condition pour que le roi 
			 * soit � une distance de 1 case 
			 * autour de sa cible � �liminer*/ 
	}

	@Override
	public void bouger(int x, int y) {
		int xRoi=roi().getX(),yRoi=roi().getY();
		Pi�ce[][] pos= getPosPi�ce();
		pos[x][y]=null;
		while((pos[x-1][y-1]==pos[xRoi][yRoi]   ||pos[x][y-1]==pos[xRoi][yRoi] ||pos[x+1][y-1]==pos[xRoi][yRoi] ||pos[x+1][y]==pos[xRoi][yRoi]
				||pos[x+1][y+1]==pos[xRoi][yRoi] ||pos[x][y+1]==pos[xRoi][yRoi] ||pos[x-1][y+1]==pos[xRoi][yRoi] ||pos[x-1][y]==pos[xRoi][yRoi]) 
				&& pos[x][y]!=pos[p1().getX()][p1().getY()]) {
			if(pos[x][y]==pos[p1().getX()][p1().getY()]) {
				System.out.println("Vous ne pouvez pas bouger sur une autre pi�ce ! Autant la bouffer ;)");
			}else {
				roi().setInitiale(null);
				pos[xRoi][yRoi]=pos[x][y];	
				roi().setPosPi�ce(pos);
				roi().setInitiale("K");
			}	
		}
		
	}
	/*Cette m�thode cr�e un mouvement sur 
	 * le plateau pour que la pi�ce se d�place sans probl�me. */


	

}
