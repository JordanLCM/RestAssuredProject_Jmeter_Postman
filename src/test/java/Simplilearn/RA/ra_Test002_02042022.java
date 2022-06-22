package Simplilearn.RA;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ra_Test002_02042022 {

	RequestSpecification req001;
	
	@Before
	public void Bef001() {
		RestAssured.baseURI = "https://postman-echo.com/basic-auth";
		req001 = RestAssured.given();
	}
	
	@Test
	public void authReq() {
		
		req001.auth().preemptive().basic("postman", "password");
		
		Response resp001 = req001.when().get("basic-auth");
		
		int sc = resp001.getStatusCode();
		System.out.println("Status code = " + sc);
		
		String stts_line = resp001.getStatusLine();
		System.out.println("Status line = " + stts_line);
		
//		Status code = 404
//		Status line = HTTP/1.1 404 Not Found
		
		resp001.then().statusCode(200);
	}
}
