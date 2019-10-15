@regression
Feature: As an registered user I can sign to the website and look at myaccount page

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer

  Scenario: Customer can perform successful login to website using valid credentials
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state

  Scenario: Customer cannot perform successful login to website using invalid credentials
    And Customer submit the login form with invalid "username" and "password"
    Then Customer will not be in Signed in state
