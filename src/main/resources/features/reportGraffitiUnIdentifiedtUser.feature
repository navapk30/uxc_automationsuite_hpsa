Feature: Report Graffiti for UnIdentified User

  Background: 
    Given Customer is on homepage of site
    When user click on "report-an-issue" from Top menu
    Then verify PLP page with "Report an Issue" will be displayed
    When User clicks "report-graffiti" Product button

  Scenario: As a citizen I can submit the graffiti form without ticking the update required checkbox with valid data
    Then User will fill the form with data
      | ServiceRequestName | Type | Address1       | Address2        | city   | postcode | Comments        | KeepUpdate |
      | Graffiti           | Bus  | 54 test street | 135 King Street | Sydney |     2234 | Report Graffiti | false      |
    Then Verify Email and Name fields are hidden
    When User will submit the form
    Then User will be redirected to Confirmation page with "Confirmation - Report Graffiti" message and correct data

  Scenario: As a citizen I can submit the graffiti form ticking the update required checkbox with valid data
    When User will fill the form with data
      | ServiceRequestName | Type | Address1       | Address2        | city   | postcode | Comments        | KeepUpdate |
      | Graffiti           | Bus  | 54 test street | 135 King Street | Sydney |     2234 | Report Graffiti | true       |
    Then Verify Email and Name fields are visible
    Then user can fill Email and Name
      | name   | email         |
      | Tester | test@test.com |
    When User will submit the form
    Then User will be redirected to Confirmation page with "Confirmation - Report Graffiti" message and correct data

  Scenario: As a citizen I can cancel the graffiti form without providing any data
    Given user leave the "report-graffiti" form empty and hit CancelButton
    Then verify user will be redirected back to "Report Graffiti" PDP page

  Scenario: As a citizen I can leave the graffiti form blank.
    Given User leave the "report-graffiti" form empty and hit submit Button
    Then User clicks on Ok button in the Popup
    Then verify user should be able to see the field level error message for "report-graffiti"
