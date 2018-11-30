 @TS_1001
Feature: Web application login function, web data collection and element functionality verification

Description: 
User able to login with valid credentials
User able to collect data from web application
User able to verify functionality of web elements
User also validate false information

Background:
Given User able to login amazon with valid credential 

@regression
Scenario: Successfully check iphone and cart functionality
	
	Then Validate Amazon homepage
	And take screenshot of the homepage
	Given User able to search for 'iphone'
	And sort the price from high to low
	Then User able to count the number of 'iphone x'
	And Find out the number of 'iphone' and 'iphone' names on the first page
	And Find out the total number of pages
	When User able to search for 'iphone x'
	And check the 'Apple brand' checkbox
	And sort the price from low to high
	Then User able to find out the highest and lowest 'iphone x' prices on the first page
	When User able to click on one 'iphone'
	Then User able to add the item to cart

@regression
Scenario: Successfully check Laptop and cart functionality
	Given User able to search for 'HP laptop'
	And sort the price of HP laptops from high to low
	Then User able to find out the total number of 'HP laptop' and 'HP laptop' names on the first page
	And find out the total page number
	When User sort the price from low to high
	When User able to find the highest and lowest 'HP laptop' price on the first page
	And Add one laptop in cart	
	And Provide invalide payment information 
	Then User not able to proceed and payment fails
	When take screenshot of the failed payment
	And close the browser


	
	