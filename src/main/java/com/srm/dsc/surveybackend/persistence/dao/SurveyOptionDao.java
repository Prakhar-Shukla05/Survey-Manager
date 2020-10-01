/**
 * 
 */
package com.srm.dsc.surveybackend.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srm.dsc.surveybackend.persistence.entity.SurveyOptionEntity;
import com.srm.dsc.surveybackend.persistence.entity.SurveyQuestionEntity;

/**
 * @author Prakhar Shukla
 *
 */
public interface SurveyOptionDao extends JpaRepository<SurveyOptionEntity, Integer>{
	
    List<SurveyOptionEntity> findBySurveyQuestionEntityQuestionId(Integer questionId);
    
    List<SurveyOptionEntity> findBySurveyQuestionEntity(SurveyQuestionEntity surveyQuestionEntity);
    
    Long deleteBySurveyQuestionEntitySurveyEntitySurveyId(Integer surveyId);



}
