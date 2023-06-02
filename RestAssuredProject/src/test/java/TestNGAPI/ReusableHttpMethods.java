package TestNGAPI;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReusableHttpMethods  { 

	
	public static Response postDemo(String Requestbody) {
		return 	given().contentType(ContentType.JSON).and().body(Requestbody).when().post().then().extract().response();
		
	}
	
public static Response getEmail(String email) {
		
		return given().contentType(ContentType.JSON).when().get(email).then().extract().response();
	}
	
	public static Response getFirstName(String first_name) {
		
		return given().contentType(ContentType.JSON).when().get(first_name).then().extract().response();
	}
	
public static Response getDemo(String id) {
		
		return given().contentType(ContentType.JSON).when().get(id).then().extract().response();
	}
	
	public static Response putDemo(String requestBody, String id) {
		
		return given().contentType(ContentType.JSON).and().body(requestBody).when().put(id).then().extract().response();
	}
	
	

}






