/**
 * 
 */
package com.srm.dsc.surveybackend.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.dsc.surveybackend.persistence.dao.SurveyDao;
import com.srm.dsc.surveybackend.persistence.dao.SurveyOptionDao;
import com.srm.dsc.surveybackend.persistence.dao.SurveyQuestionDao;

/**
 * @author Prakhar Shukla
 *
 */

@Service
public class DeleteSurveyService {

	@Transactional
	public void deleteSurvey(int surveyId) {

		long count = surveyOptionDao
				.deleteBySurveyQuestionEntitySurveyEntitySurveyId(surveyId);

		count = surveyQuestionDao.deleteBySurveyEntitySurveyId(surveyId);

		count= surveyDao.deleteBySurveyId(surveyId);
	}

	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	@Autowired
	private SurveyOptionDao surveyOptionDao;

}
