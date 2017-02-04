package exercice1;

import jade.core.Runtime;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class Lanceur {

	static void methode() throws StaleProxyException {
		Runtime rt = Runtime.instance();
		rt.setCloseVM(true);
		
		Profile pMain = new ProfileImpl("localhost", 8888, null);
		AgentContainer mc = rt.createMainContainer(pMain);
		
		AgentController test1 =
				mc.createNewAgent("test1", Autobus.class.getName(), new Object[0]);
		AgentController test2 =
				mc.createNewAgent("test2", Autobus.class.getName(), new Object[0]);
		AgentController test3 =
				mc.createNewAgent("test3", Autobus.class.getName(), new Object[0]);
		test1.start();
		test2.start();
		test3.start();
	}
	
	public static void main(String[] args) {
		try {
			Lanceur.methode();
		} catch(StaleProxyException e) {
			e.printStackTrace();
		}
	}
	
}
