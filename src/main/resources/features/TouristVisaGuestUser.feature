Feature: Tourist visa for Guest User

  Background: 
    Given Customer is on homepage of site
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with "Permits & Applications" will be displayed
    When User clicks "Apply Now" button of "apply-for-tourist-visa" service
    Then User does a Guest login with "automationtestuser@stateofrosebud.com" and "automationtestuser@stateofrosebud.com"

  Scenario: As a citizen I can submit the Tourist Visa service request with valid data
    Then User fills the Applicant Details form under tourist visa with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | RelationshipStatus | Occupation |
      | Mr    | Automation | Kane     | Male   | 1984-02-02 | Sydney       | Single             | Engineer   |
    And User fills the Applicantion Details form with valid data
      | PassportNumber | DateOfIssue | DateOfExpiry | PlaceOfIssue | Address1       | City   | PostalCode | DurationOfStay | VisaForOtherStateOfRoseBud |
      |        1234567 | 2001-02-02  | 2020-04-26   | Melbourne    | 54 test street | Sydney |       2234 | 6 Months       | No                         |
    And User fills the Health&Character form with valid data
      | Question1Disease | Question2Offence | Question3LegalAction | Question4Arrest | Question5Offender | Question6Training | Question7Deported |
      | No               | Yes              | No                   | Yes             | No                | Yes               | No                |
    And User fills the Payment and Billing address form for Tourist Visa
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Kane     | 54 test street | Sydney |       2234 |
    Then User can review tourist visa service request before submitting
    When User submits the tourist visa form
    Then User can view the confirmation page for tourist visa

  Scenario: As a citizen I can submit the Tourist Visa service request with DOB less than 18 years
    Then User fills the Applicant Details form under tourist visa with valid data
      | Title | FirstName  | LastName | Gender | DOB        | PlaceOfBirth | RelationshipStatus | Occupation |
      | Mr    | Automation | Kane     | Male   | 2016-02-02 | Sydney       | Single             | Engineer   |
    Then User clicks on Ok button in the Popup
    Then User should be able to see "You must be at least 18 years old to apply" error message

  Scenario: As a citizen I can view error message on Applicant Details form
    Then User leaves Applicant Details form empty and clicks on next button
    Then User clicks on Ok button in the Popup
    Then User should be able to see the error message in applicant details form
