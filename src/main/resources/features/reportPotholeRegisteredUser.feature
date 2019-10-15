Feature: Report pothole for Registered User

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    When user click on "report-an-issue" from Top menu
    Then verify PLP page with "Report an Issue" will be displayed
    When User clicks "report-pothole" Product button

  Scenario: As a citizen I can submit the pothole form without ticking the update required checkbox with valid data
    Then User will fill the form with pothole data
      | ServiceRequestName | Type    | Address1       | Address2        | city   | postcode | Comments       | KeepUpdate |
      | Pothole            | Pothole | 54 test street | 135 King Street | Sydney |     2234 | Report pothole | false      |
    Then Verify Email and Name fields are hidden
    When User will submit the form
    Then user will be redirected to Confirmation page with Success Message

  Scenario: As a citizen I can submit the pothole form ticking the update required checkbox with valid data
    Then User will fill the form with pothole data
      | ServiceRequestName | Type    | Address1       | Address2        | city   | postcode | Comments       | KeepUpdate |
      | pothole            | Pothole | 54 test street | 135 King Street | Sydney |     2234 | Report pothole | true       |
    Then Verify Email and Name fields are visible
    Then user can fill Email and Name
      | name   | email         |
      | Tester | test@test.com |
    When User will submit the form
    Then user will be redirected to Confirmation page with Success Message

  Scenario: As a citizen I can cancel the pothole form without providing any data
    Given user leave the "report-pothole" form empty and hit CancelButton
    Then verify user will be redirected back to "Report Pothole" PDP page

  Scenario: As a citizen I can leave the pothole form blank.
    Given User leave the "report-pothole" form empty and hit submit Button
    Then User clicks on Ok button in the Popup
    Then verify user should be able to see the field level error message for "report-pothole"
