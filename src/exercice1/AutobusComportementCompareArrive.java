package exercice1;

import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

@SuppressWarnings("serial")
public class AutobusComportementCompareArrive extends CyclicBehaviour {

	@Override
	public void action() {
		ACLMessage message = myAgent.receive(
				new MessageTemplate(
						new FiltreArrive()));
		if (message == null)
			block();
		else {
			if (((Autobus)myAgent).getEtat() >= 2) {
				ACLMessage reponseMoi = new ACLMessage(ACLMessage.INFORM);
				reponseMoi.setContent("Moi d'abord");
				reponseMoi.addReceiver(message.getSender());
				myAgent.send(reponseMoi);
				((Autobus)myAgent).setCompteurReponse(
						((Autobus)myAgent).getCompteurReponse()-1);
			} else {
				ACLMessage reponseBravo = new ACLMessage(ACLMessage.INFORM);
				reponseBravo.setContent("Bravo");
				reponseBravo.addReceiver(message.getSender());
				myAgent.send(reponseBravo);
				((Autobus)myAgent).setCompteurReponse(
						((Autobus)myAgent).getCompteurReponse()-1);
			}
		}
	}

}
