Feature: Verify PLP Pages

  Background: 
    Given Customer is on homepage of site

  Scenario: Verify Products on BirthDeathAndMarriageCertificatePLP Page
    Given user clicked on "births-deaths-and-marriages"
    Then user should navigate to Go to PLP page
    Then verify Product displayed should display following attributes:
      | ProductName                    | viewDetailButton               | viewDetailButtonText | applyNowButtonAttribute        | applyNowButtonText |
      | Apply for Marriage Certificate | Apply-for-Marriage-Certificate | VIEW DETAILS         | apply-for-marriage-certificate | APPLY NOW          |
      | Apply for a Death Certificate  | Apply-for-Death-Certificate    | VIEW DETAILS         | apply-for-death-certificate    | APPLY NOW          |
      | Register a birth               | Register-a-Birth               | VIEW DETAILS         | register-birth                 | REGISTER           |


  Scenario: Verify Products on RoadsAndVehiclePLPPage
    Given user clicked on "roads-and-vehicles"
    Then user should navigate to Go to PLP page
    Then verify Product displayed should display following attributes:
      | ProductName                    | viewDetailButton               | viewDetailButtonText | applyNowButtonAttribute        | applyNowButtonText |
      | Apply for Marriage Certificate | Apply-for-Marriage-Certificate | VIEW DETAILS         | apply-for-marriage-certificate | APPLY NOW          |
      | Apply for a Death Certificate  | Apply-for-Death-Certificate    | VIEW DETAILS         | apply-for-death-certificate    | APPLY NOW          |
      | Register a birth               | Register-a-Birth               | VIEW DETAILS         | register-birth                 | REGISTER           |
