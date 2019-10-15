Feature: To implement automation tests for Saving and Retrieving Draft Service request testing scenarios.

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state

  Scenario: As a Registered citizen, I have terminated the service request at review page, so that I cannot retrieve this service request draft
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with "Permits & Applications" will be displayed
    When User clicks "Apply Now" button of "apply-for-tourist-visa" service
    Then User fills the Applicant Details form under tourist visa with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth | RelationshipStatus | Occupation |
      | Mr    | John      | Kane     | Male   | 1984-02-02 | Sydney       | Single             | Engineer   |
    And User fills the Applicantion Details form with valid data
      | PassportNumber | DateOfIssue | DateOfExpiry | PlaceOfIssue | Address1       | City   | PostalCode | DurationOfStay | VisaForOtherStateOfRoseBud |
      |        1234567 | 2001-02-02  | 2020-04-26   | Melbourne    | 54 test street | Sydney |       2234 | 6 Months       | No                         |
    And User fills the Health&Character form with valid data
      | Question1Disease | Question2Offence | Question3LegalAction | Question4Arrest | Question5Offender | Question6Training | Question7Deported |
      | No               | No               | No                   | Yes             | No                | Yes               | No                |
    And User fills the Payment and Billing address form for Tourist Visa
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Kane     | 54 test street | Sydney |       2234 |
    And User clicks on cancel button on the review page
    Then User verifies in "My Account" page under "My Applications & Requests" that draft has not been saved

  Scenario: As a Registered citizen, I save and close on the second page, so that Page 2 is considered the "Last Visited Page" for restoration
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with "Births, Deaths & Marriages" will be displayed
    When User clicks "Register Now" button of "register-birth" service
    Then User selects "two birth certificate" option from Registration Options page
    And User clicks on save and close button
    Then User verifies the draft confirmation page
    And User verifies from my account section, if page2 is considered as last visited page

  Scenario: As a Registered citizen, I save and close on yform page that has invalid data in at least 1 field
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with "Births, Deaths & Marriages" will be displayed
    When User clicks "Register Now" button of "register-birth" service
    Then User selects "two birth certificate" option from Registration Options page
    And User fills the Child Details form with valid data
      | FirstName | LastName | UnderstandThatAsParents | DOB        | BirthWeight | Gender | Country        | Address1       | City | PostalCode |
      | Charles   | Kane     | true                    | 1992-02-02 |        2000 | Female | United Kingdom | 54 test street |      |            |
    Then User verifies global error message on child details page
    Then User clicks on Ok button in the Popup
    And User clicks on save and close button
    Then User verifies the draft confirmation page
    And User verifies from my account section, if page3 is considered as last visited page

  Scenario: As a Registered citizen, I save and close on non-yform page that has invalid data in at least 1 field
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with "Permits & Applications" will be displayed
    When User clicks "Apply Now" button of "apply-for-tourist-visa" service
    Then User fills the Applicant Details form under tourist visa with valid data
      | Title | FirstName | LastName | Gender | DOB        | PlaceOfBirth | RelationshipStatus | Occupation |
      | Mr    | John      | Kane     | Male   | 1984-02-02 | Sydney       | Single             | Engineer   |
    And User fills the Applicantion Details form with valid data
      | PassportNumber | DateOfIssue | DateOfExpiry | PlaceOfIssue | Address1       | City   | PostalCode | DurationOfStay | VisaForOtherStateOfRoseBud |
      |        1234567 | 2001-02-02  | 2020-04-26   | Melbourne    | 54 test street | Sydney |       2234 | 6 Months       | No                         |
    And User fills the Health&Character form with valid data
      | Question1Disease | Question2Offence | Question3LegalAction | Question4Arrest | Question5Offender | Question6Training | Question7Deported |
      | No               | No               | No                   | Yes             | No                | Yes               | No                |
    And User fills the Payment and Billing address form for Tourist Visa
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1       | City | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Kane     | 54 test street |      |            |
    And User clicks on save and close button on non-yform page
    Then User verifies the draft confirmation page
    And User verifies from my account section, if non-yform page is considered as last visited page

  Scenario: As a Registered citizen, I do not make any selection on the bundle selection page, and I click on Save and Close
    When user click on "births-deaths-and-marriages" from Top menu
    Then verify PLP page with "Births, Deaths & Marriages" will be displayed
    When User clicks "Register Now" button of "register-birth" service
    And User clicks on save and close button on bundled page
    Then User verifies the draft confirmation page
    And User verifies from my account section, if bundled page is considered as last visited page

  Scenario: As a Registered citizen, I make a partial selection on the bundle selection page, and I click on "Save and Close"
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with "Permits & Applications" will be displayed
    When User clicks "Apply Now" button of "event-permit-application" service
    Then User selects "event-gather-50-149-addon" option from Event Permit page and can view second question
    And User clicks on save and close button on bundled page
    Then User verifies the draft confirmation page
    And User verifies from my account section, if event permit bundled page is considered as last visited page
