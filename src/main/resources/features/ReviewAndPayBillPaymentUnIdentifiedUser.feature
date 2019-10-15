@Test
Feature: As a Citizen, there needs to be a review and pay page for a Bill, so that I can confirm the Bill details before making the payment

    Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    Then User clicks on "Retrieve Bill" link available in footer section

  Scenario: As a unidentified citizen, I verify if the part payment is allowed the the filed enter amount is visible
     And User retrieves bill by entering invalid "E-100012" and "Citizen"
    Then User verifies if the enter amount filed is visible

  Scenario: As a unidentified citizen, I verify if the part payment is not allowed the the filed enter amount is not visible
     And User retrieves bill by entering invalid "E-100018" and "Citizen"
    Then User verifies if the enter amount filed is not visible

  Scenario: As a unidentified citizen, I can make payment by entering amount less than the outstanding amount
    And User retrieves bill by entering invalid "E-100012" and "Citizen"
    And User enters "0.01" in the partial amount field
    Then User fills the card details and makes payment and clicks on pay now button
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode | FillBillingAddress |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Citizen  | 230 Primary Street | Rosebud |       2234 | Yes                |

  Scenario: As a unidentified citizen, I can make payment by entering amount less than the outstanding amount and using the saved card
    And User retrieves bill by entering invalid "E-100012" and "Citizen"
    And User enters "0.01" in the partial amount field
    Then User uses the saved card for payment

  Scenario: As a unidentified citizen, I can make payment by entering amount more than the outstanding amount
    And User retrieves bill by entering invalid "E-100012" and "Citizen"
    And User enters "1000.50" in the partial amount field
    Then User fills the card details and makes payment and clicks on pay now button
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode | FillBillingAddress |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Citizen  | 230 Primary Street | Rosebud |       2234 | Yes                |
    And User verifies the error message

