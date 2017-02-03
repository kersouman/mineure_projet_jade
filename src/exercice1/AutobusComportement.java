package exercice1;

public class AutobusComportement extends jade.core.behaviours.Behaviour {

	@Override
	public void action() {
		// Si on est au dépôt, on se met dans l'état EN_ROUTE
		switch(((Autobus)myAgent).getEtat()) {
		
		case 0:
			System.out.println(((Autobus)myAgent).getIdentifiant() 
					+ " : Départ dépôt");
			((Autobus)myAgent).setEtat(1);
			break;
		
		case 1:
			int arretCourant = ((Autobus)myAgent).getArretCourant();
			if (arretCourant <= 100) {
				arretCourant++;
				((Autobus)myAgent).setArretCourant(arretCourant);
				System.out.println(((Autobus)myAgent).getIdentifiant() 
						+ " : Je suis à l'arrêt "
						+ arretCourant);
			} else {
				((Autobus)myAgent).setArretCourant(0);
				((Autobus)myAgent).setEtat(2);
			}
			break;
			
		default:
			break;
		}
		
	}

	@Override
	public boolean done() {
		return ((Autobus)myAgent).getEtat() == 2;
	}

}
