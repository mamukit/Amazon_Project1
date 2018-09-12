 @TS_1001
Feature: Web application login function, web data collection and element functionality verification

Description: 
User able to login with valid credentials
User able to collect data from web application
User able to verify functionality of web elements
User also validate false information

Background:
Given User able to open Chrome browser 
And  Put URL and go to home page

@smoke1
Scenario Outline: Login function validation

When User enters Username as "<username>" and Password as "<password>" 
Then login should be successful

Examples:
| username  					| password  | 
| tuan_nguyen30412@hotmail.com 	| Voiu30412 | 

@regression
Scenario: Successfully collect data and verify functionalities
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
	Given User able to search for 'HP laptop'
	And sort the price of HP laptops from high to low
	Then User able to find out the total number of 'HP laptop' and 'HP laptop' names on the first page
	And find out the total page number
	When User sort the price from low to high
	Then User able to find the highest and lowest 'HP laptop' price on the first page
	When User able to select one 'HP laptop'
	Then User able to add the new item to cart 
	When User able to proceed to cart
	And User enters his email and password
	And click on the 'Deliver' button
	And click on the 'Continue' button
	When User enter invalid name on card as "Peter Michaels" and card number as "3112118191467841" 
	And select expired month and year
	And User click on the 'Add your card' button
	Then User not able to proceed and payment fails
	And take screenshot of the failed payment
	And close the browser

	


	# created a feature file but not develop stepdef yet= dry run
	
	