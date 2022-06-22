package Simplilearn.RA;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ra_Test001 {

	RequestSpecification Request001;

	@Before
	public void Before001() {
		RestAssured.baseURI = "https://reqres.in";
		Request001 = RestAssured.given();
	}

	@Test
	@Ignore
	public void SimpleTest001() {
		// Set Base URI
		RestAssured.baseURI = "https://reqres.in";

		// Create Request
		RequestSpecification Request001 = RestAssured.given();

		// Send Request
		System.out.println("--------------------------------------------");
		Request001.get("api/users?page=2").then().log().all();
		System.out.println("--------------------------------------------");
	}

	@Test
	@Ignore
	public void SimpleTest002() {
		RestAssured.given().baseUri("https://reqres.in").when().get("api/users?page=3").then().log().all();

		String Body001 = RestAssured.get("https://reqres.in/api/users?page=1").body().asString();
		System.out.println("--------------------------------------------");
		System.out.println("Body==> " + Body001);
	}

	@Test
	@Ignore
	public void SimpleTest003() {
		// Set Base URI
		RestAssured.baseURI = "https://reqres.in";

		// Create Request
		RequestSpecification Request001 = RestAssured.given();

		// Send Request
		System.out.println("--------------------------------------------");
		Request001.get("api/users?page=2").then().log().body();
	}

	@Test
	@Ignore
	public void SimpleTest004() {
		// Set Base URI
		RestAssured.baseURI = "https://reqres.in";

		// Create Request
		RequestSpecification Request001 = RestAssured.given();

		// Send Request
		System.out.println("--------------------------------------------");
		Request001.get("api/users?page=2").then().log().headers();
	}

	@Test
	@Ignore
	public void SimpleTest005() {
		System.out.println("--------------------------------------------");
		Request001.when().get("api/users?page=1").then().log().body();
	}

	@Test
	@Ignore
	public void SimpleTest006() {
		System.out.println("--------------------------------------------");
		Request001.when().get("api/users?page=2").then().log().body();
		System.out.println("--------------------------------------------");
	}

	@Test
	@Ignore
	public void SimpleTest007() {
		Response Response001 = Request001.when().get("api/users?page=1");

		Response001.then().log().body();

		Response001.then().log().headers();

		String Body002 = Response001.body().asString();

		System.out.println("Body ==> " + Body002);
	}

	@Test
	public void SimpleTest008() {
		Response Response001 = Request001.when().get("api/users?page=1");

		JsonPath Jp001 = Response001.jsonPath();

		int TotalPgs = Jp001.getInt("total_pages");

		System.out.println("Total_Pages = " + TotalPgs);
		System.out.println("--------------------------------------------");

		String Email001 = Jp001.getString("data[0].email");

		System.out.println("Email @ data==> " + Email001);
		System.out.println("--------------------------------------------");
	}

	@Test
	public void SimpleTest009() {
		Response Response001 = Request001.when().get("api/users?page=1");
		Response001.then().statusCode(200);	
		int StatusC = Response001.getStatusCode();
		String StatusL = Response001.getStatusLine();
		
		System.out.println("Status Code = " + StatusC + StatusL);
		
		//validate in body
		Assert.assertTrue(Response001.body().asString().contains("george.bluth@reqres.in"));
	}
}
