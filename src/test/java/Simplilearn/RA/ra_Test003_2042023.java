package Simplilearn.RA;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ra_Test003_2042023 {

	RequestSpecification req001;

	@Before
	public void Bef001() {
		RestAssured.baseURI = "https://www.dataaccess.com";
		req001 = RestAssured.given();
	}

	@Test
	public void authReq() {
		
		req001.header("Content-Type", "text/xml; charset=utf-8");
		
		String FinalNumber = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ " <soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ " <soap:Body>\r\n"
				+ " <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ " <ubiNum>123456</ubiNum>\r\n"
				+ " </NumberToWords>\r\n"
				+ " </soap:Body>\r\n"
				+ "	</soap:Envelope>";
		
		req001.body(FinalNumber);   
		   
		//send request
		Response resp001 = req001.when().post("/webservicesserver/NumberConversion.wso");
		
		int sc = resp001.getStatusCode();
		System.out.println("Status code = " + sc);
		
		String stts_line = resp001.getStatusLine();
		System.out.println("Status line = " + stts_line);
		
		resp001.then().log().all();
		
//		Status code = 404
//		Status line = HTTP/1.1 404 Not Found
		
		resp001.then().statusCode(200);
	}
}
