package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostTestExamples {
	
	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[1].first_name",equalTo("Lindsay")).
			body("data.first_name", hasItems("George","Rachel"));
		
		
	}
	
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Naveen");
//		map.put("job","Teacher");
//		
//		System.out.println(map);
		baseURI = "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		
		request.put("name","Naveen");
		request.put("job","Teacher");
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}

}
