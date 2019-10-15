@regression
Feature: To verify My Account Section

  Background: 
    Given Customer is on homepage of site
    When Customer click on Signin Link
    Then Verify Login form will be displayed to Customer
    And Customer submit the login form with valid "automationtestuser@stateofrosebud.com" and "Rosebud$"
    Then Customer will be in Signed in state
    Then User clicks on "My Account" link

  Scenario: As a registered citizen, I need to able to view the completed list of submitted Service Requests, so that I can view details of one of them
    Then User clicks on "Applications & Requests" link under my account
    And User verifies the my application and requests page for submitted service request

  Scenario: As a registered citizen, I need to be able to view the list of draft Service Requests, so that I can view details of one of them
    Then User clicks on "Applications & Requests" link under my account
    And User verifies the my application and requests page for submitted draft

  #pending
  #  Scenario: As a registered citizen, I need to be able to delete a draft from my account
  #    Then User clicks on "My Applications & Requests" link under my account
  #    And User clicks on delete icon for a specific draft
  #    And User clicks on confirm button on the draft overlay
  
  Scenario: As a Citizen, I need to be able to view the details of a submitted Service Request, so that I can view the form, payment and shipping information within it
    Then User clicks on "Applications & Requests" link under my account
    And User clicks on specific service request
    And User verifies the submitted service request for payment and shipping information.

  #  Scenario: As a Citizen, I can update my personal information by clicking on Update
  #    Then User clicks on "Update Personal Details" link under my account
  #    And User verifies the personal details page
  #    And User updates the title and clicks on update button
  #    Then User verifies Your profile has been updated message
  
  Scenario: As a Citizen, I can click on cancel button so that my personal information is not updated
    Then User clicks on "Update Personal Details" link under my account
    And User verifies the personal details page
    And User updates the title and clicks on cancel button
    Then User is navigated to the home page

  Scenario: As a Citizen, I can click on cancel button so that my password is not updated
    Then User clicks on "Change Password" link under my account
    And User verifies the change password page
    And User clicks on cancel button
    Then User is navigated to the home page

  Scenario: As a Citizen, I can add address to my address book
    Then User clicks on "Address Book" link under my account
    Then User clicks on "Add Address" button
    And User adds the new address
      | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Kane     | 54 test street | Sydney |       2234 |
    Then User clicks on save button

#  Scenario: As a Citizen, I can add edit any address from my address book
#    Then User clicks on "Address Book" link under my account
#    Then User clicks on edit icon to edit the address
#    And User updates the title and clicks on update button on address book page
#
#  Scenario: As a Citizen, I can cancel the address from being deleted
#    Then User clicks on "Address Book" link under my account
#    Then User clicks on delete icon to delete the address
#    Then User clicks on cancel button from the delete address overlay
#    Then User is navigated back to address book page
#
#  Scenario: As a Citizen, I can delete the address from my address book
#    Then User clicks on "Address Book" link under my account
#    Then User clicks on delete icon to delete the address
#    Then User clicks on Delete button from the delete address overlay
#    And User verifies "Address removed successfully" message

  Scenario: As a Citizen, I can verify My Documents page
    Then User clicks on "Documents" link under my account
    And User verifies the my documents page

  Scenario: As a Citizen, I can verify expired documents under My Documents page
    Then User clicks on "Documents" link under my account
    Then User clicks on View Expired Documents button
    And User verifies the expired documents page
