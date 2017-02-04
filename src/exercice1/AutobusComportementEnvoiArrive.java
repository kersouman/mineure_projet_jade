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
			for (int i = 0; i < ((Autobus)myAgent).getAutresBus().length; i++) {
				if(!((Autobus)myAgent).getAutresBus()[i].getName().equals(
						((Autobus)myAgent).getAID())) {
					ACLMessage message = new ACLMessage(ACLMessage.INFORM);
					message.setContent("Je suis arrivé");
					message.addReceiver(
							((Autobus)myAgent).getAutresBus()[i].getName());
					myAgent.send(message);
				}
			}
			((Autobus)myAgent).setEtat(3);
			break;
		case 3:
			ACLMessage message = myAgent.receive(
					new MessageTemplate(
							new FiltreReponse()));
			if (message == null)
				block();
			else if(message.getContent().equals("Bravo")) {
				((Autobus)myAgent).setScore(((Autobus)myAgent).getScore()+1);
				((Autobus)myAgent).setCompteurAutresBus(
						((Autobus)myAgent).getCompteurAutresBus()-1);
					if(((Autobus)myAgent).getCompteurAutresBus() == 0) {
						((Autobus)myAgent).setEtat(4);
					}
			} else if(message.getContent().equals("Moi d'abord")) {
				((Autobus)myAgent).setCompteurAutresBus(
						((Autobus)myAgent).getCompteurAutresBus()-1);
				if(((Autobus)myAgent).getCompteurAutresBus() == 0) {
					((Autobus)myAgent).setEtat(4);
				}
			}
			break;
		default:
			break;
		}
	}

	@Override
	public boolean done() {
		if(((Autobus)myAgent).getEtat() == 4) {
			return true;
		}
		
		return false;
	}

	
	
}
