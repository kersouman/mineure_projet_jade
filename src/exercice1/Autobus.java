package exercice1;

import java.util.Random;

import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

@SuppressWarnings("serial")
public class Autobus extends jade.core.Agent {
	
	private static int CPT_AUTOBUS = 0;
	
	private int identifiant = 0;
	private int numeroLigne = 0;
	private int longueurLigne = 0;
	private int score = 0;
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
	private int compteurAutresBus = -1;
	private int compteurReponse = -1;
	private DFAgentDescription[] autresBus = null;
	
	public Autobus() {
		this.identifiant = Autobus.CPT_AUTOBUS++;
		Random rand = new Random();
		this.numeroLigne = rand.nextInt(10);
		this.longueurLigne = 20;
	}
	
	public void setup() {		
		System.out.println("Je suis l'autobus " + this.identifiant);
		System.out.println("Je roule sur la ligne " + this.numeroLigne);
		
		this.setDescriptionService();
		this.setAutresBus();
		this.setComportements();
	}
	
	private void setDescriptionService() {
		ServiceDescription sd = new ServiceDescription();
		sd.setName("Bus" + this.identifiant);
		sd.setType("Bus");
		
		DFAgentDescription dfad = new DFAgentDescription();
		dfad.setName(this.getAID());
		dfad.addServices(sd);
		
		try {
			DFService.register(this, dfad);
		} catch (FIPAException e) {
			e.printStackTrace();
		}
	}
	
	private void setAutresBus() {
		ServiceDescription sd = new ServiceDescription();
		sd.setType("Bus");
		DFAgentDescription dfad = new DFAgentDescription();
		dfad.addServices(sd);

		try {
			this.autresBus = DFService.search(this,dfad);
		} catch(FIPAException e) {
			e.printStackTrace();
		}
		this.setCompteurAutresBus(this.autresBus.length-1);
		this.setCompteurReponse(autresBus.length-1);
	}
	
	private void setComportements() {
		this.addBehaviour(new AutobusComportement());
		this.addBehaviour(new AutobusComportementTicker(this,1000));
		this.addBehaviour(new AutobusComportementCompareArrive());
		this.addBehaviour(new AutobusComportementEnvoiArrive());
	}
	
	public void takeDown() {
		System.out.println("Je suis l'autobus " + this.identifiant
				+ ", mon score est de " + this.score 
				+ " et je vais à la casse");
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public int getNumeroLigne() {
		return numeroLigne;
	}

	public int getLongueurLigne() {
		return longueurLigne;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
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
	
	public int getCompteurAutresBus() {
		return compteurAutresBus;
	}
	
	public void setCompteurAutresBus(int compteurAutresBus) {
		this.compteurAutresBus = compteurAutresBus;
	}

	public int getCompteurReponse() {
		return compteurReponse;
	}
	
	public void setCompteurReponse(int compteurReponse) {
		this.compteurReponse = compteurReponse;
	}
	
	public DFAgentDescription[] getAutresBus() {
		return autresBus;
	}
	
}
