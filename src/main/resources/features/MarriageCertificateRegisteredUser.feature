Feature: Marriage Certificate for Registered User

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with title "Births, Deaths & Marriages"  will be displayed
    When User clicks "Apply Now" button of "apply-for-marriage-certificate" service

  Scenario: 
    As a logged in citizen I can submit the Marriage Certificate service request by filling up valid data and using custom address for shipping

    Then User fills the Marriage Details form with valid data
      | MarriagePlace | MarriageDate |
      | Rosebud       | 23/04/2016   |
    And User fills the Partner 1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | Country        | Address1           | City    | PostalCode | EmailAddress                          | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    And User fills the Partner 2 Details form with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth |
      | Mr    | Mia       | Citizen  | Male   | 1984-02-02 | Melbourne    |
    And User "uncheck" the primary address in shipping address page  for Marriage Certificate Service
    And User fills the Shipment/Pickup location form with valid data for Marriage Certificate Service
      | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Rosebud |       2234 |
    And User selects an "standard-gross" from the Shipping Method page  for Marriage Certificate Service
    And User fills the Payment and Billing address form  for Marriage Certificate Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Marriage Certificate service information
    Then User accepts the consent declaration for Marriage Certificate Service
    When User submits the Marriage Certificate form
    Then User is redirected to Marriage Certificate confirmation page

  Scenario: 
    As a logged in citizen I can submit the Marriage Certificate service request by filling up valid data and using primary address for shipping

    Then User fills the Marriage Details form with valid data
      | MarriagePlace | MarriageDate |
      | Rosebud       | 23/04/2016   |
    And User fills the Partner 1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | Country        | Address1           | City    | PostalCode | EmailAddress                          | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    And User fills the Partner 2 Details form with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth |
      | Mrs   | Mia       | Citizen  | Male   | 1984-02-02 | Melbourne    |
    Then User clicks next button on "Shipping Address" checkout page
    And User selects an "standard-gross" from the Shipping Method page  for Marriage Certificate Service
    And User fills the Payment and Billing address form  for Marriage Certificate Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Marriage Certificate service information
    Then User accepts the consent declaration for Marriage Certificate Service
    When User submits the Marriage Certificate form
    Then User is redirected to Marriage Certificate confirmation page

  Scenario: 
    As a citizen I can view the error message on Marriage Details section by filling up invalid data

    When User entered "Date of Marriage (example: 23/09/2016)" "text" field as  "27/04/2017"
    Then User should be able to see the error message "Date of marriage must not be in the future"

  Scenario: 
    As a citizen I can view the error message on Partner 2 Details section by filling up invalid data

    Then User fills the Marriage Details form with valid data
      | MarriagePlace | MarriageDate |
      | Rosebud       | 23/04/2016   |
    And User fills the Partner 1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | Country        | Address1           | City    | PostalCode | EmailAddress                          | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    When User clicks on next button in "Partner 2 Details" yformPage
    Then User will get an error dialog message with error message "There are validation errors. Please retry once all fields have been properly filled-out."

  Scenario: As a citizen I can view the error message on Partner 1 Details section by filling up invalid data
    Then User fills the Marriage Details form with valid data
      | MarriagePlace | MarriageDate |
      | Rosebud       | 23/04/2016   |
    When User clicks on next button in "Partner 1 Details" yformPage
    Then User will get an error dialog message with error message "There are validation errors. Please retry once all fields have been properly filled-out."

  Scenario: 
    As a citizen I can view the error message on review page section when I did not accept consent declaration and tries to submit

    Then User fills the Marriage Details form with valid data
      | MarriagePlace | MarriageDate |
      | Rosebud       | 23/04/2016   |
    And User fills the Partner 1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | Country        | Address1           | City    | PostalCode | EmailAddress                          | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com | IdentificationProof.PNG |
    And User fills the Partner 2 Details form with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth |
      | Mr    | Mia       | Citizen  | Male   | 1984-02-02 | Melbourne    |
    Then User clicks next button on "Shipping Address" checkout page
    And User selects an "standard-gross" from the Shipping Method page  for Marriage Certificate Service
    And User fills the Payment and Billing address form  for Marriage Certificate Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Marriage Certificate service information
    When User submits the Marriage Certificate form
    Then User should be able to see the error message that consent declaration is not selected
