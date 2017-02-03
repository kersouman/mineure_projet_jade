package exercice1;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class AutobusComportementCyclique extends CyclicBehaviour {

	@Override
	public void action() {
		ACLMessage message = myAgent.receive(
				new MessageTemplate(
						new FiltreArrive()));
		if (message == null)
			block();
		else {
			System.out.println(((Autobus)myAgent).getIdentifiant()
					+ " : " + message.getSender().getName()
					+ " est arrivé au dépôt");
		}
	}

}
