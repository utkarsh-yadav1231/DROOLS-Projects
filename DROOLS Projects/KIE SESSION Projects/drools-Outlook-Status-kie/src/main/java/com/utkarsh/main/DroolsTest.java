package com.utkarsh.main;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import com.utkarsh.model.Outlook;

public class DroolsTest {

	public static final void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");
			
			Outlook product = new Outlook();
			product.setColor("blue");

			kSession.insert(product);
			kSession.fireAllRules();
			kSession.dispose();
			
			System.out.println("\n\n The Online Presence Status on Outlook for Visible Color '" + product.getColor()
				+ "' is ('" + product.getStatus() + "') " );		
		
			} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}