Feature: Submit a Working with children check application
  As A Registered Citizen 
  I want to submit a working with children check application
  So that I can apply for this service with State of Rosebud

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with title "Permits & Applications"  will be displayed
    When User clicks "Apply Now" button of "working-with-children-check" service

  Scenario: As a Citizen I can submit the Working with children check service request as a volunteer with all the required information
    When User selects "apply-as-volunteer-addon" from Application Type page
    And user fills the application and organisations details with valid data
      | sector            | appliedBefore | organizationDetailsAvailable |
      | Child development | No            | No                           |
    And user fills his personal details with valid data
      | title | firstName  | lastName | anotherName | gender | placeOfBirth | DOB        | country        | addressLine1       | city    | postCode | PhoneNumber | emailAddress                          | uploadIdentification |
      | Mr    | Automation | Citizen  | No          | Male   | Rosebud      | 1984-02-02 | United Kingdom | 230 Primary Street | Rosebud |     1000 |  0011234567 | automationtestuser@stateofrosebud.com | yes                  |
    And user reviews working with children check service product and agrees to consent declaration before submitting
    And user submits service request
    Then service request is submitted and user is redirected to confirmation page

  Scenario: As a Citizen I can submit the Working with children check service request as a paid or self employeed with all the required information
    When User selects "apply-as-paid-employee-addon" from Application Type page
    And user fills the application and organisations details with valid data
      | sector            | appliedBefore | organizationDetailsAvailable | organizationName | addressLine1       | city    | postCode | PhoneNumber |
      | Child development | No            | Yes                          | test org         | 230 Primary Street | Rosebud |     1000 |  0011234567 |
    And user fills his personal details with valid data
      | title | firstName  | lastName | anotherName | gender | placeOfBirth | DOB        | country        | addressLine1       | city    | postCode | PhoneNumber | emailAddress                          | uploadIdentification |
      | Mr    | Automation | Citizen  | no          | Male   | Rosebud      | 1984-02-02 | United Kingdom | 230 Primary Street | Rosebud |     1000 |  0011234567 | automationtestuser@stateofrosebud.com | yes                  |
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City   | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Thomas    | Kane     | 230 Primary Street | Sydney |       2234 |
    And user reviews working with children check service product and agrees to consent declaration before submitting
    And user submits service request
    Then service request is submitted and user is redirected to confirmation page

  Scenario: As a Citizen I am asked to accept the consent declaration while submitting the Working with children check service request as a volunteer when I dont accept it
    When User selects "apply-as-volunteer-addon" from Application Type page
    And user fills the application and organisations details with valid data
      | sector            | appliedBefore | organizationDetailsAvailable |
      | Child development | No            | No                           |
    And user fills his personal details with valid data
      | title | firstName  | lastName | anotherName | gender | placeOfBirth | DOB        | country        | addressLine1       | city    | postCode | PhoneNumber | emailAddress                          | uploadIdentification |
      | Mr    | Automation | Citizen  | no          | Male   | Rosebud      | 1984-02-02 | United Kingdom | 230 Primary Street | Rosebud |     1000 |  0011234567 | automationtestuser@stateofrosebud.com | yes                  |
    And user reviews working with children check service product and doesnot accept the consent declaration before submitting
    And user submits service request
    Then user will be intimated to accept consent declaration

  Scenario: As a Citizen an error is displayed when I am submitting the Working with children check service request as a volunteer but without providing mandatory information in application details
    When User selects "apply-as-volunteer-addon" from Application Type page
    And user fills the application and organisations details with valid data
      | sector            | appliedBefore | organizationDetailsAvailable |
      | Child development | Yes           | No                           |
    Then an error is displayed to the user

  Scenario: As a Citizen an error is displayed when I am submitting the Working with children check service request as a paid or self employeed but without providing credit card details
    When User selects "apply-as-paid-employee-addon" from Application Type page
    And user fills the application and organisations details with valid data
      | sector            | appliedBefore | organizationDetailsAvailable | organizationName | addressLine1       | city    | postCode | PhoneNumber |
      | Child development | No            | Yes                          | test org         | 230 Primary Street | Rosebud |     1000 |  0011234567 |
    And user fills his personal details with valid data
      | title | firstName  | lastName | anotherName | gender | placeOfBirth | DOB        | country        | addressLine1       | city    | postCode | PhoneNumber | emailAddress                          | uploadIdentification |
      | Mr    | Automation | Citizen  | no          | Male   | Rosebud      | 1984-02-02 | United Kingdom | 230 Primary Street | Rosebud |     1000 |  0011234567 | automationtestuser@stateofrosebud.com | yes                  |
    And User fills the Payment and Billing address form
      | CardType | CardNumber | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City   | PostalCode |
      | Visa     |            |       02 |    2026 | 123 | United Kingdom | Mr.   | Thomas    | Kane     | 230 Primary Street | Sydney |       2234 |
    Then an payment info error is displayed to the user

  Scenario: As a Citizen an error is displayed when I am submitting the Working with children check service request as a paid or self employeed but without providing billding address details
    When User selects "apply-as-paid-employee-addon" from Application Type page
    And user fills the application and organisations details with valid data
      | sector            | appliedBefore | organizationDetailsAvailable | organizationName | addressLine1       | city    | postCode | PhoneNumber |
      | Child development | No            | Yes                          | test org         | 230 Primary Street | Rosebud |     1000 |  0011234567 |
    And user fills his personal details with valid data
      | title | firstName  | lastName | anotherName | gender | placeOfBirth | DOB        | country        | addressLine1       | city    | postCode | PhoneNumber | emailAddress                          | uploadIdentification |
      | Mr    | Automation | Citizen  | no          | Male   | Rosebud      | 1984-02-02 | United Kingdom | 230 Primary Street | Rosebud |     1000 |  0011234567 | automationtestuser@stateofrosebud.com | yes                  |
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Thomas    | Kane     | 230 Primary Street |      |       2234 |
    Then an payment info error is displayed to the user
