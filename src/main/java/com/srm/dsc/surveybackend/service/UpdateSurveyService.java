/**
 * 
 */
package com.srm.dsc.surveybackend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.dsc.surveybackend.persistence.dao.SurveyDao;
import com.srm.dsc.surveybackend.persistence.dao.SurveyOptionDao;
import com.srm.dsc.surveybackend.persistence.entity.SurveyEntity;
import com.srm.dsc.surveybackend.persistence.entity.SurveyOptionEntity;
import com.srm.dsc.surveybackend.request.SurveyUpdateRequest;

/**
 * @author Prakhar Shukla
 *
 */
@Service
public class UpdateSurveyService {

	public void updateSurvey(Integer surveyId, SurveyUpdateRequest surveyUploadRequest) throws Exception {

		Optional<SurveyEntity> surveyEntityResult = surveyDao.findById(surveyId);
		if(surveyEntityResult.isPresent()) {
			List<SurveyOptionEntity> surveyOptionEntities=new ArrayList<SurveyOptionEntity>();
			for(Integer optionId:surveyUploadRequest.getOptionIds()) {
				Optional<SurveyOptionEntity> surveyOptionEntityResult=surveyOptionDao.findById(optionId);
				if(surveyEntityResult.isPresent()) {
					SurveyOptionEntity surveyOptionEntity=surveyOptionEntityResult.get();
					surveyOptionEntity.setSelectedcount(surveyOptionEntity.getSelectedcount()+1);
					surveyOptionEntities.add(surveyOptionEntity);
				}
			}
			surveyOptionDao.saveAll(surveyOptionEntities);
		}else {
			throw new Exception("Illegal survey Id");
		}

	}
	
	@Autowired
	private SurveyDao surveyDao;
	@Autowired
	private SurveyOptionDao surveyOptionDao;

}
