package com.demo.api.postcode.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	private String category;
	private String context;
	private String outcome_status;
	private String month;

	public Category() {
		super();
	}

	public Category(long id, String category, String context, String outcome_status, String month) {
		super();
		this.id = id;
		this.category = category;
		this.context = context;
		this.outcome_status = outcome_status;
		this.month = month;
	}
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategories() {
		return category;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}


	public String getOutcome_status() {
		return outcome_status;
	}

	public void setOutcome_status(String outcome_status) {
		this.outcome_status = outcome_status;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
