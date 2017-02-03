package exercice1;

import java.util.Random;

public class Autobus extends jade.core.Agent {
	
	private static int CPT_AUTOBUS = 0;
	
	private int identifiant = 0;
	private int numeroLigne = 0;
	/*
	 * arretCourant = 0 -> on est au dépôt
	 * arretCourant > 0 -> on roule
	 */
	private int arretCourant = 0;
	/*
	 * etat = 0 -> au dépôt
	 * etat = 1 -> en route
	 * etat = 2 -> au dépôt après en route
	 */
	private int etat = 0;
	
	public Autobus() {
		this.identifiant = Autobus.CPT_AUTOBUS++;
		Random rand = new Random();
		this.numeroLigne = rand.nextInt(10);
	}
	
	public void setup() {
		System.out.println("Je suis l'autobus " + this.identifiant);
		System.out.println("Je roule sur la ligne " + this.numeroLigne);
		this.addBehaviour(new AutobusComportement());
	}
	
	public void takeDown() {
		System.out.println("Je suis l'autobus " + this.identifiant +
								" et je vais à la casse");
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public int getNumeroLigne() {
		return numeroLigne;
	}

	public int getArretCourant() {
		return arretCourant;
	}
	
	public void setArretCourant(int arretCourant) {
		this.arretCourant = arretCourant;
	}
	
	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}
}
