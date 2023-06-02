package TestNGAPI;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.UtilsLayer.UtilsClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class EndToEndFLow  {
	 Response resp;
	 
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://reqres.in/api/users";
		String reqBody=UtilsClass.addNewUsers("john.erik@reqres.in", "John", "Erik", "https://reqres.in/img/faces/7-image.jpg");
		 
		resp =ReusableHttpMethods.postDemo(reqBody);   
	}	
	
	
	
	@Test(priority=1)
	public void validateStatusCode() {
		Assert.assertEquals(201,resp.statusCode());
	
	}		
		
		@Test(priority=2)
		public void validateResponsePayLoadEmail1() {
			Assert.assertEquals(resp.jsonPath().getString("email"), "john.erik@reqres.in");
		}
		
		@Test(priority=3)
		public void validateResponsePayLoadFirst_Name() {
			Assert.assertEquals(resp.jsonPath().getString("first_name"), "John");
		}
		
		@Test(priority=4)
		public void validateResponsePayLoadLast_Name() {
			Assert.assertEquals(resp.jsonPath().getString("last_name"), "Erik");
		}
		
		@Test(priority=5)
		public void validateResponsePayLoadAvatar1() {
			Assert.assertEquals(resp.jsonPath().getString("avatar"),"https://reqres.in/img/faces/7-image.jpg");
		
		}
		
		@Test(priority=6)
		public void updateEntityUsingPutRequest() {
			String requestBody= UtilsClass.addNewUsers("steve.john@reqres.in",  "Steve","John" ,"https://reqres.in/img/faces/8-image.jpg"  );
			resp=ReusableHttpMethods.putDemo(requestBody, "posts/7");
		}
		
		
		
		@Test(priority=7)
		public void validateResponsePayLoadEmailPut() {
			Assert.assertEquals(resp.jsonPath().getString("email"), "steve.john@reqres.in");
		}
		
		@Test(priority=8)
		public void validateResponsePayLoadFirstNamePut() {
			Assert.assertEquals(resp.jsonPath().getString("first_name"), "Steve");
		}
		
		@Test(priority=9)
		public void validateResponsePayLoadLastNamePut() {
			Assert.assertEquals(resp.jsonPath().getString("last_name"), "John");
		}
		
		@Test(priority=10)
		public void validateResponsePayLoadAvatarPut() {
			Assert.assertEquals(resp.jsonPath().getString("avatar"),"https://reqres.in/img/faces/8-image.jpg");
		
	}
		@Test(priority=11)
		public void validateStatusCodePut() {
			Assert.assertEquals(200,resp.statusCode());
		
		}		
		
}
		
		
		
		
		
		
		
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


