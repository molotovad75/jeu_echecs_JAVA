package fr.molotovad79.jeu_d_�checs.pi�ce;

public class Reine extends Pi�ce implements FonctionPi�ces,Echec_Roi {

	private Reine[][] posQ=(Reine[][]) getPosPi�ce();
	
	public Reine(CouleurPi�ce coulPi�ce,String initiale,Pi�ce[][] posPi�ce) { // constructeur
		super(coulPi�ce, "Q",posPi�ce);
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
	public void manger(Pi�ce p) {
		int xReine=reine().getX(),yReine=reine().getY();
		Pi�ce[][] pos= p.getPosPi�ce();
		Pi�ce[][] pos2= getPosPi�ce();
		//pos[x][y]=pos[p1().getX()][p1().getY()];
		while((/*EST ET OUEST */posQ[p.getX()][yReine]==pos[p.getX()][p.getY()] ||
				 /*NORD ET SUD*/ posQ[xReine][p.getY()]==pos[p.getX()][p.getY()] ||
				/*Direction NORD-EST*/posQ[xReine+(p.getX()-xReine)][yReine+(p.getY()-yReine)]==pos[p.getX()][p.getY()] ||
				/*Direction SUD-OUEST*/ posQ[xReine-(xReine-p.getX())][yReine-(yReine-p.getY())]==pos[p.getX()][p.getY()] ||
				/*Direction NORD-OUEST*/posQ[xReine-(xReine-p.getX())][yReine+(p.getY()-yReine)]==pos[p.getX()][p.getY()]||
				/*Direction SUD-EST*/posQ[xReine+(p.getX()-xReine)][yReine-(yReine-p.getY())]==pos[p.getX()][p.getY()])
				&& p!=null && p!=roi() && pos[p.getX()][p.getY()]!=pos[getX()][getY()]
				&& pos[p.getX()][p.getY()]!=pos[getX()][getY()]) {
			
			for(int i=xReine+1;i<=p.getX()-1;i++) {
				for(int j=yReine+1;j<=p.getY()-1;j++) {
					for(int d=xReine-1;d>=p.getX()-1;d--) {
						for(int k=yReine-1;k>=p.getY()-1;k--) {
							/*On v�rifie qu'il n'y a pas de pi�ce qui entrave la circulation de la dame*/
							if(/*EST*/posQ[i][yReine]==pos2[getX()][getY()]  
								||/*NORD*/ posQ[xReine][j]==pos2[getX()][getY()]
								||/*OUEST*/posQ[d][yReine]==pos2[getX()][getY()]
								||/*SUD*/posQ[xReine][k]==pos2[getX()][getY()] 
								||/*NORD-EST*/posQ[i][j]==pos2[getX()][getY()] 
								|| /*NORD-OUEST*/posQ[d][j]==pos2[getX()][getY()] 
								|| /*SUD-EST*/posQ[i][k]==pos2[getX()][getY()] 
								||/*SUD-OUEST*/posQ[d][j]==pos2[getX()][getY()] ){
								System.out.println("Tu ne peux manger dans cette direction si une pi�ce s'interpose"
										+ "dans ton chemin ! Tu peux la manger cette pi�ce qui te g�ne aussi ^^");
							}else {
								
								
								//D�marche pour manger une pi�ce. S'en inspirer pour 
								//toutes les autres m�thodes.
								
								reine().setInitiale(null);
								posQ[xReine][yReine]=(Reine) pos[p.getX()][p.getY()];
								reine().setPosPi�ce(pos);
								p.setInitiale(null);
								cimetiere().ajouter_cimeti�re(p); 
								cimetiere().setNbPi�ces(cimetiere().getNbPi�ces()+1);
								
								
								if (p.getCoulPi�ce().equals(CouleurPi�ce.BLANC)==true) {
									reine().setInitiale("Q "+reine().getCoulPi�ce().name());
								}
								else if(p.getCoulPi�ce().equals(CouleurPi�ce.NOIR)==true) {
									reine().setInitiale("Q "+reine().getCoulPi�ce().name());
								}
								
								p.equals(null);
							}//if else	
						}// 4�me for
					}//3�me for	
				} //2�me for
			} // 1er for		
		}// While
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
		int xReine=reine().getX(),yReine=reine().getY();
		Pi�ce[][] pos= getPosPi�ce();
		Pi�ce [][] pos2=getPosPi�ce();  
		/*Le while c'est pour les mouvements autoris�s de la reine*/
		while((/*EST ET OUEST */posQ[x][yReine]==pos2[x][y] ||
				 /*NORD ET SUD*/ posQ[xReine][y]==pos2[x][y] ||
				/*Direction NORD-EST*/posQ[xReine+(x-xReine)][yReine+(y-yReine)]==pos2[x][y] ||
				/*Direction SUD-OUEST*/ posQ[xReine-(xReine-x)][yReine-(yReine-y)]==pos2[x][y] ||
				/*Direction NORD-OUEST*/posQ[xReine-(xReine-x)][yReine+(y-yReine)]==pos2[x][y]||
				/*Direction SUD-EST*/posQ[xReine+(x-xReine)][yReine-(yReine-y)]==pos2[x][y])
				&& (pos2[x][y]!=pos[p1().getX()][p1().getY()]||pos2[x][y]!=pos[p2().getX()][p2().getY()])) {
			
			for(int i=xReine+1;i<=x;i++) {
				for(int j=yReine+1;j<=y;j++) {
					for(int d=xReine-1;d>=x;d--) {
						for(int k=yReine-1;k>=y;k--) {
							/*Le if c'est pour pas que la reine bouge sur une autre pi�ce */
							if(/*EST*/posQ[i][yReine]!= pos[getX()][getY()]
								||/*NORD*/ posQ[xReine][j]!=pos[getX()][getY()]
								||/*OUEST*/posQ[d][yReine]!=pos[getX()][getY()]
								||/*SUD*/posQ[xReine][k]!= pos[getX()][getY()]
								||/*NORD-EST*/posQ[i][j]!= pos[getX()][getY()]
								|| /*NORD-OUEST*/posQ[d][j]!=pos[getX()][getY()]
								|| /*SUD-EST*/posQ[i][k]!=pos[getX()][getY()]
								||/*SUD-OUEST*/posQ[d][j]!=pos[getX()][getY()]){
								reine().setInitiale(null);
								posQ[xReine][yReine]=(Reine) pos2[x][y];
								reine().setPosPi�ce(posQ);
								reine().setInitiale("Q"+reine().getCoulPi�ce().name());
								
								
								
								//int xReine=reine().getX(), yReine=reine().getY();
								int xRoi=roi().getX(),yRoi=roi().getY();
								//Pi�ce[][] pos= getPosPi�ce();
								Pi�ce[][] posR= roi().getPosPi�ce();
								
								//Si la reine est en mesure de mettre en �chec le roi !
								for (int i1 = 0; i1 < xReine; i1++) { //v�rifier en horizontal � gauche de la dame for 1
									for (int j1 = xReine+1; j1 <8 ; j1++) { //v�rifier en horizontal � droite de la dame for 2
										for (int d1 = 0;  d1 < yReine; d1++) { //v�rifier en verticale en bas de la dame for 3
											for (int k1 = yReine+1; k1 < 8; k1++) { //v�rifier en vertical en haut de la dame for 4
												
												for (int i2 = 1; i2 < 8; i2++) {  //for 5
													for (int j2 = 1; j2 < 8; j2++) { //for 6
														//1�re partie du if on v�rifie s'il ya le roi.
												      if((posQ[i1][yReine]==posR[xRoi][yRoi] || posQ[j1][yReine]==posR[xRoi][yRoi] //Si dans le sens horizontal, la reine croise  
														||posQ[xReine][d1]==posR[xRoi][yRoi] || posQ[xReine][k1]==posR[xRoi][yRoi]
														/*Les deux lignes au dessus, on s'assure que la dame rep�re le roi en horizontal et vertical*/	
														|| posQ[xReine+i2][yReine+j2]==posR[xRoi][yRoi] /*NORD-EST*/ || posQ[xReine-i2][yReine-j2]==posR[xRoi][yRoi] /*SUD-OUEST*/ 
														|| posQ[xReine-i2][yReine+j2]==posR[xRoi][yRoi] /*NORD-OUEST*/ || posQ[xReine+i2][yReine-j2]==posR[xRoi][yRoi]/*SUD-EST*/)
														/*Les lignes au dessus on assure les diagonales de la reine*/
														
														
															&&
															
															(posQ[i1][yReine]!=pos[getX()][getY()] || posQ[j1][yReine]!=pos[getX()][getY()] 
															|| posQ[xReine][d1]!=pos[getX()][getY()] || posQ[xReine][k1]!=pos[getX()][getY()]
														/*Les deux lignes au dessus, on s'assure que la dame ne rencontre pas de pi�ces en horizontal et vertical entre elle et le roi*/
															|| posQ[xReine+i2][yReine+j2]!=pos[getX()][getY()] /*NORD-EST*/ || posQ[xReine-i2][yReine-j2]!=pos[getX()][getY()] /*SUD-OUEST*/ 
															|| posQ[xReine-i2][yReine+j2]!=pos[getX()][getY()] /*NORD-OUEST*/ || posQ[xReine+i2][yReine-j2]!=pos[getX()][getY()]/*SUD-EST*/	) 
																	
															&&
															roi().getCoulPi�ce().name().equals(reine().getCoulPi�ce().name())==false
															&& posR!=pos) {   
																//A l'int�rieur du if
															
																roi().setest_en_�chec(true);
																System.out.println("Roi "+roi().getCoulPi�ce().name()+" en danger, faut vite bouger !");
														
																
														}//Fin if
													}//Fin for 6
													
												}//Fin for 5
											}//Fin for 4
										}//Fin for 3
									}//Fin for 2
								}//Fin for 1
								
								
							}else {
								System.out.println("Tu ne peux pas bouger sur une pi�ce !");
				
							}//if else	
						}// 4�me for
					}//3�me for	
				} //2�me for
			} // 1er for	
		}
		//&& pos[x][y]!=pos[p1().getX()][p1().getY()]
		
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
