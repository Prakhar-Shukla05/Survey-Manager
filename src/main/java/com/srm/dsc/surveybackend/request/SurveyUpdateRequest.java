/**
 * 
 */
package com.srm.dsc.surveybackend.request;

import java.util.List;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyUpdateRequest {

	private List<Integer>optionIds;

	public List<Integer> getOptionIds() {
		return optionIds;
	}

	public void setOptionIds(List<Integer> optionIds) {
		this.optionIds = optionIds;
	}
	
	
}
