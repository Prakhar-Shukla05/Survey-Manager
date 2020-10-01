/**
 * 
 */
package com.srm.dsc.surveybackend.response;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyOptionViewResponse {
	
	private int optionId;
	private String name;
	
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SurveyOptionViewResponse [optionId=" + optionId + ", name=" + name + "]";
	}

	
	

}
