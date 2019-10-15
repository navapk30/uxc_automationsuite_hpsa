Feature: Disabled Parking Permit for Guest User

  Background: 
    Given Customer is on homepage of site
    Then Customer will be in Signed in state
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with "Permits & Applications" will be displayed
    When User clicks "Apply Now" button of "apply-disabled-parking-permit" service
    Then User does a Guest login with "automationtestuser@stateofrosebud.com" and "automationtestuser@stateofrosebud.com"

  Scenario: 
    As a logged in citizen I can submit the Disabled Parking Permit service request by filling up valid data and using custom address for shipping

    Then User fills the Applicant Details form with valid data for disabled parking permit
      | Title | FirstName  | LastName | Gender | DOB        | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | IdentificationProof.PNG |
    And User fills the Medical Details form with valid data for disabled parking permit
      | practicionerName | Gender | DOB        | Country        | Address1       | City   | PostalCode | EmailAddress                    | medicalReport           | declaration                                                                                                                 |
      | Mr               | Male   | 1984-02-02 | United Kingdom | 54 test street | Sydney |      56001 | jane.citizen@stateofrosebud.com | IdentificationProof.PNG | I declare that the details in this medical report are true and complete and obtained from a registered medical practitioner |
    And User fills the Shipment/Pickup location form with valid data for Disabled Parking Permit Service
      | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 54 test street | Sydney |       2234 |
    And User selects an "standard-gross" from the Shipping Method page  for Disabled Parking Permit Service
    And User fills the Payment and Billing address form  for Disabled Parking Permit Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Disabled Parking Permit service information
    Then User accepts the consent declaration for Disabled Parking Permit Service
    When User submits the Disabled Parking Permit form
    Then User is redirected to Disabled Parking Permit confirmation page

  Scenario: 
    As a citizen I can view the error message on Applicant Details section by filling up invalid data

    When User entered "Date of Birth (example: 23/09/2016)" "text" field as  ""
    Then User should be able to see the error message "Please select a date of birth"

  Scenario: 
    As a citizen I can view the error message on Medical Details section by filling up invalid data

    Then User fills the Applicant Details form with valid data for disabled parking permit
      | Title | FirstName  | LastName | Gender | DOB        | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | IdentificationProof.PNG |
    When User clicks on next button in "Medical Details" yformPage
    Then User will get an error dialog message with error message "There are validation errors. Please retry once all fields have been properly filled-out."

  Scenario: 
    As a citizen I can view the error message on review page section when I did not accept consent declaration and tries to submit

    Then User fills the Applicant Details form with valid data for disabled parking permit
      | Title | FirstName  | LastName | Gender | DOB        | identificationProof     |
      | Mr    | Automation | Citizen  | Male   | 1984-02-02 | IdentificationProof.PNG |
    And User fills the Medical Details form with valid data for disabled parking permit
      | practicionerName | Gender | DOB        | Country        | Address1       | City   | PostalCode | EmailAddress                    | medicalReport           | declaration                                                                                                                 |
      | Mr               | Male   | 1984-02-02 | United Kingdom | 54 test street | Sydney |      56001 | jane.citizen@stateofrosebud.com | IdentificationProof.PNG | I declare that the details in this medical report are true and complete and obtained from a registered medical practitioner |
    And User fills the Shipment/Pickup location form with valid data for Disabled Parking Permit Service
      | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 54 test street | Sydney |       2234 |
    And User selects an "standard-gross" from the Shipping Method page  for Disabled Parking Permit Service
    And User fills the Payment and Billing address form  for Disabled Parking Permit Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Disabled Parking Permit service information
    When User submits the Disabled Parking Permit form
    Then User should be able to see the error message that consent declaration is not selected
