
package com.utyadav.main;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.RuleBaseFactory;
import org.drools.core.WorkingMemory;
import com.utyadav.model.Covid;

public class DroolsTest 
{	
	public static void main(String[] args) throws DroolsParserException, IOException {
		System.out.println("\n\n ==== COVID-19 Symptoms Detection Test === \n\n");
		System.out.println("\n\n Identify the symptoms you have right now from below list.");
		
		System.out.println("\n I have \n");
		System.out.println(" 1. difficulty breathing or shortness of breath \n");
		System.out.println(" 2. constant Chest Pain or Pressure \n");
		System.out.println(" 3. sustained loss of smell, taste or appetite \n");
		System.out.println(" 4. loss of speech or movement \n");
		System.out.println(" 5. fever & tiredness \n");
		System.out.println(" 6. dry cough \n\n");
		
		DroolsTest droolsTest = new DroolsTest();
		droolsTest.executeDrools();
	}
	
	public void executeDrools() throws DroolsParserException, IOException {
		
		PackageBuilder packageBuilder = new PackageBuilder();
		String ruleFile = "/com/rules/Rules.drl";
		InputStream resourceAsStream = getClass().getResourceAsStream(ruleFile);
		Reader reader = new InputStreamReader(resourceAsStream);
		packageBuilder.addPackageFromDrl(reader);
		org.drools.core.rule.Package rulesPackage = packageBuilder.getPackage();
		RuleBase ruleBase = RuleBaseFactory.newRuleBase();
		ruleBase.addPackage(rulesPackage);

		WorkingMemory workingMemory = ruleBase.newStatefulSession();
		
		Covid covid1 = new Covid();
		Covid covid2 = new Covid();
		covid1.setSymptom("1");
		covid2.setSymptom("2");
		
		//covid.setSymptom("sustained loss of smell, taste or appetite");
		
		
		workingMemory.insert(covid1);
		workingMemory.fireAllRules();

		
		System.out.println("\n\nThe severity for Covid-19 is " + covid1.getResults() + "\n  Severity" + covid1.getSeverity());
		
		workingMemory.insert(covid2);
		workingMemory.fireAllRules();
		System.out.println("\n\nThe severity for Covid-19 is " + covid2.getResults() + "\n  Severity" + covid2.getSeverity());
	}	
}
