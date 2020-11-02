package pageObjects;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import helper.Utils;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Parent;

public class ApiClass {

	HashMap<String, String> statusCode = new HashMap<String, String>();
	List<String> expectedRate = new LinkedList<String>();
	List<String> actualRate = new LinkedList<String>();	
	List<String> expectedRateFuture = new LinkedList<String>();
	List<String> actualRateFuture = new LinkedList<String>();

	public void availableRates() {

		expectedRate.add("0.90208");
		System.out.println("expectedRate grb rate is : "+expectedRate); 
	}
	
	public Response forginExchangeApi() {
		RestAssured.baseURI = "http://api.ratesapi.io/api";
		Response response = null;
		try {
			
			 response = RestAssured.given().contentType(ContentType.JSON).get("/latest");
			 System.out.println("responsebody : "+response.getBody().asString()); 
		} catch(Exception e) {
			
			e.printStackTrace();
		}

		return response;
	}
	
	public Response forginExchangeIncorrectApi() {
		RestAssured.baseURI = "http://api.ratesapi.io/api";
		Response response = null;
		try {
			
			 response = RestAssured.given().contentType(ContentType.JSON).get("/wronge");
			 System.out.println("responsebody : "+response.getBody().asString()); 
		} catch(Exception e) {
			
			e.printStackTrace();
		}

		return response;
	}

	public void verifyGetApi() {

		try {
			 Gson gson = new Gson();
			 Parent parent = gson.fromJson(forginExchangeApi().getBody().asString(), Parent.class);
			 ObjectMapper obj = new ObjectMapper();
			 String jsonStr = obj.writeValueAsString(parent);
			 JSONObject jobj = new JSONObject(jsonStr);
			 String rates1 = jobj.get("rates").toString();
			 System.out.println("rates : "+rates1);
			 JSONObject rates = jobj.getJSONObject("rates");
			 String gbp = rates.get("gbp").toString();
			 actualRate.add(gbp);
			 System.out.println("actualRate gbp rate is : "+gbp);

			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void verifyGetApiResponse() {
		 System.out.println("Available API GBP rate : "+expectedRate+"  matiching with actual GBP API rate : "+actualRate);
		 Assert.assertEquals(actualRate, expectedRate);
		 Assert.assertEquals(forginExchangeApi().getStatusCode(), 200);
		 System.out.println("Assertion is successful response return status code is : "+forginExchangeApi().getStatusCode());
	}
	
	public void verifyResponseStausCode() {

		try {

			 Assert.assertEquals(forginExchangeApi().getStatusCode(), 200);
			 System.out.println("Actual response status code : "+forginExchangeApi().getStatusCode());
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	public void enterIncorrectURL() {
		try {

			 System.out.println("responsebody : "+forginExchangeIncorrectApi().getBody().asString());
			 System.out.println("Actual response status code : "+forginExchangeIncorrectApi().getStatusCode());
			 Assert.assertEquals(forginExchangeIncorrectApi().getStatusCode(), 400);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void verifyResponseForIncorrectUrl() {
		try {
			 System.out.println("Actual response status code : "+forginExchangeIncorrectApi().getStatusCode());
			 Assert.assertEquals(forginExchangeIncorrectApi().getStatusCode(), 200);

			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	// below code for future date
	
	public Response currentDateApi() {
		
		
		RestAssured.baseURI = "http://api.ratesapi.io/api/";
		Response response = null;
		try {
			
			 response = RestAssured.given().contentType(ContentType.JSON).get(Utils.currentDate());
			 System.out.println("responsebody : "+response.getBody().asString());
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	public Response futureDateApi() {
		
		
		RestAssured.baseURI = "http://api.ratesapi.io/api/";
		Response response = null;
		try {
			
			 response = RestAssured.given().contentType(ContentType.JSON).get(Utils.tomorrowDate());
			 System.out.println("responsebody : "+response.getBody().asString());
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	public void expectedAPIRatesForCurrentDate() {
		
		expectedRateFuture.add("0.90208");
		System.out.println("expected GBP rate is : "+expectedRateFuture);
	}
	
	public void avilableAPIRatesForCurrentDate() {

		try {
			
			 String responseBody = currentDateApi().getBody().asString();
			 Gson gson = new Gson();
			 Parent parent = gson.fromJson(responseBody, Parent.class);
			 ObjectMapper obj = new ObjectMapper();
			 String jsonStr = obj.writeValueAsString(parent);
			 JSONObject jobj = new JSONObject(jsonStr);
			 String rates1 = jobj.get("rates").toString();
			 System.out.println("rates : "+rates1);
			 JSONObject rates = jobj.getJSONObject("rates");
			 String gbp = rates.get("gbp").toString();
			 actualRateFuture.add(gbp);
			 System.out.println("actual GBP rate is : "+actualRateFuture);

			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void verifyStatusCodeForCurrentDate() {
		try {
	
			 Assert.assertEquals(currentDateApi().getStatusCode(), 200, "Assert the success status of response");
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void verifyResponseForCurrentDate() {
		try {
	
			 Assert.assertEquals(currentDateApi().getStatusCode(), 200, "API return status code 200");
			 Assert.assertEquals(actualRateFuture, expectedRateFuture, "Response matches for current date");
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void verifyResponseForFutureDate() {
		try {
			
			 Assert.assertEquals(futureDateApi().getStatusCode(), 200, "API return status code 200");
			 Assert.assertEquals(actualRateFuture, expectedRateFuture, "Response matches for current date");			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
}
