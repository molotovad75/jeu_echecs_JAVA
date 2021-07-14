package fr.molotovad79.jeu_d_échecs.pièce;


public class Roi extends Pièce implements FonctionPièces {

	private boolean est_en_échec;
	private boolean echec_et_mat;
	
	public Roi(CouleurPièce coulPièce,String initiale,Pièce[][] posPièce) {
		super(coulPièce, initiale,posPièce);
		this.est_en_échec=false;
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
	public boolean est_en_échec() {
		return est_en_échec;
	}
	
	public void setest_en_échec(boolean est_en_échec) {
		this.est_en_échec=est_en_échec;
	}
	
	
	@Override
	public void manger(Pièce p) { //méthode validée
		int xRoi=roi().getX(),yRoi=roi().getY();
		Pièce[][] pos= getPosPièce();
		//pos[x][y]=pos[p1().getX()][p1().getY()];			
			while((pos[p.getX()-1][p.getY()-1]==pos[xRoi][yRoi]   ||pos[p.getX()][p.getY()-1]==pos[xRoi][yRoi] 
					||pos[p.getX()+1][p.getY()-1]==pos[xRoi][yRoi] ||pos[p.getX()+1][p.getY()]==pos[xRoi][yRoi]
					||pos[p.getX()+1][p.getY()+1]==pos[xRoi][yRoi] ||pos[p.getX()][p.getY()+1]==pos[xRoi][yRoi] 
					||pos[p.getX()-1][p.getY()+1]==pos[xRoi][yRoi] ||pos[p.getX()-1][p.getY()]==pos[xRoi][yRoi]) 
					&&  p1()!=roi() &&  p1()!=null) {
				
				if(p.equals(roi())==true) {
					System.out.println("Deux roi ne peuvent pas s'entre manger !\n "
							+ "De plus ils ne peuvent se mettrent en échec tous les deux.");
				}else {
					roi().setInitiale("");
					pos[xRoi][yRoi]=pos[p.getX()][p.getY()];	
					roi().setPosPièce(pos);
					p.setInitiale("");
					cimetiere().ajouter_cimetière(p);
					cimetiere().setNbPièces(cimetiere().getNbPièces()+1);
					
					
					if (p.getCoulPièce().equals(CouleurPièce.BLANC)==true) {
						roi().setInitiale("KN");
					}else if (p.getCoulPièce().equals(CouleurPièce.NOIR)==true ) {
						roi().setInitiale("K"+roi().getCoulPièce().name());
					}
					p.equals(null);
					
				}
				
			}
			/* condition pour que le roi 
			 * soit à une distance de 1 case 
			 * autour de sa cible à éliminer*/ 
	}

	@Override
	public void bouger(int x, int y) {
		int xRoi=roi().getX(),yRoi=roi().getY();
		Pièce[][] pos= getPosPièce();
		pos[x][y]=null;
		while((pos[x-1][y-1]==pos[xRoi][yRoi]   ||pos[x][y-1]==pos[xRoi][yRoi] ||pos[x+1][y-1]==pos[xRoi][yRoi] ||pos[x+1][y]==pos[xRoi][yRoi]
				||pos[x+1][y+1]==pos[xRoi][yRoi] ||pos[x][y+1]==pos[xRoi][yRoi] ||pos[x-1][y+1]==pos[xRoi][yRoi] ||pos[x-1][y]==pos[xRoi][yRoi]) 
				&& pos[x][y]!=pos[p1().getX()][p1().getY()]) {
			if(pos[x][y]==pos[p1().getX()][p1().getY()]) {
				System.out.println("Vous ne pouvez pas bouger sur une autre pièce ! Autant la bouffer ;)");
			}else {
				roi().setInitiale(null);
				pos[xRoi][yRoi]=pos[x][y];	
				roi().setPosPièce(pos);
				roi().setInitiale("K");
			}	
		}
		
	}
	/*Cette méthode crée un mouvement sur 
	 * le plateau pour que la pièce se déplace sans problème. */


	

}
