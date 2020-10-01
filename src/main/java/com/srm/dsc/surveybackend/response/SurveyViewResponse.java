package com.srm.dsc.surveybackend.response;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyViewResponse {
	
	private int surveyId;
	private String name;
	private String description;
	private String createdBy;
	private List<SurveyQuestionViewResponse> questionsList;
	public int getSurveyId() {
		return surveyId;
	}
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<SurveyQuestionViewResponse> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<SurveyQuestionViewResponse> questionsList) {
		this.questionsList = questionsList;
	}
	@Override
	public String toString() {
		return "SurveyViewResponse [surveyId=" + surveyId + ", name=" + name
				+ ", description=" + description + ", createdBy=" + createdBy
				+ ", questionsList=" + questionsList + "]";
	}
	
	
	
	

}
