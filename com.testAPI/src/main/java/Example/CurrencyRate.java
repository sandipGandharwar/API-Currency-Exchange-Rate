package Example;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.core.gherkin.vintage.internal.gherkin.deps.com.google.gson.JsonObject;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.Gson;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.JsonElement;
import io.cucumber.core.internal.gherkin.deps.com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.Parent;

public class CurrencyRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://api.exchangeratesapi.io";
		Response response = null;
		try {
			
			 response = RestAssured.given().contentType(ContentType.JSON).get("/latest");
			 System.out.println("responsebody : "+response.getBody().asString()); 
			 Gson gson = new Gson();
			 Parent parent = gson.fromJson(response.getBody().asString(), Parent.class);
			 ObjectMapper obj = new ObjectMapper();
			 String jsonStr = obj.writeValueAsString(parent);
			 JSONObject jobj = new JSONObject(jsonStr);
			 String rates1 = jobj.get("rates").toString();
			 System.out.println("rates : "+rates1);
			 JSONObject rates = jobj.getJSONObject("rates");
			 String gbp = rates.get("gbp").toString();
//			 actualRate.add(gbp);
			 System.out.println("actualRate gbp rate is : "+gbp);
		} catch(Exception e) {
			
			e.printStackTrace();
		}		
//		expectedRate.add("0.90208");
//		System.out.println("expectedRate grb rate is : "+expectedRate); 
	}

}
