Feature: Event permit for Guest User

  Background: 
    Given Customer is on homepage of site
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with "Permits & Applications" will be displayed
    When User clicks "Apply Now" button of "event-permit-application" service
    Then User does a Guest login with "automationtestuser@stateofrosebud.com" and "automationtestuser@stateofrosebud.com"

  Scenario: As a citizen I can submit the Event permit service request by selecting bundle option "Less Than 50"
    Then User selects "event-gather-below-50-addon" option from Event Permit page
    And User fills the Event Details form with valid data
      | EventTitle | EventOpenToPublic | EventDiscription | EventDate  | Address1           | City    | PostalCode |
      | Birthday   | No                | BirthdayParty    | 2016-12-02 | 230 Primary Street | Rosebud |       1000 |
    And User fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | OrganizationType | OrganizationName |
      | Mr    | Automation | Citizen  | Community        | SAP              |
    And User fills the Payment and Billing address form for event permit
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Citizen  | 230 Primary Street | Rosebud |       1000 |
    Then User can review event permit service request before submitting
    Then User accepts the consent declaration for Event Permit Service request
    When User submits the event permit form
    Then User can view the confirmation page for event permit

  Scenario: As a citizen I can submit the Event permit service request by selecting bundle option other than "Less Than 50"
    Then User selects "event-gather-50-149-addon" option from Event Permit page and can view second question
    Then User view alcohol question and selects "event-serve-alcohol-addon" option from event page.
    And User fills the Event Details form with valid data
      | EventTitle | EventOpenToPublic | EventDiscription | EventDate  | Address1           | City    | PostalCode |
      | Birthday   | No                | BirthdayParty    | 2016-12-02 | 230 Primary Street | Rosebud |       1000 |
    And User fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | OrganizationType | OrganizationName |
      | Mr    | Automation | Citizen  | Community        | SAP              |
    And User fills the Payment and Billing address form for event permit
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Citizen  | 230 Primary Street | Rosebud |       1000 |
    Then User can review event permit service request before submitting
    Then User accepts the consent declaration for Event Permit Service request
    When User submits the event permit form
    Then User can view the confirmation page for event permit

  Scenario: As a citizen I can view error message on Event Permit page
    Then User does not select any option from Event Permit page and clicks on next button
    Then User view error message on Event Permit page

  Scenario: As a citizen I can view error message on Event Details page
    Then User selects "event-gather-50-149-addon" option from Event Permit page and can view second question
    Then User view alcohol question and selects "event-serve-alcohol-addon" option from event page.
    And User leaves the Event deatils form empty and clicks on next button
    Then User clicks on Ok button in the Popup
    Then User should be able to see the error message in event details form

  Scenario: As a citizen I can view error message on Applicant Details page
    Then User selects "event-gather-below-50-addon" option from Event Permit page
    And User fills the Event Details form with valid data
      | EventTitle | EventOpenToPublic | EventDiscription | EventDate  | Address1           | City    | PostalCode |
      | Birthday   | No                | BirthdayParty    | 2016-12-02 | 230 Primary Street | Rosebud |       1000 |
    And User leaves the Applicant Details form empty and clicks on next button
    Then User clicks on Ok button in the Popup
    Then User should be able to see the error message in Applicant details form

  Scenario: As a citizen I can can view the error message on review page section when I did not accept consent declaration and tries to submit
    Then User selects "event-gather-50-149-addon" option from Event Permit page and can view second question
    Then User view alcohol question and selects "event-serve-alcohol-addon" option from event page.
    And User fills the Event Details form with valid data
      | EventTitle | EventOpenToPublic | EventDiscription | EventDate  | Address1           | City    | PostalCode |
      | Birthday   | No                | BirthdayParty    | 2016-12-02 | 230 Primary Street | Rosebud |       1000 |
    And User fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | OrganizationType | OrganizationName |
      | Mr    | Automation | Citizen  | Community        | SAP              |
    And User fills the Payment and Billing address form for event permit
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv | Country        | Title | FirstName | LastName | Address1           | City    | PostalCode |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 | United Kingdom | Mr.   | Charles   | Citizen  | 230 Primary Street | Rosebud |       1000 |
    Then User can review event permit service request before submitting
    Then User does not accepts the consent declaration for Event Permit Service request
    Then User can view the error message to accept the consent declaration
