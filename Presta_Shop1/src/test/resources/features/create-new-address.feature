Feature: Create new address

#  Scenario: User can add new Address
#
#    Given an open browser with MyStore page
#    When user is signed as user007@user.pl with password user007
#    And User can click Addresses
#    And User can click Create new addrress
#    And User can add new address Alias "Home" Address "Adr1" City "Krak" Zip "12345" Phone "666999000"
#    Then User can see info: "Address successfully added!"
#    And Close browser


  Scenario Outline: User can add new Address

    Given an open browser with MyStore page
    When user is signed as user007@user.pl with password user007
    And User can click Addresses
    And User can click Create new addrress
    And User can add new address Alias "<aliases>" Address "<addr>" City "<city>" Zip "<zipcode>" Phone "<phonenum>"
    Then User can see info: "Address successfully added!"
    And Close browser

    Examples:
      | aliases | addr | city  | zipcode | phonenum  |
      | alias1  | Adr1 | City1 | 88888   | 222222222 |
      | alias2  | Adr2 | City2 | 99999   | 999999999 |
#      | alias3  | Adr3 | City3 | 33333   | 777777777 |
#      | alias4  | Adr4 | City4 | 44444   | 333333333 |


  Scenario: User can delete addresses

    Given an open browser with MyStore page
    When user is signed as user007@user.pl with password user007
    And User can click Addresses
    And User can click Delete
    And Check if number of addresses is 1
    And Close browser

#  user007@user.pl
#  user007