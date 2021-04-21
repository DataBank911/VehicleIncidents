package com.demo.api.postcode.components;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.api.postcode.entity.PostCodeRecord;
import com.demo.api.postcode.repository.PostCodeRepository;

@Service
public class PostCodeServicesImplementation implements PostCodeServices{
	@Autowired
	private PostCodeRepository postcodeRepository;
	@Override
	public List<PostCodeRecord> searchByPostCode(String postCode) {
		
		return postcodeRepository.findByPostCodeOrderByPostCodeAsc(postCode);
	}

	@Override
	public List<PostCodeRecord> searchByIncidentPostCode(String postCode) {
		
		return postcodeRepository.findByCategoryOfIncident(postCode);
	}

	@Override
	public List<PostCodeRecord> searchAll() {
		return (List<PostCodeRecord>) postcodeRepository.findAll();
	}

}
