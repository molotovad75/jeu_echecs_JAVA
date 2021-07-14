package fr.molotovad79.jeu_d_�checs.pi�ce;

public class Tour extends Pi�ce implements FonctionPi�ces,Echec_Roi {

	private int num�ro;
	private Tour[][] posT=(Tour[][]) getPosPi�ce();
	public Tour(CouleurPi�ce coulPi�ce,String initiale,Pi�ce[][] posPi�ce,int num�ro) {
		super(coulPi�ce,initiale,posPi�ce);
		this.setNum�ro(num�ro);
	}

	@Override
	public void manger(Pi�ce p) { //tour
		//x et y sont les coordonn�s de la cible
		int xTour=tour().getX(),yTour=tour().getY();
		Pi�ce[][] pos= p.getPosPi�ce();
		
		while((posT[p.getX()][yTour]==pos[p.getX()][p.getY()] || posT[xTour][p.getY()]==pos[p.getX()][p.getY()]) 
				&& pos[p.getX()][p.getY()]!=null && pos[p.getX()][p.getY()]!=roi() 
/* Tant qu'on veut d�placer la tour en horizontal (yTour ne doit pas changer de valeur) ou en vertical (xTour ne doit pas changer de valeur)
 * la position finale doit �tre non nulle et diff�rente s'il y a le roi
 * 
 * Extrait de code que j'ai retir� && pos[p1().getX()][p1().getY()]!=pos[p2().getX()][p2().getY()] 
 * */ 			
				) {
// Et on s'assure que les valeurs que l'on a entr� en param�tre ne soi pas les m�mes qu'une autre pi�ce.
			for(int i=xTour+1;i<=p.getX()-1;i++) {
				for(int j=yTour+1;j<=p.getY()-1;j++) {
					for(int d=xTour-1;d>=p.getX()-1;d--) {
						for(int k=yTour-1;k>=p.getY()-1;k--) {
							//p1().getX()=!p2().getX();
							//pos[p1().getX()][p1().getY()]!=pos[p2().getX()][p2().getY()];
							if((/*EST*/posT[i][yTour]==pos[getX()][getY()] 
							|| /*NORD*/posT[xTour][j]==pos[getX()][getY()] 
							||/*OUEST*/posT[d][yTour]==pos[getX()][getY()] 
							||/*SUD*/posT[xTour][k]==pos[getX()][getY()]) /*&& ((x-1)>getX() || (y-1)>getY() || (x-1)<getX() || (y-1)<getY())*/ ) {
								System.out.println("Tu ne peux manger dans cette direction si une pi�ce s'interpose "
										+ "dans ton chemin ! Tu peux la manger cette pi�ce qui te g�ne aussi ^^");
							}
							else if((/*EST*/posT[i][yTour]!=pos[getX()][getY()] 
									|| /*NORD*/posT[xTour][j]!=pos[getX()][getY()] 
									||/*OUEST*/posT[d][yTour]!=pos[getX()][getY()] 
									||/*SUD*/posT[xTour][k]!=pos[getX()][getY()]))		
							{
								p.setInitiale("");
								cimetiere().ajouter_cimeti�re(p); 
								cimetiere().setNbPi�ces(cimetiere().getNbPi�ces()+1);
								tour().setInitiale(""); //On efface l'initiale de la tour de son ancien emplacement.
								posT[xTour][yTour]=(Tour) pos[p.getX()][p.getY()];
								tour().setPosPi�ce(pos); // le pos entre parenth�ses c'est le pos de xTour yTour
								
								
								if (p.getCoulPi�ce().equals(CouleurPi�ce.BLANC)==true) {
									tour().setInitiale("TN");
								}else if(p.getCoulPi�ce().equals(CouleurPi�ce.NOIR)==true) {
									tour().setInitiale("TB");	
								}
								
								p.equals(null);
								
							}//if
						}//4eme for
					}//3eme for
				}//2eme for
			}//1er for
		}//while
	}//Fin de la m�thode manger.

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
	public void bouger(int x, int y) { //m�thode OK
		/* x et y sont des coordonn�e pour indiquer l'emplacement d'une case 
		il ne s'agit d'en aucun cas de distance d'une case � une autre.
		 * */
		int xTour=tour().getX(),yTour=tour().getY();
		Pi�ce[][] pos= getPosPi�ce();
		Pi�ce [][] pos2=getPosPi�ce();
		while((posT[x][yTour]==pos2[x][y] || posT[xTour][y]==pos2[x][y])
// Tant qu'on veut d�placer la tour en horizontal (yTour ne doit pas changer de valeur) ou en vertical (xTour ne doit pas changer de valeur)
		&& (pos2[x][y]!=pos[getX()][getY()])) {
// Et on s'assure que les valeurs que l'on a entr� en param�tre ne soi pas les m�mes qu'une autre pi�ce.
			for(int i=xTour+1;i<=x;i++) {
				for(int j=yTour+1;j<=y;j++) {
					for(int d=xTour-1;d>=x;d--) {
						for(int k=yTour-1;k>=y;k--) {
							//On teste � chaque it�ration la diff�rence entre une case vide du chemin et la non pr�sence d'une pi�ce.
							if((/*EST*/posT[i][yTour]!= pos[getX()][getY()]
							||/*NORD*/ posT[xTour][j]!= pos[getX()][getY()]
							||/*OUEST*/posT[d][yTour]!=pos[getX()][getY()]
							||/*SUD*/posT[xTour][k]!=pos[getX()][getY()]) && tour().getCoulPi�ce().equals(CouleurPi�ce.BLANC)==true){
								
								tour().setInitiale(null); //On efface l'initiale de la tour de son ancien emplacement.
								posT[xTour][yTour]=(Tour) pos2[x][y];
								tour().setPosPi�ce(posT); // le pos entre parenth�ses c'est le pos de xTour yTour
								tour().setInitiale("TB");
								System.out.println("La tour blanche a pour nouvelles coordonn�es ("+ x +","+ y+")");
							}else if((/*EST*/posT[i][yTour]!= pos[getX()][getY()]
									||/*NORD*/ posT[xTour][j]!= pos[getX()][getY()]
									||/*OUEST*/posT[d][yTour]!=pos[getX()][getY()]
									||/*SUD*/posT[xTour][k]!=pos[getX()][getY()]) && tour().getCoulPi�ce().equals(CouleurPi�ce.NOIR)==true) {
								
								tour().setInitiale(null); //On efface l'initiale de la tour de son ancien emplacement.
								posT[xTour][yTour]=(Tour) pos2[x][y];
								tour().setPosPi�ce(posT); // le pos entre parenth�ses c'est le pos de xTour yTour
								tour().setInitiale("TN");
								System.out.println("La tour noire a pour nouvelles coordonn�es ("+ x +","+ y+")");
							}
							
							else {
								System.out.println("Tu ne peux pas bouger sur une pi�ce !");
				
							}//if else	
						}// 4�me for
					}//3�me for	
				} //2�me for
			} // 1er for
		}//While
	}//Fin de la m�thode bouger
	
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
	public boolean mettre_en_�chec(Roi r) { //m�thode OK
		int xTour=tour().getX(),yTour=tour().getY(); //x c'est la ligne horizonrale et y c'est la ligne verticale.
		Pi�ce[][] pos= getPosPi�ce();
	
		for(int i=0;i<xTour;i++) {
			for(int j=0;j<yTour;j++) { // � finir !
				for(int t=xTour+1;t<8;t++) {
					for(int u=yTour+1;u<8;u++) {	
						if(( (posT[i][yTour]==pos[r.getX()][r.getY()] && posT[t][yTour]==pos[r.getX()][r.getY()]) //Si dans le sens horizontal, la tour croise  
							||(posT[xTour][j]==pos[r.getX()][r.getY()] && posT[xTour][u]==pos[r.getX()][r.getY()]))
								
								//Dans les deux lignes suivantes, on s'assure que la tour ne vas pas rencontrer de pi�ces sur son chemin entre lui et le roi.
								&& (posT[i][yTour]!=pos[getX()][getY()] || posT[t][yTour]!=pos[getX()][getY()] 
								|| posT[xTour][j]!=pos[getX()][getY()] || posT[xTour][u]!=pos[getX()][getY()]) ) { //Si dans le sens vertical, la tour croise  
							r.setest_en_�chec(true);
							System.out.println("Roi "+r.getCoulPi�ce()+" en danger, faut vite bouger !");
						}
					}
				}
				
			}
		}
		return r.est_en_�chec();
	}

	/**
	 * @return the num�ro
	 */
	public int getNum�ro() {
		return num�ro;
	}

	/**
	 * @param num�ro the num�ro to set
	 */
	public void setNum�ro(int num�ro) {
		this.num�ro = num�ro;
	}

}
