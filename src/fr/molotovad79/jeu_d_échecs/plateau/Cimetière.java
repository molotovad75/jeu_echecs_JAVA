package fr.molotovad79.jeu_d_échecs.plateau;
import java.util.ArrayList;
import fr.molotovad79.jeu_d_échecs.pièce.Pièce;

public class Cimetière {
	private int nbPièces;
	private ArrayList <Pièce> list=new ArrayList<>();
	
	public Cimetière(ArrayList<Pièce> list) {
		this.setNbPièces(0);
		this.setList(list);
	}

	public ArrayList <Pièce> getList() {
		return list;
	}

	
	public void setList(ArrayList <Pièce> list) {
		this.list = list;
	}
	
	
	
	public ArrayList <Pièce> ajouter_cimetière(Pièce p){
		list.add(p);
		setNbPièces(this.nbPièces);
		return list;
	}

	/**
	 * @return the nbPièces
	 */
	public int getNbPièces() {
		return nbPièces;
	}

	/**
	 * @param nbPièces the nbPièces to set
	 */
	public void setNbPièces(int nbPièces) {
		this.nbPièces = nbPièces;
	}
	
	
}
