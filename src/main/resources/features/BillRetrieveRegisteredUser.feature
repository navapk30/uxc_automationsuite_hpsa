@regression
Feature: To verify BillRetrieve page

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    Then User clicks on "Retrieve Bill" link available in footer section

  Scenario: As a registered citizen, I can enter correct combination of Bill Id and last name, so that I can review the payment page
    And User retrieves bill by entering valid "E-10018" and "Citizen"
    Then User is redirected to the bill details page

  Scenario: As a registered citizen, I can enter incorrect combination of Bill Id and last name, so that I can view the error message
    And User retrieves bill by entering invalid "11111" and "Last Name"
    Then User verifies "We were unable to retrieve your bill." error message

  Scenario: As a registered citizen, I can leave Bill Id and last name empty, so that I can view the error message
    And User retrieves bill by leaving blank for "" and ""
    Then User verifies "We were unable to retrieve your bill." error message

  Scenario: As a registered citizen, I can enter Bill ID for a Bill that is Fully Paid, i.e. Outstanding Amount = 0, so that I can view the receipts for the bill
    And User retrieves bill by entering "E-10006" and "Citizen" for a Bill that is Fully Paid, i.e. Outstanding Amount = 0
    Then User is redirected to the bill details page

  Scenario: As a registered citizen, I can enter Bill ID for a Bill that is Overdue and the Overdue Payment Allowed is set to False, so that I can view the receipts for the bill
    And User retrieves bill by entering "E-10032" and "Citizen" for a Bill that is Overdue and the Overdue Payment Allowed is set to False
    Then User is redirected to the bill details page
