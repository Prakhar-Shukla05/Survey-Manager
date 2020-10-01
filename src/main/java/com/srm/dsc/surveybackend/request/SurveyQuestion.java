/**
 * 
 */
package com.srm.dsc.surveybackend.request;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyQuestion {

	private String question;
	private List<SurveyOption>options;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<SurveyOption> getOptions() {
		return options;
	}
	public void setOptions(List<SurveyOption> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "SurveyQuestion [question=" + question + ", options=" + options + "]";
	}
	
	
	
	
}
