Feature: ApayloFeature
	User should be login with valid credentials
	

@SIGNIN
  Scenario : 
    Given User is on Apaylo login page
    When user provides valid credentials
    Then user on Dashboard Page