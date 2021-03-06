package exercice1;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate.MatchExpression;

public class FiltreReponse implements MatchExpression {

	@Override
	public boolean match(ACLMessage message) {
		if(message.getPerformative() == ACLMessage.INFORM &&
				(message.getContent().equals("Moi d'abord")
						|| message.getContent().equals("Bravo"))) {
			return true;
		}
		
		return false;
	}

}
