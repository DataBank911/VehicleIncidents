package com.demo.api.postcode.components;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.demo.api.postcode.entity.APIStatus;
import com.demo.api.postcode.entity.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryServices {
	public static final APIStatus API_SUCCESS_STATUS = new APIStatus("API-200","Success");

	public List<Category> categories  = new ArrayList<>(
			Arrays.asList(
					new Category( 1, "anti-social-behaviour", "context", "outcome_status",  "2017-01" ),
					new Category(2, "burglary", "context", "outcome_status",  "2018-08" ),
					new Category( 3, "all-crimes", "context", "outcome_status",  "2018-08" )
			)
	);

	public default List<Category> searchAll() {
		return categories;
	};
}
