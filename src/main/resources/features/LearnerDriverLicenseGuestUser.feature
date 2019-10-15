Feature: Learner Driver License for Registered User

  Background: 
    Given Customer is on homepage of site
    When user click on "permits-and-applications" from Top menu
    Then verify PLP page with title "Permits & Applications"  will be displayed
    When User clicks "Apply Now" button of "apply-learner-driver-licence" service
    Then User does a Guest login with "automationtestuser@stateofrosebud.com" and "automationtestuser@stateofrosebud.com"

  Scenario: 
    As a guest citizen I can submit the Learner Driver License service request by filling up valid data and using custom address for shipping

    Then User will fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | DOB        | Gender | identificationProof     |
      | Mr    | Automation | Citizen  | 1992-02-02 | Female | IdentificationProof.PNG |
    And User will fills the License Details form with valid data
      | disqualified, prohibited or refused from driving or riding | class of licence |
      | Yes                                                        | Motor Cycle      |
    And User will fills the Health Details form with valid data
      | epilepsy | fainting or other unconsciousness | any medical, physical or mental disabilities | wear glasses |
      | No       | No                                | No                                           | No           |
    And User fills the Shipment/Pickup location form with valid data for Learner Driver Licence Service
      | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 54 test street | Sydney |       2234 |
    And User selects an "standard-gross" from the Shipping Method page  for Learner Driver Licence Service
    And User fills the Payment and Billing address form  for Learner Driver Licence Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Learner Driver License service information
    Then User accepts the consent declaration for Learner Driver Licence Service
    When User submits the Learner Driver License form
    Then User is redirected to Learner Driver License confirmation page

  Scenario: 
    As a guest citizen I can view the error message on Applicant Details section by filling up invalid data

    When User entered "Date of Birth (example: 23/09/2016)" "text" field as  "27/04/2011"
    Then User should be able to see the error message "You must be at least 16 years old in order to apply"
    When User upload "automation_plp.xlsx" file in the field "Please upload identification details"
    Then User should be able to see the error message "Please upload a valid file of type - pdf, .jpg, or .png and max. 3 MB in size"

  Scenario: 
    As a guest citizen I can view the error message on Health Details section by filling up invalid data

    Then User will fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | DOB        | Gender | identificationProof     |
      | Mr    | Automation | Citizen  | 1992-02-02 | Female | IdentificationProof.PNG |
    And User will fills the License Details form with valid data
      | disqualified, prohibited or refused from driving or riding | class of licence |
      | Yes                                                        | Motor Cycle      |
    When User clicks on next button in "Health Details" yformPage
    Then User will get an error dialog message with error message "There are validation errors. Please retry once all fields have been properly filled-out."

  Scenario: 
    As a guest citizen I can view the error message on License Details section by filling up invalid data

    Then User will fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | DOB        | Gender | identificationProof     |
      | Mr    | Automation | Citizen  | 1992-02-02 | Female | IdentificationProof.PNG |
    When User clicks on next button in "Applicant Details" yformPage
    Then User will get an error dialog message with error message "There are validation errors. Please retry once all fields have been properly filled-out."

  Scenario: 
    As a guest citizen I can view the error message on review page section when I did not accept consent declaration and tries to submit

    Then User will fills the Applicant Details form with valid data
      | Title | FirstName  | LastName | DOB        | Gender | identificationProof     |
      | Mr    | Automation | Citizen  | 1992-02-02 | Female | IdentificationProof.PNG |
    And User will fills the License Details form with valid data
      | disqualified, prohibited or refused from driving or riding | class of licence |
      | Yes                                                        | Motor Cycle      |
    And User will fills the Health Details form with valid data
      | epilepsy | fainting or other unconsciousness | any medical, physical or mental disabilities | wear glasses |
      | No       | No                                | No                                           | No           |
    And User fills the Shipment/Pickup location form with valid data for Learner Driver Licence Service
      | Country        | Title | FirstName | LastName | Address1       | City   | PostalCode |
      | United Kingdom | Mr.   | Thomas    | Citizen  | 54 test street | Sydney |       2234 |
    And User selects an "standard-gross" from the Shipping Method page  for Learner Driver Licence Service
    And User fills the Payment and Billing address form  for Learner Driver Licence Service
      | CardType | CardNumber       | ExpMonth | ExpYear | Cvv |
      | Visa     | 4111111111111111 |       02 |    2026 | 123 |
    Then User reviews Learner Driver License service information
    When User submits the Learner Driver License form
    Then User should be able to see the error message that consent declaration is not selected
