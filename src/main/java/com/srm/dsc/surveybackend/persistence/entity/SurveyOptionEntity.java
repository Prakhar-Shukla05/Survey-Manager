package com.srm.dsc.surveybackend.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Prakhar Shukla
 *
 */

@Entity
@Table(name = "question_option")
public class SurveyOptionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "option_id", unique = true, nullable = false)
	private Integer optionId;
	
	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "selected_count", nullable = false)
	private int selectedcount;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false)
	private SurveyQuestionEntity surveyQuestionEntity;

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSelectedcount() {
		return selectedcount;
	}

	public void setSelectedcount(int selectedcount) {
		this.selectedcount = selectedcount;
	}

	public SurveyQuestionEntity getSurveyQuestionEntity() {
		return surveyQuestionEntity;
	}

	public void setSurveyQuestionEntity(SurveyQuestionEntity surveyQuestionEntity) {
		this.surveyQuestionEntity = surveyQuestionEntity;
	}

	public SurveyOptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
