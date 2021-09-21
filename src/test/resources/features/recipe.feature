Feature: Add Edit and delete recipe

  Background: Initialize CoffeeMaker
    Given empty recipe book and default inventory

  Scenario: Adding recipe to the recipe book
    Given the component of this recipe is 3 unit of coffee 2 unit of milk and 1 unit of sugar
    When add the recipe above to the recipe book
    Then the recipe is ready to use in the recipe book

  Scenario: Edit the recipe in the recipe book
    Given the recipe in the recipe book
    When edit the first recipe in the recipe book change from the 3 unit of coffee to 2 unit of the coffee
    Then the first recipe in the recipe book is 2 unit of coffee 2 unit of milk and 1 unit of sugar

  Scenario: Delete the recipe from the recipe book
    Given the recipe book that already have one recipe in the recipe book
    When delete the first recipe
    Then the recipe book is empty