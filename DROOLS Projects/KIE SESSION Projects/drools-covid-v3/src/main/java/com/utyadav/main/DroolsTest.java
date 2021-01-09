package com.utyadav.main;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
//import org.kie.api.runtime.rule.FactHandle;

import java.util.ArrayList;
import java.util.List;

import com.utyadav.model.Covid;

public class DroolsTest {

	public static final void main(String[] args) {
		try {
			
			System.out.println("\n\n ==== COVID-19 Symptoms Detection Test === \n");
			System.out.println("\n Identify the symptoms you have right now from below list.");
			
			System.out.println("\n I have \n");
			System.out.println(" 1. difficulty breathing or shortness of breath \n");
			System.out.println(" 2. constant Chest Pain or Pressure \n");
			System.out.println(" 3. sustained loss of smell, taste or appetite \n");
			System.out.println(" 4. loss of speech or movement \n");
			System.out.println(" 5. fever & tiredness \n");
			System.out.println(" 6. dry cough \n\n");
			
			
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rule");
	
			
/** 			
Fact fact1 = new Fact(); 
fact1.setName("name1"); 

Fact fact2 = new Fact(); 
fact2.setName("name2"); 
.... 

List<Fact> facts = new ArrayList<Fact>(); 
facts.add(fact1); 
facts.add(fact2); 

ksession.execute(facts); 
**/
			//
			Covid covid1 = new Covid();
			covid1.setSymptom("difficulty breathing or shortness of breath");


			Covid covid2 = new Covid();
			covid2.setSymptom("fever & tiredness");
			List<Covid> covid19 = new ArrayList<Covid>();

			covid19.add(covid1);covid19.add(covid2);
			kSession.insert(covid19);
			
			System.out.println("==== DROOLS SESSION START ==== ");

			kSession.fireAllRules();
			
			kSession.dispose();
			System.out.println("==== DROOLS SESSION END ==== ");
			
			System.out.println("\n\nThe severity for Covid-19 is " +covid1.getSeverity() + " and your Covid-19 Positive probability is " + covid1.getResults());

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
