/**
 * 
 */
package com.srm.dsc.surveybackend.response;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyResultResponse {
	
	private String name;
	private String description;
	private String createdBy;
	private List<SurveyQuestionResponse> questionsList;
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
	public List<SurveyQuestionResponse> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<SurveyQuestionResponse> questionsList) {
		this.questionsList = questionsList;
	}
	@Override
	public String toString() {
		return "SurveyResultResponse [name=" + name + ", description=" + description
				+ ", createdBy=" + createdBy + ", questionsList=" + questionsList + "]";
	}
	
	

}
