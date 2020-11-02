#Author: Sandip Gandharwar
Feature: Rates API

@API
Scenario: Acceptance Criteria 1
	Given Rates API for latest foreign exchange rates
	When The API is available
	Then Verify response status code
	
Scenario: Acceptance Criteria 2	
	Given Rates API for latest foreign exchange rates
	When The API is available
	Then Verify correct response
	
Scenario: Acceptance Criteria 3	
	Given Rates API for latest foreign exchange rates
	Then Verify response for provided an incorrect URL

Scenario: Acceptance Criteria 4
	Given Rates API for specific date foreign exchange rates
	When The API is available for specific date
	Then Verify response status code for specific date
	
Scenario: Acceptance Criteria 5	
	Given Rates API for specific date foreign exchange rates
	When The API is available for specific date
	Then Verify correct response
	
Scenario: Acceptance Criteria 6	
	Given Rates API for specific date foreign exchange rates
	When The API is available for specific date
	Then Verify response for provided future date