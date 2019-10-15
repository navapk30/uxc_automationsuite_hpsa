@regression
Feature: Verify PLP Pages

  Background: 
    Given Customer is on homepage of site

  Scenario: Verify Products on BirthDeathAndMarriageCertificatePLP Page
    Given user clicked on "births-deaths-and-marriages"
    Then user should navigate to Go to PLP page with title "Births, Deaths & Marriages"
    Then verify Product displayed should display following attributes:
      | productID                      | productName                    | productShortDescription                                                                             | department                     | viewDetailButton | applyNowButton |
      | apply-for-marriage-certificate | Apply for Marriage Certificate | Congratulations from the State of Rosebud! Apply for your marriage certificate conveniently online. | Ministry of Families and Youth | View Details     | Apply Now      |
      | register-birth                 | Register a Birth               | Find information and apply for birth certification.                                                 | Ministry of Families and Youth | View Details     | Register Now   |
      | apply-for-death-certificate    | Apply for Death Certificate    | Find information and apply for death certificate.                                                   | Ministry of Families and Youth | View Details     | Apply Now      |

  Scenario: Verify Products on ReportAnIssuePLP Page
    Given user clicked on "report-an-issue"
    Then user should navigate to Go to PLP page with title "Report an Issue"
    Then verify Product displayed should display following attributes:
      | productID       | productName     | productShortDescription                                                                                                                           | department                | viewDetailButton | applyNowButton |
      | report-pothole  | Report Pothole  | Find information about reporting pothole and report potholes.                                                                                     | Department of Transport   | View Details     | Report Now     |
      | report-graffiti | Report Graffiti | Graffiti vandalism can be seen ruining public transport, public spaces and private homes across Rosebud. Help us combat graffiti by reporting it. | Department of Development | View Details     | Report Now     |

  Scenario: Verify Products on RoadsAndVechilesPLP Page
    Given user clicked on "roads-and-vehicles"
    Then user should navigate to Go to PLP page with title "Roads & Vehicles"
    Then verify Product displayed should display following attributes:
      | productID                     | productName                       | productShortDescription                                                                                         | department              | viewDetailButton | applyNowButton |
      | report-pothole                | Report Pothole                    | Find information about reporting pothole and report potholes.                                                   | Department of Transport | View Details     | Report Now     |
      | apply-disabled-parking-permit | Apply for Disabled Parking Permit | Find information and apply for your disabled parking permit.                                                    | Department of Health    | View Details     | Apply Now      |
      | apply-learner-driver-licence  | Apply for Learner Driver Licence  | Find information on what you need to know about road safety and how to apply for your learner driver's license. | Department of Transport | View Details     | Apply Now      |

  Scenario: Verify Products on PermitsAndApplicationPLP Page
    Given user clicked on "permits-and-applications"
    Then user should navigate to Go to PLP page with title "Permits & Applications"
    Then verify Product displayed should display following attributes:
      | productID                      | productName                       | productShortDescription                                                                                                                                                          | department                     | viewDetailButton | applyNowButton |
      | working-with-children-check    | Working with children check       | You're looking to have a career in childcare or teaching? Or you just want to volunteer for your child's footy team? You probably need to undergo a Working with Children Check. | Department of Justice          | View Details     | Apply Now      |
      | apply-disabled-parking-permit  | Apply for Disabled Parking Permit | Find information and apply for your disabled parking permit.                                                                                                                     | Department of Health           | View Details     | Apply Now      |
      | pool-building-permit           | Pool Building Permit              | Learn everything you need to know about what to look out for when building a pool. Apply online for your permit.                                                                 | Department of Development      | View Details     | Apply Now      |
      | event-permit-application       | Apply for Event Permit            | You want to host an event? Find out what you need to know to make it safe and great for everyone.                                                                                | Department of Commerce         | View Details     | Apply Now      |
      | apply-for-marriage-certificate | Apply for Marriage Certificate    | Congratulations from the State of Rosebud! Apply for your marriage certificate conveniently online.                                                                              | Ministry of Families and Youth | View Details     | Apply Now      |
