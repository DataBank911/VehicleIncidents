package com.demo.api.postcode;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

/**
 * Test Class to simply check the URI both secure and public path
 * Search API test by default the Application adding default with postcode TF34NT to the database
 * when starting the application
 * 
 * @author softwareBuilt4U.com
 *
 */
public class PostcodeapiMicroservicesApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void welcomePageTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Welcome to Post Code Micro Service API");
	}
	
	@Test
	public void securityPathTest() {
		String body = this.restTemplate.getForObject("/crime/secure/area", String.class);
		assertThat(body).contains("unauthorized");
	}
	
	@Test
	public void resourceNotFoundPathTest() {
		String body = this.restTemplate.getForObject("/crime/postcode/test", String.class);
		assertThat(body).contains("Not Found");
	}
	@Test
	public void searchByPostCodeAPITest() {
		String body = this.restTemplate.getForObject("/crime/postcode/TF34NT", String.class);
		//Check suburb for postcode TF34NT
		assertThat(body).contains("Shropshire");
	}

}
