/**
 * 
 */
package com.srm.dsc.surveybackend.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srm.dsc.surveybackend.persistence.entity.SurveyQuestionEntity;

/**
 * @author Prakhar Shukla
 *
 */
public interface SurveyQuestionDao extends JpaRepository<SurveyQuestionEntity, Integer> 
{
    List<SurveyQuestionEntity> findBySurveyEntitySurveyId(Integer surveyId);
    
    Long deleteBySurveyEntitySurveyId(Integer surveyId);
    
//    List<SurveyQuestionEntity> findBySurveyentity(SurveyEntity surveyEntity);


}
