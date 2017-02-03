package exercice1;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate.MatchExpression;

public class FiltreArrive implements MatchExpression {

	@Override
	public boolean match(ACLMessage message) {
		if(message.getPerformative() == ACLMessage.INFORM &&
				message.getContent().equals("Je suis arriv�"))
			return true;
		
		return false;
	}

}
