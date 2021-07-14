package fr.molotovad79.jeu_d_�checs.plateau;

import fr.molotovad79.jeu_d_�checs.pi�ce.Cavalier;
import fr.molotovad79.jeu_d_�checs.pi�ce.CouleurPi�ce;
import fr.molotovad79.jeu_d_�checs.pi�ce.Pion;
import fr.molotovad79.jeu_d_�checs.pi�ce.Pi�ce;
import fr.molotovad79.jeu_d_�checs.pi�ce.Reine;
import fr.molotovad79.jeu_d_�checs.pi�ce.Roi;
import fr.molotovad79.jeu_d_�checs.pi�ce.Tour;

public class Plateau {
	private Pi�ce tab[][];
	
	public Plateau() {
		this.setTab(new Pi�ce [8][8]);
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
	/**
	 * @return the tab
	 */
	public Pi�ce[][] getTab() {
		return tab;
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
	/**
	 * @param tab the tab to set
	 */
	public void setTab(Pi�ce tab[][]) {
		this.tab = tab;
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
	
	public void initialiser_plateau() {
		Pi�ce grille [][]=this.tab; 

		/*Instancion du roi*/
		Pi�ce roi_blanc=new Roi(CouleurPi�ce.BLANC,"",Pi�ce.roi().getPosPi�ce());
		Pi�ce roi_noir=new Roi(CouleurPi�ce.NOIR,"",Pi�ce.roi().getPosPi�ce());
		
		roi_blanc.setInitiale("K "+roi_blanc.getCoulPi�ce().name());
		roi_noir.setInitiale("K "+roi_noir.getCoulPi�ce().name());
		//placement des deux rois
		grille[0][5]=roi_blanc;
		grille[7][5]=roi_noir;
		
		/*Instanciation de la reine*/
		Pi�ce reine_blanche=new Reine(CouleurPi�ce.BLANC,"",Pi�ce.reine().getPosPi�ce());
		Pi�ce reine_noire=new Reine(CouleurPi�ce.NOIR,"",Pi�ce.reine().getPosPi�ce());
		
		reine_blanche.setInitiale("Q "+reine_blanche.getCoulPi�ce().name());
		reine_noire.setInitiale("Q "+reine_noire.getCoulPi�ce().name());
		
		//Placement des deux reines
		grille[0][4]=reine_blanche;
		grille[7][4]=reine_noire;
		
		
		//Initialisation des pions blancs
		
		Pi�ce pion_blanc_1=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),1);
		Pi�ce pion_blanc_2=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),2);
		Pi�ce pion_blanc_3=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),3);
		Pi�ce pion_blanc_4=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),4);
		Pi�ce pion_blanc_5=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),5);
		Pi�ce pion_blanc_6=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),6);
		Pi�ce pion_blanc_7=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),7);
		Pi�ce pion_blanc_8=new Pion(CouleurPi�ce.BLANC,"",Pi�ce.pion().getPosPi�ce(),8);
		
		//Initialisation des pions noirs
		Pi�ce pion_noir_1=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),1);
		Pi�ce pion_noir_2=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),2);
		Pi�ce pion_noir_3=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),3);
		Pi�ce pion_noir_4=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),4);
		Pi�ce pion_noir_5=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),5);
		Pi�ce pion_noir_6=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),6);
		Pi�ce pion_noir_7=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),7);
		Pi�ce pion_noir_8=new Pion(CouleurPi�ce.NOIR,"",Pi�ce.pion().getPosPi�ce(),8);
		
		//Instantion des initiales pour les pions blancs
		pion_blanc_1.setInitiale("P "+pion_blanc_1.getCoulPi�ce().name()+((Pion) pion_blanc_1).getNum�ro());
		pion_blanc_2.setInitiale("P "+pion_blanc_2.getCoulPi�ce().name()+((Pion) pion_blanc_2).getNum�ro());
		pion_blanc_3.setInitiale("P "+pion_blanc_3.getCoulPi�ce().name()+((Pion) pion_blanc_3).getNum�ro());
		pion_blanc_4.setInitiale("P "+pion_blanc_4.getCoulPi�ce().name()+((Pion) pion_blanc_4).getNum�ro());
		pion_blanc_5.setInitiale("P "+pion_blanc_5.getCoulPi�ce().name()+((Pion) pion_blanc_5).getNum�ro());
		pion_blanc_6.setInitiale("P "+pion_blanc_6.getCoulPi�ce().name()+((Pion) pion_blanc_6).getNum�ro());
		pion_blanc_7.setInitiale("P "+pion_blanc_7.getCoulPi�ce().name()+((Pion) pion_blanc_7).getNum�ro());
		pion_blanc_8.setInitiale("P "+pion_blanc_8.getCoulPi�ce().name()+((Pion) pion_blanc_8).getNum�ro());
		
		//Instantion des initiales pour les pions noirs
		pion_noir_1.setInitiale("P "+pion_noir_1.getCoulPi�ce().name()+((Pion) pion_noir_1).getNum�ro());
		pion_noir_2.setInitiale("P "+pion_noir_2.getCoulPi�ce().name()+((Pion) pion_noir_2).getNum�ro());
		pion_noir_3.setInitiale("P "+pion_noir_3.getCoulPi�ce().name()+((Pion) pion_noir_3).getNum�ro());
		pion_noir_4.setInitiale("P "+pion_noir_4.getCoulPi�ce().name()+((Pion) pion_noir_4).getNum�ro());
		pion_noir_5.setInitiale("P "+pion_noir_5.getCoulPi�ce().name()+((Pion) pion_noir_5).getNum�ro());
		pion_noir_6.setInitiale("P "+pion_noir_6.getCoulPi�ce().name()+((Pion) pion_noir_6).getNum�ro());
		pion_noir_7.setInitiale("P "+pion_noir_7.getCoulPi�ce().name()+((Pion) pion_noir_7).getNum�ro());
		pion_noir_8.setInitiale("P "+pion_noir_8.getCoulPi�ce().name()+((Pion) pion_noir_8).getNum�ro());
		
		//Placement des pions blancs
		grille[0][1]=pion_blanc_1;
		grille[1][1]=pion_blanc_2;
		grille[2][1]=pion_blanc_3;
		grille[3][1]=pion_blanc_4;
		grille[4][1]=pion_blanc_5;
		grille[5][1]=pion_blanc_6;
		grille[6][1]=pion_blanc_7;
		grille[7][1]=pion_blanc_8;
	
		//placement des pions noirs
		grille[0][6]=pion_noir_1;
		grille[1][6]=pion_noir_2;
		grille[2][6]=pion_noir_3;
		grille[3][6]=pion_noir_4;
		grille[4][6]=pion_noir_5;
		grille[5][6]=pion_noir_6;
		grille[6][6]=pion_noir_7;
		grille[7][6]=pion_noir_8;
		
		
		/*Instancion des 4 Tours*/
		
		Pi�ce tour_blanche_1=new Tour(CouleurPi�ce.BLANC,"",Pi�ce.tour().getPosPi�ce(),1);
		tour_blanche_1.setInitiale("T "+tour_blanche_1.getCoulPi�ce().name()+((Tour) tour_blanche_1).getNum�ro());
		
		Pi�ce tour_blanche_2=new Tour(CouleurPi�ce.BLANC,"",Pi�ce.tour().getPosPi�ce(),2);
		tour_blanche_2.setInitiale("T "+tour_blanche_2.getCoulPi�ce().name()+((Tour) tour_blanche_2).getNum�ro());
		
		Pi�ce tour_noire_1=new Tour(CouleurPi�ce.NOIR,"",Pi�ce.tour().getPosPi�ce(),1);
		tour_noire_1.setInitiale("T "+tour_noire_1.getCoulPi�ce().name()+((Tour) tour_noire_1).getNum�ro());
		
		Pi�ce tour_noire_2=new Tour(CouleurPi�ce.NOIR,"",Pi�ce.tour().getPosPi�ce(),2);
		tour_noire_2.setInitiale("T "+tour_noire_2.getCoulPi�ce().name()+((Tour) tour_noire_2).getNum�ro());
		
		/*Placement des tours */
		grille[0][0]=tour_blanche_1;
		grille[7][0]=tour_blanche_2;
		grille[0][7]=tour_noire_1;
		grille[7][7]=tour_noire_2;
		
		
		//Instanciation des cavaliers
		Pi�ce cavalier_blanc_1=new Cavalier(CouleurPi�ce.BLANC,"",Pi�ce.cavalier().getPosPi�ce());
		Pi�ce cavalier_noir_1=new Cavalier(CouleurPi�ce.NOIR,"",Pi�ce.cavalier().getPosPi�ce());
		Pi�ce cavalier_blanc_2=new Cavalier(CouleurPi�ce.BLANC,"",Pi�ce.cavalier().getPosPi�ce());
		Pi�ce cavalier_noir_2=new Cavalier(CouleurPi�ce.NOIR,"",Pi�ce.cavalier().getPosPi�ce());
		
		cavalier_blanc_1.setInitiale("C "+CouleurPi�ce.BLANC.name()+cavalier_blanc_1.getNum�ro());
		
		/*Dessin de la grille*/
		for (int i = 0; i<8; i++){
			for (int j = 0; j < 8; j++){
				System.out.print(" | "+ grille[i][j]);
			}System.out.println(" | ");
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
	

}
