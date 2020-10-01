/**
 * 
 */
package com.srm.dsc.surveybackend.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srm.dsc.surveybackend.persistence.entity.SurveyEntity;

/**
 * @author Prakhar Shukla
 *
 */
public interface SurveyDao extends JpaRepository<SurveyEntity, Integer> {

	Long deleteBySurveyId(Integer surveyId);
}
