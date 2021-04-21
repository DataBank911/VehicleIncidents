package com.demo.api.postcode.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.api.postcode.components.PostCodeServices;
import com.demo.api.postcode.entity.PostCodeRecord;
import com.demo.api.postcode.entity.SearchResult;
import com.demo.api.postcode.exception.ResourceNotFoundException;

@RestController
@Validated
public class PostcodeController {
	
	@Autowired
	private PostCodeServices service;
	
	@RequestMapping("/")
	public String home() {
		return "Welcome to Vehicle Incident by Post Code Micro Service API";
	}
	/**
	 * Restful API to search by postcode
	 * 
	 * @param postcode must be 6 alpha numeric values
	 * @return The JSON Response containing postcode,longitude and latitude
	 */
	@CrossOrigin
	@RequestMapping(value="/crime/postcode/{postcode}", method=RequestMethod.GET)
	public SearchResult search(
			@Valid
			@Pattern(regexp="(^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$)", message = "Invalid UK PostCode Format")
			@PathVariable ("postcode")  
			String postcode){
		
		SearchResult result = new SearchResult();
		result.setStatus(PostCodeServices.API_SUCCESS_STATUS);
		List<PostCodeRecord> searchResult = service.searchByPostCode(postcode);
		try {
			Assert.notEmpty(searchResult);
		}catch(Exception e){
			throw new ResourceNotFoundException(e);
		}
		
		result.setResult( searchResult);
		return  result;
	}
	/**
	 * Restful API to search by suburb
	 * 
	 * @param postcode Return a list of Categorys by PostCode
	 * @return The JSON Response containing Categorys and PostCodes within Categorys
	 */
	@CrossOrigin
	@RequestMapping(value="/crime/postcode/{postcode}", method=RequestMethod.GET)
	public SearchResult searchByIncidentPostCode(
	@PathVariable ("postcode")  String postcode) {
		SearchResult result = new SearchResult();
		result.setStatus(PostCodeServices.API_SUCCESS_STATUS);
		List<PostCodeRecord> searchResult = service.searchByIncidentPostCode(postcode);
		try {
			Assert.notEmpty(searchResult);
		} catch (Exception e) {
			throw new ResourceNotFoundException(e);
		}
		result.setResult(searchResult);
		return result;
	}
	
}
