package TestNGAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GetRequestValidationTask   {

	
	 Response resp;
	 RequestSpecification httpRequest;
	
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://reqres.in/api/users?page=1";
		httpRequest=RestAssured.given();
		    resp=ReusableHttpMethods.getDemo("id");
		    
		     resp=httpRequest.get("/1"); 
			
			int code=resp.getStatusCode();
			System.out.println(code);
			
		
			
		String reqBody2=resp.getBody().asString(); 
			System.out.println(reqBody2);
	
	for (int i=6; i>=0 ;i--) 
	{
		
		 resp =httpRequest.get("/email");
		
		 String reqBody =resp.getBody().asString();
		 
		System.out.println("Response Body is" + reqBody);
	
	
		 resp =httpRequest.get("/first_name");
		
		 String reqBody1 =resp.getBody().asString();
		 
		System.out.println("Response Body is" + reqBody1);
	
	}
	}
	@Test(priority=0)
	public void validategetdemo() {
		resp.jsonPath().getString("id"); 
		
	}
	@Test(priority=1)
	public void validateResponseCodeUsingGet() {
		Assert.assertEquals(resp.statusCode(), 200);
	}
	
	
	@Test(priority=2)
	public void validateResponsePayLoadEmail() {
		Assert.assertEquals(resp.jsonPath().getString("email"), "george.bluth@reqres.in");
	}
	
	@Test(priority=3)
	public void validateResponsePayLoadFirstName() {
		Assert.assertEquals(resp.jsonPath().getString("first_name"), "George");
	}
	
	@Test(priority=4)
	public void validateResponsePayLoadLastName() {
		Assert.assertEquals(resp.jsonPath().getString("last_name"), "Bluth");
	}
	
	@Test(priority=5)
	public void validateResponseAvatar() {
		Assert.assertEquals(resp.jsonPath().getString("avatar"),"avatar\":\"https://reqres.in/img/faces/1-image.jpg");
	
	}
	
	
	


}