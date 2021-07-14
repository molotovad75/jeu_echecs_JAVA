package fr.molotovad79.jeu_d_échecs.pièce;

public class Tour extends Pièce implements FonctionPièces,Echec_Roi {

	private int numéro;
	private Tour[][] posT=(Tour[][]) getPosPièce();
	public Tour(CouleurPièce coulPièce,String initiale,Pièce[][] posPièce,int numéro) {
		super(coulPièce,initiale,posPièce);
		this.setNuméro(numéro);
	}

	@Override
	public void manger(Pièce p) { //tour
		//x et y sont les coordonnés de la cible
		int xTour=tour().getX(),yTour=tour().getY();
		Pièce[][] pos= p.getPosPièce();
		
		while((posT[p.getX()][yTour]==pos[p.getX()][p.getY()] || posT[xTour][p.getY()]==pos[p.getX()][p.getY()]) 
				&& pos[p.getX()][p.getY()]!=null && pos[p.getX()][p.getY()]!=roi() 
/* Tant qu'on veut déplacer la tour en horizontal (yTour ne doit pas changer de valeur) ou en vertical (xTour ne doit pas changer de valeur)
 * la position finale doit être non nulle et différente s'il y a le roi
 * 
 * Extrait de code que j'ai retiré && pos[p1().getX()][p1().getY()]!=pos[p2().getX()][p2().getY()] 
 * */ 			
				) {
// Et on s'assure que les valeurs que l'on a entré en paramètre ne soi pas les mêmes qu'une autre pièce.
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
								System.out.println("Tu ne peux manger dans cette direction si une pièce s'interpose "
										+ "dans ton chemin ! Tu peux la manger cette pièce qui te gène aussi ^^");
							}
							else if((/*EST*/posT[i][yTour]!=pos[getX()][getY()] 
									|| /*NORD*/posT[xTour][j]!=pos[getX()][getY()] 
									||/*OUEST*/posT[d][yTour]!=pos[getX()][getY()] 
									||/*SUD*/posT[xTour][k]!=pos[getX()][getY()]))		
							{
								p.setInitiale("");
								cimetiere().ajouter_cimetière(p); 
								cimetiere().setNbPièces(cimetiere().getNbPièces()+1);
								tour().setInitiale(""); //On efface l'initiale de la tour de son ancien emplacement.
								posT[xTour][yTour]=(Tour) pos[p.getX()][p.getY()];
								tour().setPosPièce(pos); // le pos entre parenthèses c'est le pos de xTour yTour
								
								
								if (p.getCoulPièce().equals(CouleurPièce.BLANC)==true) {
									tour().setInitiale("TN");
								}else if(p.getCoulPièce().equals(CouleurPièce.NOIR)==true) {
									tour().setInitiale("TB");	
								}
								
								p.equals(null);
								
							}//if
						}//4eme for
					}//3eme for
				}//2eme for
			}//1er for
		}//while
	}//Fin de la méthode manger.

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
	public void bouger(int x, int y) { //méthode OK
		/* x et y sont des coordonnée pour indiquer l'emplacement d'une case 
		il ne s'agit d'en aucun cas de distance d'une case à une autre.
		 * */
		int xTour=tour().getX(),yTour=tour().getY();
		Pièce[][] pos= getPosPièce();
		Pièce [][] pos2=getPosPièce();
		while((posT[x][yTour]==pos2[x][y] || posT[xTour][y]==pos2[x][y])
// Tant qu'on veut déplacer la tour en horizontal (yTour ne doit pas changer de valeur) ou en vertical (xTour ne doit pas changer de valeur)
		&& (pos2[x][y]!=pos[getX()][getY()])) {
// Et on s'assure que les valeurs que l'on a entré en paramètre ne soi pas les mêmes qu'une autre pièce.
			for(int i=xTour+1;i<=x;i++) {
				for(int j=yTour+1;j<=y;j++) {
					for(int d=xTour-1;d>=x;d--) {
						for(int k=yTour-1;k>=y;k--) {
							//On teste à chaque itération la différence entre une case vide du chemin et la non présence d'une pièce.
							if((/*EST*/posT[i][yTour]!= pos[getX()][getY()]
							||/*NORD*/ posT[xTour][j]!= pos[getX()][getY()]
							||/*OUEST*/posT[d][yTour]!=pos[getX()][getY()]
							||/*SUD*/posT[xTour][k]!=pos[getX()][getY()]) && tour().getCoulPièce().equals(CouleurPièce.BLANC)==true){
								
								tour().setInitiale(null); //On efface l'initiale de la tour de son ancien emplacement.
								posT[xTour][yTour]=(Tour) pos2[x][y];
								tour().setPosPièce(posT); // le pos entre parenthèses c'est le pos de xTour yTour
								tour().setInitiale("TB");
								System.out.println("La tour blanche a pour nouvelles coordonnées ("+ x +","+ y+")");
							}else if((/*EST*/posT[i][yTour]!= pos[getX()][getY()]
									||/*NORD*/ posT[xTour][j]!= pos[getX()][getY()]
									||/*OUEST*/posT[d][yTour]!=pos[getX()][getY()]
									||/*SUD*/posT[xTour][k]!=pos[getX()][getY()]) && tour().getCoulPièce().equals(CouleurPièce.NOIR)==true) {
								
								tour().setInitiale(null); //On efface l'initiale de la tour de son ancien emplacement.
								posT[xTour][yTour]=(Tour) pos2[x][y];
								tour().setPosPièce(posT); // le pos entre parenthèses c'est le pos de xTour yTour
								tour().setInitiale("TN");
								System.out.println("La tour noire a pour nouvelles coordonnées ("+ x +","+ y+")");
							}
							
							else {
								System.out.println("Tu ne peux pas bouger sur une pièce !");
				
							}//if else	
						}// 4ème for
					}//3ème for	
				} //2ème for
			} // 1er for
		}//While
	}//Fin de la méthode bouger
	
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
	public boolean mettre_en_échec(Roi r) { //méthode OK
		int xTour=tour().getX(),yTour=tour().getY(); //x c'est la ligne horizonrale et y c'est la ligne verticale.
		Pièce[][] pos= getPosPièce();
	
		for(int i=0;i<xTour;i++) {
			for(int j=0;j<yTour;j++) { // À finir !
				for(int t=xTour+1;t<8;t++) {
					for(int u=yTour+1;u<8;u++) {	
						if(( (posT[i][yTour]==pos[r.getX()][r.getY()] && posT[t][yTour]==pos[r.getX()][r.getY()]) //Si dans le sens horizontal, la tour croise  
							||(posT[xTour][j]==pos[r.getX()][r.getY()] && posT[xTour][u]==pos[r.getX()][r.getY()]))
								
								//Dans les deux lignes suivantes, on s'assure que la tour ne vas pas rencontrer de pièces sur son chemin entre lui et le roi.
								&& (posT[i][yTour]!=pos[getX()][getY()] || posT[t][yTour]!=pos[getX()][getY()] 
								|| posT[xTour][j]!=pos[getX()][getY()] || posT[xTour][u]!=pos[getX()][getY()]) ) { //Si dans le sens vertical, la tour croise  
							r.setest_en_échec(true);
							System.out.println("Roi "+r.getCoulPièce()+" en danger, faut vite bouger !");
						}
					}
				}
				
			}
		}
		return r.est_en_échec();
	}

	/**
	 * @return the numéro
	 */
	public int getNuméro() {
		return numéro;
	}

	/**
	 * @param numéro the numéro to set
	 */
	public void setNuméro(int numéro) {
		this.numéro = numéro;
	}

}
