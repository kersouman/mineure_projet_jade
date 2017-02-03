package exercice1;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class AutobusComportementTicker extends TickerBehaviour {

	public AutobusComportementTicker(Agent a, long period) {
		super(a, period);
	}

	@Override
	protected void onTick() {
		int arretCourant = ((Autobus)myAgent).getArretCourant();
		int longueurLigne = ((Autobus)myAgent).getLongueurLigne();
		
		if ((arretCourant + 1) < longueurLigne)
			System.out.println(((Autobus)myAgent).getIdentifiant()
					+ " : Le prochain arrêt est le "
					+ (((Autobus)myAgent).getArretCourant()+1));
		else
			System.out.println(((Autobus)myAgent).getIdentifiant()
				+ " : Je vais au dépôt");
	}

}
