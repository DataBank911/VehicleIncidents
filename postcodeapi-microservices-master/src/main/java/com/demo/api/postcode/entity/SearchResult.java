package com.demo.api.postcode.entity;

import java.util.List;


public class SearchResult {
	
	private APIStatus status;
	
	private List<PostCodeRecord> postCodeResult;
	private List<Category> categories;
	
	public APIStatus getStatus() {
		return status;
	}
	public void setStatus(APIStatus status) {
		this.status = status;
	}
	public List<PostCodeRecord> getResult() {
		return postCodeResult;
	}
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategoriesResult(List<Category> result) {
		this.categories = result;
	}
	public void setResult(List<PostCodeRecord> result) {
		this.postCodeResult = result;
	}

	public void searchAll(List<Category> result) {
		this.categories = result;
	}

}
	
