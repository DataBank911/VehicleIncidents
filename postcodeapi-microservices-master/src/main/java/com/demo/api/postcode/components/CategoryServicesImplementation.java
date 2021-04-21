package com.demo.api.postcode.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.postcode.entity.Category;
import com.demo.api.postcode.repository.CategoryRepository;

@Service
public class CategoryServicesImplementation implements CategoryServices{
	@Autowired
	private CategoryRepository repo;

	@Override
	public List<Category> searchAll() {
		return (List<Category>) repo.findAll();
	}

}
