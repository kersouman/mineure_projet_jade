package exercice1;

import java.util.Random;

public class AutobusComportement extends jade.core.behaviours.Behaviour {

	@Override
	public void action() {
		Random rand = new Random();
	
		switch(((Autobus)myAgent).getEtat()) {
		
		case 0:
			System.out.println(((Autobus)myAgent).getIdentifiant() 
					+ " : D�part d�p�t");
			((Autobus)myAgent).setEtat(1);
			break;
		
		case 1:
			int arretCourant = ((Autobus)myAgent).getArretCourant();
			if (arretCourant < ((Autobus)myAgent).getLongueurLigne()) {
				arretCourant++;
				((Autobus)myAgent).setArretCourant(arretCourant);
				System.out.println(((Autobus)myAgent).getIdentifiant() 
						+ " : Je suis � l'arr�t "
						+ arretCourant);
				block(rand.nextInt(1000));
			} else {
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
