package com.utyadav.model;

public class Covid 
{
	private String symptom ;
	int severity;
	int count = 0 ;
	private String results ;
	
	
	public String getResults() {
		return results;
	}
	public void setResults(String results) {
		this.results = results;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public int getSeverity() {
		return count;
	}
	public void setSeverity(int severity) {
		//this.severity += severity;
		count = count + severity; 
   	}
}