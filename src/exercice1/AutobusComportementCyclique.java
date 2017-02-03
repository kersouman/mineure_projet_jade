package exercice1;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class AutobusComportementCyclique extends CyclicBehaviour {

	@Override
	public void action() {
		ACLMessage message = myAgent.receive();
		if (message == null)
			block();
		else {
			System.out.println(((Autobus)myAgent).getIdentifiant()
					+ " : " + message.getSender().getName()
					+ " est arrivé au dépôt");
		}
	}

}
