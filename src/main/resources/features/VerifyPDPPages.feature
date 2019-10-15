@regression
Feature: Verify PDP Pages

  Background: 
    Given Customer is on homepage of site

  Scenario: Verify PDP page for Report Graffiti
    When user click on "report-an-issue" from Top menu
    Then User clicks on view details button of "Report Graffiti" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Report Graffiti     | Reporting Online            | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Report Now      | Report Now      |

  Scenario: Verify PDP page for Report Pothole
    When user click on "report-an-issue" from Top menu
    Then User clicks on view details button of "Report Pothole" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Report Pothole      | Reporting Online            | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Report Now      | Report Now      |

  Scenario: Verify PDP page for Learner Driver License
    When user click on "roads-and-vehicles" from Top menu
    Then User clicks on view details button of "Learner Driver Licence" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle              | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Apply for Learner Driver Licence | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for Disabled Parking Permit
    When user click on "roads-and-vehicles" from Top menu
    Then User clicks on view details button of "Disabled Parking Permit" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle               | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Apply for Disabled Parking Permit | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for WWCC
    When user click on "permits-and-applications" from Top menu
    Then User clicks on view details button of "Working with children check" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle         | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Working with children check | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for Pool Building Permit
    When user click on "permits-and-applications" from Top menu
    Then User clicks on view details button of "Pool Building Permit" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle  | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Pool Building Permit | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for Event Permit
    When user click on "permits-and-applications" from Top menu
    Then User clicks on view details button of "Event Permit" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle    | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Apply for Event Permit | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for Marriage Certificate
    When user click on "permits-and-applications" from Top menu
    Then User clicks on view details button of "Marriage Certificate" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle            | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Apply for Marriage Certificate | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for Register a Birth
    When user click on "births-deaths-and-marriages" from Top menu
    Then User clicks on view details button of "Register a Birth" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Register a Birth    | Registering Online          | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Register Now    | Register Now    |

  Scenario: Verify PDP page for Death Certificate
    When user click on "births-deaths-and-marriages" from Top menu
    Then User clicks on view details button of "Death Certificate" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle         | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Apply for Death Certificate | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |

  Scenario: Verify PDP page for Tourist Visa
    When user click on "permits-and-applications" from Top menu
    Then User clicks on view details button of "Tourist Visa" service request
    Then verify user will be redirected back to PDP page
      | serviceRequestTitle    | serviceRequestOnlineSection | emailPostSection | phoneSection | keyFactsSection | relatedLinksSection | helpDeskSection | sharePageSection | applynowButton1 | applynowButton2 |
      | Apply for Tourist Visa | Applying Online             | By email or post | By Phone     | Key Facts       | Related Links       | Help Desk       | Share this page  | Apply Now       | Apply Now       |
