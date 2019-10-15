Feature: Death Certificate for Registered User

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with "Births, Deaths & Marriages" will be displayed
    When User clicks "Apply Now" button of "apply-for-death-certificate" service

  Scenario: As a citizen I can submit the Death Certificate service request by filling up valid data and using custom address for shipping
    Then User fills the Deceased Details form with valid data
      | Title | FirstName | LastName | Gender | Address1           | City    | PostalCode | DateOFDeath | DateOFBirth | PlaceOfBirth |
      | Mr    | John      | Citizen  | Male   | 230 Primary Street | Rosebud |       1000 | 2016-02-02  | 1992-02-02  | Melbourne    |
    And User fills the Applicant Details form with valid data for Death Certificate
      | Title | FirstName  | LastName | Gender | DOB        | RelationshipWithDeceased | Address1           | City    | PostalCode | EmailAddess                           | IdentificationProof     |
      | Mr    | Automation | Citizen  | Female | 1994-02-02 | Sister                   | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    And User "uncheck" the primary address in shipping address page for Death Certificate
    And User fills the Shipment/Pickup location form with valid data for Death Certificate
      | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Rosebud |       1000 |
    And User selects an "standard-gross" from the Shipping Method page for Death Certificate
    And User fills the Payment and Billing address form for Death Certificate
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User can review Death Certificate service request before submitting
    Then User accepts the consent declaration for Death Certificate Service request
    When User submits the Death Certificate form
    Then User can view the confirmation page for Death Certificate

  Scenario: As a citizen I can submit the Death Certificate service request by filling up valid data and using primary address for shipping
    Then User fills the Deceased Details form with valid data
      | Title | FirstName | LastName | Gender | Address1           | City    | PostalCode | DateOFDeath | DateOFBirth | PlaceOfBirth |
      | Mr    | John      | Citizen  | Male   | 230 Primary Street | Rosebud |       1000 | 2016-02-02  | 1992-02-02  | Melbourne    |
    And User fills the Applicant Details form with valid data for Death Certificate
      | Title | FirstName  | LastName | Gender | DOB        | RelationshipWithDeceased | Address1           | City    | PostalCode | EmailAddess                           | IdentificationProof     |
      | Mr    | Automation | Citizen  | Female | 1994-02-02 | Sister                   | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    Then User clicks next button on "Shipping Address" checkout page for Death Certificate
    And User selects an "standard-gross" from the Shipping Method page for Death Certificate
    And User fills the Payment and Billing address form for Death Certificate
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User can review Death Certificate service request before submitting
    Then User accepts the consent declaration for Death Certificate Service request
    When User submits the Death Certificate form
    Then User can view the confirmation page for Death Certificate

  Scenario: As a citizen I can submit the Death Certificate service request by filling up valid data and using saved card
    Then User fills the Deceased Details form with valid data
      | Title | FirstName | LastName | Gender | Address1           | City    | PostalCode | DateOFDeath | DateOFBirth | PlaceOfBirth |
      | Mr    | John      | Citizen  | Male   | 230 Primary Street | Rosebud |       1000 | 2016-02-02  | 1992-02-02  | Melbourne    |
    And User fills the Applicant Details form with valid data for Death Certificate
      | Title | FirstName  | LastName | Gender | DOB        | RelationshipWithDeceased | Address1           | City    | PostalCode | EmailAddess                           | IdentificationProof     |
      | Mr    | Automation | Citizen  | Female | 1994-02-02 | Sister                   | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    And User "uncheck" the primary address in shipping address page for Death Certificate
    And User fills the Shipment/Pickup location form with valid data for Death Certificate
      | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Rosebud |       1000 |
    And User selects an "standard-gross" from the Shipping Method page for Death Certificate
    And User uses saved card for payment for Death Certificate
    Then User can review Death Certificate service request before submitting
    Then User accepts the consent declaration for Death Certificate Service request
    When User submits the Death Certificate form
    Then User can view the confirmation page for Death Certificate

  Scenario: As a citizen I can view the error message when I enter date of death in future
    Then User fills the Deceased Details form with valid data
      | Title | FirstName | LastName | Gender | Address1           | City    | PostalCode | DateOFDeath | DateOFBirth | PlaceOfBirth |
      | Mr    | John      | Citizen  | Male   | 230 Primary Street | Rosebud |       1000 | 2020-02-02  | 1992-02-02  | Melbourne    |
    Then User can view the error message

  Scenario: As a citizen I can submit the error message on Deceased Details form
    Then User leaves the Deceased Details form empty and clicks on next button
    Then User clicks on Ok button in the Popup
    Then User should be able to see the error message in Deceased Details form

  Scenario: As a citizen I can submit the error message on Applicant Details form
    Then User fills the Deceased Details form with valid data
      | Title | FirstName | LastName | Gender | Address1           | City    | PostalCode | DateOFDeath | DateOFBirth | PlaceOfBirth |
      | Mr    | John      | Citizen  | Male   | 230 Primary Street | Rosebud |       1000 | 2016-02-02  | 1992-02-02  | Melbourne    |
    Then User leaves the Applicant Details form for death certificate empty and clicks on next button
    Then User clicks on Ok button in the Popup
    Then User should be able to see the error message in Applicant Details form
