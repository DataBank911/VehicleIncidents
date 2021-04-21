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

import com.demo.api.postcode.components.CategoryServices;
import com.demo.api.postcode.entity.Category;
import com.demo.api.postcode.entity.SearchResult;
import com.demo.api.postcode.exception.ResourceNotFoundException;

@RestController
@Validated
public class CategoryController {
	
	@Autowired
	private CategoryServices service;
	
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
	@RequestMapping(value="/crime/category", method=RequestMethod.GET)
	public SearchResult searchAll(){

		SearchResult result = new SearchResult();
		result.setStatus(service.API_SUCCESS_STATUS);
		List<Category> searchResult = service.searchAll();
		try {
			Assert.notEmpty(searchResult);
		}catch(Exception e){
			throw new ResourceNotFoundException(e);
		}

		result.setCategoriesResult(searchResult);
		return  result;
		}
	
}
