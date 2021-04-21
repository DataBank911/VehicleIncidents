package com.demo.api.postcode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.api.postcode.entity.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long>{
	public List<Category> findAll();
}
