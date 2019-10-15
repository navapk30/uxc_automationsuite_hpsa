Feature: As a Citizen, I need to be able to add a Citizen (who is not currently in my relationships) in a 2 step process, for both registered users and non registered users, so that we can act as delegates for each other

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    Then User clicks on "My Account" link
    Then User clicks on "Permissions and Relationships" link under my account

  Scenario: As a registered citizen, I am on the Relationship Details Page and I add an Email Address for a registered user, and I click Next
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User verifies if he is redirected to permission page

  Scenario: As a registered citizen, I am on the Relationship Details Page and I add an Email Address that does not exist for a registered user, and I click Next
    Then User clicks on "Set up Permissions" button
    And User adds Email Address that does not exist for a registered user, and clicks on next
    Then User verifies if he is redirected to confirmation page

  Scenario: As a registered citizen, I am on the Relationship Details Page and I add an Email Address for a Citizen already in my Relationships (i.e. Status = Active), and I click "Next"
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a Citizen already in my Relationships, and clicks on next
    Then User verifies error message "You already have a relationship"

  Scenario: As a registered citizen, I am on the Relationship Details Page and I add an Email Address for a Citizen already in an existing Relationship Request with status = Pending, and I click Next
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a Citizen already in an existing Relationship Request, and clicks on next
    Then User verifies error message "You have a pending relationship"

  Scenario: As a registered citizen, I am on the Permissions Page, and I select the option "Give Permissions"
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User selects the option "Give Permissions"
    And User verifies the sections for Give Permissions

  Scenario: As a registered citizen, I am on the Permissions Page, and I select the option "Request Permissions"
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User selects the option "Request Permissions"
    And User verifies the sections for Request Permissions

  Scenario: As a registered citizen, I am on the Permissions Page, and I select the option "Give and Request Permissions"
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User selects the option "Give and Request Permissions"
    And User verifies the sections for Give and Request Permissions

  Scenario: As a registered citizen, I am on the Permissions Page, and I select the option "Request the same Permissions from this person"
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User selects the option "Request the same Permissions from this person"
    And User verifies the sections for Request the same Permissions from this person

  Scenario: As a registered citizen, I add an Email Address for a registered user and clicks on add relationship button
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User verifies if he is redirected to permission page
    Then User selects the option "Give and Request Permissions"
    And User clicks on Add Relationship button

  Scenario: As a registered citizen, I add an Email Address for a registered user and clicks on add cancel button
    Then User clicks on "Set up Permissions" button
    And User adds Email Address for a registered user and clicks on next
    Then User verifies if he is redirected to permission page
    Then User selects the option "Give and Request Permissions"
    And User clicks on cancel button
