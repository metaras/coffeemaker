Feature: Add Edit and delete recipe

  Background: Initialize CoffeeMaker
    Given default inventory
    And the recipe in the recipe book

  Scenario: Adding recipe to the recipe book
    When add the recipe above to the recipe book
    Then the recipe is ready to use in the recipe book

  Scenario: Edit the recipe in the recipe book
    When edit the first recipe in the recipe book
    Then the first recipe in the recipe book will change

  Scenario: Delete the recipe from the recipe book
    When delete the first recipe
    Then the recipe book is empty