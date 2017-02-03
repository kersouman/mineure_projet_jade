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
			if (((Autobus)myAgent).getEtat() >= 2)
				myAgent.send(((Autobus)myAgent).getMessageMoi());
			else
				myAgent.send(((Autobus)myAgent).getMessageBravo());
			((Autobus)myAgent).setReponseEnvoyee(true);
		}
	}

}
