package com.srm.dsc.surveybackend.persistence.entity;

import javax.persistence.CascadeType;
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
@Table(name = "question")
public class SurveyQuestionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "question_id", unique = true, nullable = false)
	private Integer questionId;
	
	@Column(name = "description", nullable = false)
	private String question;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "survey_id", nullable = false)
//	private SurveyEntity surveyentity;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "survey_id", nullable = false)
    private SurveyEntity surveyEntity;
	
//	@OneToMany(mappedBy = "surveyQuestionEntity", cascade = CascadeType.ALL)
//	private Set<SurveyOptionEntity>options;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public SurveyEntity getSurveyEntity() {
		return surveyEntity;
	}

	public void setSurveyEntity(SurveyEntity surveyEntity) {
		this.surveyEntity = surveyEntity;
	}

	public SurveyQuestionEntity() {
		super();
	}
}
