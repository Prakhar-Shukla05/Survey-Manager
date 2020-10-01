package com.srm.dsc.surveybackend.request;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyUploadRequest {
	
	private String name;
	private String description;
	private String createdBy;
	private List<SurveyQuestion> questionsList;
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
	public List<SurveyQuestion> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<SurveyQuestion> questionsList) {
		this.questionsList = questionsList;
	}
	@Override
	public String toString() {
		return "SurveyUploadRequest [name=" + name + ", description=" + description
				+ ", createdBy=" + createdBy + ", questionsList=" + questionsList + "]";
	}
	
	
	
	

}
