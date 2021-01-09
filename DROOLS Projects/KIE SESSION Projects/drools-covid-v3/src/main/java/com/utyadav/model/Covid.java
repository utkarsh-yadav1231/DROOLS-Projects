package com.utyadav.model;

public class Covid 
{
	public String symptom ;
	public int severity = 0 ;
	public String results ;
	
	
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
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity += severity;
	}
}