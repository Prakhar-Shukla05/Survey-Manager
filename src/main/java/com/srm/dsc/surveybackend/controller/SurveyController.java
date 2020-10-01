package com.srm.dsc.surveybackend.controller;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srm.dsc.surveybackend.request.SurveyUpdateRequest;
import com.srm.dsc.surveybackend.request.SurveyUploadRequest;
import com.srm.dsc.surveybackend.response.SurveyResultResponse;
import com.srm.dsc.surveybackend.response.SurveyViewResponse;
import com.srm.dsc.surveybackend.service.DeleteSurveyService;
import com.srm.dsc.surveybackend.service.SurveyUploadService;
import com.srm.dsc.surveybackend.service.UpdateSurveyService;
import com.srm.dsc.surveybackend.service.ViewSurveyService;

/**
 * @author Prakhar Shukla
 *
 */

@RestController
public class SurveyController {
	
	Logger log = LoggerFactory.getLogger(SurveyController.class);

	@PostMapping(path = "/upload-survey")
	public ResponseEntity<Integer> uploadSurvey(
			@RequestBody final SurveyUploadRequest surveyUploadRequest) {

		log.info("request of upload is {}", surveyUploadRequest);
		int surveyId = surveyUploadService.uploadSurvey(surveyUploadRequest);
		return new ResponseEntity<>(surveyId, HttpStatus.CREATED);

	}

	@GetMapping(path = "/{surveyId}")
	public ResponseEntity<SurveyViewResponse> viewSurvey(
			@PathVariable(name = "surveyId", required = true) Integer surveyId) {

		log.info("request of view for surveyId is {}", surveyId);
		SurveyViewResponse surveyViewResponse = viewSurveyService.viewSurvey(surveyId);
		if (Objects.nonNull(surveyViewResponse))
			return new ResponseEntity<>(surveyViewResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@PutMapping(path = "/update-survey/{surveyId}")
	public ResponseEntity updateSurvey(
			@PathVariable(name = "surveyId", required = true) Integer surveyId,
			@RequestBody SurveyUpdateRequest surveyUploadRequest) throws Exception {

		log.info("request of update for surveyId is {}", surveyId);
		updateSurveyService.updateSurvey(surveyId, surveyUploadRequest);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping(path = "/view-results/{surveyId}")
	public ResponseEntity<SurveyResultResponse> viewResults(
			@PathVariable(name = "surveyId", required = true) Integer surveyId)
			throws Exception {

		log.info("request of view-results for surveyId is {}", surveyId);
		SurveyResultResponse surveyResultResponse = viewSurveyService
				.viewResult(surveyId);
		if (Objects.nonNull(surveyResultResponse))
			return new ResponseEntity<>(surveyResultResponse, HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@DeleteMapping(path = "/{surveyId}/delete")
	public ResponseEntity<SurveyResultResponse> deleteSurvey(
			@PathVariable(name = "surveyId", required = true) Integer surveyId)
			throws Exception {

		log.info("request of deletion of surveyId is {}", surveyId);
		deleteSurveyService.deleteSurvey(surveyId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@Autowired
	private SurveyUploadService surveyUploadService;

	@Autowired
	private ViewSurveyService viewSurveyService;

	@Autowired
	private UpdateSurveyService updateSurveyService;

	@Autowired
	private DeleteSurveyService deleteSurveyService;

}
