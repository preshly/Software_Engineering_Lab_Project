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
Feature: Add Movie
  I want to add a movie
  
 
  Scenario: Adding a movie
    Given I am already logged in as admin
    And I click on the Movie
    And I click on add movie
    Then I should be able to enter the movie details
    And the movie should be added in the database
    
    And I click on any movie 
    And click on delete
    Then the movie shold be deleted
