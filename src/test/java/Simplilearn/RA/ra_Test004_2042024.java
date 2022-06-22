package Simplilearn.RA;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ra_Test004_2042024 {

	RequestSpecification req001;

	@Test
	public void authReq() {
		
		req001 = RestAssured.given();
		
		//send request
		Response resp001 = req001.relaxedHTTPSValidation().when().get("https://expired.badssl.com/");
		
		int sc = resp001.getStatusCode();
		System.out.println("Status code = " + sc);
		
		String stts_line = resp001.getStatusLine();
		System.out.println("Status line = " + stts_line);
		
		resp001.then().log().all();
		
//		Status code = 404
//		Status line = HTTP/1.1 404 Not Found
		
//		resp001.then().statusCode(200);
	}
}
