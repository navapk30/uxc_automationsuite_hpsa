Feature: As a user I can do registeration with site

  @sanity
  Scenario: User can perform registration after providing valid information
    Given Customer is on homepage of site
    When Customer click on Registration Link
    Then Registration form will be displayed to Customer
    And Customer will submit Registration form with valid information
    Then Customer will able to get Registered sucessfully
