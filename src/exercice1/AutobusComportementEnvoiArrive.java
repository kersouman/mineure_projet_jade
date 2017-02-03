package exercice1;

import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

@SuppressWarnings("serial")
public class AutobusComportementEnvoiArrive extends Behaviour {

	@Override
	public void action() {

		switch(((Autobus)myAgent).getEtat()) {
		case 2:
			myAgent.send(((Autobus)myAgent).getMessageArrive());
			((Autobus)myAgent).setEtat(3);
			break;
		case 3:
			ACLMessage message = myAgent.receive(
					new MessageTemplate(
							new FiltreReponse()));
			if (message == null)
				block();
			else if(message.getContent().equals(
					((Autobus)myAgent).getMessageBravo().getContent())) {
				((Autobus)myAgent).setScore(1);
				((Autobus)myAgent).setEtat(4);
			} else if(message.getContent().equals(
					((Autobus)myAgent).getMessageMoi().getContent())) {
				((Autobus)myAgent).setEtat(4);
			}
			break;
		}
	}

	@Override
	public boolean done() {
		if(((Autobus)myAgent).getEtat() == 4)
			return true;
			
		return false;
	}

	
	
}
