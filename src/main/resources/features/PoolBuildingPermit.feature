Feature: Submit a Pool Building Permit application
  As A Registered Citizen 
  I want to submit a pool building permit application
  So that I can apply for this service with State of Rosebud

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with title "Permits & Applications"  will be displayed
    When User clicks "Apply Now" button of "pool-building-permit" service

  Scenario: As a Citizen I can submit the Pool building permit service request by providing the required details
    When user fills his personal information with valid data
      | title | firstName  | lastName | DOB        | addressLine1       | city    | postCode | emailAddress                          | PhoneNumber |
      | Mr    | Automation | Citizen  | 1984-02-02 | 230 Primary Street | Rosebud |     1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    And user fills his work details
      | devAppApprovalNum | complyDevCertApprovalNum | certifierNum | marketValueOfTheWork | offenceQuestion | certOfInsuranceQuestion |
      |             12345 |                    54321 |        12345 |                10000 | Yes             | No                      |
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City   | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Sydney |       1000 |
    And user reviews pool building permit service product
    And user submits service request
    Then pool building permit service request is submitted and user is redirected to confirmation page

  Scenario: As a Citizen an error is displayed when I am submitting the Pool building permit service request without providing mandatory information in personal details form
    When user fills his personal information with valid data
      | title | firstName  | lastName | DOB        | addressLine1       | city    | postCode | emailAddress                          | PhoneNumber |
      | Mr    | Automation |          | 1984-02-02 | 230 Primary Street | Rosebud |     1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    Then an error is displayed to the user

  Scenario: As a Citizen an error is displayed when I am submitting the Pool building permit service request without providing credit card details
    When user fills his personal information with valid data
      | title | firstName  | lastName | DOB        | addressLine1       | city    | postCode | emailAddress                          | PhoneNumber |
      | Mr    | Automation | Citizen  | 1984-02-02 | 230 Primary Street | Rosebud |     1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    And user fills his work details
      | devAppApprovalNum | complyDevCertApprovalNum | certifierNum | marketValueOfTheWork | offenceQuestion | certOfInsuranceQuestion |
      |             12345 |                    54321 |        12345 |                10000 | Yes             | No                      |
    And User fills the Payment and Billing address form
      | CardType | CardNumber | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City   | PostalCode |
      | Visa     |            |       02 |    2026 | 123 | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Sydney |       1000 |
    Then an payment info error is displayed to the user

  Scenario: As a Citizen an error is displayed when I am submitting the Pool building permit service request without providing billding address details
    When user fills his personal information with valid data
      | title | firstName  | lastName | DOB        | addressLine1       | city    | postCode | emailAddress                          | PhoneNumber |
      | Mr    | Automation | Citizen  | 1984-02-02 | 230 Primary Street | Rosebud |     1000 | automationtestuser@stateofrosebud.com |  0011234567 |
    And user fills his work details
      | devAppApprovalNum | complyDevCertApprovalNum | certifierNum | marketValueOfTheWork | offenceQuestion | certOfInsuranceQuestion |
      |             12345 |                    54321 |        12345 |                10000 | Yes             | No                      |
    And User fills the Payment and Billing address form
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City   | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Thomas    | Citizen  | 230 Primary Street | Sydney |            |
    Then an payment info error is displayed to the user
