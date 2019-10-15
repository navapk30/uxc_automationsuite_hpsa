Feature: Regsiter A Birth for Guest User

  Background: 
    Given Customer is on homepage of site
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with "Births, Deaths & Marriages" will be displayed
    When User clicks Register a Birth Product button
    Then User does a Guest login with "automationtestuser@stateofrosebud.com" and "automationtestuser@stateofrosebud.com"

  Scenario: As a citizen I can submit the Register a Birth service request by selecting bundle option other than "None"
    Then User selects "two birth certificate" option from Registration Options page
    And User fills the Child Details form with valid data
      | FirstName | LastName | UnderstandThatAsParents | DOB        | BirthWeight | Gender | Country        | Address1           | City    | PostalCode |
      | Charles   | Citizen  | true                    | 1992-02-02 |        2000 | Female | United Kingdom | 230 Primary Street | Rosebud |       2234 |
    And User fills the Parent1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | RelationshipToChild | Country        | Address1           | City    | PostalCode | EmailAddress                          | PhoneNumber |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | Father              | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    And User fills the Parent2 Details form with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth | RelationshipToChild | Country        | Address1           | City    | PostalCode | EmailAddress                          | PhoneNumber | Parent2IsUnknown |
      | Ms    | Jane      | Citizen  | Female | 1986-02-02 | Rosebud      | Mother              | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com |  0011234567 | False            |
    And User fills the Shipment/Pickup location form with valid data
      | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Rosebud |       2234 |
    And User selects an "standard-gross" from the Shipping Method page
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User can review register a birth service product before submitting
    When User submits the Regsiter a Birth form
    Then User can view the confirmation page

  Scenario: As a citizen I can submit the Register a Birth service request by selecting bundle option "None"
    Then User selects "none" option from Registration Options page
    And User fills the Child Details form with valid data
      | FirstName | LastName | UnderstandThatAsParents | DOB        | BirthWeight | Gender | Country        | Address1           | City    | PostalCode |
      | Charles   | Citizen  | true                    | 1992-02-02 |        2000 | Female | United Kingdom | 230 Primary Street | Rosebud |       2234 |
    And User fills the Parent1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | RelationshipToChild | Country        | Address1           | City    | PostalCode | EmailAddress                          | PhoneNumber |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | Father              | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    And User fills the Parent2 Details form with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth | RelationshipToChild | Country        | Address1           | City    | PostalCode | EmailAddress                          | PhoneNumber | Parent2IsUnknown |
      | Ms    | Jane      | Citizen  | Female | 1986-02-02 | Rosebud      | Mother              | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com |  0011234567 | False            |
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode | FillBillingAddress |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Citizen  | 230 Primary Street | Rosebud |       2234 | Yes                |
    Then User can review register a birth service product before submitting
    When User submits the Regsiter a Birth form
    Then User can view the confirmation page

  Scenario: As a citizen I can submit the Register a Birth service request by selecting "Parent2 is unknown" in Parent2 details form
    Then User selects "two birth certificate" option from Registration Options page
    And User fills the Child Details form with valid data
      | FirstName | LastName | UnderstandThatAsParents | DOB        | BirthWeight | Gender | Country        | Address1           | City    | PostalCode |
      | Charles   | Citizen  | true                    | 1992-02-02 |        2000 | Female | United Kingdom | 230 Primary Street | Rosebud |       2234 |
    And User fills the Parent1 Details form with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | RelationshipToChild | Country        | Address1           | City    | PostalCode | EmailAddress                          | PhoneNumber |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | Melbourne    | Father              | United Kingdom | 230 Primary Street | Rosebud |       1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    And User fills the Parent2 Details form with valid data
      | Parent2IsUnknown |
      | True             |
    And User fills the Shipment/Pickup location form with valid data
      | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Rosebud |       2234 |
    And User selects an "standard-gross" from the Shipping Method page
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User can review register a birth service product before submitting
    When User submits the Regsiter a Birth form
    Then User can view the confirmation page

  Scenario: As a citizen I can view the error message on Registration Options section
    Then User does not selects a option from Registration Options page and clicks on next button
    Then User should be able to see the error message.

  Scenario: As a citizen I can view the error message on Child Details Section
    Then User selects "two birth certificate" option from Registration Options page
    And User leaves the Child deatils form empty and clicks on next button
    Then User clicks on Ok button in the Popup
    Then User should be able to see the error message in child details form
