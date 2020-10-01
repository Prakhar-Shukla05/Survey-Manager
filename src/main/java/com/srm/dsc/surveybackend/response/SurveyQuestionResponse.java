/**
 * 
 */
package com.srm.dsc.surveybackend.response;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyQuestionResponse {

	private String question;
	private List<SurveyOptionResponse> options;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<SurveyOptionResponse> getOptions() {
		return options;
	}

	public void setOptions(List<SurveyOptionResponse> options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "SurveyQuestionResponse [question=" + question + ", options=" + options
				+ "]";
	}

}
