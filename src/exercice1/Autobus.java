package exercice1;

import java.util.Random;

import jade.core.AID;
import jade.lang.acl.ACLMessage;

public class Autobus extends jade.core.Agent {
	
	private static int CPT_AUTOBUS = 0;
	
	private int identifiant = 0;
	private int numeroLigne = 0;
	private int longueurLigne = 0;
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
	
	private AID idAutreBus = null;
	private ACLMessage message = new ACLMessage(ACLMessage.INFORM);
	
	public Autobus() {
		this.identifiant = Autobus.CPT_AUTOBUS++;
		Random rand = new Random();
		this.numeroLigne = rand.nextInt(10);
		this.longueurLigne = 20;
	}
	
	public void setup() {
		String nomAutreBus = this.getLocalName();
		int longueur = nomAutreBus.length();
		int numeroAutreBus = Integer.parseInt(nomAutreBus.substring(longueur-1));
		nomAutreBus = nomAutreBus.substring(0, longueur-1);
		numeroAutreBus = (numeroAutreBus%2) + 1;
		nomAutreBus += numeroAutreBus;
		this.idAutreBus = new AID(nomAutreBus, false);
		
		this.message.setContent("Je suis arrivé");
		this.message.addReceiver(this.idAutreBus);
		
		System.out.println("Je suis l'autobus " + this.identifiant);
		System.out.println("Je roule sur la ligne " + this.numeroLigne);
		
		this.addBehaviour(new AutobusComportement());
		this.addBehaviour(new AutobusComportementTicker(this,1000));
		this.addBehaviour(new AutobusComportementCyclique());
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
	
	public AID getIdAutreBus() {
		return idAutreBus;
	}
	
	public ACLMessage getMessage() {
		return message;
	}
	
	public int getLongueurLigne() {
		return longueurLigne;
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
