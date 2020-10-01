/**
 * 
 */
package com.srm.dsc.surveybackend.response;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyQuestionViewResponse {

	private int questionId;
	private String question;
	private List<SurveyOptionViewResponse>options;
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<SurveyOptionViewResponse> getOptions() {
		return options;
	}
	public void setOptions(List<SurveyOptionViewResponse> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "SurveyQuestionViewResponse [questionId=" + questionId + ", question="
				+ question + ", options=" + options + "]";
	}
	
	
	
	
	
}
