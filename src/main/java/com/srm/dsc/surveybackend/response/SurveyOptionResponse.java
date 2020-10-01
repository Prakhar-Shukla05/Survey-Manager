/**
 * 
 */
package com.srm.dsc.surveybackend.response;

/**
 * @author Prakhar Shukla
 *
 */
public class SurveyOptionResponse {

	private String name;
	private int selectedCount;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSelectedCount() {
		return selectedCount;
	}
	public void setSelectedCount(int selectedCount) {
		this.selectedCount = selectedCount;
	}
	@Override
	public String toString() {
		return "SurveyOptionResponse [name=" + name + ", selectedCount=" + selectedCount
				+ "]";
	}
	
	
	
}
