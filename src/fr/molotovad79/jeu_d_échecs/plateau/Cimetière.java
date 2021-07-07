package fr.molotovad79.jeu_d_�checs.plateau;
import java.util.ArrayList;
import fr.molotovad79.jeu_d_�checs.pi�ce.Pi�ce;

public class Cimeti�re {
	private int nbPi�ces;
	private ArrayList <Pi�ce> list=new ArrayList<>();
	
	public Cimeti�re(ArrayList<Pi�ce> list) {
		this.setNbPi�ces(0);
		this.setList(list);
	}

	public ArrayList <Pi�ce> getList() {
		return list;
	}

	
	public void setList(ArrayList <Pi�ce> list) {
		this.list = list;
	}
	
	
	
	public ArrayList <Pi�ce> ajouter_cimeti�re(Pi�ce p){
		list.add(p);
		setNbPi�ces(this.nbPi�ces);
		return list;
	}

	/**
	 * @return the nbPi�ces
	 */
	public int getNbPi�ces() {
		return nbPi�ces;
	}

	/**
	 * @param nbPi�ces the nbPi�ces to set
	 */
	public void setNbPi�ces(int nbPi�ces) {
		this.nbPi�ces = nbPi�ces;
	}
	
	
}
