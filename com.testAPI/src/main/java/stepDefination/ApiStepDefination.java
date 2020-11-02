package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ApiClass;

public class ApiStepDefination{

	ApiClass api = new ApiClass();
	
	@Given("Rates API for latest foreign exchange rates")
	public void rates_API_for_latest_foreign_exchange_rates() {
	    // Write code here that turns the phrase above into concrete actions
		api.availableRates();

	}

	@When("The API is available")
	public void the_API_is_available() {
	    // Write code here that turns the phrase above into concrete actions
		api.verifyGetApi();
	}

	@Then("Verify correct response")
	public void verify_correct_response() {
	    // Write code here that turns the phrase above into concrete actions
		api.verifyGetApiResponse();
	}
	
	@Then("Verify response status code")
	public void verify_response_status_code() {
	    // Write code here that turns the phrase above into concrete actions
		api.verifyResponseStausCode();
	}
	

	@When("An incorrect URL is provided")
	public void an_incorrect_URL_is_provided() {
	    // Write code here that turns the phrase above into concrete actions

	}
	
	@Then("Verify response for incorrect URL")
	public void verify_response_for_incorrect_URL() {
	    // Write code here that turns the phrase above into concrete actions
		api.verifyResponseForIncorrectUrl();
	}
	
	@Then("Verify response for provided an incorrect URL")
	public void verify_response_for_provided_an_incorrect_URL() {
	    // Write code here that turns the phrase above into concrete actions
		api.enterIncorrectURL();
	}
	
	// future date stepdefinations as below
	
	@Given("Rates API for specific date foreign exchange rates")
	public void rates_API_for_specific_date_foreign_exchange_rates() {
	    // Write code here that turns the phrase above into concrete actions
		api.expectedAPIRatesForCurrentDate();
	}

	@When("The API is available for specific date")
	public void the_API_is_available_for_specific_date() {
	    // Write code here that turns the phrase above into concrete actions
		api.avilableAPIRatesForCurrentDate();
	}

	@Then("Verify response status code for specific date")
	public void verify_response_status_code_for_specific_date() {
	    // Write code here that turns the phrase above into concrete actions
		api.verifyStatusCodeForCurrentDate();
		api.verifyResponseForCurrentDate();
	}
	
	@Then("Verify response for provided future date")
	public void verify_response_for_provided_future_date() {
	    // Write code here that turns the phrase above into concrete actions
		api.verifyResponseForFutureDate();
	}
	
	
}
