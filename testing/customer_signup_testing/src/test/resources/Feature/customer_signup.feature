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

Feature: Movie Customer Signup
  I want to signup to the BookMyMovie website

  
  Scenario: Customer Signup
    Given I want to signup 
    And The website is open
    When I click on signup 
    And enter the correct details with unique username
    Then I should get register and able to login
    When I am prompted to login
    And I enter correct credentials
    Then I should be able to login

