Feature: Testing Fuel On Return
#I expect the below the test to fail see bug 2 in my documentation, System returns Negative Fuel Cost Calculations for Discrepancy
  Scenario: Testing Fuel on return 8/8 and Fuel Price per Litre cost to be 1 euro
  Given User logins into the system
  When User Enters "8" into the Fuel on return field
  And User Enters "1" into the Fuel Price per Litre field
  And User clicks the calculate button
  Then Assert that is Estimated Fuel Cost is "0"




