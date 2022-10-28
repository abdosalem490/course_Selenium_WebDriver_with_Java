
@tag
Feature: Purchase the order from Ecommece website
  I want to use this template for my feature file

	Background:
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive test of submitting the order
    Given loged in with username <name> and password <password>
    When I add product <productName> from Cart
    And checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER." is displayed on the ConfirmationPage

    Examples: 
      | name  									| password 	|	productName  	|
      | abdosalm555@gmail.com 	| Test@1234 |	ZARA COAT 3		|
