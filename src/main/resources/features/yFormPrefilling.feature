Feature: To Verify prefilling for service request

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state

  Scenario: As a signed in citizen, I can verify prefilling for Pool Building service request
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with title "Permits & Applications"  will be displayed
    When User clicks "Apply Now" button of "pool-building-permit" service
    Then User verifies the personal details form is prepopulated

  Scenario: As a signed in citizen, I can verify prefilling for Report Graffiti service request
    When user click on "report-an-issue" from Top menu
    Then verify PLP page with "Report an Issue" will be displayed
    When User clicks "Report Now" button of "report-graffiti" service
    Then User verifies the Report Graffiti form is prepopulated

  Scenario: As a signed in citizen, I can verify prefilling for Register a Birth service request
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with "Births, Deaths & Marriages" will be displayed
    When User clicks "Register Now" button of "register-birth" service
    Then User selects "two birth certificate" option from Registration Options page
    And User fills the Child Details form with valid data
      | FirstName | LastName | UnderstandThatAsParents | DOB        | BirthWeight | Gender | Country        | Address1       | City   | PostalCode |
      | Charles   | Kane     | true                    | 1992-02-02 |        2000 | Female | United Kingdom | 54 test street | Sydney |       2234 |
    Then User Verfies Parent details form is prefilled
