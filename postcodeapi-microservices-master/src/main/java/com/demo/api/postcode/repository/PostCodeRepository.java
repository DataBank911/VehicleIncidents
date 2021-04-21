package com.demo.api.postcode.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.api.postcode.entity.PostCodeRecord;

@Repository
public interface PostCodeRepository extends CrudRepository<PostCodeRecord,Long> {
	public List<PostCodeRecord> findByPostCodeOrderByPostCodeAsc(String postCode);
	public List<PostCodeRecord> findByCategoryOfIncident(String postCode);
}
