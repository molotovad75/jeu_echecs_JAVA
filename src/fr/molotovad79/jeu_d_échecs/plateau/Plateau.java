package fr.molotovad79.jeu_d_échecs.plateau;

import fr.molotovad79.jeu_d_échecs.pièce.Cavalier;
import fr.molotovad79.jeu_d_échecs.pièce.CouleurPièce;
import fr.molotovad79.jeu_d_échecs.pièce.Pion;
import fr.molotovad79.jeu_d_échecs.pièce.Pièce;
import fr.molotovad79.jeu_d_échecs.pièce.Reine;
import fr.molotovad79.jeu_d_échecs.pièce.Roi;
import fr.molotovad79.jeu_d_échecs.pièce.Tour;

public class Plateau {
	private Pièce tab[][];
	
	public Plateau() {
		this.setTab(new Pièce [8][8]);
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
	public Pièce[][] getTab() {
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
	public void setTab(Pièce tab[][]) {
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
		Pièce grille [][]=this.tab; 

		/*Instancion du roi*/
		Pièce roi_blanc=new Roi(CouleurPièce.BLANC,"",Pièce.roi().getPosPièce());
		Pièce roi_noir=new Roi(CouleurPièce.NOIR,"",Pièce.roi().getPosPièce());
		
		roi_blanc.setInitiale("K "+roi_blanc.getCoulPièce().name());
		roi_noir.setInitiale("K "+roi_noir.getCoulPièce().name());
		//placement des deux rois
		grille[0][5]=roi_blanc;
		grille[7][5]=roi_noir;
		
		/*Instanciation de la reine*/
		Pièce reine_blanche=new Reine(CouleurPièce.BLANC,"",Pièce.reine().getPosPièce());
		Pièce reine_noire=new Reine(CouleurPièce.NOIR,"",Pièce.reine().getPosPièce());
		
		reine_blanche.setInitiale("Q "+reine_blanche.getCoulPièce().name());
		reine_noire.setInitiale("Q "+reine_noire.getCoulPièce().name());
		
		//Placement des deux reines
		grille[0][4]=reine_blanche;
		grille[7][4]=reine_noire;
		
		
		//Initialisation des pions blancs
		
		Pièce pion_blanc_1=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),1);
		Pièce pion_blanc_2=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),2);
		Pièce pion_blanc_3=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),3);
		Pièce pion_blanc_4=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),4);
		Pièce pion_blanc_5=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),5);
		Pièce pion_blanc_6=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),6);
		Pièce pion_blanc_7=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),7);
		Pièce pion_blanc_8=new Pion(CouleurPièce.BLANC,"",Pièce.pion().getPosPièce(),8);
		
		//Initialisation des pions noirs
		Pièce pion_noir_1=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),1);
		Pièce pion_noir_2=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),2);
		Pièce pion_noir_3=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),3);
		Pièce pion_noir_4=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),4);
		Pièce pion_noir_5=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),5);
		Pièce pion_noir_6=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),6);
		Pièce pion_noir_7=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),7);
		Pièce pion_noir_8=new Pion(CouleurPièce.NOIR,"",Pièce.pion().getPosPièce(),8);
		
		//Instantion des initiales pour les pions blancs
		pion_blanc_1.setInitiale("P "+pion_blanc_1.getCoulPièce().name()+((Pion) pion_blanc_1).getNuméro());
		pion_blanc_2.setInitiale("P "+pion_blanc_2.getCoulPièce().name()+((Pion) pion_blanc_2).getNuméro());
		pion_blanc_3.setInitiale("P "+pion_blanc_3.getCoulPièce().name()+((Pion) pion_blanc_3).getNuméro());
		pion_blanc_4.setInitiale("P "+pion_blanc_4.getCoulPièce().name()+((Pion) pion_blanc_4).getNuméro());
		pion_blanc_5.setInitiale("P "+pion_blanc_5.getCoulPièce().name()+((Pion) pion_blanc_5).getNuméro());
		pion_blanc_6.setInitiale("P "+pion_blanc_6.getCoulPièce().name()+((Pion) pion_blanc_6).getNuméro());
		pion_blanc_7.setInitiale("P "+pion_blanc_7.getCoulPièce().name()+((Pion) pion_blanc_7).getNuméro());
		pion_blanc_8.setInitiale("P "+pion_blanc_8.getCoulPièce().name()+((Pion) pion_blanc_8).getNuméro());
		
		//Instantion des initiales pour les pions noirs
		pion_noir_1.setInitiale("P "+pion_noir_1.getCoulPièce().name()+((Pion) pion_noir_1).getNuméro());
		pion_noir_2.setInitiale("P "+pion_noir_2.getCoulPièce().name()+((Pion) pion_noir_2).getNuméro());
		pion_noir_3.setInitiale("P "+pion_noir_3.getCoulPièce().name()+((Pion) pion_noir_3).getNuméro());
		pion_noir_4.setInitiale("P "+pion_noir_4.getCoulPièce().name()+((Pion) pion_noir_4).getNuméro());
		pion_noir_5.setInitiale("P "+pion_noir_5.getCoulPièce().name()+((Pion) pion_noir_5).getNuméro());
		pion_noir_6.setInitiale("P "+pion_noir_6.getCoulPièce().name()+((Pion) pion_noir_6).getNuméro());
		pion_noir_7.setInitiale("P "+pion_noir_7.getCoulPièce().name()+((Pion) pion_noir_7).getNuméro());
		pion_noir_8.setInitiale("P "+pion_noir_8.getCoulPièce().name()+((Pion) pion_noir_8).getNuméro());
		
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
		
		Pièce tour_blanche_1=new Tour(CouleurPièce.BLANC,"",Pièce.tour().getPosPièce(),1);
		tour_blanche_1.setInitiale("T "+tour_blanche_1.getCoulPièce().name()+((Tour) tour_blanche_1).getNuméro());
		
		Pièce tour_blanche_2=new Tour(CouleurPièce.BLANC,"",Pièce.tour().getPosPièce(),2);
		tour_blanche_2.setInitiale("T "+tour_blanche_2.getCoulPièce().name()+((Tour) tour_blanche_2).getNuméro());
		
		Pièce tour_noire_1=new Tour(CouleurPièce.NOIR,"",Pièce.tour().getPosPièce(),1);
		tour_noire_1.setInitiale("T "+tour_noire_1.getCoulPièce().name()+((Tour) tour_noire_1).getNuméro());
		
		Pièce tour_noire_2=new Tour(CouleurPièce.NOIR,"",Pièce.tour().getPosPièce(),2);
		tour_noire_2.setInitiale("T "+tour_noire_2.getCoulPièce().name()+((Tour) tour_noire_2).getNuméro());
		
		/*Placement des tours */
		grille[0][0]=tour_blanche_1;
		grille[7][0]=tour_blanche_2;
		grille[0][7]=tour_noire_1;
		grille[7][7]=tour_noire_2;
		
		
		//Instanciation des cavaliers
		Pièce cavalier_blanc_1=new Cavalier(CouleurPièce.BLANC,"",Pièce.cavalier().getPosPièce());
		Pièce cavalier_noir_1=new Cavalier(CouleurPièce.NOIR,"",Pièce.cavalier().getPosPièce());
		Pièce cavalier_blanc_2=new Cavalier(CouleurPièce.BLANC,"",Pièce.cavalier().getPosPièce());
		Pièce cavalier_noir_2=new Cavalier(CouleurPièce.NOIR,"",Pièce.cavalier().getPosPièce());
		
		cavalier_blanc_1.setInitiale("C "+CouleurPièce.BLANC.name()+cavalier_blanc_1.getNuméro());
		
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
