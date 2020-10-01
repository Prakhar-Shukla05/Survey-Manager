/**
 * 
 */
package com.srm.dsc.surveybackend.persistence.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Prakhar Shukla
 *
 */
@Entity
@Table(name = "survey")
public class SurveyEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "survey_id", unique = true, nullable = false)
	private Integer surveyId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "created_by", nullable = false)
	private String createdBy;
	

	public SurveyEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
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
	
//	@OneToMany(mappedBy = "surveyentity", cascade = CascadeType.ALL)
//	private Set<SurveyQuestionEntity> surveyQuestion;

	
	
}
