#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login to BookMyMovie website
  I want login to the website

  Scenario: Login
    Given I want to login
    And the website is open
    When I click on login
    And enter the correct details
    Then I should be redirected to the customer home page
    When I click on any movie image or name
    Then I a modal of movie details should be visible
    When I close the modal
    And click on logout
    Then I should be logged out


