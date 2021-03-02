package tests;

	import org.json.simple.JSONObject;
	import org.testng.annotations.Test;

	import io.restassured.http.ContentType;

	import static io.restassured.RestAssured.*;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

	import java.util.HashMap;
	import java.util.Map;

public class PutPatchDeleteExamples {
	
	
		@Test
		public void testPut() {
			
			Map<String, Object> map = new HashMap<String, Object>();
			

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
				put("/users/2").
			then().
				statusCode(200).
				log().all();
			
		}
		
		@Test
		public void testPatch() {
			
			Map<String, Object> map = new HashMap<String, Object>();
			

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
				patch("/users/2").
			then().
				statusCode(200).
				log().all();
			
		}
		
		@Test
		public void testDelete() {
			
			baseURI = "https://reqres.in/api";
			when().
				delete("/users/2").
			then().
				statusCode(204).
				log().all();
			
		}

}



