/**
 * 
 */
package com.srm.dsc.surveybackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.srm.dsc.surveybackend.persistence.dao.SurveyDao;
import com.srm.dsc.surveybackend.persistence.dao.SurveyOptionDao;
import com.srm.dsc.surveybackend.persistence.dao.SurveyQuestionDao;
import com.srm.dsc.surveybackend.persistence.entity.SurveyEntity;
import com.srm.dsc.surveybackend.persistence.entity.SurveyOptionEntity;
import com.srm.dsc.surveybackend.persistence.entity.SurveyQuestionEntity;
import com.srm.dsc.surveybackend.request.SurveyOption;
import com.srm.dsc.surveybackend.request.SurveyQuestion;
import com.srm.dsc.surveybackend.request.SurveyUploadRequest;

/**
 * @author Prakhar Shukla
 *
 */
@Service
public class SurveyUploadService {

	public int uploadSurvey(SurveyUploadRequest surveyUploadRequest) {

		SurveyEntity surveyEntity = saveSurveyEntity(surveyUploadRequest);
		saveSurveyQuestions(surveyEntity, surveyUploadRequest);

		return surveyEntity.getSurveyId();
	}

	private void saveSurveyQuestions(SurveyEntity surveyEntity,
			SurveyUploadRequest surveyUploadRequest) {

		if (!CollectionUtils.isEmpty(surveyUploadRequest.getQuestionsList())) {
			for (SurveyQuestion surveyQuestion : surveyUploadRequest.getQuestionsList()) {
				List<SurveyOptionEntity> surveyOptionList=new ArrayList<>();
				SurveyQuestionEntity surveyQuestionEntity = saveSurveyQuestions(
						surveyEntity, surveyQuestion);
				if (!CollectionUtils.isEmpty(surveyQuestion.getOptions())) {
					
					for (SurveyOption surveyOption : surveyQuestion.getOptions()) {
						SurveyOptionEntity surveyOptionEntity = new SurveyOptionEntity();
						surveyOptionEntity.setDescription(surveyOption.getName());
						surveyOptionEntity.setSelectedcount(0);
						surveyOptionEntity.setSurveyQuestionEntity(surveyQuestionEntity);
						surveyOptionList.add(surveyOptionEntity);
					}
				}
				saveSurveyOptionsList(surveyOptionList);
			}
		}
	}

	private void saveSurveyOptionsList(List<SurveyOptionEntity> surveyOptionList) {
		surveyOptionDao.saveAll(surveyOptionList);
	}

	private SurveyQuestionEntity saveSurveyQuestions(SurveyEntity surveyEntity,
			SurveyQuestion surveyQuestion) {
		// TODO Auto-generated method stub
		SurveyQuestionEntity surveyQuestionEntity = new SurveyQuestionEntity();
		surveyQuestionEntity.setQuestion(surveyQuestion.getQuestion());
		surveyQuestionEntity.setSurveyEntity(surveyEntity);
		surveyQuestionEntity = surveyQuestionDao.save(surveyQuestionEntity);
		return surveyQuestionEntity;
	}

	private SurveyEntity saveSurveyEntity(SurveyUploadRequest surveyUploadRequest) {
		// TODO Auto-generated method stub
		SurveyEntity surveyEntity = convertToSurveyEntity(surveyUploadRequest);
		surveyEntity = surveyDao.save(surveyEntity);
		return surveyEntity;
	}

	private SurveyEntity convertToSurveyEntity(SurveyUploadRequest surveyUploadRequest) {
		SurveyEntity surveyEntity = new SurveyEntity();
		surveyEntity.setCreatedBy(surveyUploadRequest.getCreatedBy());
		surveyEntity.setDescription(surveyUploadRequest.getDescription());
		surveyEntity.setName(surveyUploadRequest.getName());
		return surveyEntity;
	}

	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	@Autowired
	private SurveyOptionDao surveyOptionDao;

}
