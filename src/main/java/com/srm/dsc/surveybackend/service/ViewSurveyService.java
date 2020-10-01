/**
 * 
 */
package com.srm.dsc.surveybackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.srm.dsc.surveybackend.response.SurveyOptionResponse;
import com.srm.dsc.surveybackend.response.SurveyOptionViewResponse;
import com.srm.dsc.surveybackend.response.SurveyQuestionResponse;
import com.srm.dsc.surveybackend.response.SurveyQuestionViewResponse;
import com.srm.dsc.surveybackend.response.SurveyResultResponse;
import com.srm.dsc.surveybackend.response.SurveyViewResponse;

/**
 * @author Prakhar Shukla
 *
 */
@Service
public class ViewSurveyService {

	public SurveyResultResponse viewResult(Integer surveyId) {
		Optional<SurveyEntity> surveyEntityResult = surveyDao.findById(surveyId);
		if (surveyEntityResult.isPresent()) {
			SurveyEntity surveyEntity = surveyEntityResult.get();
			SurveyResultResponse surveyResultResponse = convertToSurveyResultResponse(
					surveyEntity);
			List<SurveyQuestionResponse> surveyQuestionResponseList = new ArrayList<>();
			List<SurveyQuestionEntity> surveyQuestionEntityList = surveyQuestionDao
					.findBySurveyEntitySurveyId(surveyId);
			if (!CollectionUtils.isEmpty(surveyQuestionEntityList)) {
				for (SurveyQuestionEntity surveyQuestionEntity : surveyQuestionEntityList) {
					List<SurveyOptionEntity> surveyOptionEntities = surveyOptionDao
							.findBySurveyQuestionEntity(surveyQuestionEntity);
					SurveyQuestionResponse surveyQuestionResponse = convertToSurveyResultResponse(
							surveyResultResponse, surveyQuestionEntity,
							surveyOptionEntities);
					surveyQuestionResponseList.add(surveyQuestionResponse);
				}
			}
			surveyResultResponse.setQuestionsList(surveyQuestionResponseList);
			return surveyResultResponse;
		}
		return null;
	}


	
	public SurveyViewResponse viewSurvey(Integer surveyId) {
		Optional<SurveyEntity> surveyEntityResult = surveyDao.findById(surveyId);
		if (surveyEntityResult.isPresent()) {
			SurveyEntity surveyEntity = surveyEntityResult.get();
			SurveyViewResponse surveyViewResponse = convertToSurveyViewResponse(
					surveyEntity);
			List<SurveyQuestionViewResponse> surveyQuestionList = new ArrayList<>();
			List<SurveyQuestionEntity> surveyQuestionEntityList = surveyQuestionDao
					.findBySurveyEntitySurveyId(surveyId);
			if (!CollectionUtils.isEmpty(surveyQuestionEntityList)) {
				for (SurveyQuestionEntity surveyQuestionEntity : surveyQuestionEntityList) {
					List<SurveyOptionEntity> surveyOptionEntities = surveyOptionDao
							.findBySurveyQuestionEntity(surveyQuestionEntity);
					SurveyQuestionViewResponse surveyQuestion = convertToSurveyUploadRequest(
							surveyViewResponse, surveyQuestionEntity,
							surveyOptionEntities);
					surveyQuestionList.add(surveyQuestion);
				}
			}
			surveyViewResponse.setQuestionsList(surveyQuestionList);
			return surveyViewResponse;
		}
		return null;
	}

	private SurveyResultResponse convertToSurveyResultResponse(
			SurveyEntity surveyEntity) {
		SurveyResultResponse surveyResultResponse = new SurveyResultResponse();
		surveyResultResponse.setCreatedBy(surveyEntity.getCreatedBy());
		surveyResultResponse.setDescription(surveyEntity.getDescription());
		surveyResultResponse.setName(surveyEntity.getName());
		return surveyResultResponse;
	}
	
	private SurveyViewResponse convertToSurveyViewResponse(SurveyEntity surveyEntity) {
		SurveyViewResponse surveyViewResponse = new SurveyViewResponse();
		surveyViewResponse.setCreatedBy(surveyEntity.getCreatedBy());
		surveyViewResponse.setDescription(surveyEntity.getDescription());
		surveyViewResponse.setName(surveyEntity.getName());
		surveyViewResponse.setSurveyId(surveyEntity.getSurveyId());
		return surveyViewResponse;
	}
	
	private SurveyQuestionResponse convertToSurveyResultResponse(
			SurveyResultResponse surveyResultResponse,
			SurveyQuestionEntity surveyQuestionEntity,
			List<SurveyOptionEntity> surveyOptionEntities) {
		SurveyQuestionResponse surveyQuestionResponse = new SurveyQuestionResponse();
		surveyQuestionResponse.setQuestion(surveyQuestionEntity.getQuestion());
		List<SurveyOptionResponse> surveyOptionsResponseList = new ArrayList<>();
		if (!CollectionUtils.isEmpty(surveyOptionEntities)) {
			for (SurveyOptionEntity surveyOptionEntity : surveyOptionEntities) {
				SurveyOptionResponse surveyOptionResponse = new SurveyOptionResponse();
				surveyOptionResponse.setName(surveyOptionEntity.getDescription());
				surveyOptionResponse.setSelectedCount(surveyOptionEntity.getSelectedcount());
				surveyOptionsResponseList.add(surveyOptionResponse);
			}
		}
		surveyQuestionResponse.setOptions(surveyOptionsResponseList);
		return surveyQuestionResponse;
	}
	
	private SurveyQuestionViewResponse convertToSurveyUploadRequest(
			SurveyViewResponse surveyViewResponse,
			SurveyQuestionEntity surveyQuestionEntity,
			List<SurveyOptionEntity> surveyOptionEntities) {
		SurveyQuestionViewResponse surveyQuestionViewResponse = new SurveyQuestionViewResponse();
		surveyQuestionViewResponse.setQuestion(surveyQuestionEntity.getQuestion());
		surveyQuestionViewResponse.setQuestionId(surveyQuestionEntity.getQuestionId());
		List<SurveyOptionViewResponse> surveyOptions = new ArrayList<>();
		if (!CollectionUtils.isEmpty(surveyOptionEntities)) {
			for (SurveyOptionEntity surveyOptionEntity : surveyOptionEntities) {
				SurveyOptionViewResponse surveyOption = new SurveyOptionViewResponse();
				surveyOption.setName(surveyOptionEntity.getDescription());
				surveyOption.setOptionId(surveyOptionEntity.getOptionId());
				surveyOptions.add(surveyOption);
			}
		}
		surveyQuestionViewResponse.setOptions(surveyOptions);
		return surveyQuestionViewResponse;

	}



	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private SurveyQuestionDao surveyQuestionDao;
	@Autowired
	private SurveyOptionDao surveyOptionDao;

}
