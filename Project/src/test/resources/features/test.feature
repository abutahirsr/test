Feature: JDoodle

  Scenario: Verify Presence of Java Compiler Execute Button
    Given User is in JDoodle Online Java Compiler Page
    When Execute Button is present
    Then User should be able to click on the Button
    
	Scenario: Verify Font Size Change
		Given User is in JDoodle Online Java Compiler Page
    Then User should be able to change font size
    
  Scenario: Verify Presence of Light/Dark Mode Toggle
  	Given User is in JDoodle Online Java Compiler Page
  	When Light and Dark Mode Toggle is present
  	Then User should be able to click on the Toggle
    
  Scenario: Verify Presence of Navigation Options
  	Given User is in JDoodle Online Java Compiler Page
  	Then User should be able to find all the options in Navigation Pane
  	
  Scenario: Verify Presence of Login Button
  	Given User is in JDoodle Online Java Compiler Page
  	When User is able to find Login Button
  	Then User should be able to click on the login button
  	
  	